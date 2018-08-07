<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />

<title>七彩云登陆注册</title><base target="_blank" />
<script type="text/javascript">
function validate_required(field,alerttxt)
{
	
with (field)
  {
  if (value==null||value=="")
    {alert(alerttxt);return false}
  else {return true}
  }
}

function validate1_form(thisform)
{
	
with (thisform)
  {
  if (validate_required(login_account,"请输入用户名")==false)
    {login_account.focus();return false}
  if (validate_required(login_password,"请输入密码")==false)
  {login_password.focus();return false}
  if (validate_required(type,"请选择类型")==false)
  {type.focus();return false}



}
}

</script>
<style>
*{
	padding:0px;
	margin:0px;
	}
    a{color:White}
body{
	font-family:Arial, Helvetica, sans-serif;
	background:url(21/images/sky2.jpg) no-repeat  center;
	font-size:13px;    
	}
img{
	border:0;
	}
.lg{width:468px; height:468px; margin:100px auto; background:url(21/images/login_bg.png) no-repeat;}
.lg_top{ height:200px; width:468px;}
.lg_main{width:400px; height:180px; margin:0 25px;}
.lg_m_1{
	width:290px;
	height:100px;
	padding:60px 55px 20px 55px;
}
.ur{
	height:37px;
	border:0;
	color:#666;
	width:236px;
	margin:4px 28px;
	background:url(21/images/user.png) no-repeat;
	padding-left:10px;
	font-size:16pt;
	font-family:Arial, Helvetica, sans-serif;
}
.pw{
	height:37px;
	border:0;
	color:#666;
	width:236px;
	margin:4px 28px;
	background:url(21/images/password.png) no-repeat;
	padding-left:10px;
	font-size:16pt;
	font-family:Arial, Helvetica, sans-serif;
}
.bn{width:330px; height:72px; background:url(21/images/enter.png) no-repeat; border:0; display:block; font-size:18px; color:#FFF; font-family:Arial, Helvetica, sans-serif; font-weight:bolder;}
.lg_foot{
	height:80px;
	width:330px;
	padding: 6px 68px 0 68px;
}
</style>
</head>

<body class="b">
<div class="lg">
<form name="form1" action="/TheFinalProject/base/checkLogin" method="POST"  onSubmit="return validate1_form(this)" target="_self">
    <div class="lg_top"></div>
    <div class="lg_main">
      <div class="lg_m_1">
        
        <div align="center">
          <input name="login_account" placeholder="请输入账号" class="ur" value="cht"/>
          <input name="login_password" type="password" placeholder="请输入密码" class="pw" value="chenhantao"/>
          <select name="type" >
            <option value="" selected>---请选择---</option>
            <option value="1">会员</option>
            <option value="2">商家</option>
            <option value="3">管理员</option>

          </select>
        </div>
      </div>
    </div>
    <div class="lg_foot">
    <input type="submit" value="点这里登录" class="bn" /></div>
    <td>&nbsp;</td>
</form>
</div>
<div style="text-align:center;">
<p><a href="regist_user.jsp" target="_self">会员注册</a> <a href="regist_business.jsp" target="_self">商家注册</a> </p>
</div>
</body>
</html>
