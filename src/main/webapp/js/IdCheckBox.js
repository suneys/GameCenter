//多选全选
function GetIDStr(IdCheckBox)
{
    if(!IdCheckBox)
    {
        return "";
    }

    var i;
    var idstr="";
    if(IdCheckBox.length)
    {
        for(i=0;i<IdCheckBox.length;i++)
        {
            if(IdCheckBox[i].checked)
            {
                if(idstr=="")
                    idstr += IdCheckBox[i].value;
                else
                    idstr += "," + IdCheckBox[i].value;
            }
        }
    }
    else
    {
        if(IdCheckBox.checked)
            idstr=IdCheckBox.value;
    }
    
    return idstr;
}

function GetRecordIDStr(IdCheckBox,idType)
{
    if(!IdCheckBox)
    {
        return "";
    }

    var i;
    var idstr="";
    if(IdCheckBox.length)
    {
        for(i=0;i<IdCheckBox.length;i++)
        {
            if(IdCheckBox[i].checked)
            {
                if(idstr=="")
                    idstr += GetSplitID(IdCheckBox[i].value,idType);
                else
                    idstr += "," + GetSplitID(IdCheckBox[i].value,idType);
            }
        }
    }
    else
    {
        if(IdCheckBox.checked)
            idstr = GetSplitID(IdCheckBox.value,idType);
    }
    
    return idstr;
}

function GetSplitID(str,idType)
{
    var strArr = str.split("|");
    if(idType == 0)
        return strArr[0];
    else
        return strArr[1];
}


///获得ApplyID和ResumeID
function NewGetRecordIDStr(IdCheckBox)
{
	if(!IdCheckBox)
    {
        return "";
    }

    var i;
    var idstr="";
    if(IdCheckBox.length)
    {
        for(i=0;i<IdCheckBox.length;i++)
        {
            if(IdCheckBox[i].checked)
            {
                if(idstr=="")
                    idstr += IdCheckBox[i].value;
                else
                    idstr += "," + IdCheckBox[i].value;
            }
        }
    }
    else
    {
        if(IdCheckBox.checked)
            idstr = IdCheckBox.value;
    }
    
    return idstr;
}


function CheckAll_OnClick(checkAll,IdCheckBox)
{
    if(!IdCheckBox) return;
    if(!IdCheckBox.length) { IdCheckBox.checked=checkAll.checked;return; }
    
    var i;
    for(i=0;i<IdCheckBox.length;i++)
    {
        IdCheckBox[i].checked=checkAll.checked;
    }
}

function IdCheckBox_OnClick(IdCheckBox,checkAll)
{
    if(!IdCheckBox.length)
    { checkAll.checked = IdCheckBox.checked;return; }
    
    var allCheck=true;
    var i;
    
    for(i=0;i<IdCheckBox.length;i++)
    {
        if(!IdCheckBox[i].checked)
        {
            allCheck=false;
            break;
        }
    }
    checkAll.checked=allCheck;
}

