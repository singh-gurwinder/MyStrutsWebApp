<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='itag' uri='icebird'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<itag:getNewID />

<h1>Add New Customer</h1>
<s:push value="#request">
	<s:form action="adduserdetails" validate="true">
		<s:textfield name="customerBean.iD" label="ID" value="%{newUserID}"
			readonly="true" />
		<s:textfield name="customerBean.firstName" label="First name" />
		<s:textfield name="customerBean.lastName" label="Last name" />
		<s:textfield name="customerBean.street" label="Street" />
		<s:textfield name="customerBean.city" label="City" />
		<s:submit />

	</s:form>
</s:push>