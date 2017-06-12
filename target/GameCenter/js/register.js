
var Tel = "#Tel", pwd1 = "#pwd1", Email = "#Email", pwd2 = "#pwd2";
var uTip1 = "#uTip1", pTip1 = "#pTip1", uTip2 = "#uTip2", pTip2 = "#pTip2";
var  BtnSubmit = ".btn_lg";
document.onkeydown = function (evt) {
    var evt = window.event ? window.event : evt;
    if (evt.keyCode == 13) {
        $(BtnSubmit).click();
    }
};
$(document).ready(function () {
    verfocus(Tel, uTip1);
    verfocus(pwd1, pTip1);
    verfocus(Email, uTip2);
    verfocus(pwd2, pTip2);

    verification(Tel,uTip1,1);
    verification(pwd1,pTip1,3);
    verification(Email, uTip2,2);
    verification(pwd2, pTip2, 4);

    $.AutoComplete('#Email',true);
});

function SubmitRegister() {
    if ($("#Model").val() == 1)  CheckTel();
    else  CheckEail();
}
function CheckBlur(ctype, val) {
    if (ctype == 1) {
        if (!RegTel.test(val)) {
            ShowTip(Tel, uTip1, GetMsgInfo(10003));
            return false;
        }
    }
    else if (ctype == 2) {
       if (!RegEail.test(val)) {
           ShowTip(Email, uTip2, GetMsgInfo(10004));
           return false;
       }
   }
    else if (ctype == 3) {
       if (val.length < 6) {
           ShowTip(pwd1, pTip1, GetMsgInfo(10002));
           return false;
       }
   }
    else if (ctype == 4) {
       if (val.length < 6) {
           ShowTip(pwd2, pTip2, GetMsgInfo(10002));
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
function CheckTel() {
    if (!isBlank($(Tel).val()) || !isBlank($(pwd1).val())) {
        if (!isBlank($(Tel).val())) {
            ShowTip(Tel, uTip1, null);
        }
        if (!isBlank($(pwd1).val())) {
            ShowTip(pwd1, pTip1, null);
        }
        return;
    }
    else {
        if (!CheckBlur(1, $(Tel).val())) return;
        if (!CheckBlur(3, $(pwd1).val())) return;

        $("#UserName").val($(Tel).val());
        $("#PassWord").val($(pwd1).val());
        
        ReisterInfo(1);
    }
}
function CheckEail() {
    if (!isBlank($(Email).val())|| !isBlank($(pwd2).val())) {
        if (!isBlank($(Email).val())) {
            ShowTip(Email, uTip2,null);
        }
        if (!isBlank($(pwd2).val())) {
            ShowTip(pwd2, pTip2, null);
        }
        return;
    }
    else {
        
        if (!CheckBlur(2, $(Email).val())) return;
        if (!CheckBlur(4, $(pwd2).val())) return;

        $("#UserName").val($(Email).val());
        $("#PassWord").val($(pwd2).val());
        ReisterInfo(2);
    }
}
function ReisterInfo(Id) {
    CleanTip();
    SetDisabled(BtnSubmit, GetMsgInfo(10021), true);
    $.ajax({
        url: GetUrlInfo(10002) + "?t=" + Math.random(),
        type: 'POST',
        dataType: 'json',
        timeout: 300000,
        data: $("#form1").serialize(),
        error: function () {
            SetDisabled(BtnSubmit, GetMsgInfo(10008), false);
            if (Id == 1) {
                ShowTip(Tel, uTip1, GetMsgInfo(10001))
            }
            else {
                ShowTip(Email, uTip2, GetMsgInfo(10001))
            }
        },
        success: function (obj) {
            if (obj.IsOk) {
                window.location = GetUrlInfo(10005);
            } else {
                SetDisabled(BtnSubmit, GetMsgInfo(10008), false);
                if (Id == 1) {
                    $(uTip1).show();
                    $(uTip1).html(obj.Msg);
                }
                else {
                    $(uTip2).show();
                    $(uTip2).html(obj.Msg);
                }
            }
        }
    });
}
function SelectModel(id) {
    if (id == 1) {
        $("#mailModel").removeClass("active");
        $("#phoneModel").addClass("active");
        $("#selectModel").css("left", "0px");
        $("#phoneRegister").show();
        $("#emailRegister").hide();
        $("#Model").val(1);
    }
    else {
        $("#phoneModel").removeClass("active");
        $("#mailModel").addClass("active");
        $("#selectModel").css("left", "150px");
        $("#phoneRegister").hide();
        $("#emailRegister").show();
        $("#Model").val(2);
    }
    CleanTip();
}
function CleanTip() {
    $(uTip1).hide();
    $(pTip1).hide();
    $(uTip2).hide();
    $(pTip2).hide();
    $(Tel).removeClass(warning);
    $(pwd1).removeClass(warning);
    $(Email).removeClass(warning);
    $(pwd2).removeClass(warning);
}