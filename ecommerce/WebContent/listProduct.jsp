<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of product</title>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
	<c:choose>
		<c:when test="${empty liste}">
			<p>No products to display</p>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<c:if test="${not empty username}">
						<th>Action</th>
					</c:if>
				</tr>
				<c:forEach items="${liste}" var="p">
				<tr>
					<td><a href="show?id=${p.id}">${p.id}</a></td>
					<td>${p.nom}</td>
					<td>${p.description}</td>
					<c:if test="${not empty username}">
						<td>
							<form action="auth/remove" method="POST">
								<input type="hidden" value="${p.id}" name="id"/>
								<input type="submit" value="Remove" />
							</form>
						</td>
					</c:if>
				</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
<hr>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>