/**
 * Created by sun on 2016/6/5.
 */
/**
 * 管理员和用户登录
 */
$(document).ready(function () {
    $("#submit").click(function () {
        let user = {};
        console.log($("#email").val());
        user.email = $("#email").val();
        user.password = $("#password").val();
        let requestData = JSON.stringify(user);
        console.log("new  user", requestData);

        $.ajax({
            url: 'http://localhost:8080/user/login',
            // headers: {'Authorization': token},
            method: 'POST',
            contentType: "application/json",
            data: requestData
        }).always(function (data, status, xhr) {
            if (data.token) {
                $.session.set('token', data.token);
                console.log("token", $.session.get('token'));
                window.location.href = '../dashboard-realtime.html';
            }
            else
                window.wxc.xcConfirm("登录失败", window.wxc.xcConfirm.typeEnum.error, {});
        });
    });
});

