function submitRecord(isNewRecord ) {
    let title = $('#recordTitle').val();
    console.log(title);
    let recordinfo = document.getElementsByClassName("note-editable").item(0).innerHTML;
    console.log(recordinfo);

    let record = {};

    record.title = title;
    record.recordInfo = recordinfo;
    let requestData = JSON.stringify(record);
    console.log(requestData);
    if (isNewRecord) {
        $(document).ready(function () {
            const res = $.ajax({
                type: 'POST',
                url: `http://localhost:8080/record/`,
                contentType: "application/json",
                data: requestData,
                success: successInfo,
            });

            function successInfo() {
                if (res.responseText === "success") {
                    $("#submitSuccess").css("display", "block")
                    setTimeout(function () {
                        $("#submitSuccess").css("display", "none")
                    }, 2000);
                }
            }
        });
    } else { //修改
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
            $("#recordTitle").attr("value", arr2[0].substr(6));//清空内容

            //延时加载
            console.log("load recordInfo");
            setTimeout(function () {
                document.getElementsByClassName("note-editable").item(0).innerHTML = arr2[1].substr(11);
            }, 50);
            return arr2;
        }
        let v = parseUrl();
        record.id = v[2].substr(3);
        let requestData = JSON.stringify(record);
        $(document).ready(function () {
            const res = $.ajax({
                type: 'POST',
                url: `http://localhost:8080/record/update`,
                contentType: "application/json",
                data: requestData,
                success: successInfo,
            });



            console.log("record", record );

            function successInfo() {
                if (res.responseText === "success") {
                    $("#ModifySuccess").css("display", "block")
                    setTimeout(function () {
                        $("#ModifySuccess").css("display", "none")
                    }, 2000);
                }
                window.location.href=`dashboard-recorddetail.html?title=${record.title}&recordInfo=${record.recordInfo}&id=${record.id}`;
            }
        });
    }
}

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
    $.getJSON(`http://localhost:8080/record/list/${pageNum + 1}&${6}`, function (data) {
        nextItemNum = data.pageInfo.length;
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



