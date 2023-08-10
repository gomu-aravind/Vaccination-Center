<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<h1>Center</h1>
<div style="text-align:center;margin-bottom: 20px;">
<a href="/addCenter"><button>Add new center</button></a>
</div>
<table>
<tr>
<th>Id</th>
<th>Name</th>
<th>City</th>
<th>Action</th>
</tr>
<c:forEach var="center" items="${centers}">
<tr>
	<td>${center.id }</td>
	<td>${center.centername }</td>
	<td>${center.city }</td>
	<td style="width:80%;">
	<a href="/vaccinationcenter/center/${center.id}">View</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="/vaccinationcenter/modify/${center.id}">Edit</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="/vaccinationcenter/${center.id}">Delete</a>
	</td>
	</tr>
</c:forEach>
</table>
<h5 style="text-align:center;">There are ${count} no of vaccination centers</h5>
<c:if test="${not empty successCenter }">
<p style="color:green;text-align:center;">${successCenter }</p>
</c:if>
<c:if test="${not empty citmsg }">
<p style="color:red;text-align:center;">${citmsg }</p>
</c:if>
</body>
</html>