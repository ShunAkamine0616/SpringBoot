<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>検索結果</h1>
	<table border="1">
		<tr>
		<th><fmt:message key="form.lbl.product_id" /></th>
		<th><fmt:message key="form.lbl.product_name" /></th>
		<th><fmt:message key="form.lbl.price" /></th>
		</tr>
		<c:forEach var="product" items="${productList}">
		<tr>
			<td>${product.productId}</td>
			<td>${product.productName}</td>
			<td>${product.price}</td>
		</tr>
		</c:forEach>
		
	</table>
	

	<div>
		<a href="index"><fmt:message key="btn.back" /></a>
	</div>
</body>
</html>