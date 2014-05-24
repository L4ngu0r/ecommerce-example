<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<ul>
		<li><a href="${pageContext.servletContext.contextPath}">Home</a></li>
		<li><a href="${pageContext.servletContext.contextPath}/list">Product List</a></li>
		<c:choose>
			<c:when test="${not empty sessionScope.username}">
				<li><a href="${pageContext.servletContext.contextPath}/auth/add">Add a product</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/auth/basicInsert">Insert random</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/logout">Logout</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.servletContext.contextPath}/login">Login</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</header>