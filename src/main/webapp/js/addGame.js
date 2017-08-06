
$(function () {
    $.formValidator.initConfig({ formid: "from1", onerror: function (msg) { return false; }, onsuccess: function () {return SaveProInfo() } });
    $("#gameName").formValidator({ onshow: "", onfocus: "请输入游戏名", oncorrect: "" }).inputValidator({ min: 3, max: 30, onerror: "游戏名称为3～30个字符" });
    $("#gamePath").formValidator({ onshow: "", onfocus: "请填写游戏的下载地址", oncorrect: "" }).inputValidator({ min: 1,onerror: "下载路径不能为空" });
    $("#packageName").formValidator({ onshow: "", onfocus: "请填写游戏的包名", oncorrect: "" }).inputValidator({ min: 1,onerror: "游戏包名不能为空" });
});

function SaveProInfo() {

   // var data = $("#from1").serialize();
    var data = new FormData();
    data.append("file",$("#s_file")[0].files[0]);
    data.append("gameName",$("#gameName").val());
    data.append("gamePath",$("#gamePath").val());
    data.append("packageName",$("#packageName").val());
    //var formData = new FormData($( "#from1" )[0]);
    // $.post(getRootPath()+"/game/zengJia/?t=" + Math.random(),
    //     //{gameName:$('#gameName').val(),gamePath:$('#gamePath').val(),packageName:$('#packageName').val()},
    //     data,
    //     function (obj) {
    //     //alert(obj.IsOk);
    //     if (obj.IsOk) {
    //         parent.R_Game();
    //         parent.ShowOK(119, 10026);
    //     } else {
    //         parent.ShowError(118, 10016);
    //     }
    // }, "json");
    $.ajax({
        url : getRootPath()+"/game/zengJia/?t=" + Math.random(),
        type : 'POST',
        data : data,
        contentType: false,
        processData: false,
        dataType: 'json',
        success : function (obj) {
                if (obj.IsOk) {
                    parent.R_Game();
                    parent.ShowOK(119, 10026);
                } else {
                    parent.ShowError(118, 10016);
                }

        },
        error: function (obj) {
            alert(obj);
        }
    });
    return false;
}


