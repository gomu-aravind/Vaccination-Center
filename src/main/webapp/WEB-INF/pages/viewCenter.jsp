<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewCenter</title>
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
<h1>Center Information</h1>
<table>
<tr>
<th colspan="2"><h4>${center.centername}</h4></th>
</tr>
<tr>
<th>ID</th>
<td>${center.id}</td>
</tr>
<tr>
<th>City</th>
<td>${center.city}</td>
</tr>
</table>
<hr>
<h1>All Citizen of this center</h1>
<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Action</th>
</tr>
<c:forEach var="citizens" items="${citizens}">
	<tr>
	<td>${citizens.citizenid}</td>
	<td>${citizens.name}</td>
	<td><a href="/citizens/${citizens.citizenid}">View</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>