/**
 * Created by Administrator on 2017/5/11 0011.
 */
var warning = "input_warning";
var RegEail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/; //验证邮箱
var RegTel = /^0?(13[0-9]|15[012356789]|18[01236789]|14[57]|17[012356789])[0-9]{8}$/; //验证电话

var isBlank = function (a) {
    if (a == undefined || a == null || a.length == 0) {
        return false;
    } else {
        return true;
    }
};

function verfocus(Id, Tip) {
    $(Id).focus(function () {
        $(Tip).hide();
    });
}
function ShowTip(Id, Tip, Msg) {
    $(Tip).show();
    $(Id).addClass(warning);
    if (isBlank(Msg)) {
        $(Tip).text(Msg);
    }
}

function SetDisabled(Id, Title,disabled) {
    $(Id).val(Title).attr("disabled", disabled);
}