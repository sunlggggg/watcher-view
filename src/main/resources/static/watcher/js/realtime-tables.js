var state = ['success', 'active', 'info', 'warning', 'danger'];
var clnames = [
    '源IP',
    '访问次数',
];
const clvalues = [
    [0, 1, 4, 2],//from state
    ['121.000.121', '121.12.121', '124.121.212', '12'],
    [0, 12, 2, 1],
];
var createTable = function (tableid, clnames, clvalues) {
    var tc = document.getElementById(tableid);
    var tableHtml =
        `<table class="table"> 
            <thead> 
            <tr>
        <th>#</th>`;
    tableHtml += `<th>${clnames[0]}</th>\n` +
        '<th>' + clnames[1] + '</th>\n' +
        '</tr>\n' +
        '</thead>\n' +
        '<tbody>\n';
    for (var i = 0; i < clvalues[0].length; i++) {
        tableHtml +=
            '<tr class=' + state[clvalues[0][i]] + '>\n' +
            '<th scope="row">' + (i + 1) + '</th>\n' +
            '<td>' + clvalues[1][i] + '</td>\n' +
            '<td>' + clvalues[2][i] + '</td>\n' +
            '</tr>\n';
    }
    tableHtml +=
        '</tbody>\n' +
        '</table>\n';
    tc.innerHTML = tableHtml;
}

function buildTable(type) {
    $.ajax({
        url: "http://localhost:8080/api/statistics/list/" + type,
        headers: {'Authorization': $.session.get('token')},
        method: 'GET'
    }).always(function (data, status, xhr) {
        data = JSON.parse(data);
        clvalues[0] = data.status;
        clvalues[1] = data.ip;
        clvalues[2] = data.count;
        switch (type) {
            case "originalSrcIp":
                clnames = ['源IP', '访问次数',];
                createTable('tablesrcip', clnames, clvalues);
                break;
            case "originalSrcPort":
                clnames = ['源端口', '访问次数',];
                createTable('tablesrcport', clnames, clvalues);
                break
            case "originalDestIp":
                clnames = ['目的IP', '访问次数',];
                createTable('tabledestip', clnames, clvalues);
                break;
            case "originalDestPort":
                clnames = ['目的端口', '访问次数',];
                createTable('tabledestport', clnames, clvalues);
                break;
        }
    });
}

buildTable("originalSrcIp");
buildTable("originalSrcPort");
buildTable("originalDestIp");
buildTable("originalDestPort");
