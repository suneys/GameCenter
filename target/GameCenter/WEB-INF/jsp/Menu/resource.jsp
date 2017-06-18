<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <title></title>
    <meta name="description" content="海报助手、数字广告牌、数字灯箱、数字海报、数字菜单、数字展架、数字白板、海报发布系统 研发 制造 生产"/>
    <meta name="keywords" content="海报助手、数字广告牌、数字灯箱、数字海报、数字菜单、数字展架、数字白板、海报发布系统 研发 制造 生产"/>
    <link rel="Shortcut Icon" href="http://image.smt-view.com/Style/Images/favicon.ico?ver=V1.189536"/>
    <input type="hidden" name="Images_" id="Images_" value="http://localhost:8080/"/>
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->
    <link href="${pageContext.request.contextPath }/css/font-awesome.min.css" rel="stylesheet"/>

    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet"/>

    <link href="${pageContext.request.contextPath }/css/bootstrap-table.min.css" rel="stylesheet"/>

    <link href="${pageContext.request.contextPath }/css/animate.min.css" rel="stylesheet"/>

    <link href="${pageContext.request.contextPath }/css/style.min.css" rel="stylesheet"/>

    <link href="${pageContext.request.contextPath }/css/sweetalert.css" rel="stylesheet"/>

    <link href="${pageContext.request.contextPath }/css/introjs.min.css" rel="stylesheet"/>

</head>
<body class="fixed-sidebar full-height-layout gray-bg  pace-done" style="overflow:hidden">
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>

<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>

<script src="${pageContext.request.contextPath }/js/jquery.metisMenu.js"></script>

<script src="${pageContext.request.contextPath }/js/jquery.slimscroll.min.js"></script>

<script src="${pageContext.request.contextPath }/js/layer.min.js"></script>

<script src="${pageContext.request.contextPath }/js/hplus.min.js"></script>

<script src="${pageContext.request.contextPath }/js/contabs.min.js"></script>

<script src="${pageContext.request.contextPath }/js/pace.min.js"></script>

<script src="${pageContext.request.contextPath }/js/sweetalert.min.js"></script>

<script src="${pageContext.request.contextPath }/js/mesageinfo.js"></script>

<script src="${pageContext.request.contextPath }/js/index.js"></script>

<script src="${pageContext.request.contextPath }/js/content.min.js"></script>

<script src="${pageContext.request.contextPath }/js/intro.min.js"></script>

<link href="${pageContext.request.contextPath }/css/awesome-bootstrap-checkbox.css" rel="stylesheet"/>

<script src="${pageContext.request.contextPath }/js/icheck.min.js"></script>

<script src="${pageContext.request.contextPath }/js/jquery.pagination.js"></script>

<script src="${pageContext.request.contextPath }/js/IdCheckBox.js"></script>

<script src="${pageContext.request.contextPath }/js/jquery.form.js"></script>

<link href="${pageContext.request.contextPath }/css/zTreeStyle.css" rel="stylesheet"/>

<link href="${pageContext.request.contextPath }/css/popupSmallMenu.css" rel="stylesheet"/>

<script src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.core-3.5.js"></script>

<script src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.excheck-3.5.js"></script>

<script src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.exedit-3.5.js"></script>

<script src="${pageContext.request.contextPath }/js/ztree/jquery.popupSmallMenu.js"></script>

<script src="${pageContext.request.contextPath }/js/adv_Folder.js"></script>

<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-3">
            <div class="ibox float-e-margins">
                <div class="ibox-content" style="position:fixed; width:23%;">
                    <div class="file-manager tooltip-demo">
                        <h5>文件夹</h5>
                        <ul id="treeDemo" class="ztree" style="font-size:18px;"></ul>
                        <form id="form2" name="form2" method="post" action="#" enctype="multipart/form-data">

                            <input type="file" name="s_file" id="s_file" accept=".JPG,.PNG,.GIF,.BMP,.JPEG,,.MP4,.MP3"
                                   multiple="multiple" onchange="UploadFile(2)" style="display:none;"/>
                            <input type="submit" name="s_submit" id="s_submit" class="inputSubmit"
                                   style="display:none;">
                        </form>
                        <div class="hr-line-dashed"></div>
                        <div class="progress progress-striped active" style="display:none;" id="progress">
                            <div style="width:0%;z-index:0;" aria-valuemax="100" aria-valuemin="0" aria-valuenow="75"
                                 role="progressbar" class="progress-bar progress-bar-warning"></div>
                            <div id="progressfont"
                                 style="color:red;z-index:9999;position:absolute;width:85%; text-align:right;">0%
                            </div>
                        </div>
                        <div id="Pagination" class="yellow1 ptb" style="padding-top:0px;"></div>
                        <ul class="folder-list" style="padding: 0;">
                            <li style="margin-left:10%;"><span id="maxsize">Loding...</span>&nbsp;<span
                                    class="glyphicon glyphicon-trash" style="cursor:pointer;" onclick="DelResource(0)"
                                    title="删除素材"></span>&nbsp;<span class="glyphicon glyphicon-repeat"
                                                                    style="cursor:pointer;" onclick="RefreshPage()"
                                                                    title="刷新页面"></span></li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>
        <form id="form1" action="#" enctype="multipart/form-data">
            <div class="col-sm-9 animated fadeInRight">
                <div class="row" style="height:510px;">
                    <div class="col-sm-12"></div>
                </div>
            </div>
        </form>
    </div>
</div>
<input type="hidden" id="accept" value=".JPG,.PNG,.GIF,.BMP,.JPEG,.MP4,.MP3"/>
<input type="hidden" id="SouceType" value="0"/>
<input type="hidden" id="tid" value="0"/>
<input type="hidden" id="fid" value="1"/>
<input type="hidden" id="iframe" value="p1407"/>
<input type="hidden" id="Id" name="Id" value="0"/>
<input type="hidden" id="VIP" value="2"/>
<script src="${pageContext.request.contextPath }/js/adv_Resource.js"></script>

<script src="${pageContext.request.contextPath }/js/content.min.js"></script>

<div>
    <ul id="menu" class="small-menu">
        <li class="upload"><a href="javascript:void()">上传</a></li>
        <li class="add"><a href="javascript:void()">新建目录</a></li>
        <li class="delete"><a href="javascript:void()">删除目录</a></li>
        <li class="edit"><a href="javascript:void()">重命名</a></li>
        <li class="small-menu-separator"></li>
        <li class="refresh"><a href="javascript:void()">刷新</a></li>
    </ul>
</div>
<script type="text/javascript">window.setTimeout(function () {
    if (parent.$("input[name='student']").is(':checked')) {
        introJs().setOptions({
            nextLabel: '下一步',
            prevLabel: '上一步',
            skipLabel: '跳过',
            doneLabel: "我清楚了",
            exitOnOverlayClick: true,
            exitOnEsc: true,
            showBullets: true
        }).start();
    }
}, 500);</script>
</body>
</html>
