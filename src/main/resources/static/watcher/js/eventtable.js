const state = ['success', 'active', 'info', 'warning', 'danger'];
let clnames = [
    'Record Title',
    'Creator',
    'Create Time',
    '',
];
let clvalues = [[], [], [],[],[],];
let createTable = function (tableid, clnames, clvalues) {
    let tc = document.getElementById(tableid);
    let tableHtml = `<table class="table"><thead><tr><th>#</th>`;
    tableHtml += `<th>${clnames[0]}</th>\n` +
        '<th>' + clnames[1] + '</th>\n' +
        '<th>' + clnames[2] + '</th>\n' +
        '<th>' + clnames[3] + '</th>\n' +
        '</tr>\n' +
        '</thead>\n' +
        '<tbody>\n';
    for (let i = 0; i < clvalues[0].length; i++) {
        tableHtml +=
            '<tr class= "info" >\n' +
            '<th scope="row">' + (i + 1) + '</th>\n' +
            '<td>' + clvalues[0][i] + '</td>\n' +
            '<td>' + clvalues[1][i] + '</td>\n' +
            '<td>' + clvalues[2][i] + '</td>\n' +
            `<td > <button class="btn btn-block btn-primary" onclick="eventDetail(${i});">查看详情</button></td>\n` +
            '</tr>\n';
    }
    tableHtml +=
        '</tbody>\n' +
        '</table>\n';
    tc.innerHTML = tableHtml;
}

function buildTable(pageNum) {
    // clvalues[0] = ['121.000.121', '121.12.121', '124.121.212', '12'];
    // clvalues[0] = [0, 12, 2, 1];
    // createTable('recordTable', clnames, clvalues);
    clnames = [
        'Start Time',
        'Ent Time',
        'Event Type',
        '',
    ];
    clvalues = [[], [], [],[],[],];
    $.getJSON(`http://localhost:8080/event/list/${pageNum}&${6}`, function (data) {
        console.log("events ", data);
        for(let i = 0 ; i <data.length ; i++ ){
            clvalues[0][i] = data[i].startTime;
            clvalues[1][i] = data[i].lastTime;
            clvalues[2][i] = data[i].attackType;
            clvalues[3][i] = data[i].id;
        }
        createTable('eventTable', clnames, clvalues);
    });
}

buildTable(1);


function eventDetail(i) {
    window.location.href=`dashboard-eventDetail.html?id=${clvalues[3][i]}`;
    console.log($(this).attr("class"))
}

//分页

//分页。。。
function lastPage() {
    let pageNum = parseInt($("#nowPage").text());
    if (1 - pageNum === 0) {
        $("#firstPage").css("display", "block")
        setTimeout(function () {
            $("#firstPage").css("display", "none")
        }, 2000);
    } else {
        $("#nowPage").text(--pageNum)
        buildTable(pageNum);
    }
}

function nextPage() {
    let pageNum = parseInt($("#nowPage").text());
    let nextItemNum;
    $.getJSON(`http://localhost:8080/event/list/${pageNum + 1}&${6}`, function (data) {
        nextItemNum = data.length;
        if (nextItemNum === 0) {
            $("#finalPage").css("display", "block")
            setTimeout(function () {
                $("#finalPage").css("display", "none")
            }, 2000);
        } else {
            $("#nowPage").text(++pageNum)
            buildTable(pageNum);
        }
    });

}