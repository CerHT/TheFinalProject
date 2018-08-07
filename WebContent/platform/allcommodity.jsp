<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
function buy(id){   
    window.location.href="<%=request.getContextPath()%>/spendrecord?method=buy&id=" + id;   
}  
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
	border-collapse: collapse;
}

td {
	border: 2px solid blue;
}
</style>
</head>
<body>
	<center>
		<form name="form" >
			<table>
				<tr>
					<td>商品名称</td>
					<td>商品价格</td>
					<td>商品数量</td>
					<td>购买</td>
				</tr>
				<c:forEach items="${list }" var="user" varStatus="status">
					<tr id="<c:out  value="${user.c_id}"/>">
						<td><input value="${user.c_name}" readonly="readonly" /></td>
						<td><input value="${user.c_price }" readonly="readonly"></td>
						<td><input name="list[${status.index}].c_number"
							value="${user.c_number}" readonly="readonly" /></td>
						<td><input type="button" onclick="buy('<c:out value="${user.c_id}"/>')"value="购买" /></td>
					</tr>
				</c:forEach>
			</table>
		</form>
		<br>
		<table>
			<tr>
				<td colspan="6" align="center" bgcolor="#5BA8DE">共${page.totalRecords}条记录
					共${page.totalPages}页 当前第${page.pageNo}页<br> <a
					href="<%=request.getContextPath()%>/platform/allcommodity?pageNo=${page.topPageNo}"><input
						type="button" name="fristPage" value="首页" /></a> <c:choose>
						<c:when test="${page.pageNo!=1}">
							<a
								href="<%=request.getContextPath()%>/platform/allcommodity?pageNo=${page.previousPageNo }"><input
								type="button" name="previousPage" value="上一页" /></a>
						</c:when>
						<c:otherwise>
							<input type="button" disabled="disabled" name="previousPage"
								value="上一页" />
						</c:otherwise>
					</c:choose> <c:choose>
						<c:when test="${page.pageNo != page.totalPages}">
							<a
								href="<%=request.getContextPath()%>/platform/allcommodity?pageNo=${page.nextPageNo }"><input
								type="button" name="nextPage" value="下一页" /></a>
						</c:when>
						<c:otherwise>
							<input type="button" disabled="disabled" name="nextPage"
								value="下一页" />
						</c:otherwise>
					</c:choose> <a
					href="<%=request.getContextPath()%>/platform/allcommodity?pageNo=${page.bottomPageNo}"><input
						type="button" name="lastPage" value="尾页" /></a>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>