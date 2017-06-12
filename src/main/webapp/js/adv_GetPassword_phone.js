
var findPwd1 = "#findPwd1", findPwd2 = "#findPwd2", sendtype = "#sendtype";
var flipOutY = "flipOutY", flipInY = "flipInY", gomail = "#go-mail", gophone = "#go-phone";
var TxtPhone = "#TxtPhone", TxtverifyCode = "#TxtverifyCode", TxtPhoneCode = "#TxtPhoneCode", BtnverifyCode = "#BtnverifyCode", BtnByPhone = "#BtnByPhone", BtnSavePhone = "#BtnSavePhone";
var pTip1 = "#pTip1", pTip2 = "#pTip2", pTip3 = "#pTip3", pTip4 = "#pTip4", pTip5 = "#pTip5";
var yzm1 = "#yzm1", yzm2 = "#yzm2";
var txt1 = "获取验证码", txt2 = "重置密码", txt3 = "找回密码";
var p_pwd1 = "#p_pwd1", p_pwd2 = "#p_pwd2";

function CleanTip1() {
    $(pTip1).hide();
    $(TxtPhone).removeClass(warning);
    $(pTip2).hide();
    $(TxtverifyCode).removeClass(warning);
};
function CleanTip2() {
    $(pTip3).hide();
    $(TxtPhoneCode).val("");
    $(TxtPhoneCode).removeClass(warning);
};
function CleanTip3() {
    $(pTip4).hide();
    $(p_pwd1).removeClass(warning);
    $(pTip5).hide();
    $(p_pwd2).removeClass(warning);
};
function CleanTxt1() {
    $(TxtPhone).val("");
    $(TxtPhone).removeClass(warning);
    $(TxtverifyCode).val("");
    $(TxtverifyCode).removeClass(warning);
};
var sendEmail = 1, sendPhone = 2;
$(document).ready(function () {
    $(gomail).on("click", function () {
        $(findPwd1).removeClass(flipInY).addClass(flipOutY).hide();
        $(findPwd2).removeClass(flipOutY).addClass(flipInY).show();
        $(sendtype).val(sendEmail);
        $(yzm2).click();
    }),
    $(gophone).on("click", function () {
        $(findPwd1).show().removeClass(flipOutY).addClass(flipInY);
        $(findPwd2).hide().removeClass(flipInY).addClass(flipOutY);
        $(sendtype).val(sendPhone);
        CleanTip1();
        CleanTxt1();
        $(yzm1).click();
    });
    verification(TxtPhone, pTip1,11);
    verification(TxtverifyCode, pTip2, 4);
    verification(p_pwd1, pTip4, 6);
    verification(p_pwd2, pTip5, 6);
});
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
function CheckBlur(ctype, val) {
    if (ctype == 1) {
        if (!RegTel.test(val)) {
            ShowTip(TxtPhone, pTip1, GetMsgInfo(10003));
            return false;
        }
    }
    else if (ctype == 2) {
        if (!RegEail.test(val)) {
            ShowTip(txtEmail, eTip1, GetMsgInfo(10004));
            return false;
        }
    }
    else if (ctype == 3) {
        if (val.length < 4) {
            ShowTip(TxtverifyCode, pTip2, GetMsgInfo(10081));
            return false;
        }
    }
    else if (ctype == 4) {
        if (val.length < 4) {
            ShowTip(TxtPhoneCode, pTip3, GetMsgInfo(10083));
            return false;
        }
    }
    else if (ctype == 5) {
        if (val.length <6) {
            ShowTip(p_pwd1, pTip4, GetMsgInfo(201));
            return false;
        }
    }
    else if (ctype == 6) {
        if (val.length <6) {
            ShowTip(p_pwd2, pTip5, GetMsgInfo(202));
            return false;
        }
    }
    else if (ctype == 7) {
        if (val.length < 4) {
            ShowTip(txtEmailCode, eTip2, GetMsgInfo(10083));
            return false;
        }
    }
    return true;
};
//发送验证码
function SendPhoneCode() {
    if (!isBlank($(TxtPhone).val()) || !isBlank($(TxtverifyCode).val())) {
        if (!isBlank($(TxtPhone).val())) {
            ShowTip(TxtPhone, pTip1, null);
        }
        if (!isBlank($(TxtverifyCode).val())) {
            ShowTip(TxtverifyCode, pTip2, null);
        }
        CleanTip2();
    }
    else {
        if (!CheckBlur(1, $(TxtPhone).val())) return;
        if (!CheckBlur(3, $(TxtverifyCode).val())) return;
        CleanTip1();
        $(BtnverifyCode).addClass("btn_disabled");
        SetDisabled(BtnverifyCode, GetMsgTitle(149), true);
        $.ajax({
            url: GetUrlInfo(10006) + "?SendType=" + sendPhone + "&SendName=" + $(TxtPhone).val() + "&code=" + $(TxtverifyCode).val() + "&t=" + Math.random(),
            type: 'POST',
            dataType: 'json',
            timeout: 300000,
            error: function () {
                $(BtnverifyCode).removeClass("btn_disabled");
                ShowTip(TxtPhone, pTip1, GetMsgInfo(10001))
            },
            success: function (obj) {
                if (obj.IsOk) {
                    LodingSMS(60);
                    ShowTip(TxtPhoneCode, pTip3, GetMsgInfo(10082))
                } else {
                    if (obj.Msg == "图形验证码错误！") {
                        CleanTip2();
                        $(yzm1).click();
                        ShowTip(TxtverifyCode, pTip2, obj.Msg)
                    }
                    else {
                        ShowTip(TxtPhone, pTip1, obj.Msg);
                    }
                    SetDisabled(BtnverifyCode, txt1, false);
                    $(BtnverifyCode).removeClass("btn_disabled");
                }
            }
        });
    }
};
function LodingSMS(count) {
    window.setTimeout(function () {
        count--;
        if (count > 0) {
            $(BtnverifyCode).val(count + "秒后重试");
            LodingSMS(count);
        }
        else {
            $(BtnverifyCode).removeClass("btn_disabled");
            SetDisabled(BtnverifyCode, txt1, false);
        }
    }, 1000);
};
//找回密码
function GetPwdPhone() {
    if (!isBlank($(TxtPhone).val()) || !isBlank($(TxtverifyCode).val()) || !isBlank($(TxtPhoneCode).val())) {
        if (!isBlank($(TxtPhone).val())) {
            ShowTip(TxtPhone, pTip1, null);
        }
        if (!isBlank($(TxtverifyCode).val())) {
            ShowTip(TxtverifyCode, pTip2, null);
        }
        if (!isBlank($(TxtPhoneCode).val())) {
            ShowTip(TxtPhoneCode, pTip3, null);
        }
    }
    else {
        if (!CheckBlur(1, $(TxtPhone).val())) return;
        if (!CheckBlur(3, $(TxtverifyCode).val())) return;
        if (!CheckBlur(3, $(TxtverifyCode).val())) return;
        CleanTip1();
        SetDisabled(BtnByPhone, GetMsgTitle(149), true);
        $.ajax({
            url: GetUrlInfo(10007) + "?phone=" + $(TxtPhone).val() + "&sms=" + $(TxtPhoneCode).val() + "&yzm="+$(TxtverifyCode).val()+"&t=" + Math.random(),
            type: 'POST',
            dataType: 'json',
            timeout: 300000,
            error: function () {
                SetDisabled(BtnByPhone, txt3, false);
                ShowTip(TxtPhone, pTip1, GetMsgInfo(10001));
            },
            success: function (obj) {
                if (obj.IsOk) {
                    SetDisabled(BtnByPhone, txt3, false);
                    $("#phoneFindStep1").hide();
                    $("#phoneFindStep2").show();
                    $("#clearfix1").removeClass("active");
                    $("#clearfix2").addClass("active");
                } else {
                    switch (obj.Msg) {
                        case "1": ShowTip(TxtPhone, pTip1, GetMsgTitle(195)); break;
                        case "2": ShowTip(TxtverifyCode, pTip2, GetMsgTitle(196));$(yzm1).click(); break;
                        case "3": ShowTip(TxtPhoneCode, pTip3, GetMsgTitle(197)); break;
                        case "4": ShowTip(TxtPhoneCode, pTip3, GetMsgTitle(198)); break;
                        case "5": ShowTip(TxtPhoneCode, pTip3, GetMsgTitle(199)); break;
                        default: ShowTip(TxtPhone, pTip1, GetMsgTitle(200)); break;
                    }
                    SetDisabled(BtnByPhone, txt3, false);
                }
            }
        });
    }
};
//确定
function SavePwdPhone() {
    if (!isBlank($(p_pwd1).val()) || !isBlank($(p_pwd2).val())) {
        if (!isBlank($(p_pwd1).val())) {
            ShowTip(p_pwd1, pTip4, null);
        }
        if (!isBlank($(p_pwd2).val())) {
            ShowTip(p_pwd2, pTip5, null);
        }
    }
    else {
        if (!CheckBlur(5, $(p_pwd1).val())) return false;
        CleanTip3();
        if ($(p_pwd1).val() != $(p_pwd2).val()) {
            ShowTip(p_pwd2, pTip5, GetMsgTitle(203));
            return false;
        };
        SetDisabled(BtnSavePhone, GetMsgTitle(149), true);
        $.ajax({
            url: GetUrlInfo(10008) + "?Pwd=" + $(p_pwd1).val() + "&phone=" + $(TxtPhone).val() + "&code=" + $(TxtPhoneCode).val() + "&type=1&t=" + Math.random(),
            type: 'POST',
            dataType: 'json',
            timeout: 300000,
            error: function () {
                SetDisabled(BtnByPhone, txt2, false);
                ShowTip(TxtPhone, pTip1, GetMsgInfo(10001));
            },
            success: function (obj) {
                if (obj.IsOk) {
                    SetDisabled(BtnSavePhone, txt2, false);
                    alert(GetMsgTitle(204));
                    window.location.href = GetUrlInfo(10001);
                } else {
                    ShowTip(p_pwd1, pTip4, obj.Msg);
                    SetDisabled(BtnSavePhone, txt2, false);
                }
            }
        });
    }
};
