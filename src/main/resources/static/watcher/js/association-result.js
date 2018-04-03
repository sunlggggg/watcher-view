const state = ['success', 'active', 'info', 'warning', 'danger'];
let clnames = [
    '源IP',
    '访问次数',
    '',
];
const clvalues = [
    [],//from state
    [],//start time
    [],//end time
    [],//collection
];
const createTable = function (tableid, clnames, clvalues) {
    let tc = document.getElementById(tableid);
    let tableHtml =
        `<table class="table"> <thead><tr><th>#</th>`;
    tableHtml += `<th>${clnames[0]}</th>\n` +
        '<th>' + clnames[1] + '</th>\n' +
        '<th>' + clnames[2] + '</th>\n' +
        '</tr>\n' +
        '</thead>\n' +
        '<tbody>\n';
    for (let i = 0; i < clvalues[1].length; i++) {
        tableHtml +=
            // '<tr class=' + state[clvalues[0][i]] + '>\n' +
            '<th scope="row">' + (i + 1) + '</th>\n' +
            '<td>' + clvalues[1][i] + '</td>\n' +
            '<td>' + clvalues[2][i] + '</td>\n' +
            '<td>' + clvalues[3][i] + '</td>\n' +
            '</tr>\n';
    }
    tableHtml +=
        '</tbody>\n' +
        '</table>\n';
    tc.innerHTML = tableHtml;
};

function buildTable(type) {
    $.getJSON(`http://localhost:8080/association/list/1&6`, function (data) {
        console.log("association result", data);
        for (let i = 0; i < data.length; i++) {
            clvalues[1][i] = data[i].startTime;
            clvalues[2][i] = data[i].endTime;
            clvalues[3][i] = data[i].collection;
        }
        // clvalues[0] = data.status;
        console.log("clvalues", clvalues);
        switch (type) {
            case "associationResult":
                clnames = ['start time', 'end time', 'collection',];
                createTable('associationResult', clnames, clvalues);
                break;
        }
    });
}

buildTable("associationResult");


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
    $.getJSON(`http://localhost:8080/association/list/${pageNum + 1}&${6}`, function (data) {
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