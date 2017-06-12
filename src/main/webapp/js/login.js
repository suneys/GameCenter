
var UserName = "#UserName", PassWord = "#PassWord", BtnSubmit = "#BtnLogin";
var uTip = "#uTip", pTip = "#pTip";

document.onkeydown = function (evt) {
    var evt = window.event ? window.event : evt;
    if (evt.keyCode == 13) {
        $(BtnSubmit).click();
    }
};
//超时跳出iframe并跳到登陆页面
function loadTopWindow() {
    if (window.top.location.href != location.href) {
        window.top.location.href = location.href;
    };
};
$(document).ready(function () {
    verfocus(UserName, uTip);
    verfocus(PassWord, pTip);
    verification(UserName, uTip,1);
    verification(PassWord, pTip, 2);
    $.AutoComplete('#UserName', false);
});
function CheckBlur(ctype, val) {
    if (ctype == 1) {
        if (val.length <4) {
            ShowTip(UserName, uTip, GetMsgInfo(10009));
            return false;
        }
    }
    else if (ctype ==2) {
        if (val.length <4) {
            ShowTip(PassWord, pTip, GetMsgInfo(10002));
            return false;
        }
    }
    return true;
}
function verification(Id, Tip, ctype) {
    $(Id).blur(function () {
        if ($(Id).val().length > 0 && CheckBlur(ctype, $(Id).val())) {
            $(Id).removeClass(warning);
        }
        else {
            $(Id).addClass(warning);
            $(Tip).show();
        }
    });
} 
function SubmitLogin() {
    if (!isBlank($(UserName).val())|| !isBlank($(PassWord).val())) {
        if (!isBlank($(UserName).val())) {
            ShowTip(UserName, uTip, null);
        }
        if (!isBlank($(PassWord).val())) {
            ShowTip(PassWord, pTip, null);
        }
    }
    else {

        if (!CheckBlur(1, $(UserName).val())) return;
        if (!CheckBlur(2, $(PassWord).val())) return;
        CleanTip();
        SetDisabled(BtnSubmit, GetMsgInfo(10021), true);
        
        $.ajax({
            url: GetUrlInfo(10001) + "?t=" + Math.random(),
            type: 'POST',
            dataType: 'json',
            timeout: 300000,
            data: $("#form1").serialize(),
            error: function () {
                SetDisabled(BtnSubmit, GetMsgInfo(10007), false);
                ShowTip(UserName, uTip, GetMsgInfo(10001))
            },
            success: function (obj) {
                if (obj.IsOk) {
                    window.location = GetUrlInfo(10005);
                } else {
                    if (obj.Msg == "密码错误！") {
                        $(BtnSubmit).val("重新登录").attr("disabled", false);
                        ShowTip(PassWord, pTip, obj.Msg)
                    }
                    else {
                        $(BtnSubmit).val("重新登录").attr("disabled", false);
                        ShowTip(UserName, uTip, obj.Msg)
                    }
                }
            }
        });
    }
}
function CleanTip() {
    $(uTip, pTip).hide();
}