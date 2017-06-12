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
    <title>节目内容-海报助手</title>
    <meta name="description" content="海报助手、数字广告牌、数字灯箱、数字海报、数字菜单、数字展架、数字白板、海报发布系统 研发 制造 生产">
    <meta name="keywords" content="海报助手、数字广告牌、数字灯箱、数字海报、数字菜单、数字展架、数字白板、海报发布系统 研发 制造 生产">
    <link rel="Shortcut Icon" href="http://image.smt-view.com/Style/Images/favicon.ico?ver=V1.189536">
    <link rel="stylesheet" href="http://image.smt-view.com/Computer/js/../css/layer.css" id="layui_layer_csslayercss">
    <script src="http://image.smt-view.com/Computer/js/extend/layer.ext.js" id="layui_layer_extendlayerextjs"></script>
</head>
<body class="fixed-sidebar full-height-layout gray-bg    pace-done mini-navbar" style="overflow:hidden">
<div class="pace  pace-inactive">
    <div class="pace-progress" data-progress-text="100%" data-progress="99" style="width: 100%;">
        <div class="pace-progress-inner"></div>
    </div>
    <div class="pace-activity"></div>
</div>
<input type="hidden" name="Images_" id="Images_" value="http://image.smt-view.com">
<!--[if lt IE 9]>
<meta http-equiv="refresh" content="0;ie.html"/>
<![endif]-->
<link href="${pageContext.request.contextPath }/css/font-awesome.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath }/css/bootstrap-table.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath }/css/animate.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath }/css/style.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath }/css/sweetalert.css" rel="stylesheet">

<link href="${pageContext.request.contextPath }/css/introjs.min.css" rel="stylesheet">


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

<div class="wrapper wrapper-content animated fadeInRight">
    <!-- Panel Sort & Hideheader -->
    <div class="ibox float-e-margins">
        <div class="ibox-content">
            <div class="row row-lg">
                <div class="col-sm-12">
                    <!-- Example Events -->
                    <div class="example-wrap">
                        <div class="example">
                            <div class="btn-group hidden-xs tooltip-demo" id="exampleTableEventsToolbar" role="group">
                                <button onclick="SendYun()" data-intro=请在&quot;节目制作&quot;勾选节目再点我发布 id="BtnSend" class="btn btn-outline btn-default" data-toggle="tooltip" disabled=&quot;disabled&quot; data-placement="top" title="一键发布">
                                    <i class="fa fa-cloud-upload" aria-hidden="true"></i>
                                </button>
                                <button onclick="ScreenShot()" class="btn btn-default btn-outline" data-toggle="tooltip" data-placement="top" title="远程截屏">
                                    <i class="glyphicon glyphicon-camera" aria-hidden="true"></i>
                                </button>
                                <button class="btn btn-outline btn-default" onclick="PlayPro()" data-toggle="tooltip" data-placement="top" title="节目播控">
                                    <i class="glyphicon glyphicon-play" aria-hidden="true"></i>
                                </button>
                                <button class="btn btn-outline btn-default"  onclick="parent.ShowInput(180,10071, 'bind', 1)" data-toggle="tooltip" data-placement="top" title="绑定新终端">
                                    <i class="glyphicon glyphicon-link" aria-hidden="true"></i>
                                </button>
                                <button onclick="OpenNumber()" class="btn btn-outline btn-default" data-toggle="tooltip"  data-placement="top" title="注册码管理">
                                    <i class="fa fa-key" aria-hidden="true"></i>
                                </button>
                                <button onclick="OpenSubscribe()" class="btn btn-outline btn-default" data-toggle="tooltip" data-placement="top" title="支付宝订单">
                                    <i class="fa fa-credit-card" aria-hidden="true"></i>
                                </button>
                                <button class="btn btn-outline btn-default" data-toggle="tooltip" disabled="disabled" data-placement="top" title="重启终端">
                                    <i class="glyphicon glyphicon-signal" aria-hidden="true"></i>
                                </button>
                                <button class="btn btn-outline btn-default" data-toggle="tooltip" disabled="disabled" data-placement="top" title="终端关机">
                                    <i class="glyphicon glyphicon-off" aria-hidden="true"></i>
                                </button>
                                <button class="btn btn-outline btn-default" data-toggle="tooltip" disabled="disabled" data-placement="top" title="远程升级">
                                    <i class="glyphicon glyphicon-file" aria-hidden="true"></i>
                                </button>

                            </div>
                            <table id="TableList"  data-click-to-select="true" data-mobile-responsive="true"></table>
                        </div>
                    </div>
                    <!-- End Example Events -->
                </div>
            </div>
        </div>

        <!-- End Panel Other -->
</div>
<input type="hidden" id="Ids">
<input type="hidden" id="DaySend" value="0">
<script src="${pageContext.request.contextPath }/js/content.min.js"></script>

<script src="${pageContext.request.contextPath }/js/bootstrap-table.js"></script>

<script src="${pageContext.request.contextPath }/js/bootstrap-table-zh-CN.min.js"></script>

<link href="${pageContext.request.contextPath }/css/bootstrap-editable.css" rel="stylesheet">

<script src="${pageContext.request.contextPath }/js/bootstrap-editable.js"></script>

<script src="${pageContext.request.contextPath }/js/bootstrap-table-editable.js"></script>

<script src="${pageContext.request.contextPath }/js/adv_Terminals.js"></script>

<script type="text/javascript">
    var operatecolumns = function () {
        return [
            {field: 'state', checkbox: true, formatter: stateFormatter},// ,formatter:stateFormatter
            {
                field: 'TerminalNo',
                title: '屏幕序列号',
                width: 100,
                align: 'left',
                valign: 'middle',
                sortable: true,
                formatter: IcoIndex
            },
            {
                field: 'TerminalName',
                title: '终端名称',
                width: 20,
                editable: true,
                align: 'left',
                valign: 'top',
                sortable: true
            },
            {field: 'SourceName', title: '播放广告', width: 20, align: 'left', valign: 'top', sortable: true},

            {field: 'CreateDateStr', title: '最后操作', width: 40, align: 'left', valign: 'top', sortable: true},
            {
                field: 'PublishStateStr',
                title: '终端状态',
                width: 40,
                align: 'left',
                valign: 'top',
                sortable: true,
                formatter: IcoPublishState
            }
        ];
    }
</script>


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

</div>
</body>
</html>
