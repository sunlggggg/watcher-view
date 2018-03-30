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
console.log("record", v);





