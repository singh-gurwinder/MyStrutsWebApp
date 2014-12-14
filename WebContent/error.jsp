<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>

<h1>OOPs...</h1>
<br>
Tomcat web server error.
<table border="1">
	<tr valign="top">
		<td width="40%"><b>Error:</b></td>
		<td>${pageContext.exception}</td>
	</tr>
	<tr valign="top">
		<td><b>URI:</b></td>
		<td>${pageContext.errorData.requestURI}</td>
	</tr>
	<tr valign="top">
		<td><b>Status code:</b></td>
		<td>${pageContext.errorData.statusCode}</td>
	</tr>
	<tr valign="top">
		<td><b>Stack trace:</b></td>
		<td><c:forEach var="trace"
				items="${pageContext.exception.stackTrace}">
				<p>${trace}</p>
			</c:forEach></td>
	</tr>
</table>