const state = ['success', 'active', 'info', 'warning', 'danger'];
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
    $.getJSON(`http://localhost:8080/history/list/${type}`, function (data) {
        clvalues[0] = data.status;
        clvalues[1] = data.ip;
        clvalues[2] = data.count;
        switch (type) {
            case "originalSrcIp":
                clnames = ['源IP', '访问次数',];
                createTable('historySrcIp', clnames, clvalues);
                break;
            case "originalDestIp":
                clnames = ['目的IP', '访问次数',];
                createTable('historyDestIp', clnames, clvalues);
                break;
        }
    });
}
buildTable("originalSrcIp");
buildTable("originalDestIp");
