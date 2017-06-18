var setting = {
    data: {
        simpleData: {
            enable: true
        }
    },
    edit: {
        enable: true,
        showRemoveBtn: false,
        showRenameBtn: false
    },
    callback: {
        onRightClick: OnRightClick,
        beforeRename: beforeRename,
        onClick: zTreeOnClick
    }
};
function zTreeOnClick(event, treeId, treeNode) {
    $("#fid").val(treeNode.id);
    LoadPage();
};
var ztree;
$(document).ready(function () {
    LoadZtree();
});
function LoadZtree() {
    $.ajax({
        url: getRootPath()+"/folder/folderList/",
        type: 'POST',
        dataType: 'json',
        timeout: 30000,
        error: function () {
            alert("生成Ztree失败！");
        },
        success: function (data) {
            var container = new Array();
            for (var n = 0; n < data.rows.length; n++) {
                container[n] = data.rows[n];
            }
            $.fn.zTree.init($("#treeDemo"), setting, container);
            ztree = $.fn.zTree.getZTreeObj("treeDemo");
        }
    });
};
function beforeRename(treeId, treeNode, newName, isCancel) {
    if (!isBlank(newName)) {
        LoadZtree();
        return false;
    }
    else {
        var Id = 0;
        if (isBlank($("#Id").val()) && $("#Id").val() == 1) {
            Id = treeNode.pId;//新增时只需获取Pid
        }
        else {
            Id = treeNode.id;//编辑时取主键Id
        }
        $.post(getRootPath()+"/folder/edit/?Id=" + Id + "&name=" + newName + "&type=" + $("#Id").val(), function (obj) {
            if (!obj.IsOk) {
                alert("编辑失败！");
            }
            LoadZtree();
        }, "json");
        return true;
    }
}
function EditZtree() {
    $("#Id").val(0);
    var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
    nodes = zTree.getSelectedNodes(),
    treeNode = nodes[0];
    if (nodes.length == 0) {
        alert("请先选择一个文件夹");
        return false;
    }
    else if (treeNode.id == 1) {
        alert("根目录不能重命名！");
        return false;
    }
    zTree.editName(treeNode);
};
function CreateZtree() {
    $("#Id").val(1);
    var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
    nodes = zTree.getSelectedNodes(),
    treeNode = nodes[0];
    if (treeNode) {
        treeNode = zTree.addNodes(treeNode, { id: 100, pId: treeNode.id, isParent: true, name: "" });
    }
    if (treeNode) {
        zTree.editName(treeNode[0]);
    }
};
function DelZtree(Id) {
    if (confirm('确定要删除文件夹和该目录下素材?')) {
        $.post(getRootPath()+"/folder/delete/?Id=" + Id, function (obj) {
            if (!obj.IsOk) {
                alert("删除失败！");
            }
            LoadPage();
            LoadZtree();
        }, "json");
    }
};
function OnRightClick(event, treeId, treeNode) {
    ztree.selectNode(treeNode);
    $("#fid").val(treeNode.id);
    //LoadPage();
    if (treeNode) {
        $("#menu").popupSmallMenu({
            event: event,
            onClickItem: function (item) {
                switch (item) {
                    case "edit": EditZtree(); break;
                    case "upload":
                        if ($("#progress").is(":hidden")) {
                            $("#Fid").val(treeNode.id); UploadFile(1);
                        } else {
                            alert("正在上传文件,请稍后再试!");
                        };
                        break;
                    case "add": CreateZtree(); break;
                    case "refresh": LoadZtree(); LoadPage(); break;
                    case "delete":
                        var srcNode = ztree.getSelectedNodes();
                        var obj = srcNode[0];
                        if (obj != null && obj.children != null && obj.children.length != null && obj.children.length > 0) {
                            alert("该目录含有子目录不能删除！");
                        }
                        else if (treeNode.id == 1) {
                            alert("根目录不能删除！");
                            return false;
                        }
                        else {
                            DelZtree(treeNode.id);
                        }
                        break;
                }
                $(".small-menu").hide();
            }
        });
    }
};