<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Center</title>
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
<h1 style="text-align:center;width:100%">Add New Vaccination Center</h1>
<form method="POST" action="/regCenter" >
<table>
<tr>
<th>Center name</th>
<td><input type="text" name="centername" placeholder="CenterName" /></td>
</tr>
<tr>
<th>Center city</th>
<td>
<select name="centercity">
<option value="">Select City</option>
<option value="Bengaluru">Bengaluru</option>
<option value="Mumbai">Mumbai</option>
<option value="Pune">Pune</option>
<option value="Hyderabad">Hyderabad</option>
<option value="Chennai">Chennai</option>
</select>
</td>
</tr>
<tr>
<td colspan="2"><p style="text-align:center;"><input type="submit"  value="Submit" /></p></td>
</tr>
</table>
<c:if test="${not empty nocity }">
	<p style='color:red;text-align:center;'>${nocity}</p>
</c:if>

</form>
</body>
</html>