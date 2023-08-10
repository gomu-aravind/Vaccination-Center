<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ModifyCenter</title>
<style>
table,th,td,tr{
border: 1px solid black;
  border-collapse: collapse;
  width:40%;
  margin-left: auto;
margin-right: auto;
}
</style>
</head>
<body>
<h1 style="text-align:center;">Modifying center Information</h1>
<hr>
<br>
<form method="post" action="/editCenter">
<input type="hidden" name="id" value="${center.id}">
<table>
<tr>
<th>Name</th>
<td><input type="text" name="centername" value="${center.centername}"></td>
<tr>
<tr><td colspan="2"><h4 style="text-align:center;">Your selected city is ${center.city}</h4></td></tr>
<tr>
<th>City</th>
<td>
<select name="city">
<option value="">Select City</option>
<option value="Bengaluru"<c:if test="${center.city == 'Bengaluru'}">selected</c:if>>Bengaluru</option>
<option value="Mumbai"<c:if test="${center.city == 'Mumbai'}">selected</c:if>>Mumbai</option>
<option value="Pune"<c:if test="${center.city == 'Pune'}">selected</c:if>>Pune</option>
<option value="Hyderabad"<c:if test="${center.city == 'Hyderabad'}">selected</c:if>>Hyderabad</option>
<option value="Chennai"<c:if test="${center.city == 'Chennai'}">selected</c:if>>Chennai</option>
</select>
</td>
</tr>
<tr>
<td colspan="2"><p style="text-align:center;"><input type="submit" value="modify"></p></td>
</tr>
</table>
</form>
<c:if test="${not empty nocity }">
	<p style='color:red;text-align:center;'>${nocity}</p>
</c:if>
</body>
</html>