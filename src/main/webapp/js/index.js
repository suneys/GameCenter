/*!
 @Name：电脑端公用JS操作集合
 @Author：Mr.Liu
 @Date：2016-08-08
 @License：MIT  
 */
var isBlank = function (a) {
    if (a == undefined || a == null || a.length == 0) {
        return false;
    } else {
        return true;
    }
};
//截取字符串
var SubStrName = function (value, length) {
    if (value.length > length) {
        return value.substr(0, length) + "...";
    }
    else {
        return value;
    }
};
//去最后一个字符
function TriEnd(str) {
    if (isBlank(str)) {
        return str.substring(0, str.length - 1);
    }
    else {
        return "";
    }
};
function BtnDisabled(Id, Title, disabled) {
    $(Id).val(Title).attr("disabled", disabled);
};

var success = "success", error = "error", info = "info", warning = "warning", input = "input";
var confirmButtonText = "确定", cancelButtonText = "取消", inputPlaceholder = "请在此输入...", animation = "slide-from-top", showInputError="输入内容不能为空！";
var timer = 6000, confirmButtonText1 = "确定";//确定(3)
var InfoColor = "#F8AC59", errorColor = "#DD6B55", successColor = "#19B293";

//成功用这个  parent.ShowOK(101,1001)
function ShowOK(title, text, IsCode) {
    if (isBlank(IsCode)) {
        swal({ title: title, text: text, timer: timer, confirmButtonText: confirmButtonText1, confirmButtonColor: successColor, type: success });
    }
    else {
        swal({ title: GetMsgTitle(title), text: GetMsgInfo(text), timer: timer, confirmButtonText: confirmButtonText1, confirmButtonColor: successColor, type: success });
    }
};
//失败用这个 parent.ShowError(101,1001)
function ShowError(title, text, IsCode) {
    if (isBlank(IsCode)) {
        swal({ title: title, text: text, timer: timer, confirmButtonText: confirmButtonText1, confirmButtonColor: errorColor, type: error });
    }
    else {
        swal({ title: GetMsgTitle(title), timer: timer, text: GetMsgInfo(text), confirmButtonText: confirmButtonText1, confirmButtonColor: errorColor, type: error });
    }
};
//提示用这个 parent.ShowInfo(101,1001)
function ShowInfo(title, text, IsCode) {
    if (isBlank(IsCode)) {
        swal({ title: title, text: text, timer: timer, confirmButtonText: confirmButtonText1, confirmButtonColor: InfoColor, type: info });
    }
    else {
        swal({ title: GetMsgTitle(title), timer: timer, text: GetMsgInfo(text), confirmButtonText: confirmButtonText1, confirmButtonColor: InfoColor, type: info });
    }
};
//询问用这个
function ShowWarning(title, text, directive, strId, Text1, Text2) {
    if (isBlank(Text1)) {
        confirmButtonText = Text1;
    };
    if (isBlank(Text2)) {
        cancelButtonText = Text2;
    };
    swal({
        title: GetMsgTitle(title),
        text: GetMsgInfo(text),
        type:warning,
        showCancelButton: true,
        confirmButtonColor: errorColor,
        confirmButtonText: confirmButtonText,
        cancelButtonText: cancelButtonText,
        closeOnConfirm: false,
        closeOnCancel: true
    },
    function (isConfirm) {
        if (isConfirm) {
            switch (directive) {
                case "LoginOut": window.location.href = getRootPath()+"logout";break;
                case "Resource": parent.frames["iframe9"].window.DelResource(strId); break;//删除资源
                case "DelPro": parent.frames["iframe9"].window.DelPro(strId); break;
                case "CopyPro": parent.frames["iframe9"].window.CopyPro(strId); break;
                case "Tem": parent.frames["iframe_"].window.DelTemInfo(strId); break;//删除模板
                case "Send": parent.frames["iframe" + strId].window.SaveTemplate(1); break;//询问是否前往发布
                case "solution"://重置分辨率
                    var Arrary = strId.split('|');
                    parent.frames["iframe" + Arrary[0]].window.resolution(Arrary[1], 1);
                    break; 
                case "Menu": parent.frames["iframe_"].window.DelMenu(strId, 1); break;//功能
                case "Create": parent.frames["iframe" + strId].window.CreateTemplate(1); break;//新增模板
                case "Edit": //编辑模板
                    var Arrary = strId.split('|');
                    parent.frames["iframe" + Arrary[0]].window.EditTemplate(1, Arrary[1],0);
                    break;
                case "DelLog": parent.frames["iframe2"].window.DelLog(strId); break;
                case "VIP":parent.$(".cancel").click();R_NavAcount(3); break;
                case "dingdan": parent.frames["iframe_"].window.CheckSubId(); break;
                case "Game": parent.frames["iframe7"].window.DelGame(strId); break;
                default:
                    ShowError(151, 10043);
                    break;
            };
        };
    });
};
//输入文本值用这个
function ShowInput(title, text, directive, strId) {
    swal({
        title: GetMsgTitle(title),
        text: GetMsgInfo(text),
        type: input,
        showCancelButton: true,
        closeOnConfirm: false,
        confirmButtonColor: successColor,
        animation: animation,
        confirmButtonText: confirmButtonText,
        cancelButtonText: cancelButtonText,
        inputPlaceholder: inputPlaceholder,
        showLoaderOnConfirm: true
    },
   function (inputValue) {
       if (inputValue === false) return false;
       if (!isBlank(inputValue)) {
           swal.showInputError(showInputError);
           return false
       }
       else {
           switch (directive) {
               case "RegistTer"://终端注册
                   var Arrary = strId.split('|');
                   $.post("/Terminal/Register/?Number=" + inputValue + "&TerminalNo=" + Arrary[0], function (obj) {
                       if (obj.IsOk) {
                           parent.ShowOK(166, 10051);
                           parent.frames["iframe"+Arrary[1]].window.ParentRefresh();
                       } else {
                           swal.showInputError(obj.Msg);
                       }
                   }, "json");
                   break;
               case "website":
                   parent.frames["iframe" + strId].window.loadWebSite(inputValue);
                   break;
               case "bind":
                   $.post("/Terminal/Bind/?TerminalNo=" + inputValue, function (obj) {
                       if (obj.IsOk) {
                           parent.ShowOK(138, 10036);
                           parent.frames["iframe10"].window.ParentRefresh();
                       } else {
                           swal.showInputError(obj.Msg);
                       }
                   }, "json");
                   break;
           }
       }
   });
};
//关闭询问层
function CloseInfo() {
    $(".cancel").click();
}
function iFrameHeight(obj) {
    $(obj).siblings(".ibox-content").remove();
    $(obj).show();
    var idocumentElement = obj.contentWindow.document.documentElement;
    obj.height = idocumentElement.scrollHeight;
    //obj.height =550;
}
var OpenModal = function (url, title, width,show) {
    if (!isBlank(width)) width = "600px";
    if (!isBlank(show)) show =true;
    var html = "<div class=\"modal inmodal\" id=\"myModal2\" tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\">";
    html += "<div class=\"modal-dialog\" style=\"width:" + width + "\">";
    html += "<div class=\"modal-content animated bounceInRight\">";//flipInY  fadeIn bounceInRight
    if (show) {
        html += "<div class=\"modal-header\">";
        html += "<button type=\"button\" class=\"close\" data-dismiss=\"modal\"><span aria-hidden=\"true\">&times;</span><span class=\"sr-only\">Close</span></button>";
        html += "<h4 class=\"modal-title\">" + title + "</h4></div>";
    }
    else {//但不显示头部时
        html += "<button style=\"display:none;\" type=\"button\" class=\"close\" data-dismiss=\"modal\"><span aria-hidden=\"true\">&times;</span><span class=\"sr-only\">Close</span></button>";
    }
    html += "<div class=\"ibox-content\">";
    html += "<div class=\"spiner-example\">";
    html += "<div class=\"sk-spinner sk-spinner-cube-grid\">";
    html += "<div class=\"sk-cube\"></div>";
    html += "<div class=\"sk-cube\"></div>";
    html += "<div class=\"sk-cube\"></div>";
    html += "<div class=\"sk-cube\"></div>";
    html += "<div class=\"sk-cube\"></div>";
    html += "<div class=\"sk-cube\"></div>";
    html += "<div class=\"sk-cube\"></div>";
    html += "<div class=\"sk-cube\"></div>";
    html += "<div class=\"sk-cube\"></div>";
    html += "</div>";
    html += "</div>";
    html += "</div>";
    html += "<iframe ' id='iframe_' name='iframe_' onLoad='iFrameHeight(this)' frameborder='0' width='100%' height='100%'  style='display: none;'   scrolling='auto' src='" + url +"'>";
    html += "</div>";
    html += "</div>";
    html += "</div>";
    $("#myModal2").remove();
    $("body").append(html);
    $("#dialogBnt").click();
}

var CloseModal = function () {
    $(".close").click();
}
var CloseSub = function () {
    parent.CloseModal();
}

var SaveSubmit = function () {
    $("#SaveBtn").click();
}

var R_avatar = function () {
    OpenModal('/Mem/avatar/', '企业LoGo上传', "650px");
}

var R_LoginOut = function () {
    ShowWarning(104, 10013, "LoginOut", 1);
}

var R_Manage = function () {
    parent.OpenModal('/Template/Manage/?ProgrammeId=124&templateId=0', '模板编辑与管理', "95%",false);
}

//节目列表进入
var R_ManageLink1 = function (Id, N) {
    var iframe = "p" + Id;//解决iframe中name重复问题
    var url = "/Template/Manage/?ProgrammeId=" + Id + "&templateId=0&Solution=1&iframe=" + iframe + "&IsCreate=false";
    parent.$("#submenu8").attr("href", url).attr("data-index", iframe).text(SubStrName(N, 8)).click();
}
//模板列表进入
var R_ManageLink2 = function (tid,pid,s,N) {
    var iframe = "t" + tid;
    var url = "/Template/Manage/?ProgrammeId=" + pid + "&templateId=" + tid + "&Solution=" + s + "&iframe=" + iframe;
    CloseSub();
    parent.$("#submenu8").attr("href", url).attr("data-index", iframe).text(SubStrName(N, 8)).click();
}

var R_Template = function (Pid, iframe) {
    parent.OpenModal('/Template/List/?Pid=' + Pid + "&iframe=" + iframe, '关联模板', "500px", true);
}

var R_Resource = function (tid, type, iframe,title) {
    parent.OpenModal('/Resource/ListShow/?tid=' + tid + "&SouceType=" + type + "&iframe=" + iframe, title, "95%", true);
}
var R_Menu= function () {
    parent.OpenModal('/Menu/List/', '创建导航菜单', "800px", true);
}
var R_LoGoPath = function (src) {
    CloseModal();
    $("#LoGoPath_").attr("src", src);
}

//解决点击后层不隐藏问题
var R_NavAcount = function (Id) {
    switch (Id) {
        case 1: $("#MenInfoNav").click(); break;
        case 2: $("#LogNav").click(); break;
        case 3: parent.$("#submenu1001").click(); break;
    }
};
var R_Game= function () {
    parent.CloseModal();
    //parent.frames["submenu7"].window.ParentRefresh();
    alert("r_game");
    parent.$("#submenu7").window.ParentRefresh();
}
var R_SysTemplate = function () {
    parent.CloseModal();
    parent.frames["iframe24"].window.ParentRefresh();
}

var R_UserInfo = function () {
    parent.CloseModal();
    parent.frames["iframe13"].window.ParentRefresh();
}
var OpenWindows = function (URL,Title, Width, Height) {
    if (!isBlank(Width)) Width = 550;
    if (!isBlank(Height)) Height = 400;
    if (!isBlank(Title)) Title = "内容显示";
    var Top = (window.screen.availHeight - 30 - Height) / 2;
    var Left = (window.screen.availWidth - 10 - Width) / 2;
    window.open(URL, Title, 'height=' + Height + ',,innerHeight=' + Height + ',width=' + Width + ',innerWidth=' + Width + ',top=' + Top + ',left=' + Left + ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');
}

$(function () {
    $("#mainmenu2").click();
    $("#top-search").blur(function () {
        var search = $("#top-search").val();
        if (search.length > 0) {
            window.open("http://bbs.smt-view.com/search.php?mod=forum&searchid=2&orderby=lastpost&ascdesc=desc&searchsubmit=yes&kw=" + search);
        }
    });
});
var R_loadParent = function (path, thumb, iframe, Type) {
    switch(Type)
    {
        case 1: parent.frames["iframe" + iframe].window.loadImg(path, thumb); break;
        case 2: parent.frames["iframe" + iframe].window.loadVideo(path, thumb); break;
        case 3: parent.frames["iframe" + iframe].window.loadMisuc(path, thumb); break;
        default: parent.frames["iframe" + iframe].window.loadImg(path, thumb); break;
    }
}

var R_WangEditor = function (txt,souce, iframe) {
    parent.$("#eiframe").val(iframe);
    parent.$("#souce").val(souce);
    if (txt != "文本(双击编辑)" &&txt != "链接区域(双击编辑)") {
        parent.$(".wangEditor-txt").html(txt.replace(/<p style=\"zoom:0.3;\">/g, "<p>"));
    }
    parent.$("#BtnTxt").click();
}

var R_SaveEditor = function () {
    var iframe = $("#eiframe").val();
    parent.frames["iframe" + iframe].window.loadTextBox($(".wangEditor-txt").html());
    $(".wangEditor-txt").html("");
    $("#BtnTxtClose").click();
}

var R_SendTerminals = function (Pid) {
    var url = "/Terminal/List/?Ids=" +Pid;
    parent.$("#submenu8").attr("href", url).text("一键发布").click();
}

function TemplateView() {
    var url = '/Template/View/?Tid=' + $("#Tid").val() + "&Id=0";
    $.ajax({
        url: url,
        type: 'POST',
        dataType: 'json',
        timeout: 300000,
        error: function () {
            parent.ShowOK(145, 10012);
        },
        success: function (obj) {
            $("#DivView").html(obj.Msg);
        }
    });
}

function HomeCarte(Id) {
    switch (Id) {
        case 1: parent.$("#submenu9").click(); break;
        case 2: parent.$("#submenu10").click(); break;
        case 3: parent.$("#submenu7").click(); break;
        case 4: window.open("/M/Pay/VipClass/"); break;
    }
}

function slideToggle(Id1, Id2) {
    $("#" + Id1).slideToggle("slow", function () {
        if ($(this).is(':hidden')) {
            $("#" + Id2).removeClass("fa fa-chevron-up");
            $("#" + Id2).addClass("fa fa-chevron-down");
        }
        else {
            $("#" + Id2).removeClass("fa fa-chevron-down");
            $("#" + Id2).addClass("fa fa-chevron-up");
        }
    });
};
function IsStudent() {
    var resurt = $("input[name='student']").is(':checked');
    if (isBlank(resurt)) {
        $.post("/Mem/IsStudent/?resurt=" + resurt, function (obj) {
            if (!obj.IsOk) {
                alert("操作失败！");
            };
        }, "json");
    };
};
function OpenNumber() {
    parent.OpenModal("/Distribution/Number/", "注册码管理", "800px", true);
};
function OpenSubscribe() {
    parent.OpenModal("/Terminal/Subscribe/", "支付宝订单", "95%", true);
};
function AutoLogin(key) {
    parent.OpenModal('/User/AutoLogin/?Key=' + key, '正在登录...', "400px", true);
};
function OpenPlay(TerminalId) {
    parent.OpenModal("/Programme/Play/?TerminalId=" + TerminalId, "节目播控", "800px", true);
};
function OpenVip(Vip) {
    parent.OpenModal("/Pays/List/?Vip=" + Vip, "勾选续费终端", "800px", true);
};
