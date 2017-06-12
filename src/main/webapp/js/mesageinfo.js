/**
 * Created by Administrator on 2017/5/11 0011.
 *
 * 信息工具类
 */


//GetMsgTitle(149)
function GetMsgTitle(Id) {
    var Msg = "";
    switch (Id) {
        case 101: Msg = "删除提示"; break;
        case 102: Msg = "未勾选任何数据"; break;
        case 103: Msg = "数据加载失败"; break;
        case 104: Msg = "您确定要退出吗?"; break;
        case 105: Msg = "字符长度不符合规则"; break;
        case 106: Msg = "删除数据确认"; break;
        case 107: Msg = "删除数据失败"; break;
        case 108: Msg = "加载出错请重启页面"; break;
        case 109: Msg = "删除提示"; break;
        case 110: Msg = "头像上传失败"; break;
        case 111: Msg = "企业信息保存成功"; break;
        case 112: Msg = "企业信息保存失败"; break;
        case 113: Msg = "密码修改成功"; break;
        case 114: Msg = "密码修改失败"; break;
        case 115: Msg = "用户名修改成功"; break;
        case 116: Msg = "用户名修改失败"; break;
        case 117: Msg = "请至少勾选一个周期区段"; break;
        case 118: Msg = "保存数据失败"; break;
        case 119: Msg = "点击右边\"铅笔\"按钮创建模板"; break;
        case 120: Msg = "删除数据成功"; break;
        case 121: Msg = "没有搜索到包含该关键字页面"; break;
        case 122: Msg = "未获取到有效图片"; break;
        case 123: Msg = "截屏成功"; break;
        case 124: Msg = "截屏失败"; break;
        case 125: Msg = "暂不支持多个终端同时截屏"; break;
        case 126: Msg = "截屏命令推送未成功"; break;
        case 130: Msg = "模板编辑已打开"; break;
        case 131: Msg = "确定要重置分辨率吗？"; break;
        case 132: Msg = "请在右下角输入模板名称！"; break;
        case 133: Msg = "请为模板添加元素！"; break;
        case 134: Msg = "已成功关联到该节目！"; break;
        case 135: Msg = "当前操作失败！"; break;
        case 136: Msg = "保存成功是否前往发布？"; break;
        case 137: Msg = "模板内容保存成功！"; break;
        case 138: Msg = "终端绑定成功！"; break;
        case 139: Msg = "无效机器序列号！"; break;
        case 140: Msg = "请勾选节目后在发布！"; break;
        case 141: Msg = "发布节目没有成功！"; break;
        case 142: Msg = "发布成功！"; break;
        case 143: Msg = "数据保存失败！"; break;
        case 144: Msg = "提交中..."; break;
        case 145: Msg = "加载资源失败！"; break;
        case 146: Msg = "请输入功能名称！"; break;
        case 147: Msg = "请选择链接的模板！"; break;
        case 148: Msg = "数据保存成功！"; break;
        case 149: Msg = "处理中.."; break;
        case 150: Msg = "重新生成"; break;
        case 151: Msg = "请求参数错误"; break;
        case 152: Msg = "删除成功！"; break;
        case 153: Msg = "删除失败！"; break;
        case 154: Msg = "无效的节目编号！"; break;
        case 155: Msg = "前往发布"; break;
        case 156: Msg = "继续添加"; break;
        case 157: Msg = "格式错误,请重新选择"; break;
        case 158: Msg = "格式错误,仅支持以下格式"; break;
        case 159: Msg = "密钥已过期"; break;
        case 160: Msg = "登录失败"; break;
        case 161: Msg = "分配失败"; break;
        case 162: Msg = "请输入正确机器号"; break;
        case 163: Msg = "请输入正确注册码"; break;
        case 164: Msg = "请勾选要注册的终端"; break;
        case 165: Msg = "注册失败"; break;
        case 166: Msg = "注册成功"; break;
        case 167: Msg = "请输入您的身份凭证"; break;
        case 168: Msg = "上传成功"; break;
        case 169: Msg = "上传信息不完整"; break;
        case 170: Msg = "新增成功"; break;
        case 171: Msg = "确定要新增模板吗？"; break;
        case 172: Msg = "请至少选择一条数据"; break;
        case 173: Msg = "确定要编辑该模板吗？"; break;
        case 174: Msg = "请输入购买的注册码"; break;
        case 175: Msg = "请输入链接网址"; break;
        case 176: Msg = "请为节目创建模板"; break;
        case 177: Msg = "复制数据确认"; break;
        case 178: Msg = "复制数据成功"; break;
        case 179: Msg = "复制数据失败"; break;
        case 180: Msg = "请输入机器上屏幕序列号"; break;
        case 181: Msg = "未获取有效的终端编号"; break;
        case 182: Msg = "推送指令失败"; break;
        case 183: Msg = "暂停节目成功"; break;
        case 184: Msg = "播放节目成功"; break;
        case 185: Msg = "操作成功"; break;
        case 186: Msg = "操作失败"; break;
        case 187: Msg = "请填写完整的信息"; break;
        case 188: Msg = "文件超出限制"; break;
        case 189: Msg = "文件格式错误"; break;
        case 190: Msg = "可用储存不足"; break;
        case 191: Msg = "上传失败"; break;
        case 192: Msg = "只能添加图片"; break;
        case 193: Msg = "只能添加视频"; break;
        case 194: Msg = "只能添加音乐"; break;
        case 195: Msg = "手机号码不存在！"; break;

        case 196: Msg = "图形验证码错误！"; break;
        case 197: Msg = "验证码已使用！"; break;
        case 198: Msg = "验证码已超时！"; break;
        case 199: Msg = "短信验证码错误！"; break;
        case 200: Msg = "系统忙,请稍后再试！"; break;
        case 201: Msg = "请输入6-15位密码！"; break;
        case 202: Msg = "请输入6-15位确认密码！"; break;
        case 203: Msg = "确认密码不一致！"; break;
        case 204: Msg = "修改成功，请重新登录！"; break;
        case 205: Msg = "今天发布数已达上限"; break;
        case 206: Msg = "订单生成失败"; break;
        case 207: Msg = "交易是否完成?"; break;
        case 208: Msg = "支付未成功"; break;
        case 209: Msg = "支付成功"; break;
    }
    return Msg;
}
//GetMsgInfo(10082)
function GetMsgInfo(Id) {
    var Msg = "";
    switch (Id) {
        case 10001: Msg = "系统繁忙,请稍后再试"; break;
        case 10002: Msg = "密码长度至少6位"; break;
        case 10003: Msg = "手机号码格式错误"; break;
        case 10004: Msg = "邮箱地址格式错误"; break;
        case 10005: Msg = "正在加载中...."; break;
        case 10006: Msg = "操作成功"; break;
        case 10007: Msg = "重新登录"; break;
        case 10008: Msg = "重新注册"; break;
        case 10009: Msg = "请输入正确的登录账户"; break;
        case 10010: Msg = "删除后不可恢复您确定要删除吗？"; break;
        case 10011: Msg = "请至少勾选一条数据才能执行当前操作"; break;
        case 10012: Msg = "请稍后再试或将问题反馈客服专员"; break;
        case 10013: Msg = "退出后将清除用户所有数据，下次需重新输入信息"; break;
        case 10014: Msg = "请确保内容非空或减少字符长度重试"; break;
        case 10015: Msg = "删除数据失败，建议稍后再试"; break;
        case 10016: Msg = "服务器开了小差，建议稍后再试"; break;
        case 10017: Msg = "上传成功,继续上传"; break;
        case 10018: Msg = "上传失败,请重试"; break;
        case 10019: Msg = "正在上传"; break;
        case 10020: Msg = "上传即将完成..."; break;
        case 10021: Msg = "正在校验账户..."; break;
        case 10022: Msg = "您填写的信息已成功保存云端数据库"; break;
        case 10023: Msg = "请输入正确的手机或邮箱号"; break;
        case 10024: Msg = "用户名已被其他用户注册请更换"; break;
        case 10025: Msg = "需要重新勾选数据才能继续当前保存操作"; break;
        case 10026: Msg = "节目内容已保存成功！请继续操作"; break;
        case 10027: Msg = "您勾选的数据已成功删除了！"; break;
        case 10028: Msg = "抱歉没有搜索到相关页面信息！"; break;
        case 10029: Msg = "请确认该终端是否打开且网络连接正常！"; break;
        case 10030: Msg = "请仅勾选一个终端再重新进行当前操作！"; break;
        case 10031: Msg = "请确保勾选终端均已开机且网络连接正常！"; break;
        case 10032: Msg = "请先保存模板内容避免数据丢失！"; break;
        case 10033: Msg = "重置后编辑内容将丢失！为避免损失建议先保存模板！"; break;
        case 10034: Msg = "当前操作需完善信息才能继续！"; break;
        case 10035: Msg = "模板关联成功了！"; break;
        case 10036: Msg = "当前输入的机器序列号已绑定到您账户了！"; break;
        case 10037: Msg = "请核实输入的序列号是否与机器上的完全一致！"; break;
        case 10038: Msg = "未获取到有效的节目编号请重试！"; break;
        case 10039: Msg = "正在监测推送指令和发布状态，请稍候。"; break;
        case 10040: Msg = "修改成功！下次要用新用户名登录"; break;
        case 10041: Msg = "修改成功！下次要用新密码登录"; break;
        case 10042: Msg = "模板内容保存未成功建议稍后重试！"; break;
        case 10043: Msg = "没有获取到有效的编号请稍后再试！"; break;
        case 10044: Msg = "已成功将您选中的功能菜单删除！"; break;
        case 10045: Msg = "您可前往发布该模板，也可继续添加新模板！"; break;
        case 10046: Msg = "未获取到有效的节目编号请关闭该页重试！"; break;
        case 10047: Msg = "登录失败如有疑问请致电客服专员！"; break;
        case 10048: Msg = "会员信息已成功保存到数据库了！"; break;
        case 10049: Msg = "您输入的机器序列号长度不符合规定！"; break;
        case 10050: Msg = "您输入的机器序列号长度不符合规定！"; break;
        case 10051: Msg = "序列号注册成功，感谢您的使用！"; break;
        case 10060: Msg = "该操作涉及核心数据，请输入您登录密码校验身份"; break;
        case 10061: Msg = "上传成功！但当前状态为已删除,请调试好再显示！"; break;
        case 10062: Msg = "成功新增一个注册码，请在列表页查看！"; break;
        case 10063: Msg = "确定后当前内容可能丢失,为避免损失建议先保存模板！"; break;
        case 10064: Msg = "可通过鼠标左键托选列表值或直接点选列表值来操作"; break;
        case 10065: Msg = "您可致电400-8080-835获取注册码"; break;
        case 10066: Msg = "发布后将直接调用并显示该网址详细内容"; break;
        case 10067: Msg = "当前需为节目创建模板才能发布"; break;
        case 10068: Msg = "您确定要复制当前选中的数据吗？"; break;
        case 10069: Msg = "复制成功，数据将以“副本”形式显示"; break;
        case 10071: Msg = "获取方式：安装终端APP>终端设置>查看终端ID"; break;
        case 10072: Msg = "未获取到有效的终端编码建议重新打开页面"; break;
        case 10073: Msg = "推送系统繁忙，建议勾选一个终端重试！"; break;
        case 10074: Msg = "推送指令已成功发送给终端，待终端响应反馈！"; break;
        case 10075: Msg = "当前操作需填写完整的信息才能继续"; break;
        case 10076: Msg = "单次上传最多选择10个文件，请重新选择！"; break;
        case 10077: Msg = "抱歉！当前目录暂未上传任何文件！"; break;
        case 10078: Msg = "抱歉！当前目录暂未找到图片文件！"; break;
        case 10079: Msg = "抱歉！当前目录暂未找到视频文件！"; break;
        case 10080: Msg = "抱歉！当前目录暂未找到音乐文件！"; break;
        case 10081: Msg = "验证码长度为4位！"; break;
        case 10082: Msg = "短信已发送,请查收短信！"; break;
        case 10083: Msg = "请输入正确短信验证码"; break;
        case 10084: Msg = "当日发布次数已达上限"; break;
        case 10085: Msg = "升级VIP会员发布不受限，更多功能等您尊享！"; break;
        case 10086: Msg = "立即升级VIP会员，最大容量可达1GB！"; break;
        case 10087: Msg = "订单已提交，请确认本次是否已完成交易"; break;
        case 10088: Msg = "本次交易未成功，如有疑问请致电客服"; break;
        case 10089: Msg = "本次交易已完成，列表可查询您的订单信息"; break;
    }
    return Msg;
}
/*
 * 获取工程的路径
 */
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName
            .indexOf('/'));
    var url = window.location.protocol + '//' + window.location.host + '/'
        + webName + '/';
    return url;
}
//GetUrlInfo(10010)
function GetUrlInfo(Id) {
    var Url = "";
    switch (Id) {
        case 10001: Url = getRootPath()+"login/"; break;
        case 10002: Url = getRootPath()+"register"; break;
        case 10003: Url = "/Default/Index/"; break;
        case 10004: Url = "/Programme/ProgrammeList/"; break;
        case 10005: Url = getRootPath()+"index"; break;
        case 10006: Url = getRootPath()+"sendEmail"; break;
        case 10007: Url = "/Send/CheckSMS/"; break;
        case 10008: Url = getRootPath()+"update"; break;
        case 10009: Url = "/M/Pay/Index/"; break;
        case 10010: Url = "/Pays/Order/"; break;
    }
    return Url;
}