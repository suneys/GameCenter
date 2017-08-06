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
    <input type="hidden" name="Images_" id="Images_" value="http://localhost:8080/game/"/>
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

<link href="${pageContext.request.contextPath }/css/custom.css" rel="stylesheet"/>

<link href="${pageContext.request.contextPath }/css/awesome-bootstrap-checkbox.css" rel="stylesheet"/>

<link href="${pageContext.request.contextPath }/css/formValidator.css" rel="stylesheet"/>

<script src="${pageContext.request.contextPath }/js/formValidator.js"></script>

<script src="${pageContext.request.contextPath }/js/icheck.min.js"></script>

<script src="${pageContext.request.contextPath }/js/formValidatorRegex.js"></script>

<script src="${pageContext.request.contextPath }/js/moment.js.js"></script>


<form class="form-horizontal m-t" id="from1" enctype="multipart/form-data" method="post">
    <div class="wrapper wrapper-content animated fadeInRight" style="margin-top:-20px; padding-bottom:0px;">
        <div class="row">
            <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <div class="form-group" style="height:45px;">
                            <label class="col-sm-3 control-label" style="width:70%;">游戏名称：<span id="gameNameTip"></span></label>
                            <div class="col-sm-8" data-intro="先输入游戏名称" data-step="1">
                                <input id="gameName" name="gameName"  type="text" class="form-control" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" style="width:70%;">游戏下载地址：<span id="gamePathTip"></span></label>
                            <div class="col-sm-8">
                                <input id="gamePath" type="text" class="form-control" name="gamePath">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" style="width:70%;">游戏包名：<span id="packageNameTip"></span></label>
                            <div class="col-sm-8">
                                <input id="packageName" type="text" class="form-control" name="packageName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" style="width:70%;">上传游戏图片：</label>
                            <div class="col-sm-8">
                                <input type="file" name="file" id="s_file"  accept=".JPG,.PNG,.GIF,.BMP,.JPEG " multiple="multiple">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal-footer" style="border:0px;padding-top:0px;">
        <button type="button" class="btn btn-white" style="width: 100px; height: 50px;" onclick="CloseSub()">关闭</button>
        <button type="submit" class="btn btn-primary" data-intro="再点击保存按钮" data-step="2" data-position="left" style="width: 100px; height: 45px;">保存</button>
    </div>
</form>
<script src="${pageContext.request.contextPath }/js/addGame.js"></script>
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
