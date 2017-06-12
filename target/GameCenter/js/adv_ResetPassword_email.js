
var txtPassword1 = "#txtPassword1", txtPassword2 = "#txtPassword2";
var eTip1 = "#eTip1", eTip2 = "#eTip2";
var BtnResetPassword = "#BtnResetPassword";

function CleanETip1() {
    $(eTip1).hide();
    $(txtPassword1).removeClass(warning);
    $(eTip2).hide();
    $(txtPassword2).removeClass(warning);

};

function verification(Id, Tip, length) {
    $(Id).blur(function () {
        if ($(Id).val().length >= length) {
            $(Id).removeClass(warning);
            $(Tip).hide();
        }
        else {
            $(Id).addClass(warning);
            $(Tip).show();
        }
    });
}

function CheckBlur(id,tip, val) {


        if (val.length <6) {
            ShowTip(id, tip, GetMsgInfo(201));
            return false;
        }

    return true;
};

$(document).ready(function () {
    verification(txtPassword1, eTip1, 6);
    verification(txtPassword2, eTip2, 6);
});
//发送验证码
function SendNewPassword() {
    if (!isBlank($(txtPassword1).val()) || !isBlank($(txtPassword2).val()) ) {
        if (!isBlank($(txtPassword1).val())) {
            ShowTip(txtPassword1, eTip1, null);
        }
        if (!isBlank($(txtPassword2).val())) {
            ShowTip(txtPassword2, eTip2, null);
        }

    }
    else {

        if (!CheckBlur(txtPassword1,eTip1, $(txtPassword1).val())) return;

        if (!CheckBlur(txtPassword2,eTip2, $(txtPassword2).val())) return;

        if ($(txtPassword1).val() != $(txtPassword2).val())
        {
            ShowTip(txtPassword2,eTip2,"两次密码不相同,请重新输入");
            return;
        }
        CleanETip1();
        SetDisabled(BtnResetPassword, GetMsgTitle(149), true);
        // $.ajax({
        //     url: GetUrlInfo(10008) + "?userID=" + $("#userID").val() + "&password=" + $(txtPassword2).val() +"&t=" + Math.random(),
        //     type: 'POST',
        //     dataType: 'json',
        //     timeout: 300000
        // });
        $("#from2").submit();
    }
};
function gotoVerify() {
    var URL = $(gotoUrl).val();
    window.open(URL);
};