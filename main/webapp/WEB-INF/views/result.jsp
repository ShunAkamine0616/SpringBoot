<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果画面</title>
</head>
<body>
	<p>${fn:escapeXml(name)}さんが下記の商品を選択しました</p>
	
	<p>商品：${fn:escapeXml(product.name)}</p>
	<p>金額：${fn:escapeXml(product.price)}</p>
<%-- 	<c:forEach var="product" items="${productList}"> --%>
<%-- 		<c:if test="${product.getId() == id}"> --%>
<!-- 			<div> -->
<%-- 				<label class="required">商品：${product.getName()}</label> --%>
<!-- 			</div> -->
<!-- 			<div> -->
<%-- 				<label class="required">金額：${product.getPrice()}</label> --%>
<!-- 			</div> -->
<%-- 		</c:if> --%>
<%-- 	</c:forEach> --%>
</body>
</html>