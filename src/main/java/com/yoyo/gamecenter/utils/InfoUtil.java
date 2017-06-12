package com.yoyo.gamecenter.utils;

/**
 * Created by Administrator on 2017/5/13 0013.
 */
public class InfoUtil {
    public static String GetMsgInfo(int Id)
    {
        String Msg = "";
        switch (Id)
        {
            case 1001: Msg = "系统繁忙,请稍候再试！"; break;
            case 1002: Msg = "修改成功！"; break;
            case 1003: Msg = "删除成功！"; break;
            case 1004: Msg = "添加成功！"; break;
            case 1005: Msg = "注册成功！"; break;
            case 1006: Msg = "已注册且未过期终端不能删除！"; break;
            case 1007: Msg = "推送终端成功！"; break;
            case 1008: Msg = "无效的终端编号！"; break;
            case 1009: Msg = "用户已存在，请更换！"; break;
            case 1010: Msg = "参数错误，请重试！"; break;
            case 1011: Msg = "无效的注册码！"; break;
            case 1012: Msg = "注册码已使用,请重新输入！"; break;
            case 1013: Msg = "终端已注册,不能重复注册！"; break;
            case 1014: Msg = "关联成功！"; break;
            case 1015: Msg = "登录成功！"; break;
            case 1016: Msg = "已收录,感谢参与！"; break;
            case 1017: Msg = "保存成功,跳转中.."; break;
            case 1018: Msg = "请不要使用∈或≌特殊字！"; break;
            case 1019: Msg = "原始密码错误！"; break;
            case 1020: Msg = "抱歉，没有查询到您输入的账户信息！"; break;
            case 1021: Msg = "保存成功！"; break;
            case 1022: Msg = "名称已存在，请更换！"; break;
            case 1023: Msg = "格式不正确,请重试！"; break;
            case 1024: Msg = "操作成功,请稍候！"; break;
            case 1025: Msg = "当前登录账户不能删除！"; break;
            case 1026: Msg = "当前为VIP会员,此数据不能删除！"; break;
            case 1027: Msg = "激活成功！"; break;
            case 1028: Msg = "操作成功！"; break;
            case 1029: Msg = "权限不足,请联系管理人员！"; break;
            case 1030: Msg = "非法加密字符串！"; break;
            case 1031: Msg = "非法加密字符串！"; break;
            case 1032: Msg = "存储空间{max}已满"; break;
            case 1033: Msg = "文件格式不正确！"; break;
            case 1034: Msg = "暂无激活终端记录！"; break;
            case 1035: Msg = "推送繁忙，请稍候重试！"; break;
            case 1036: Msg = "请为该节目关联模板！"; break;
            case 1037: Msg = "终端已过期,请联系客服续费！"; break;
            case 1038: Msg = "请先保存模板内容！"; break;
            case 1039: Msg = "请先选择文件！"; break;
            case 1040: Msg = "部分终端发布失败！"; break;
            case 1041: Msg = "终端序列号已存在！"; break;
            case 1042: Msg = "暂无数据"; break;
            case 1043: Msg = "共享成功！"; break;
            case 1044: Msg = "非当前账户资源不能删除！"; break;
            case 1045: Msg = "账户禁用,请联系客服激活"; break;
            case 1046: Msg = "用户名或密码错误！"; break;
            case 1047: Msg = "请勿使用含特殊字符的关键字！"; break;
            case 1048: Msg = "请勿使用含SQL语句的关键字！"; break;
            case 1049: Msg = "账户已删除,请联系客服专员！"; break;
            case 1050: Msg = "个推送失败,请检查网络连接！"; break;
            case 1051: Msg = "新增模板失败！"; break;
            case 1052: Msg = "新增节目失败！"; break;
            case 1053: Msg = "保存文本失败！"; break;
            case 1054: Msg = "发布成功！"; break;
            case 1055: Msg = "场景制作"; break;
            case 1056: Msg = "发布失败,请稍候再试！"; break;
            case 1057: Msg = "场景已存在,不能重复添加！"; break;
            case 1058: Msg = "请联系客服开通点播功能！"; break;
            case 1059: Msg = "模板已达上限,请联系客服!"; break;
            case 1060: Msg = "请致电续费！"; break;
            case 1061: Msg = "请选择图片!"; break;
            case 1062: Msg = "当日发布数{count}次已满"; break;
            case 1063: Msg = "订单编号不存在！"; break;
            case 1064: Msg = "请勿重复提交订单！"; break;
            case 1065: Msg = "当前模板不提供编辑！"; break;
            case 1066: Msg = "终端没有提交截图！"; break;
            case 1067: Msg = "无效的套餐编号！"; break;
            case 1068: Msg = "无效的终端编号！"; break;
            case 1069: Msg = "生成订单失败！"; break;
            case 1070: Msg = "交易未完成！"; break;
            case 1071: Msg = "交易成功！"; break;
            case 1072: Msg = "订单已关闭！"; break;
            case 1073: Msg = "审核成功！"; break;
            case 1074: Msg = "数据处理中..."; break;
            case 1075: Msg = "用户不存在！"; break;
            case 1076: Msg = "密码错误！"; break;
            case 1077: Msg = "成功发布{n}个模板"; break;
            case 1078: Msg = "请为{souce}添加素材！"; break;
            case 1079: Msg = "无效的密文票据！"; break;
            case 1080: Msg = "储存不足,剩余{max}"; break;
            case 1081: Msg = "总储存<span style=\"color:red;\">{count}</span>,可用<span style=\"color:red;\">{surplus}</span>"; break;
            case 1082: Msg = "-专注视觉领域发布系统"; break;
            case 1083: Msg = "密钥仅3分钟内有效,请刷新重新生成凭证！"; break;
            case 1084: Msg = "身份验证出现问题,请检查密码是否正确！"; break;
            case 1085: Msg = "用户名：{UserName},密码：{PassWord}"; break;
            case 1086: Msg = "当前终端已在您账户，不能重复分配！"; break;
            case 1087: Msg = "身份验证出现问题,请检查是否有操作权限！"; break;
            case 1088: Msg = "当前为图片区域，只能添加图片素材！"; break;
            case 1089: Msg = "当前为视频区域，只能添加视频素材！"; break;
            case 1090: Msg = "当前为音乐区域，只能添加音乐素材！"; break;
            case 1091: Msg = "添加至图片区域"; break;
            case 1092: Msg = "添加至视频区域"; break;
            case 1093: Msg = "添加至音乐区域"; break;
            case 1094: Msg = "账户不存在,请确认！"; break;
            case 1095: Msg = "邮箱系统繁忙，请稍后再试！"; break;
            case 1096: Msg = "写入数据时保存失败！"; break;
            case 1097: Msg = "非法的链接地址！请重新获取！"; break;
            case 1098: Msg = "链接地址已使用,请重新获取！"; break;
            case 1099: Msg = "链接地址已超时,请重新获取！"; break;
            case 1100: Msg = "无效的链接地址！请重新获取！"; break;
            case 1101: Msg = "当日发送数3次已满！"; break;
            case 1102: Msg = "图形验证码错误！"; break;
            case 1103: Msg = "身份验证出错,请重试！"; break;
            case 1104: Msg = "没有查询到订单信息"; break;
            case 1105: Msg = "您有{count}个终端已到期,请续费!"; break;
            case 1106: Msg = "{SiteName}-专注视觉领域发布系统！我们的产品有：海报盒子，数字标牌电视，互动数字菜单，数字标牌拼接，互动产品墙。全国热线：{Tel}"; break;
            case 1107: Msg = "办理{SiteName}VIP会员，即可去除海报广告，赠送{H5}套手机模板，赠送{UploadSize}存储空间，发布次数不受限，微场景模板任性配！详情登录{Domain}"; break;
            case 1108: Msg = "{SiteName}-中国最受欢迎的海报推广品牌！截至2016年8月,网站注册量达1.3万，日活跃用户2万。我们的使命是为经营者提供更有效的营销推广方案。"; break;
            default: Msg = "暂无对应编号！"; break;

        }
        return Msg;
    }

    //日志摘要GetLogInfo(1048)
    public static String GetLogInfo(int Id)
    {
        String Msg = "";
        switch (Id)
        {
            case 1001: Msg = "删除节目"; break;
            case 1002: Msg = "删除模板"; break;
            case 1003: Msg = "删除终端"; break;
            case 1004: Msg = "会员注册"; break;
            case 1005: Msg = "注册终端"; break;
            case 1006: Msg = "添加终端"; break;
            case 1007: Msg = "绑定终端"; break;
            case 1008: Msg = "关联模板"; break;
            case 1009: Msg = "终端名称"; break;
            case 1010: Msg = "缓存加载"; break;
            case 1011: Msg = "数据库加载"; break;
            case 1012: Msg = "清除缓存"; break;
            case 1013: Msg = "LoGo上传"; break;
            case 1014: Msg = "会员登录"; break;
            case 1015: Msg = "站点出错"; break;
            case 1016: Msg = "新增节目"; break;
            case 1017: Msg = "添加模板"; break;
            case 1018: Msg = "读取模板"; break;
            case 1019: Msg = "预览模板"; break;
            case 1020: Msg = "终端发布"; break;
            case 1021: Msg = "增注册码"; break;
            case 1022: Msg = "分配终端"; break;
            case 1023: Msg = "资源上传"; break;
            case 1024: Msg = "系统模板上传"; break;
            case 1025: Msg = "批量上传"; break;
            case 1026: Msg = "删除用户"; break;
            case 1027: Msg = "模拟登录"; break;
            case 1028: Msg = "上传屏幕"; break;
            case 1029: Msg = "网络状态"; break;
            case 1030: Msg = "发布状态"; break;
            case 1031: Msg = "终端更新"; break;
            case 1032: Msg = "下载为空"; break;
            case 1033: Msg = "下载成功"; break;
            case 1034: Msg = "下载异常"; break;
            case 1035: Msg = "密文不符"; break;
            case 1036: Msg = "终端已存在"; break;
            case 1037: Msg = "终端注册成功"; break;
            case 1038: Msg = "终端注册异常"; break;
            case 1039: Msg = "参数错误"; break;
            case 1040: Msg = "过期查询"; break;
            case 1041: Msg = "推送成功"; break;
            case 1042: Msg = "推送失败"; break;
            case 1043: Msg = "推送异常"; break;
            case 1044: Msg = "推送超时"; break;
            case 1045: Msg = "登录出错"; break;
            case 1046: Msg = "安全退出"; break;
            case 1047: Msg = "编辑模板"; break;
            case 1048: Msg = "会员注册"; break;
            case 1049: Msg = "修改用户"; break;
            case 1050: Msg = "IP解析"; break;
            case 1051: Msg = "缓存不存在"; break;
            case 1052: Msg = "添加文本"; break;//电脑端编辑时
            case 1053: Msg = "读取文本"; break;
            case 1054: Msg = "终端共享"; break;
            case 1055: Msg = "资源共享"; break;
            case 1056: Msg = "删除资源"; break;
            case 1057: Msg = "场景制作"; break;
            case 1058: Msg = "保存模板"; break;
            case 1059: Msg = "查询终端"; break;
            case 1060: Msg = "QQ登录"; break;
            case 1061: Msg = "缓存读取模板"; break;
            case 1062: Msg = "重新读取模板"; break;
            case 1063: Msg = "欢迎使用"; break;
            case 1064: Msg = "支付宝支付"; break;
            case 1065: Msg = "Alipay回调参数错"; break;
            case 1066: Msg = "Alipay验证失败"; break;
            case 1067: Msg = "终端截图"; break;
            case 1068: Msg = "支付回调成功"; break;
            case 1069: Msg = "地址验证成功"; break;
            case 1070: Msg = "读取写入数据"; break;
            case 1071: Msg = "拒绝重复提交"; break;
            case 1072: Msg = "拒绝重复提交"; break;
            case 1073: Msg = "会员登录"; break;
            case 1074: Msg = "复制节目"; break;
            case 1075: Msg = "复制模板"; break;
            case 1076: Msg = "模板管理"; break;
            case 1077: Msg = "素材管理"; break;
            case 1078: Msg = "终端注册"; break;
            case 1079: Msg = "VIP办理"; break;
            default: Msg = "暂无对应编号"; break;
        }
        return Msg;
    }
}
