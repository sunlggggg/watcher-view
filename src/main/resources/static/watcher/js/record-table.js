const state = ['success', 'active', 'info', 'warning', 'danger'];
let clnames = [
    '日志标题',
    '创建者',
    '创建时间',
    '操作',
];
let clvalues = [[], [], [],[],[],];
let createTable = function (tableid, clnames, clvalues) {
    let tc = document.getElementById(tableid);
    let tableHtml =
        `<table class="table"> 
            <thead> 
            <tr>
        <th>#</th>`;
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
            '<td>' + clvalues[4][i] + '</td>\n' +
            `<td > <button class="btn btn-block btn-primary" onclick="recordDetail(${i});">查看详情</button></td>\n` +
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
    let clnames = [
        '日志标题',
        '创建者',
        '创建时间',
        '操作',
    ];
    clvalues = [[], [], [],[],[],];
    $.ajax({
        url: `http://localhost:8080/api/record/list/${pageNum}&${6}`,
        headers: {'Authorization': $.session.get('token')},
        method: 'GET'
    }).always(function (data, status, xhr) {
        data = JSON.parse(data);
        const pageinfo = data.pageInfo;
        console.log("pageinfo", pageinfo);
        for(let i = 0 ; i <pageinfo.length ; i++ ){
            clvalues[0][i] = pageinfo[i].title;
            //TODO 权限控制
            clvalues[1][i] = "Sun LiGang";
            clvalues[2][i] = pageinfo[i].recordInfo;
            clvalues[3][i] = pageinfo[i].id;
            clvalues[4][i] = dateFormat(pageinfo[i].createTime);
        }
        createTable('recordTable', clnames, clvalues);

    });
}

buildTable(1);


function recordDetail(i) {
    window.location.href=`dashboard-recorddetail.html?title=${clvalues[0][i]}&recordInfo=${clvalues[2][i]}&id=${clvalues[3][i]}`;
    console.log($(this).attr("class"))
}