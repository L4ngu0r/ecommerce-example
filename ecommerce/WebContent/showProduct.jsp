<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail of product ${product.nom}</title>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
	<h1>${product.nom}</h1>
	<p>${product.description}</p>
	<span>${product.price}</span>
<hr>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>