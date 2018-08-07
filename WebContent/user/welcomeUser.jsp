<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">  
 <img src="${pageContext.request.contextPath }/photo/shun5.jpg" width="100%" height="100%" border="0"/></div> 

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>.alsp{ font-family:"楷体";font-size:16px}</style>
<title>Insert title here</title>
</head>
<body>
<hr class="alsp"><center>会员主页</center><hr>
	<%!String name;%>
	<center><%
		name=(String) session.getAttribute("welcomeName");
		if(name!=null){
			out.println("你好   "+name+"！\n");
		}
	%></center>
	<hr><center>七彩云，欢迎你~</center><hr>
</body>
</html>