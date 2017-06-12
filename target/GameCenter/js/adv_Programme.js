var $table;
function initTable() {
    $table = $('#TableList').bootstrapTable({
        method: "post",//做数据查询时，建议用Get方式；而在做数据添加、修改或删除时，建议用Post方式
        url: "/Programme/ProgrammeList/?t=" + Math.random(),
        dataType: "json",
        //"queryParamsType": "limit",//参数格式,发送标准的RESTFul类型的参数请求 
        contentType: "application/x-www-form-urlencoded",
        height: $(window).height() -20,//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度            
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）                 
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        singleSelect: false,//是否单选
        search: true,//显示搜索框
        pagination: true,//在表格底部显示分页工具栏
        showRefresh: true,//是否显示刷新
        showToggle: true,//是否显示详细视图和列表视图的切换按钮  
        showColumns: true,//是否要选择显示的列
        clickToSelect: true,                //是否启用点击选中行
        cardView: false,                    //是否显示详细视图
        detailView: false,                  //是否显示父子表
        //showExport: true,                     //是否显示导出
        //exportDataType: "basic",              //basic', 'all', 'selected'.
        iconSize: "outline",
        toolbar: "#exampleTableEventsToolbar", //工具按钮用哪个容器
        pageSize: 10, //每页的记录行数（*）
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageList: [10,20,30,40],
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        queryParams: queryParams,//传递参数（*）
        minimunCountColumns: 2,//最少允许的列数  
        icons: {
            refresh: "glyphicon-repeat",
            toggle: "glyphicon-list-alt",
            columns: "glyphicon-list"
        },
        columns: [
        operatecolumns()
        ],
        onLoadSuccess: function (date) {
            sortOrder = date.sortOrder;
            field = date.field;
        },
        onLoadError: function () {
            parent.ShowError(103, 10012);
        }
    });
}
function IcoIndex(value, rows) {
    var icon = rows.Id % 2 === 0 ? 'glyphicon-star' : 'glyphicon-star-empty'
    return '<i class="glyphicon ' + icon + '"></i> ' + value;
}
function stateFormatter(value, rows) {
    if (!isBlank(rows.TemplateStr)) {
        return {
            disabled: true,
            checked: false
        };
    }
    return value;
}
var count = 0;
function IcoEdit(value, row, index) {
    count++;
    if (count == 0) {
        return [
              '<button onclick="EditPro(' + row.Id + ')\"  data-intro="3.点我可帮您删除素材" data-step="2" class="btn btn-default btn-xs"  href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="参数设置">',
                    '<i class="glyphicon glyphicon-time"></i>',
                '</button>',
               '<button onclick=\"R_ManageLink1(' + row.Id + ',\'' + SubStrName(row.ProgrammeName) + '\')\" class="btn btn-default btn-xs" style="margin-left:5px" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="编辑模板">',
                    '<i class="glyphicon glyphicon-pencil"></i>',
                '</button>',
        ].join('');
    }
    else {
        return [
               '<button onclick="EditPro(' + row.Id + ')\" class="btn btn-default btn-xs"  href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="参数设置">',
                     '<i class="glyphicon glyphicon-time"></i>',
                 '</button>',
                '<button onclick=\"R_ManageLink1(' + row.Id + ',\'' + SubStrName(row.ProgrammeName) + '\')\" class="btn btn-default btn-xs" style="margin-left:5px" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="编辑模板">',
                     '<i class="glyphicon glyphicon-pencil"></i>',
                 '</button>',
        ].join('');
    }
}

function stateFormatter(value, rows) {
    if (!isBlank(rows.TemplateStr)) {
        return {
            disabled: true,
            checked: false
        };
    }
    return value;
}
window.operateEvents = {
    'click .like': function (e, value, row, index) {
    },
    'click .edit': function (e, value, row, index) {
        $table.bootstrapTable('refresh');
    },
    'click .remove': function (e, value, row, index) {
    }
};

function queryParams(params) {
    return {
        rows: params.limit,//页面大小
        page: (params.offset / params.limit) + 1,//params.pageNumber
        sort: params.sort, //排序列名
        order: params.order,//排位命令（desc，asc）
        SearchName: $(".input-outline").val()//搜索名称
    };
}

$(function () {
    initTable();
});
function DelPro(state) {
    var Pid = GetSelectId();
    if (!isBlank(Pid)) {
        return false;
    }
    if (state == 0) {
        parent.ShowWarning(106, 10010, "DelPro", 1);
    }
    else {
        $.post("/Programme/Del/?ProgrammeId=" + Pid, function (obj) {
            if (obj.IsOk) {
                parent.ShowOK(120, 10027);
                ParentRefresh();
            } else {
                parent.ShowError(107, 10016);
            }
        }, "json");
    }
};
function CopyPro(state) {
    var Pid = GetSelectId();
    if (!isBlank(Pid)) {
        return false;
    }
    if (state == 0) {
        parent.ShowWarning(177, 10068, "CopyPro", 1);
    }
    else {
        $.post("/Programme/CopyPro/?ProgrammeId=" + Pid, function (obj) {
            if (obj.IsOk) {
                parent.ShowOK(178, 10069);
                ParentRefresh();
            } else {
                parent.ShowError(179, 10016);
            }
        }, "json");
    }
};
function AddPro() {
    parent.OpenModal('/Programme/Add/', '新增节目菜单', "750px");
}
function EditPro(Id) {
    parent.OpenModal('/Programme/Add/?ProgrammeId=' + Id, '修改节目菜单', "750px");
}
function GetSelectId() {
    var ids = "";
    var rows = $table.bootstrapTable('getSelections');
    for (var i = 0; i < rows.length; i++) {
        ids += rows[i].Id + ',';
    }
    ids = ids.substring(0, ids.length - 1);
    if (!isBlank(ids)) {
        parent.ShowInfo(102, 10011);
        return ids;
    }
    return ids;
};
function IsTemplateStr() {
    var IsBool = true, ProgrammeName="";
    var rows = $table.bootstrapTable('getSelections');
    for (var i = 0; i < rows.length; i++) {
        if (!isBlank(rows[i].TemplateStr)) {
            IsBool = false;
            ProgrammeName += rows[i].ProgrammeName + ",";
        }
    }
    if (IsBool==false) {
        parent.ShowInfo(GetMsgTitle(176), SubStrName(TriEnd(ProgrammeName),16) + "需创建模板才能发布！", true);
        return IsBool;
    }
    return IsBool;
};
var R_SendPro = function () {
    var Ids = GetSelectId();
    if (isBlank(Ids)) {
        if (IsTemplateStr()) {
            R_SendTerminals(Ids);
        }
    }
}
//新增节目成功后加载表格
var ParentRefresh = function () {
    //var BtnRefresh = $("button")[2];
    //BtnRefresh.click();
    $("button[name=refresh]").click();
}
