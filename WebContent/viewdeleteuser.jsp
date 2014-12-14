<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<h1>Customer Details:</h1>
<table border=1>
	<tr>
		<th>ID</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Street</th>
		<th>City</th>
	</tr>
	<tr>
		<td>${user.ID}</td>
		<td>${user.firstName}</td>
		<td>${user.lastName}</td>
		<td>${user.street}</td>
		<td>${user.city}</td>
	</tr>
	<c:set var="userIDtoDelete" value="${user.ID}" />
</table>
<form action="viewdeleteuser" method="post">
	<input type="hidden" name="userIDtoDelete" value="${userIDtoDelete}" />
	<input type="submit" value="Delete" />
</form>
