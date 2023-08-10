<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
table,tr,th,td{
	border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>
<h1>Login</h1>
<c:if  test="${not empty message}">
	<p style="color:red;">${message}</p>
</c:if>
<form action="/vaccinationcenter" method="get">
<table>
<tr>
<th>UserName</th>
<td><input type="text" name="email"></td>
</tr>
<tr>
<th>Password</th>
<td><input type="password" name="password"></td>
</tr>
<tr>
</table><br>
<input type="submit"  value="Login">
&nbsp;|&nbsp;<a href="registeration"><button type="button">Register</button></a>
</form>
<c:if  test="${not empty result}">
	<h5 style="color:green;">${result}</h5>
</c:if>
<c:if test="${not empty thanknote }">
<p style="color:blue;">${thanknote }</p>
</c:if>
</body>
</html>