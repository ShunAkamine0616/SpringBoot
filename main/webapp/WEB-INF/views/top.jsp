<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ画面</title>
</head>
<body>
	<h1>検索条件を入力してください</h1>
	<c:if test="${not empty msg}">
		${fn:escapeXml(msg)}
	</c:if>
	<form:form action="result" modelAttribute="index" method="post">
		<label>product_id：</label>
		<form:input type="text" path="productId" />
		<br>
		<form:button type="submit">検索</form:button>
	</form:form>
</body>
</html>