var finish = 0;
window.onbeforeunload = function (e) {
    e = e || window.event;
    if (finish > 0) {
        if (e) {
            e.returnValue = '正在上传素材，确定要离开吗？';
        }
        else {
        }
        return '正在上传素材，确定要离开吗？';
    }
};
var pageIndex = 0, pageSize = 12, total = 0;
var BtnUpload = "#BtnUpload";
$(function () {
    LoadPage();
});
function LoadPage() {
    InitTable(0);
    PageLoding(0);
}
function PageLoding() {
    window.setTimeout(function () {
        $("#Pagination").pagination(total, {
            callback: PageCallback,
            prev_text: '<',       //上一页按钮里text
            next_text: '>',       //下一页按钮里text
            items_per_page: pageSize,
            num_edge_entries: 1,       //两侧首尾分页条目数
            num_display_entries: 3,    //连续分页主体部分分页条目数
            current_page: 0   //当前页索引
        });
        $("body").removeAttr("style");
    }, 300);
}
function PageCallback(index) {
    InitTable(index);
};
var capacity1=0,capacity2=0;

function InitTable(pageindex) {
    $(".col-sm-12 div").remove();
    $.ajax({
        url: getRootPath()+"/resource/list/?Id=0&t=" + Math.random(),
        type: 'POST',
        dataType: 'json',
        timeout: 30000,
        data: "pageIndex=" + (pageindex + 1) + "&pageSize=" + pageSize + "&fid=" + $("#fid").val() + "&tid=" + $("#tid").val() + "&SouceType=0",// + $("#SouceType").val(),
        error: function () {
            parent.ShowError(108, 10001);
        },
        success: function (data) {
            $(".col-sm-12 div").remove();
            var content = '';
            total = data.total;
            capacity1 = data.other.split('|')[1];
            capacity2 = data.other.split('|')[2];
            $("#maxsize").html("<i class=\"glyphicon glyphicon-hdd\"></i>总储存<span style=\"color:red;\">" + data.other.split('|')[0] + "</span>,可用<span style=\"color:red;\">" + data.other.split('|')[1] + "</span>");
            for (var n = 0; n < data.rows.length; n++) {
                content += "<div class=\"file-box\" onclick=\"DivCheckBox(" + data.rows[n].Id + ")\">";
                content += "<div class=\"file\"><span><span class=\"corner\"></span>";
                if (data.rows[n].SouceType == 3)
                    content += "<div class=\"icon\"><i class=\"fa fa-music\"></i></div>";
                else
                    content += "<div class=\"image\"><img alt=\"image\" class=\"img-responsive\" style=\"width:100%; height:100%;\" src=\"" + $("#Images_").val() + data.rows[n].ThumbPath + "\"></div>";
                content += "<div class=\"file-name\">" + data.rows[n].FileNameStr + IcoSouceType(data.rows[n].SouceType) + "<br/>";
                content += "<small>大小：" + data.rows[n].FileSizeStr + "</small>";
                content += "<span onclick=\"DivCheckBox(" + data.rows[n].Id + ")\" class=\"checkbox checkbox-success checkbox-inline\" style=\"float:right;\"><input type=\"checkbox\"  name=\"ID\"  id=\"inlineCheckbox" + data.rows[n].Id + "\" value=\"" + data.rows[n].Id + "\"><label for=\"inlineCheckbox" + data.rows[n].Id + "\"></label></span>";
                content += "</div></a></div></div>";
            }
            if (isBlank(content)) {
                $(".col-sm-12").append(content);
                $(".file-box").each(function () {
                    animationHover(this, "pulse")
                });
            }
            else {
                $(".col-sm-12").append("<div><h3>" + getSoucetxt() + "</h3></div>");
            }
        }
    });
};
function getSoucetxt() {
    var resurt = "";
    switch (parseInt($("#SouceType").val())) {
        case 0: resurt = GetMsgInfo(10077); break;
        case 1: resurt = GetMsgInfo(10078); break;
        case 2: resurt = GetMsgInfo(10079); break;
        case 3: resurt = GetMsgInfo(10080); break;
    }
    return resurt;
};
function DivCheckBox(Id) {
    $("#inlineCheckbox" + Id).click();
};
var BtnFile = "#s_file", BtnSuffix = "#accept";
function UploadFile(Id) {
    if (Id == 1) {
        $(BtnFile).click();
    }
    else {
        var Array = document.getElementById("s_file").files, FileSize = 0;
        var IsSuffix = true, IsSize = true;
        if (Array.length >10) {
            parent.ShowInfo(188, 10076);
            resetFileInput($(BtnFile));
            return false
        }
        for (var i = 0; i < Array.length; i++) {
            var UploadSuffix = $(BtnFile).val().substr($(BtnFile).val().lastIndexOf(".")).toLowerCase();
            if ($(BtnSuffix).val().toLowerCase().indexOf(UploadSuffix) == -1) {
                parent.ShowInfo(GetMsgTitle(189), "支持格式：" + $(BtnSuffix).val().toLowerCase(), true);
                resetFileInput($(BtnFile));
                IsSuffix = false;
                break;
            }
            else {
                FileSize += Array[i].size;
            }
        }
        if (!IsSuffix) return false;
        if (FileSize > capacity2) {
            if ($("#VIP").val()==1)
                parent.ShowWarning(190, 10086, "VIP", "0");
            else
                parent.ShowInfo(GetMsgTitle(190), "请上传小于" + capacity1 + "文件,如需扩容，请联系客服专员", true);
            resetFileInput($(BtnFile));
            return false;
        };
        $("#form2").attr("action", getRootPath()+"/resource/upload/?Id=" + $("#fid").val() + "&t=" + Math.random());
        $("#s_submit").click();
    };
};
$(document).ready(function () {
    $('#form2').ajaxForm({
        beforeSend: function () {
            finish = 1;
            $("#progress").show();
            //$(BtnUpload).text(GetMsgInfo(10005)).attr("disabled", true);
        },
        uploadProgress: function (event, position, total, percentComplete) {
            if (percentComplete >= 99) {
                percentComplete = 99;
            };
            $("#progressfont").html(percentComplete + "%");
            $(".progress-bar-warning").css("width", percentComplete + "%");
            finish = 1;
            //if (percentComplete==100)
            //    $(BtnUpload).text(GetMsgInfo(10020)).attr("disabled", true);
            //else
             //   $(BtnUpload).text(GetMsgInfo(10019) + "：" + percentVal).attr("disabled", true);
        },

        complete: function (xhr) {

        },
        success: function (responseText, statusText, xhr, $form) {
            var obj = jQuery.parseJSON(responseText);
            if (obj.IsOk) {
                //$(BtnUpload).text(GetMsgInfo(10017)).attr("disabled", false);
            }
            else {
                parent.ShowInfo(GetMsgTitle(191), obj.Msg,true);
                //$(BtnUpload).text(obj.Msg).attr("disabled", false);
            }
            finish = 0;
            $("#progress").hide();
            $("#progressfont").html("0%");
            $(".progress-bar-warning").css("width", "0%");
            resetFileInput($("#s_file"));
            LoadPage();
        },
        error: function () {
            finish = 0;
            $(BtnUpload).text(GetMsgInfo(10018)).attr("disabled", false);
        }
    });
});
function resetFileInput(file) {
    file.after(file.clone().val(""));
    file.remove();
    finish = 0;
}
function IcoSouceType(SouceType) {
    if (SouceType == 0) return " <i class=\"glyphicon glyphicon-picture\"></i>";
    else if (SouceType == 1) return " <i class=\"glyphicon glyphicon-facetime-video\"></i>";
    else return " <i class=\"fa fa-music\"></i>";
}

function GetResourceIds(){
    var ID = document.all.form1.ID;
    var Ids = GetIDStr(ID);
    if (!isBlank(Ids)) {
        parent.ShowInfo(102, 10011);
        return "";
    }
    else {
        return Ids;
    }
}
function DelResource(state) {
    var Ids = GetResourceIds();
    if (isBlank(Ids)) {
        if (state == 0) {
            parent.ShowWarning(106, 10010, "Resource", 1)
        }
        else {
            $.post(getRootPath()+"/resource/delete/?resIds=" + Ids, function (obj) {
                if (obj.IsOk) {
                    parent.ShowOK(120, 10027);
                    LoadPage();
                } else {
                    parent.ShowError(107, 10015);
                }
            }, "json");
        }
    }
} 
function SouceType(Id) {
    $("#SouceType").val(Id);
    var b = $(".file-control");
    b.each(function () {
        if ($(this).hasClass("active")) {
            $(this).removeClass("active")
        }
    });
    $("#a_" + Id).addClass("active");
    LoadPage();
}
function RefreshPage() {
    //self.location.reload();
    LoadPage();
    LoadZtree();
}
function AddToTemInfo() {
var Ids = GetResourceIds();
if (isBlank(Ids)) {
    $.post("/Template/GetResourcePath/?Ids=" + Ids + "&souce=" + parseInt($("#SouceType").val()), function (obj) {
        if (obj.IsOk) {
            parent.R_loadParent(obj.BackURL, obj.attributes.thumb, $("#iframe").val(), obj.Data);
            CloseSub();
        }
        else {
            switch (parseInt($("#SouceType").val())) {
                case 1: parent.ShowInfo(GetMsgTitle(192), obj.Msg, true); break;
                case 2: parent.ShowInfo(GetMsgTitle(193), obj.Msg, true); break;
                case 3: parent.ShowInfo(GetMsgTitle(194), obj.Msg, true); break;
            }
        }
        }, "json");
    }
}
