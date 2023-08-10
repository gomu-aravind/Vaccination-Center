<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewCitizen</title>
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
<table>
<tr>
<td><a href="/citizens">Citizens</a></td>
<td><a href="/vaccinationcenter/">Vaccinatiion Centers</a></td>
<td><a href="/logout">Logout</a></td>
<td>Welcome,<%=session.getAttribute("name")%></td>
</tr>
</table>
<hr>
<h1>Citizen Information</h1>
<table>
<tr>
<th colspan="2"><h1>${citizen.name}</h1></th>
</tr>
<tr>
<th>ID</th>
<td>${citizen.citizenid}</td>
</tr>
<tr>
<th>City</th>
<td>${citizen.center.city}</td>
</tr>
<tr>
<th>Number of vaccines</th>
<td>${citizen.doses}</td>
</tr>
<tr>
<th>Vaccination status</th>
<td>${citizen.status}</td>
</tr>
<tr>
<th>Center</th>
<td><a href="/citizens/center/${citizen.center.id}">${citizen.center.centername}</a></td>
</tr>
</table>
</body>
</html>