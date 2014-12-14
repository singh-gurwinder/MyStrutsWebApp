<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='itag' uri='icebird'%>

<h1>View/Delete Customers</h1>
<form action="viewdeleteuser" method="post">
	Select Customer ID:
	<itag:getID />
</form>
