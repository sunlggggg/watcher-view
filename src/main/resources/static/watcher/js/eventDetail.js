function parseUrl() {
    let url = decodeURI(location.href);
    console.log(url);
    let i = url.indexOf('?');
    if (i === -1) return;
    let querystr = url.substr(i + 1);
    let arr1 = querystr.split('&');
    let arr2 = {};
    for (i in arr1) {
        arr2[i] = arr1[i];
    }
    return arr2;
}

let v = parseUrl();
console.log(v);
console.log("event id", v[0].substr(3));
const eventId = v[0].substr(3);

const state = ['success', 'active', 'info', 'warning', 'danger'];
let clnames = [
    'TimeStamp',
    'Source IP',
    'Source Port',
    'Dest IP',
    'Dest Port',
];
let clvalues = [[], [], [],[],[],];
let createTable = function (tableid, clnames, clvalues) {
    let tc = document.getElementById(tableid);
    let tableHtml = `<table class="table"><thead><tr><th>#</th>`;
    tableHtml += `<th>${clnames[0]}</th>\n` +
        '<th>' + clnames[1] + '</th>\n' +
        '<th>' + clnames[2] + '</th>\n' +
        '<th>' + clnames[3] + '</th>\n' +
        '<th>' + clnames[4] + '</th>\n' +
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
            '<td>' + clvalues[3][i] + '</td>\n' +
            '<td>' + clvalues[4][i] + '</td>\n' +
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

    clvalues = [[], [], [],[],[],];
    $.getJSON(`http://localhost:8080/event/list/allFwlogs/${eventId}`, function (data) {
        console.log("allFwlogs", data);
        for(let i = 0 ; i <data.length ; i++ ){
            clvalues[0][i] = data[i].timestamp;
            clvalues[1][i] = data[i].originalSrcIp;
            clvalues[2][i] = data[i].originalSrcPort;
            clvalues[3][i] = data[i].originalDestIp;
            clvalues[4][i] = data[i].originalDestPort;
        }
        createTable('eventDetailTable', clnames, clvalues);

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







