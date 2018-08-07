<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
　

<html>

<head>
<title>注册</title>
<script type="text/javascript">
function validate_email(field,alerttxt)
{
with (field)
{
apos=value.indexOf("@")
dotpos=value.lastIndexOf(".")
if (apos<1||dotpos-apos<2) 
  {alert(alerttxt);return false}
else {return true}
}
}

function validate_form(thisform)
{
with (thisform)
{
if (validate_email(email,"Not a valid e-mail address!")==false)
  {email.focus();return false}
}
}
function checkpwd(){
	  var p1=document.form1.password.value;//获取密码框的值
	  var p2=document.form1.confirmpass.value;//获取重新输入的密码值
	
	  
	  if(p1!=p2){//判断两次输入的值是否一致，不一致则显示错误信息
	   document.getElementById("msg").innerHTML="两次密码不一致，请重新输入";//在div显示错误信息

	   return false;
	  }else{
		  document.getElementById("msg").innerHTML="密码正确！";//在div正确

			  return true;
	  }
	 }


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
  if (validate_required(regist_bname,"请输入店铺名")==false)
    {regist_bname.focus();return false}
  if (validate_required(regist_account,"请输入账号")==false)
  {regist_account.focus();return false}
  if (validate_required(regist_password,"请输入密码")==false)
  {regist_password.focus();return false}
  if (validate_required(confirmpass,"请确认密码")==false)
  {confirmpass.focus();return false}
  if (validate_email(regist_email,"电子邮箱格式不正确！")==false)
  {regist_email.focus();return false}
  if (validate_required(education,"请选择学历")==false)
  {education.focus();return false}
  if (validate_required(accept,"请阅读接受相关协议，完成注册")==false)
  {accept.focus();return false}
  if (validate_required(regist_scorerate,"请填写积分比例")==false)
  {regist_scorerate.focus();return false}


}
}

</script>
</head>
<body>

<!-- 
<div>  <a href="show.jsp" target="content">
  链接名1
  </a>  <a href="xxoo2.html" target="content">
  链接名2
  </a>  <a href="xxoo3.html" target="content">
  链接名3
  </a></div>
<iframe name="content" src="user.jsp" width="100%" height="100%"></iframe> 
-->
<div id="Layer1" style="position:absolute; width:100%; height:127px; z-index:-1; overflow: auto; top: -3px; left: 11px;">  
<img src="photo/shun1.jpg" height="100%" width="100%"/></div> 


<h1 align="center">欢迎新商家</h1>
<hr align="center">

<h1 align="center">商家注册</h1>
<hr align="center">
<form name="form1" action="/TheFinalProject/base/addbusiness" onSubmit="return validate1_form(this)" method="post">
  <div align="center">
 		
    <div align="center">
      <table width="0" border="0" cellspacing="0" cellpadding="0">
       
	          <tr>
          <td>账号：</td>
      <td><input type="text" name="regist_account"/></td>
      </tr>
        <tr>
          <td>密码： </td>
      <td><input type="password" name="regist_password"/></td>
      </tr>
        
        <tr>
          <td>确认密码：</td>
      <td><input type="password" name="confirmpass" onChange="checkpwd()"/></td>

      </tr>
        	 <tr>
        	   <td><!--DWLayoutEmptyCell-->&nbsp;</td>
	  		   <td id="msg"  align="left" style="color:green" ></td>

			</tr>
	 <tr>
          <td>商家名：</td>
      <td><input type="text" name="regist_bname"/></td>
      </tr>
        <tr>
          <td>电子邮箱：</td>
      <td><input type="text" name="regist_email" /></td>
     </tr>
   <tr>
          <td>电话：</td>
      <td><input type="text" name="regist_bphone" /></td>
     </tr>
     <tr>
     	<td>地址:</td>
		<td><input type ="text" name = "regist_addr"/></td>
     </tr>   
        <tr>
          <td>积分比率：</td>
      <td><input type="text" name="regist_scorerate" /></td>
      </tr>
        
        <tr>
          <td>商家类型：</td>
          <td>
        <select name="regist_type"> 
          <option value="">---请选择---</option>
          <option value="美食" selected>美食</option>
          <option value="酒店">酒店</option>
          <option value="电影">电影</option>
          <option value="生活服务">生活服务</option>
          <option value="购物">购物</option>
          <option value="周边游/旅游">周边游/旅游</option>
          <option value="其他">其他</option>
          </select>      </td>
      </tr>
        <tr>
          <td>                </td>
  </tr>
        <tr> 
          <td>服务协议:        </td>
      <td>
        <textarea rows="10" cols="30">
吊炸天的条款
</textarea>      </td>
  </tr>
        
        
        
        <tr>
        <td>    是否接受协议           </td>
      <td>
        <select name="accept"> 
        <option value="" selected>拒绝</option>
        <option value="1">接受</option>  </select> </td>
        </tr>
        
        <tr>
        <td colspan="2"><div align="center">
        <input type="submit" value="注册" />
        <a href="login.jsp" target="_self"><input type="button" value="取消"/></a>       
        </div></td>
        </tr>
    </table>
  </div>
    </div>
</form>

 

</body>
</html>