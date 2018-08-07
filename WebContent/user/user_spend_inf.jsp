<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
		<h1>留言信息列表</h1>
		<form name="form" >
			<table>
				<tr>
					<td>商品</td>
					<td>单价</td>
					<td>数量</td>
					<td>总价</td>
					<td>是否使用现金</td>
					<td>是否使用积分</td>
					<td>现金金额</td>
					<td>使用积分</td>
					<td>实付金额</td>
				</tr>
				<c:forEach items="${spend_list }" var="user" varStatus="status">
					<tr id="<c:out  value="${user.id}"/>">
						<td><input name="list[${status.index}].commodity_inf.c_id"
							value="${user.commodity_inf.c_id}" readonly="readonly" /></td>
						<td><input name="list[${status.index}].commodity_inf.c_price"
							value="${user.commodity_inf.c_price}" readonly="readonly" /></td>
						<td><input name="list[${status.index}].commoditynumber"
							value="${user.commoditynumber}" readonly="readonly" /></td>
						<td><input name="list[${status.index}].money"
							value="${user.money}" readonly="readonly" /></td>
						<td><input name="list[${status.index}].is_use_cash"
							value="${user.is_use_cash}" readonly="readonly" /></td>
						<td><input name="list[${status.index}].is_use_score"
							value="${user.is_use_score}" readonly="readonly" /></td>
						<td><input name="list[${status.index}].cash"
							value="${user.cash}" readonly="readonly" /></td>
						<td><input name="list[${status.index}].used_score_once"
							value="${user.used_score_once}" readonly="readonly" /></td>
						<td><input name="list[${status.index}].finalpay"
							value="${user.finalpay}" readonly="readonly" /></td>

					</tr>
				</c:forEach>
			</table>
		</form>
		<br>
		<table>
			<tr>
				<td colspan="6" align="center" bgcolor="#5BA8DE">共${page.totalRecords}条记录
					共${page.totalPages}页 当前第${page.pageNo}页<br> <a
					href="<%=request.getContextPath()%>/spendrecord/show?pageNo=${page.topPageNo}"><input
						type="button" name="fristPage" value="首页" /></a> <c:choose>
						<c:when test="${page.pageNo!=1}">
							<a
								href="<%=request.getContextPath()%>/spendrecord/show?pageNo=${page.previousPageNo }"><input
								type="button" name="previousPage" value="上一页" /></a>
						</c:when>
						<c:otherwise>
							<input type="button" disabled="disabled" name="previousPage"
								value="上一页" />
						</c:otherwise>
					</c:choose> <c:choose>
						<c:when test="${page.pageNo != page.totalPages}">
							<a
								href="<%=request.getContextPath()%>/spendrecord/show?pageNo=${page.nextPageNo }"><input
								type="button" name="nextPage" value="下一页" /></a>
						</c:when>
						<c:otherwise>
							<input type="button" disabled="disabled" name="nextPage"
								value="下一页" />
						</c:otherwise>
					</c:choose> <a
					href="<%=request.getContextPath()%>/spendrecord/show?pageNo=${page.bottomPageNo}"><input
						type="button" name="lastPage" value="尾页" /></a>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>