/**
 * Created by sun on 2016/6/4.
 */
$(document).ready(function () {
    $("#submit").click(function () {
        let user = {};
        console.log($("#email").val());
        user.email = $("#email").val();
        user.name = $("#username").val();
        user.password = $("#password").val();
        let requestData = JSON.stringify(user);
        console.log("new  user", requestData);
        const res = $.ajax({
            type: 'POST',
            url: `http://localhost:8080/user/`,
            contentType: "application/json",
            data: requestData,
            success: successInfo,
        });

        function successInfo() {
            if (res.responseText === 'success') {
                window.wxc.xcConfirm("注册成功", window.wxc.xcConfirm.typeEnum.success, {
                    onOk: function () {
                        window.location.href = "login.html"
                    }
                });
            } else {
                window.wxc.xcConfirm("注册失败", window.wxc.xcConfirm.typeEnum.error, {});
            }
        }
    });
})




