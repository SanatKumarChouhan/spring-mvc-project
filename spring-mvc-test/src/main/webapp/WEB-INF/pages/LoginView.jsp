<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="Header.jsp" %>
	<sf:form method="post" modelAttribute="form">

		<div align="center">
			<h1>Login</h1>
			<table>
				<tr>
					<th>Login id:</th>
					<td><sf:input path="login" /></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><sf:input path="password" /></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="SignIn"></td>
				</tr>
			</table>
		</div>

	</sf:form>

</body>
</html>