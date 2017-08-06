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
    <input type="hidden" name="Images_" id="Images_" value="${pageContext.request.contextPath }"/>
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
    <div class="ibox float-e-margins">
        <div class="ibox-content">
            <div class="btn-group hidden-xs tooltip-demo" id="exampleTableEventsToolbar" role="group"
                 style="margin-bottom: 10px">
                <button class="btn btn-default btn-outline" data-toggle="tooltip" data-placement="top" title="增加游戏"
                onclick="AddGame();">
                <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
                </button>
                <button class="btn btn-outline btn-default" data-intro=勾选资源后可点我快速发布
                        onclick="sendResource()" data-toggle="tooltip" data-placement="top" title="发布游戏">
                    <i class="fa fa-desktop" aria-hidden="true"></i>
                </button>
                <%--<button class="btn btn-outline btn-default" onclick="CopyPro(0)" data-toggle="tooltip"--%>
                <%--data-placement="top"--%>
                <%--title="复制节目">--%>
                <%--<i class="fa fa-copy" aria-hidden="true"></i>--%>
                <%--</button>--%>
                <button onclick="DelGame(0)" class="btn btn-outline btn-default" data-toggle="tooltip"
                        data-placement="top"
                        title="删除游戏">
                    <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
                </button>
            </div>

            <div class="row">
                <div id="Pagination" class="yellow1 ptb" style="padding-top:0px;"></div>
                <form id="form1" action="#" enctype="multipart/form-data">
                    <div class="col-sm-9 animated fadeInRight">
                        <div class="row" style="height:510px;">
                            <div class="col-sm-12"></div>
                        </div>
                    </div>
                </form>
            </div>

            <input type="hidden" id="accept" value=".JPG,.PNG,.GIF,.BMP,.JPEG,.MP4,.MP3"/>
            <input type="hidden" id="SouceType" value="0"/>
            <input type="hidden" id="tid" value="0"/>
            <input type="hidden" id="fid" value="1"/>
            <input type="hidden" id="iframe" value="p1407"/>
            <input type="hidden" id="Id" name="Id" value="0"/>
            <input type="hidden" id="VIP" value="2"/>
            <script src="${pageContext.request.contextPath }/js/adv_Game.js"></script>

            <script src="${pageContext.request.contextPath }/js/content.min.js"></script>

        </div>
    </div>
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
