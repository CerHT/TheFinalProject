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
  if (validate_required(username,"请输入用户名")==false)
    {username.focus();return false}
  if (validate_required(account,"请输入账号")==false)
  {account.focus();return false}
  if (validate_required(password,"请输入密码")==false)
  {password.focus();return false}
  if (validate_required(confirmpass,"请确认密码")==false)
  {confirmpass.focus();return false}
  if (validate_email(Email,"电子邮箱格式不正确！")==false)
  {Email.focus();return false}
  if (validate_required(education,"请选择学历")==false)
  {education.focus();return false}
  if (validate_required(accept,"请阅读接受相关协议，完成注册")==false)
  {accept.focus();return false}
  


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
<img src="${pageContext.request.contextPath }/photo/shun1.jpg" height="100%" width="100%"/></div> 


<h1 align="center">修改信息</h1>
<hr align="center">
<form name="form1" action="/TheFinalProject/business/update" onSubmit="return validate1_form(this)" method="post">
  <div align="center">
 		
    <div align="center">
      <table width="0" border="0" cellspacing="0" cellpadding="0">
        	 <tr>
        	   <td><!--DWLayoutEmptyCell-->&nbsp;</td>
	  		   <td id="msg"  align="left" style="color:green" ></td>
			</tr>
	 <tr>
          <td>用户名：</td>
      <td><input type="text" name="b_name" value="<%=request.getAttribute("b_name")%>"/></td>
      </tr>
        <tr>
          <td>电子邮箱：</td>
      <td><input type="text" name="b_email" value="<%=request.getAttribute("b_mail")%>"/></td>
     </tr>
   <tr>
          <td>电话：</td>
      <td><input type="text" name="b_phone" value="<%=request.getAttribute("b_tel")%>"/></td>
     </tr>
     <tr>
     	<td>地址:</td>
		<td><input type ="text" name = "b_add" value="<%=request.getAttribute("b_add")%>"/></td>
     </tr>   
        <tr>
          <td>积分比率：</td>
      <td><input type="text" name="score_rate" value="<%=request.getAttribute("score_rate")%>"/></td>
      </tr>
        
        <tr>
          <td>商家类型：</td>
          <td>
        <select name="b_type"> 
          <option value="">---请选择---</option>
          <option value="0" selected>美食</option>
          <option value="1">酒店</option>
          <option value="2">电影</option>
          <option value="3">生活服务</option>
          <option value="4">购物</option>
          <option value="5">周边游/旅游</option>
          <option value="6">其他</option>
          </select>      </td>
      </tr>

        
         <tr>
        <td colspan="2"><div align="center">
        <input type="submit" value="修改" />
        </div></td>
        </tr>
    </table>
  </div>
    </div>
</form>

 

</body>
</html>