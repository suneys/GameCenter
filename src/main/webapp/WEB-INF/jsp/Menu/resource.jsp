
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

                            <div class="bootstrap-table">
                                <div class="fixed-table-toolbar">
                                    <div class="bs-bars pull-left">
                                        <div class="btn-group hidden-xs tooltip-demo" id="exampleTableEventsToolbar"
                                             role="group">
                                            <button class="btn btn-default btn-outline" data-toggle="tooltip"
                                                    data-placement="top" title="" onclick="AddPro();"
                                                    data-original-title="新增节目">
                                                <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
                                            </button>
                                            <button class="btn btn-outline btn-default"
                                                    data-intro="勾选节目后可点我快速发布;也可点右侧&quot;铅笔&quot;按钮编辑模板"
                                                    onclick="R_SendPro()" data-toggle="tooltip" data-placement="top"
                                                    title="" data-original-title="发布节目">
                                                <i class="fa fa-desktop" aria-hidden="true"></i>
                                            </button>
                                            <button class="btn btn-outline btn-default" onclick="CopyPro(0)"
                                                    data-toggle="tooltip" data-placement="top" title="复制节目">
                                                <i class="fa fa-copy" aria-hidden="true"></i>
                                            </button>
                                            <button onclick="DelPro(0)" class="btn btn-outline btn-default"
                                                    data-toggle="tooltip" data-placement="top" title="删除节目">
                                                <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="columns columns-right btn-group pull-right">
                                        <button class="btn btn-default btn-outline" type="button" name="refresh"
                                                title="刷新"><i class="glyphicon glyphicon-repeat"></i></button>
                                        <button class="btn btn-default btn-outline" type="button" name="toggle"
                                                title="切换"><i class="glyphicon glyphicon-list-alt"></i></button>
                                        <div class="keep-open btn-group" title="列">
                                            <button type="button" class="btn btn-default btn-outline dropdown-toggle"
                                                    data-toggle="dropdown"><i class="glyphicon glyphicon-list"></i>
                                                <span class="caret"></span></button>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><label><input type="checkbox" data-field="ProgrammeName" value="1"
                                                                  checked="checked"> 节目名称</label></li>
                                                <li><label><input type="checkbox" data-field="LoopTimeStr" value="2"
                                                                  checked="checked"> 模板轮播</label></li>
                                                <li><label><input type="checkbox" data-field="TemplateName" value="3"
                                                                  checked="checked"> 关联模板</label></li>
                                                <li><label><input type="checkbox" data-field="CreateDateStr" value="4"
                                                                  checked="checked"> 创建时间</label></li>
                                                <li><label><input type="checkbox" data-field="operate" value="5"
                                                                  checked="checked"> 操作</label></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="pull-right search"><input class="form-control input-outline" type="text"
                                                                          placeholder="搜索"></div>
                                </div>
                                <div class="fixed-table-container" style="height: 492px; padding-bottom: 36px;">
                                    <div class="fixed-table-header" style="margin-right: 0px;">
                                        <table class="table table-hover table-striped" style="width: 1138px;">
                                            <thead>
                                            <tr>
                                                <th title="全选/返选" class="bs-checkbox " style="width: 36px; "
                                                    data-field="state" tabindex="0">
                                                    <div class="th-inner "><input name="btSelectAll" type="checkbox">
                                                    </div>
                                                    <div class="fht-cell" style="width: 36px;"></div>
                                                </th>
                                                <th style="text-align: left; vertical-align: middle; "
                                                    data-field="ProgrammeName" tabindex="0">
                                                    <div class="th-inner sortable both">节目名称</div>
                                                    <div class="fht-cell" style="width: 302px;"></div>
                                                </th>
                                                <th style="text-align: left; vertical-align: top; "
                                                    data-field="LoopTimeStr" tabindex="0">
                                                    <div class="th-inner sortable both">模板轮播</div>
                                                    <div class="fht-cell" style="width: 185px;"></div>
                                                </th>
                                                <th style="text-align: left; vertical-align: top; "
                                                    data-field="TemplateName" tabindex="0">
                                                    <div class="th-inner sortable both">关联模板</div>
                                                    <div class="fht-cell" style="width: 291px;"></div>
                                                </th>
                                                <th style="text-align: left; vertical-align: top; "
                                                    data-field="CreateDateStr" tabindex="0">
                                                    <div class="th-inner sortable both">创建时间</div>
                                                    <div class="fht-cell" style="width: 240px;"></div>
                                                </th>
                                                <th style="text-align: center; vertical-align: middle; width: 80px; "
                                                    data-field="operate" tabindex="0">
                                                    <div class="th-inner ">操作</div>
                                                    <div class="fht-cell" style="width: 79px;"></div>
                                                </th>
                                            </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div class="fixed-table-body">
                                        <div class="fixed-table-loading" style="top: 37px; display: none;">
                                            正在努力地加载数据中，请稍候……
                                        </div>
                                        <table id="TableList" data-position="top" data-click-to-select="true"
                                               data-mobile-responsive="true" class="table table-hover table-striped"
                                               style="margin-top: -36px;">
                                            <thead>
                                            <tr>
                                                <th title="全选/返选" class="bs-checkbox " style="width: 36px; "
                                                    data-field="state" tabindex="0">
                                                    <div class="th-inner "><input name="btSelectAll" type="checkbox">
                                                    </div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                                <th style="text-align: left; vertical-align: middle; "
                                                    data-field="ProgrammeName" tabindex="0">
                                                    <div class="th-inner sortable both">节目名称</div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                                <th style="text-align: left; vertical-align: top; "
                                                    data-field="LoopTimeStr" tabindex="0">
                                                    <div class="th-inner sortable both">模板轮播</div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                                <th style="text-align: left; vertical-align: top; "
                                                    data-field="TemplateName" tabindex="0">
                                                    <div class="th-inner sortable both">关联模板</div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                                <th style="text-align: left; vertical-align: top; "
                                                    data-field="CreateDateStr" tabindex="0">
                                                    <div class="th-inner sortable both">创建时间</div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                                <th style="text-align: center; vertical-align: middle; width: 80px; "
                                                    data-field="operate" tabindex="0">
                                                    <div class="th-inner ">操作</div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr data-index="0">
                                                <td class="bs-checkbox "><input data-index="0" name="btSelectItem"
                                                                                type="checkbox"></td>
                                                <td style="text-align: left; vertical-align: middle; "><i
                                                        class="glyphicon glyphicon-star-empty"></i> 节目10
                                                </td>
                                                <td style="text-align: left; vertical-align: top; ">21600秒</td>
                                                <td style="text-align: left; vertical-align: top; ">请创建模板</td>
                                                <td style="text-align: left; vertical-align: top; ">18分钟前</td>
                                                <td style="text-align: center; vertical-align: middle; width: 80px; ">
                                                    <button onclick="EditPro(1407)" class="btn btn-default btn-xs"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="参数设置"><i
                                                            class="glyphicon glyphicon-time"></i></button>
                                                    <button onclick="R_ManageLink1(1407,'节目10')"
                                                            class="btn btn-default btn-xs" style="margin-left:5px"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="编辑模板"><i
                                                            class="glyphicon glyphicon-pencil"></i></button>
                                                </td>
                                            </tr>
                                            <tr data-index="1">
                                                <td class="bs-checkbox "><input data-index="1" name="btSelectItem"
                                                                                type="checkbox"></td>
                                                <td style="text-align: left; vertical-align: middle; "><i
                                                        class="glyphicon glyphicon-star-empty"></i> 链接
                                                </td>
                                                <td style="text-align: left; vertical-align: top; ">10秒</td>
                                                <td style="text-align: left; vertical-align: top; ">安小粉,辣酱鸡,排骨饭</td>
                                                <td style="text-align: left; vertical-align: top; ">2016-08-04 15:45
                                                </td>
                                                <td style="text-align: center; vertical-align: middle; width: 80px; ">
                                                    <button onclick="EditPro(689)" class="btn btn-default btn-xs"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="参数设置"><i
                                                            class="glyphicon glyphicon-time"></i></button>
                                                    <button onclick="R_ManageLink1(689,'链接')"
                                                            class="btn btn-default btn-xs" style="margin-left:5px"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="编辑模板"><i
                                                            class="glyphicon glyphicon-pencil"></i></button>
                                                </td>
                                            </tr>
                                            <tr data-index="2">
                                                <td class="bs-checkbox "><input data-index="2" name="btSelectItem"
                                                                                type="checkbox"></td>
                                                <td style="text-align: left; vertical-align: middle; "><i
                                                        class="glyphicon glyphicon-star-empty"></i> 视频
                                                </td>
                                                <td style="text-align: left; vertical-align: top; ">3600秒</td>
                                                <td style="text-align: left; vertical-align: top; ">视频</td>
                                                <td style="text-align: left; vertical-align: top; ">2016-08-03 10:38
                                                </td>
                                                <td style="text-align: center; vertical-align: middle; width: 80px; ">
                                                    <button onclick="EditPro(687)" class="btn btn-default btn-xs"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="参数设置"><i
                                                            class="glyphicon glyphicon-time"></i></button>
                                                    <button onclick="R_ManageLink1(687,'视频')"
                                                            class="btn btn-default btn-xs" style="margin-left:5px"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="编辑模板"><i
                                                            class="glyphicon glyphicon-pencil"></i></button>
                                                </td>
                                            </tr>
                                            <tr data-index="3">
                                                <td class="bs-checkbox "><input data-index="3" name="btSelectItem"
                                                                                type="checkbox"></td>
                                                <td style="text-align: left; vertical-align: middle; "><i
                                                        class="glyphicon glyphicon-star"></i> 测试1
                                                </td>
                                                <td style="text-align: left; vertical-align: top; ">20秒</td>
                                                <td style="text-align: left; vertical-align: top; ">百香绿茶,辣酱鸡</td>
                                                <td style="text-align: left; vertical-align: top; ">2016-07-21 13:31
                                                </td>
                                                <td style="text-align: center; vertical-align: middle; width: 80px; ">
                                                    <button onclick="EditPro(654)" class="btn btn-default btn-xs"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="参数设置"><i
                                                            class="glyphicon glyphicon-time"></i></button>
                                                    <button onclick="R_ManageLink1(654,'测试1')"
                                                            class="btn btn-default btn-xs" style="margin-left:5px"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="编辑模板"><i
                                                            class="glyphicon glyphicon-pencil"></i></button>
                                                </td>
                                            </tr>
                                            <tr data-index="4">
                                                <td class="bs-checkbox "><input data-index="4" name="btSelectItem"
                                                                                type="checkbox"></td>
                                                <td style="text-align: left; vertical-align: middle; "><i
                                                        class="glyphicon glyphicon-star-empty"></i> 测试
                                                </td>
                                                <td style="text-align: left; vertical-align: top; ">20秒</td>
                                                <td style="text-align: left; vertical-align: top; ">限时特价,春夏时尚</td>
                                                <td style="text-align: left; vertical-align: top; ">2016-07-21 13:26
                                                </td>
                                                <td style="text-align: center; vertical-align: middle; width: 80px; ">
                                                    <button onclick="EditPro(653)" class="btn btn-default btn-xs"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="参数设置"><i
                                                            class="glyphicon glyphicon-time"></i></button>
                                                    <button onclick="R_ManageLink1(653,'测试')"
                                                            class="btn btn-default btn-xs" style="margin-left:5px"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="编辑模板"><i
                                                            class="glyphicon glyphicon-pencil"></i></button>
                                                </td>
                                            </tr>
                                            <tr data-index="5">
                                                <td class="bs-checkbox "><input data-index="5" name="btSelectItem"
                                                                                type="checkbox"></td>
                                                <td style="text-align: left; vertical-align: middle; "><i
                                                        class="glyphicon glyphicon-star"></i> 节目5979[系统生成]
                                                </td>
                                                <td style="text-align: left; vertical-align: top; ">20秒</td>
                                                <td style="text-align: left; vertical-align: top; ">请创建模板</td>
                                                <td style="text-align: left; vertical-align: top; ">2016-07-21 13:25
                                                </td>
                                                <td style="text-align: center; vertical-align: middle; width: 80px; ">
                                                    <button onclick="EditPro(652)" class="btn btn-default btn-xs"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="参数设置"><i
                                                            class="glyphicon glyphicon-time"></i></button>
                                                    <button onclick="R_ManageLink1(652,'节目5979[系统生成]')"
                                                            class="btn btn-default btn-xs" style="margin-left:5px"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="编辑模板"><i
                                                            class="glyphicon glyphicon-pencil"></i></button>
                                                </td>
                                            </tr>
                                            <tr data-index="6">
                                                <td class="bs-checkbox "><input data-index="6" name="btSelectItem"
                                                                                type="checkbox"></td>
                                                <td style="text-align: left; vertical-align: middle; "><i
                                                        class="glyphicon glyphicon-star"></i> 节目2389
                                                </td>
                                                <td style="text-align: left; vertical-align: top; ">20秒</td>
                                                <td style="text-align: left; vertical-align: top; ">请创建模板</td>
                                                <td style="text-align: left; vertical-align: top; ">2016-06-22 13:32
                                                </td>
                                                <td style="text-align: center; vertical-align: middle; width: 80px; ">
                                                    <button onclick="EditPro(544)" class="btn btn-default btn-xs"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="参数设置"><i
                                                            class="glyphicon glyphicon-time"></i></button>
                                                    <button onclick="R_ManageLink1(544,'节目2389')"
                                                            class="btn btn-default btn-xs" style="margin-left:5px"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="编辑模板"><i
                                                            class="glyphicon glyphicon-pencil"></i></button>
                                                </td>
                                            </tr>
                                            <tr data-index="7">
                                                <td class="bs-checkbox "><input data-index="7" name="btSelectItem"
                                                                                type="checkbox"></td>
                                                <td style="text-align: left; vertical-align: middle; "><i
                                                        class="glyphicon glyphicon-star-empty"></i> 节目3963
                                                </td>
                                                <td style="text-align: left; vertical-align: top; ">20000秒</td>
                                                <td style="text-align: left; vertical-align: top; ">黄村牌坊</td>
                                                <td style="text-align: left; vertical-align: top; ">2016-06-14 15:32
                                                </td>
                                                <td style="text-align: center; vertical-align: middle; width: 80px; ">
                                                    <button onclick="EditPro(501)" class="btn btn-default btn-xs"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="参数设置"><i
                                                            class="glyphicon glyphicon-time"></i></button>
                                                    <button onclick="R_ManageLink1(501,'节目3963')"
                                                            class="btn btn-default btn-xs" style="margin-left:5px"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="编辑模板"><i
                                                            class="glyphicon glyphicon-pencil"></i></button>
                                                </td>
                                            </tr>
                                            <tr data-index="8">
                                                <td class="bs-checkbox "><input data-index="8" name="btSelectItem"
                                                                                type="checkbox"></td>
                                                <td style="text-align: left; vertical-align: middle; "><i
                                                        class="glyphicon glyphicon-star"></i> 节目4010
                                                </td>
                                                <td style="text-align: left; vertical-align: top; ">20秒</td>
                                                <td style="text-align: left; vertical-align: top; ">图片</td>
                                                <td style="text-align: left; vertical-align: top; ">2016-06-01 13:28
                                                </td>
                                                <td style="text-align: center; vertical-align: middle; width: 80px; ">
                                                    <button onclick="EditPro(466)" class="btn btn-default btn-xs"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="参数设置"><i
                                                            class="glyphicon glyphicon-time"></i></button>
                                                    <button onclick="R_ManageLink1(466,'节目4010')"
                                                            class="btn btn-default btn-xs" style="margin-left:5px"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="编辑模板"><i
                                                            class="glyphicon glyphicon-pencil"></i></button>
                                                </td>
                                            </tr>
                                            <tr data-index="9">
                                                <td class="bs-checkbox "><input data-index="9" name="btSelectItem"
                                                                                type="checkbox"></td>
                                                <td style="text-align: left; vertical-align: middle; "><i
                                                        class="glyphicon glyphicon-star"></i> 节目3705
                                                </td>
                                                <td style="text-align: left; vertical-align: top; ">20秒</td>
                                                <td style="text-align: left; vertical-align: top; ">防火门芯,热荐</td>
                                                <td style="text-align: left; vertical-align: top; ">2016-05-19 17:19
                                                </td>
                                                <td style="text-align: center; vertical-align: middle; width: 80px; ">
                                                    <button onclick="EditPro(430)" class="btn btn-default btn-xs"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="参数设置"><i
                                                            class="glyphicon glyphicon-time"></i></button>
                                                    <button onclick="R_ManageLink1(430,'节目3705')"
                                                            class="btn btn-default btn-xs" style="margin-left:5px"
                                                            href="javascript:void(0)" data-toggle="tooltip"
                                                            data-placement="top" title="编辑模板"><i
                                                            class="glyphicon glyphicon-pencil"></i></button>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="fixed-table-footer" style="display: none;">
                                        <table>
                                            <tbody>
                                            <tr></tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="fixed-table-pagination" style="display: block;">
                                        <div class="pull-left pagination-detail"><span class="pagination-info">显示第 1 到第 10 条记录，总共 11 条记录</span><span
                                                class="page-list">每页显示 <span class="btn-group dropup"><button
                                                type="button" class="btn btn-default btn-outline dropdown-toggle"
                                                data-toggle="dropdown"><span class="page-size">10</span> <span
                                                class="caret"></span></button><ul class="dropdown-menu" role="menu"><li
                                                class="active"><a href="javascript:void(0)">10</a></li><li><a
                                                href="javascript:void(0)">20</a></li></ul></span> 条记录</span></div>
                                        <div class="pull-right pagination">
                                            <ul class="pagination pagination-outline">
                                                <li class="page-pre"><a href="javascript:void(0)">‹</a></li>
                                                <li class="page-number active"><a href="javascript:void(0)">1</a></li>
                                                <li class="page-number"><a href="javascript:void(0)">2</a></li>
                                                <li class="page-next"><a href="javascript:void(0)">›</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <!-- End Example Events -->
                </div>
            </div>
        </div>
    </div>
    <!-- End Panel Other -->
</div>
<script src="${pageContext.request.contextPath }/js/content.min.js"></script>

<script src="${pageContext.request.contextPath }/js/bootstrap-table.js"></script>

<script src="http://image.smt-view.com/Computer/js/bootstrap-table-mobile.min.js?ver=V1.189536"></script>

<script src="http://image.smt-view.com/Computer/js/bootstrap-table-zh-CN.min.js?ver=V1.189536"></script>

<script src="http://image.smt-view.com/Computer/js/adv_Programme.js?ver=V1.189536"></script>

<script type="text/javascript">
    var operatecolumns = function () {
        return [
            {field: 'state', titleTooltip: '全选/返选', checkbox: true},//, formatter: stateFormatter
            {
                field: 'ProgrammeName',
                title: '节目名称',
                align: 'left',
                valign: 'middle',
                sortable: true,
                formatter: IcoIndex
            },
            {field: 'LoopTimeStr', title: '模板轮播', align: 'left', valign: 'top', sortable: true},
            {field: 'TemplateName', title: '关联模板', align: 'left', valign: 'top', sortable: true},
            {field: 'CreateDateStr', title: '创建时间', align: 'left', valign: 'top', sortable: true},
            {
                field: 'operate',
                title: '操作',
                align: 'center',
                valign: 'middle',
                width: 80,
                formatter: IcoEdit,
                events: operateEvents
            }// width: 80,
        ];
    };
    var IframeName = "iframe9";
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

</body>
</html>
