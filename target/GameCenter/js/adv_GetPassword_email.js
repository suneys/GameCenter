var hash = {
    'qq.com': 'http://mail.qq.com',
    'gmail.com': 'http://mail.google.com',
    'sina.com': 'http://mail.sina.com.cn',
    '163.com': 'http://mail.163.com',
    '126.com': 'http://mail.126.com',
    'yeah.net': 'http://www.yeah.net/',
    'sohu.com': 'http://mail.sohu.com/',
    'tom.com': 'http://mail.tom.com/',
    'sogou.com': 'http://mail.sogou.com/',
    '139.com': 'http://mail.10086.cn/',
    'hotmail.com': 'http://www.hotmail.com',
    'live.com': 'http://login.live.com/',
    'live.cn': 'http://login.live.cn/',
    'live.com.cn': 'http://login.live.com.cn',
    '189.com': 'http://webmail16.189.cn/webmail/',
    'yahoo.com.cn': 'http://mail.cn.yahoo.com/',
    'yahoo.cn': 'http://mail.cn.yahoo.com/',
    'eyou.com': 'http://www.eyou.com/',
    '21cn.com': 'http://mail.21cn.com/',
    '188.com': 'http://www.188.com/',
    'foxmail.com': 'http://www.foxmail.com',
    'outlook.com': 'http://www.outlook.com'
};
var txtEmail = "#txtEmail", txtEmailCode = "#txtEmailCode", BtnByEmail = "#BtnByEmail", gotoUrl = "#gotoUrl", txtName = "#txtName";
var eTip1 = "#eTip1", eTip2 = "#eTip2", eTip3 = "#eTip3",  active = "active";
var etxt1 = "找回密码", elearfix1 = "#elearfix1", elearfix2 = "#elearfix2";
var emailFindStep1 = "#emailFindStep1", emailFindStep2 = "#emailFindStep2", txtEmail = "#txtEmail",des_mail=".des_mail";

function CleanETip1() {
    $(eTip1).hide();
    $(txtEmail).removeClass(warning);
    $(eTip2).hide();
    $(txtEmailCode).removeClass(warning);
    $(eTip3).hide();
    $(txtName).removeClass(warning);
};
$(document).ready(function () {
    verification(txtEmail, eTip1, 5);
    verification(txtEmailCode, eTip2, 4);
    $.AutoComplete(txtEmail,true);
});
//发送验证码
function SendEmailCode() {
    if (!isBlank($(txtEmail).val()) || !isBlank($(txtEmailCode).val()) ||!isBlank($(txtName).val()) ) {
        if (!isBlank($(txtEmail).val())) {
            ShowTip(txtEmail, eTip1, null);
        }
        if (!isBlank($(txtEmailCode).val())) {
            ShowTip(TxtverifyCode, eTip2, null);
        }
        if(!isBlank($(txtName).val())){
            ShowTip(txtName, eTip3, null);
        }

    }
    else {
        if (!CheckBlur(1, $(txtName).val())) return;
        if (!CheckBlur(2, $(txtEmail).val())) return;
        if (!CheckBlur(7, $(txtEmailCode).val())) return;
        CleanETip1();
        SetDisabled(BtnByEmail, GetMsgTitle(149), true);
        $.ajax({
            url: GetUrlInfo(10006) + "?SendName=" + $(txtName).val() + "&SendEmail=" + $(txtEmail).val() + "&code=" + $(txtEmailCode).val() + "&t=" + Math.random(),
            type: 'POST',
            dataType: 'json',
            timeout: 300000,
            error: function () {
                SetDisabled(BtnByEmail, etxt1, false);
                ShowTip(txtEmail, eTip1, GetMsgInfo(10001))
            },
            success: function (obj) {
                if (obj.IsOk) {
                    $(emailFindStep1).hide();
                    $(emailFindStep2).show();
                    $(des_mail).html($(txtEmail).val());
                    var _mail = $(txtEmail).val().toLowerCase().split('@')[1];    //获取邮箱域
                    for (var j in hash) {
                        if (j == _mail) {
                            $(gotoUrl).val(hash[_mail]);    //替换登陆链接
                        }
                    }
                    $(elearfix1).removeClass(active);
                    $(elearfix2).addClass(active);
                    SetDisabled(BtnByEmail, etxt1, false);
                } else {
                    if (obj.Msg == "图形验证码错误！") {
                        CleanETip1();
                        $(yzm1).click();
                        ShowTip(txtEmailCode, eTip2, obj.Msg)
                    }
                    else {
                        ShowTip(txtEmail, eTip1, obj.Msg);
                    }
                    SetDisabled(BtnByEmail, etxt1, false);
                }
            }
        });
    }
};
function gotoVerify() {
    var URL = $(gotoUrl).val();
    window.open(URL);
};