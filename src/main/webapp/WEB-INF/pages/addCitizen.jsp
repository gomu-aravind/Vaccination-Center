<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Citizen</title>
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
<h1 style="text-align:center;width:100%">Add New Citizen</h1>
<form method="POST" action="/regCitizen" >
<table>
<tr>
<th>Name</th>
<td><input type="text" name="name" placeholder="Name" /></td>
</tr>
<tr>
<th>CenterName</th>
<td>
<select name="centername">
<option value="">Select a center</option>
<c:forEach var="center" items="${centers}">
	<option value="${center.centername}">${center.centername}</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<th>Doses</th>
<td>
<select name="doses">
<option value="">Select no of doses</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
</select>
</td>
</tr>
<tr>
<th>Status</th>
<td><input type="text" name="status" placeholder="status" /></td>
</tr>
<tr>
<td colspan="2"><p style="text-align:center"><input type="submit"  value="Submit" /></p></td>
</tr>
</table>
<c:if test="${not empty notselect }">
	<p style='color:red;text-align:center;'>${notselect}</p>
</c:if>

</form>
</body>
</html>