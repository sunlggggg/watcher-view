//Mar 29, 2018 2:13:07 AM
//2018-3-29 2:13:07
function dateFormat(inputStr) {
    console.log(inputStr);
    let parts = inputStr.split(" ");
    console.log("时间分割",parts);
    const month = {
        "Jan": 1,
        "Feb": 2,
        "Mar": 3,
        "Apr": 4,
        "May": 5,
        "Jun": 6,
        "Jul": 7,
        "Aug": 8,
        "Sep": 9,
        "Oct": 10,
        "Nov": 11,
        "Dec": 12,
    };


    const newMonthAndDay = `${month[parts[0]]}-${parts[1].substr(0, parts[1].length - 1)}`;
    const year = parts[2];

    if (parts[4] === 'PM') {
        console.log("PM");
        let hms = parts[3].split(":");
        let hour = hms[0];
        hour = parseInt(hour);
        hour += 12;
        console.log(hour);
        hour %= 24;
        hms[0] = hour;
        parts[3] = "";
        hms.forEach(function (item) {
            parts[3] += item + ":";
        });
        parts[3] = parts[3].substr(0,parts[3].length - 1);
    }
    const hms = parts[3];
    return year + "-" + newMonthAndDay  + "&nbsp&nbsp&nbsp" + hms;
}
