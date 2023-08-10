<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<frm:form method="POST" action="/newUser"  modelAttribute="admin">
<table>
<tr>
<th>Name</th>
<td><frm:input type="text" path="name"/></td>
</tr>
<tr>
<th>Email</th>
<td><frm:input type="text" path="email"/></td>
</tr>
<tr>
<th>Password</th>
<td><frm:input type="text" path="password"/></td>
</tr>
<tr>
<td><input type="submit" value="Register"><td>
</tr>
</table>	
</frm:form>
</body>
</html>