<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>JWP Company Home Page</title>
</head>

<body>
	<h2>JWP Company Home Page -- Persist!</h2>
	<hr>
	
	<p>
	Welcome to the JWP Company Home Page!
	</p>
	
	<p>
		User: <security:authentication property="principal.username"/>
		<br><hr>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	
	<!-- Add a link to /leaders -->
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
	</p>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
	<input type="submit" value="Logout" />	
	
	</form:form>
	
</body>

</html>