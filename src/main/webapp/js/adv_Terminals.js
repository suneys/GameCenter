var $table;
function initTable() {
    $table = $('#TableList').bootstrapTable({
        method: "post",
        url: getRootPath() + "terminal/list",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        height: $(window).height() - 20,
        striped: true,
        cache: false,
        sortable: true,
        sortOrder: "asc",
        singleSelect: false,
        search: true,
        pagination: true,
        showRefresh: true,
        showToggle: true,
        showColumns: true,
        clickToSelect: true,
        cardView: false,
        detailView: false,
        iconSize: "outline",
        toolbar: "#exampleTableEventsToolbar",
        pageSize: 10,
        pageNumber: 1,
        pageList: [10, 20, 30, 40],
        sidePagination: "server",
        queryParams: queryParams,
        minimunCountColumns: 2,
        icons: {
            refresh: "glyphicon-repeat",
            toggle: "glyphicon-list-alt",
            columns: "glyphicon-list"
        },
        columns: [
            operatecolumns()
        ],
        onLoadSuccess: function () {

        },
        onLoadError: function () {
            parent.ShowError(103, 10012);
        },
        onEditableSave: function (field, row, oldValue, $el) {
            //alert(field);
            //alert(row.Id);
            //alert(row.TerminalName);
            //alert(oldValue);
            //alert(JSON.stringify(row));
            //alert(row.TerminalName.length);
            if (row.TerminalName.length == 0 || row.TerminalName.length > 10) {
                parent.ShowError(105, 10014);
                return;
            }
            $.ajax({
                type: "post",
                dataType: 'json',
                url: getRootPath() + "terminal/editName/?TerminalNo=" + row.TerminalNo + "&N=" + row.TerminalName,
                data: {strJson: JSON.stringify(row)},
                success: function (obj) {
                    if (!obj.IsOk) {
                        parent.ShowError(101, 10014);
                    }
                    $("button")[6].click();
                },
                error: function () {
                    parent.ShowError(101, 10010);
                },
                complete: function () {

                }
            });
        }
    });
}
function IcoIndex(value, rows) {
    var icon = rows.Id % 2 === 0 ? 'fa fa-desktop' : 'fa fa-laptop'
    return '<i class="' + icon + '"></i> ' + value;
}
function stateFormatter(value, rows) {
    if (rows.IsOverdue) {
        return {
            disabled: true,
            checked: false
        };
    }
    return value;
}
function IcoPublishState(value, rows) {

    var Id = "id=\"s_" + rows.TerminalNo + "\"";
    if (rows.PublishState === 1)//成功
        return '<span ' + Id + ' class="label label-primary"> 发布成功</span> ';
    else if (rows.PublishState === 2)//响应
        return '<span ' + Id + ' class="label label-warning">发布中</span>';
    else//未发布
        return '<span ' + Id + ' class="label label-danger">未发布</span> ';


}
function IcoEndDate(value, rows) {
    if (rows.IsOverdue || rows.Activation == 1) {
        return value + VipClass(rows.TerminalNo);
    }
    else {
        return value;
    }
}
function VipClass(TerminalNo) {
    return '&nbsp;<a href=\"javascript:R_NavAcount(3)\" target=\"_blank\" title=\"支付宝续费\" class="fa fa-credit-card"></a> ' + '<a href=\'javascript:parent.ShowInput(174,10065,"RegistTer","' + TerminalNo + '|10");\' title=\"注册码续费\" class="fa fa-key"></a> '
}
window.operateEvents = {
    'click .like': function (e, value, row, index) {
        alert(row.id);
    },
    'click .edit': function (e, value, row, index) {
        $table.bootstrapTable('refresh');
        alert("sx")
    },
    'click .remove': function (e, value, row, index) {
        alert("sc")
    }
};
function queryParams(params) {
    return {
        rows: params.limit,
        page: (params.offset / params.limit) + 1,
        sort: params.sort,
        order: params.order,
        SearchName: $(".input-outline").val()
    };
}

$(function () {
    initTable();
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
});
var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};
    oInit.Init = function () {
    };
    return oInit;
};
function GetSelectId() {
    var ids = "";
    var rows = $table.bootstrapTable('getSelections');
    for (var i = 0; i < rows.length; i++) {
        ids += rows[i].TerminalNo + ',';
    }
    ids = ids.substring(0, ids.length - 1);
    if (!isBlank(ids)) {
        parent.ShowInfo(102, 10011);
        return ids;
    }
    return ids;
}
var BtnSend = "#BtnSend";

var SendYun = function () {
    var Pid = $("#Ids").val();
    if (!isBlank(Pid)) {
        parent.ShowError(140, 10038);
        return false;
    }
    var chekId = GetSelectId();
    if (!isBlank(chekId)) {
        return false;
    }
    ;
    BtnDisabled(BtnSend, "", true);
    $.ajax({
        url: "/Terminal/Send/?ProgrammeId=" + Pid + "&TerminalNo=" + chekId + "&t=" + Math.random(),
        type: 'POST',
        dataType: 'json',
        timeout: 300000,
        error: function () {
            parent.ShowError(141, 10001);
            BtnDisabled(BtnSend, "", false);
        },
        success: function (obj) {
            if (obj.IsOk) {
                parent.ShowOK(obj.BackURL, GetMsgInfo(10039), true);
                var array = chekId.split(",");
                for (var n = 0; n < array.length; n++) {
                    CheckIsSuccess(array[n]);
                }
            } else {
                if (obj.Msg == "1") {
                    parent.ShowWarning(205, 10085, "VIP", "0");
                }
                else {
                    parent.ShowInfo(obj.Msg, GetMsgInfo(10016), true);
                }
                BtnDisabled(BtnSend, "", false);
            }
        }
    });
}

function CheckIsSuccess(TerminalNo) {
    var timeID;
    var Counts_ = 1;
    $("#s_" + TerminalNo).removeClass("label-primary").addClass("label-danger");
    $("#s_" + TerminalNo).text("处理中...");
    timeID = window.setInterval(function () {
        $.post("/M/Terminals/Check/?TerminalNo=" + TerminalNo, function (obj) {
            if (obj.IsOk) {
                $("#s_" + TerminalNo).removeClass("label-danger").addClass("label-primary");
                $("#s_" + TerminalNo).text("发布成功");
                Counts_ = 0;
                clearInterval(timeID);
                BtnDisabled(BtnSend, "", false);
            }
            else if (Counts_ <= 3) {
                $("#s_" + TerminalNo).text(Counts_ + "次监测..");
            }
            else {
                $("#s_" + TerminalNo).removeClass("label-danger").addClass("label-warning");
                $("#s_" + TerminalNo).text("检查网络");
                Counts_ = 0;
                clearInterval(timeID);
                BtnDisabled(BtnSend, "", false);
            }
            Counts_++;
        }, "json");
    }, 3000);//3秒
}

function ScreenShot() {
    var Ids = GetSelectId();
    if (isBlank(Ids)) {
        $.post("/Terminal/ScreenShot/?Ids=" + Ids, function (obj) {
            if (obj.IsOk) {
                var Array = Ids.split(",");
                for (var n = 0; n < Array.length; n++) {
                    $("#s_" + Array[n]).removeClass("label-primary").addClass("label-danger");
                    $("#s_" + Array[n]).text("处理中...");
                    LodingScreenShot(4, Array[n]);
                }
            } else {
                parent.ShowError(126, 10031);
            }
        }, "json");
    }
}

function LodingScreenShot(count, TerminalId) {
    window.setTimeout(function () {
        count--;
        if (count > 0) {
            $("#s_" + TerminalId).text(count + "秒获取");
            LodingScreenShot(count, TerminalId);
        }
        else {
            $.post("/Terminal/GetCutPath/?TerminalId=" + TerminalId, function (obj) {
                if (obj.IsOk) {
                    $("#s_" + TerminalId).removeClass("label-danger").addClass("label-primary");
                    $("#s_" + TerminalId).text(GetMsgTitle(123));
                    //parent.OpenWindows(obj.Msg);
                    parent.OpenModal("/Terminal/CutView/?Path=" + obj.Msg, "远程截图");
                } else {
                    $("#s_" + TerminalId).text(GetMsgTitle(124));
                    parent.ShowError(122, 10029);
                }
            }, "json");
        }
    }, 1000);
};
var ParentRefresh = function () {
    $("button[name=refresh]").click();
    //$("button")[2].click();
};
var PlayPro = function () {
    var chekId = GetSelectId();
    if (!isBlank(chekId)) {
        return false;
    }
    else {
        OpenPlay(chekId);
    }
}