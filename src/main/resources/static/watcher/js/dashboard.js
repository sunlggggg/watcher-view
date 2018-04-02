$(function(){

    this.makeGauge = function(selector, value, color)
    {
	c3.generate({
	    bindto: selector,
	    data: {
		columns: [
		    ['data', value]
		],
		type: 'gauge'
	    },
	    tooltip: {
		show: false
	    },
	    gauge: {
		label: {
		    format: function(value, ratio) {
			return value + '%';
		    },
		    show: false
		},
		min: 0,
		max: 100,
		units: ' %',
		width: 50
	    },
	    color: {
		pattern: [color, color, color], // the 3 color levels for the percentage values.
	    }
	});
    };

    this.makeGauge('#d1-c1', 42, '#1abc9c');
    this.makeGauge('#d1-c2', 22, '#3498db');
    this.makeGauge('#d1-c3', 72, '#f39c12');
    this.makeChart = function(selector, type, colors, legend) {
        console.log(1212);
        c3.generate({
            bindto: selector,
            data: {
                x: 'x',
                //        xFormat: '%Y%m%d', // 'xFormat' can be used as custom format of 'x'
                columns: [
                    ['x', '2013-01-01', '2013-01-02', '2013-01-03', '2013-01-04', '2013-01-05', '2013-01-06',
                        '2013-01-07', '2013-01-08', '2013-01-09', '2013-01-10', '2013-01-11', '2013-01-12'],
                    // ['Catoni anteponas', 130, 340, 200, 500, 250, 350, 130, 333, 200, 500, 220, 350],
                    ['Et quoniam inedia', 100, 200, 100, 400, 150, 250, 30, 200, 112, 322, 70, 300]
                ],
                //type: 'spline'
                type: type
            },
            axis: {
                x: {
                    type: 'timeseries',
                    tick: {
                        format: '%Y-%m-%d'
                    }
                },

                y: {
                    max: 500,
                    tick: {
                        values: [100, 200, 300, 400, 500]
                    }
                }

            },

            legend: {
                show: legend,
                position: 'inset'
            },

            color: {
                pattern: colors
            }

        });
    }
    //this.makeChart('#d1-c5', 'bar', ['#1abc9c', '#16a085', '#f39c12'], false);
	this.makeChart('#d1-c5', 'bar', ['#3498db', '#2980b9'], false);
});
const count = 0 ;
const activeData = [];
const generateAccessFlowSpline = function() {
    let needRebuild = false;
    $(document).ready(function () {
        $.getJSON(
            "http://localhost:8080/accessFlow",
            function (data) {
                console.log("old", activeData);
                console.log("new", data.activeData);
                if (activeData.length !== 61) {
                    needRebuild = true;
                }else{
                    for (let i = 0; i < 60; i++) {
                        if (data.activeData[i] !== activeData[60 - i]) {
                            needRebuild = true;
                        }
                    }
                }
                if (needRebuild) {
                    console.log("accessFlowSpline ReBuild");
                    activeData[0] = 'last 2 minutes';
                    for (let i = 1; i <= 60; i++) {
                        activeData[i] = data.activeData[60 - i];//传过来的数据时间上倒置
                    }

                    let min = activeData[1], max = activeData[1];
                    for (let i = 1; i <= 60; i++) {
                        if (activeData[i] > max) {
                            max = activeData[i];
                        }
                        if (activeData[i] < min) {
                            min = activeData[i];
                        }
                    }

                    this.makeChart = function (selector, type, colors, legend) {
                        let yValues;
                        yValues = [];
                        let span = (max - min + 5) / 5;
                        for (let i = 0; i <= 5; i++) {
                            yValues[i] = min + i * (span);
                        }

                        c3.generate({
                            bindto: selector,
                            data: {
                                // x: 'x',
                                //        xFormat: '%Y%m%d', // 'xFormat' can be used as custom format of 'x'
                                columns: [
                                    // time,
                                    /*['x', '2013-01-01', '2013-01-02', '2013-01-03', '2013-01-04', '2013-01-05', '2013-01-06',
                                        '2013-01-07', '2013-01-08', '2013-01-09', '2013-01-10', '2013-01-11', '2013-01-12'],*/
                                    // ['Catoni anteponas', 130, 340, 200, 500, 250, 350, 130, 333, 200, 500, 220, 350],
                                    activeData,
                                    // ['数据流量', 100, 200, 100, 400, 150, 250, 30, 200, 112, 322, 70, 300]
                                ],
                                type: 'spline'
                                // type: spline
                            },
                            axis: {
                                // x: {
                                //     type: 'timeseries',
                                //     tick: {
                                //         format: '%M'
                                //     }
                                // },

                                y: {
                                    max: max + 10,
                                    tick: {
                                        yValues,
                                    }
                                }

                            },

                            legend: {
                                show: legend,
                                position: 'inset'
                            },

                            color: {
                                pattern: colors
                            }

                        });
                    }
                    this.makeChart('#d1-c4', 'spline', ['#1abc9c', '#3498db'], true);
                }else {
                    console.log("accessFlowSpline not ReBuild");
                }
            });
    });
};

setInterval(generateAccessFlowSpline, 2000);


