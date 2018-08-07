<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
　

<html>

<head>
<title>注册</title>
<style>.alsp{ font-family:"楷体";font-size:36px}</style>
<style>.alsp2{ font-family:"楷体";font-size:16px}</style>
<style>.alsp3{ font-family:"行楷";font-size:12px}</style>
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
	  var p1=document.form1.update_password.value;//获取密码框的值
	  var p2=document.form1.confirm_password.value;//获取重新输入的密码值
	
	  
	  if(p1!=p2){//判断两次输入的值是否一致，不一致则显示错误信息
	   document.getElementById("msg").innerHTML="两次密码不一致!";//在div显示错误信息

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


  if (validate_required(update_password,"请输入密码")==false)
  {update_password.focus();return false}
  if (validate_required(confirm_password,"请确认密码")==false)
  {confirm_password.focus();return false}


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
<div class="alsp" id="Layer1" style="position:absolute; width:100%; height:200px; z-index:-1; overflow: auto; left: 0px; top: 110px;">  
<img src="${pageContext.request.contextPath }/photo/shun3.jpg" height="100%" width="100%"/></div> 
<div class="alsp" id="Layer1" style="position:absolute; width:100%; height:129px; z-index:-1; overflow: auto;">  
<img src="${pageContext.request.contextPath }/photo/shun4.jpg" height="100%" width="100%"/></div> 



<h1 align="center">修改密码</h1>
<hr align="center">
<form name="form1" action="/TheFinalProject/base/changePwd" onSubmit="return checkpwd()" method="post">
  <div align="center">
 		
    <div align="center">
      <table width="0" border="0" cellspacing="0" cellpadding="0">

	  
        <tr>
          <td>新密码： </td>
      <td><input type="password" name="update_password"/></td>
      </tr>
        
        <tr>
          <td>确认密码：</td>
      <td><input type="password" name="confirm_password" onChange="checkpwd()"/></td>
      </tr>
        	 <tr>
        	   <td><!--DWLayoutEmptyCell-->&nbsp;</td>
	  		   <td id="msg"  align="left" style="color:green" ></td>
			</tr>
        
        
        
       
        
        <tr>
        <td colspan="2"><div align="center">
        <input type="submit" value="确定" />
            <input type="button" value="取消" />
        </div></td>
        </tr>
    </table>
  </div>
    </div>
</form>

 

</body>
</html>