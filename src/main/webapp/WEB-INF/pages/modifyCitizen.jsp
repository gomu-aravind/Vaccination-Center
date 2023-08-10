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
<h1 style="text-align:center;">Modifying citizen Information</h1>
<hr>
<br>
<form method="post" action="/editCitizen">
<input type="hidden" name="citizenid" value="${citizen.citizenid}">
<table>
<tr>
<th>Name</th>
<td><input type="text" name="name" value="${citizen.name}"></td>
<tr>
<tr><td colspan="2"><h4 style="text-align:center;">Your selected city is ${citizen.center.city}</h4></td></tr>
<tr>
<th>City</th>
<td>
<select name="center.city">
<option value="">Select City</option>
<c:forEach var="cities" items="${cities}">
<option value="${cities}" <c:if test="${cities== citizen.center.city }">selected</c:if>>${cities}</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<th>No of Doses</th>
<td>
<select name="doses">
<option value="">Select no of doses</option>
<option value="0" <c:if test="${citizen.doses== '0'}">selected</c:if>>0</option>
<option value="1"  <c:if test="${citizen.doses== '1'}">selected</c:if>>1</option>
<option value="2"  <c:if test="${citizen.doses== '2'}">selected</c:if>>2</option>
</select>
</td>
</tr>
<tr>
<th>Vaccination Status</th>
<td><input type="text" name="status" value="${citizen.status}"></td>
</tr>
<tr>
<th>Center names</th>
<td>
<select name="center.centername">
<option value="">Select Center</option>
<c:forEach var="centername" items="${centernames}">
<option value="${centername}" <c:if test="${centername== citizen.center.centername}">selected</c:if>>${centername}</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td colspan="2"><p style="text-align:center;"><input type="submit" value="modify"></p></td>
</tr>
</table>
</form>
<c:if test="${not empty change}">
	<p style='color:red;text-align:center;'>${change}</p>
</c:if>
</body>
</html>