package com.yoyo.gamecenter.utils;

/**
 * Created by Administrator on 2017/5/13 0013.
 * 检验工具累
 */
public class CheckUtil {
    // 检查输入的内容是否包括HTML代码
    public static boolean checkHtmlData(String strContentData)
    {
        String strRepalce = strContentData.replace("◆", "");
        if (strRepalce == "")
            return true;
        if (strContentData == null || strContentData == "")
            return true;
        String strToLower = strContentData.toLowerCase();
        if (strToLower.indexOf('|') >= 0)// |（竖线符号）
            return false;
        else if (strToLower.indexOf("&") >= 0)//& （& 符号）
            return false;
        else if (strToLower.indexOf(";") >= 0)//;（分号）
            return false;
        else if (strToLower.indexOf("$") >= 0)//$（美元符号）
            return false;
        else if (strToLower.indexOf("￥") >= 0)//￥（人民币符号）
            return false;
        else if (strToLower.indexOf("%") >= 0)//%（百分比符号）
            return false;
        else if (strToLower.indexOf("#") >= 0)//#号
            return false;
        else if (strToLower.indexOf("!") >= 0)//!（英文感叹号）
            return false;
        else if (strToLower.indexOf("！") >= 0)//！（中文感叹号）
            return false;
        else if (strToLower.indexOf("*") >= 0)//*（英文*号）
            return false;
        else if (strToLower.indexOf("×") >= 0)//^（中文*号）
            return false;
        else if (strToLower.indexOf("^") >= 0)//^（英文^号）
            return false;
        else if (strToLower.indexOf("……") >= 0)//……（中文^号）
            return false;
        else if (strToLower.indexOf("——") >= 0)//——（中文上划线号）
            return false;
        else if (strToLower.indexOf("{") >= 0)//{（英文括号）
            return false;
        else if (strToLower.indexOf("}") >= 0)//}（英文括号）
            return false;
        else if (strToLower.indexOf("[") >= 0)//[（英文中括号）
            return false;
        else if (strToLower.indexOf("]") >= 0)//]（英文中括号）
            return false;
        else if (strToLower.indexOf("『") >= 0)//『（中文括号）
            return false;
        else if (strToLower.indexOf("』") >= 0)//』（中文括号）
            return false;
        else if (strToLower.indexOf("【") >= 0)//【（中文中括号）
            return false;
        else if (strToLower.indexOf("】") >= 0)//】（中文中括号）
            return false;
        else if (strToLower.indexOf("、") >= 0)//、（中文顿号）
            return false;
        else if (strToLower.indexOf("？") >= 0)//？（中文问号）
            return false;
        else if (strToLower.indexOf("?") >= 0)//?（英文问号）
            return false;
            //else if (strToLower.indexOf("@") >= 0)// @（at 符号）  //邮箱符号
            //    return false;
        else if (strToLower.indexOf("'") >= 0)// '（单引号）
            return false;
        else if (strToLower.indexOf('"') >= 0)//"（引号）
            return false;
        else if (strToLower.indexOf("\'") >= 0)//\'（反斜杠转义单引号）
            return false;
        else if (strToLower.indexOf('\"') >= 0)//\"（反斜杠转义引号）
            return false;
        else if (strToLower.indexOf("<>") >= 0)//<>（尖括号）
            return false;
        else if (strToLower.indexOf('<') >= 0)//&gt;
            return false;
        else if (strToLower.indexOf('>') >= 0)//&lt;
            return false;
        else if (strToLower.indexOf("()") >= 0)//()（括号）
            return false;
        else if (strToLower.indexOf("(") >= 0)//(
            return false;
        else if (strToLower.indexOf(")") >= 0)//)
            return false;
        else if (strToLower.indexOf("+") >= 0)//+（加号）
            return false;
        else if (strToLower.indexOf("=") >= 0)//+（等于号）
            return false;
        else if (strToLower.indexOf("cr") >= 0)//CR（回车符，ASCII 0x0d）
            return false;
        else if (strToLower.indexOf("lf") >= 0)//LF（换行，ASCII 0x0a）
            return false;
        else if (strToLower.indexOf("0x0d") >= 0)//CR（回车符，ASCII 0x0d）
            return false;
        else if (strToLower.indexOf("0x0a") >= 0)//LF（换行，ASCII 0x0a）
            return false;
        else if (strToLower.indexOf('\n') >= 0)//<br/>
            return false;
        else if (strToLower.indexOf('\r') >= 0)//<br/>
            return false;
        else if (strToLower.indexOf("<br/>") >= 0)//<br/>
            return false;
        else if (strToLower.indexOf(",") >= 0)//,（逗号）
            return false;
        else if (strToLower.indexOf("\\") >= 0)//\（反斜杠）
            return false;
        else if (strToLower.indexOf("javascript") >= 0)
            return false;
        else if (strToLower.indexOf("document.cookie") >= 0)
            return false;
        else if (strToLower.indexOf("document.location") >= 0)
            return false;
        else if (strToLower.indexOf("iframe") >= 0)
            return false;
        return true;

    }

    // 检查输入的内容是否包括SQL关键字
    public static boolean checkSqlData(String strContentData)
    {
        String strRepalce = strContentData.replace("◆", "");
        if (strRepalce == "")
            return true;
        if (strContentData == null || strContentData == "")
            return true;
        String strToLower = strContentData.toLowerCase();
        //&& strToLower.indexOf("','")== -1
        if (strToLower.indexOf("'") >= 0)//'（单引号）
            return false;
        else if (strToLower.indexOf('"') >= 0)//"（引号）
            return false;
            // && strToLower.indexOf("\',\'") == -1
        else if (strToLower.indexOf("\'") >= 0)//\'（反斜线转义单引号）
            return false;
        else if (strToLower.indexOf('\"') >= 0)//\"（反斜杠转义引号）
            return false;
        else if (strToLower.indexOf(")") >= 0)//)（结束括号）
            return false;
        else if (strToLower.indexOf(";") >= 0)//;（分号）
            return false;
        else if (strToLower.indexOf("--") >= 0)//--（SQL注释号）
            return false;
        else if (strToLower.indexOf(":") >= 0)//:（冒号）
            return false;
        else if (strToLower.indexOf("net user") >= 0)
            return false;
        else if (strToLower.indexOf("xp_cmdshell") >= 0)
            return false;
        else if (strToLower.indexOf("/add") >= 0)
            return false;
        else if (strToLower.indexOf("exec master.dbo.xp_cmdshell") >= 0)
            return false;
        else if (strToLower.indexOf("net localgroup administrators") >= 0)
            return false;
        else if (strToLower.indexOf("insert") >= 0)
            return false;
        else if (strToLower.indexOf("delete") >= 0)
            return false;
        else if (strToLower.indexOf("drop") >= 0)
            return false;
        else if (strToLower.indexOf("update") >= 0)
            return false;
        else if (strToLower.indexOf("truncate") >= 0)
            return false;
        else if (strToLower.indexOf("exec") >= 0)
            return false;
        else if (strToLower.indexOf("select") >= 0)
            return false;
        else if (strToLower.indexOf("create") >= 0)
            return false;
        else if (strToLower.indexOf("alter") >= 0)
            return false;
        else if (strToLower.indexOf("database") >= 0)
            return false;
        else if (strToLower.indexOf("set") >= 0)
            return false;
        else if (strToLower.indexOf("and") >= 0)
            return false;
        else if (strToLower.indexOf("or") >= 0)
            return false;
        else if (strToLower.indexOf("values") >= 0)
            return false;
        else if (strToLower.indexOf("insert") >= 0)
            return false;
        else if (strToLower.indexOf("from") >= 0)
            return false;
        return true;

    }
}
