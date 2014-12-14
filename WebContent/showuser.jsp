<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1>Edit Customer Details:</h1>
<s:form action="edituser" validate="true">
	<s:textfield name="customerBean.iD" label="ID"
		value="%{customerBean.iD}" readonly="true" />
	<s:textfield name="customerBean.firstName" label="First name"
		value="%{customerBean.firstName}" />
	<s:textfield name="customerBean.lastName" label="Last name"
		value="%{customerBean.lastName}" />
	<s:textfield name="customerBean.street" label="Street"
		value="%{customerBean.street}" />
	<s:textfield name="customerBean.city" label="City"
		value="%{customerBean.city}" />
	<s:submit />
	<s:hidden name="userUpdated" value="true"></s:hidden>
</s:form>
