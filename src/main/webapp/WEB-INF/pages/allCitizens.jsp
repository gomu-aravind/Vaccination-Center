<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Citizens</title>
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
<h1>Citizens</h1>
<div style="text-align:center;margin-bottom: 20px;">
<a href="/addCitizen"><button>Add new citizen</button></a>
</div>
<table>
<tr>
<th>Id</th>
<th>Name</th>
<th>City</th>
<th>No of Doses</th>
<th>Vaccination Status</th>
<th>Vaccination Center</th>
<th>Action</th>
</tr>
<c:forEach var="citizens" items="${citizens}">
<tr>
	<td>${citizens.citizenid }</td>
	<td>${citizens.name }</td>
	<td>${citizens.center.city}</td>
	<td>${citizens.doses}</td>
	<td>${citizens.status}</td>
	<td>${citizens.center.centername}</td>
	<td style="width:80%;">
	<a href="/citizens/${citizens.citizenid}">View</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="/citizens/modify/${citizens.citizenid}">Edit</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="/citizens/delete/${citizens.citizenid}">Delete</a>
	</td>
	</tr>
</c:forEach>
</table>
<h5 style="text-align:center;">There are ${count} no of citizens</h5>
<c:if test="${not empty successCenter }">
<p style="color:green;text-align:center;">${successCenter }</p>
</c:if>
</body>
</html>