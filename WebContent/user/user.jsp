<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

  <head>
<frameset rows="20%,*" cols="*" frameborder="yes" border="1" framespacing="1">
<frame src="${pageContext.request.contextPath }/user/welcomeUser.jsp" scrolling="no"/>
</frameset>
<frameset cols="15%,85%" frameborder="yes" framespacing="1">
<frame src="${pageContext.request.contextPath }/user/menuUser.jsp" name="left" id="left" title="leftFrame" scrolling="auto">
<frame src="${pageContext.request.contextPath }/white.jsp"  name="right" id="right" title="rightFrame" ></frame>

</frameset>
  </head>

  <body>

  </body>
</html>