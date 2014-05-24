<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product</title>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
	<form action="add" method="post">
		<p>Nom : </p><input type="text" name="nom" />
		<p>Description : </p><input type="text" name="desc" />
		<p>Prix : </p><input type="number" name="price" />
		<input type="submit" value="Add"/>
	</form>
<hr>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>