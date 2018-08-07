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
						<td><input name="list[${status.index}].id.u_id"
							value="${user.id.u_id}" readonly="readonly" /></td>
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
	</center>
</body>
</html>