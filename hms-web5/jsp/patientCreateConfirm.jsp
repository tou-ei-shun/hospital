<%@ page language="java" contentType ="text/html; charset = Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ page import="java.util.*,jp.co.mtrx.hms.service.*, jp.co.mtrx.hms.model.*" %> 
	
<!DOCTYPE html>
<html>
<head>
<title>���Ғǉ�</title>
</head>
<body>
<h1>���Ғǉ�</h1>
<br />

<%
		//String name = (String)request.getAttribute("name");
		//String bloodType = (String)request.getAttribute("bloodType");
		//String height = (String)request.getAttribute("height");
		
		String name = (String)session.getAttribute("name");
		String bloodType = (String)session.getAttribute("bloodType");
		String height = (String)session.getAttribute("height");
		System.out.println("JSP :" + getClass().getName());
%>
<table border="1" width="400">
	<tr>
		<td width="50%">ID</td>
		<td width="50%"></td>
	
	</tr>
	<tr>
		<td width="50%">���O</td>
		<td width="50%"><%= name %></td>
	
	</tr>
	<tr>
		<td width="50%">���t�^</td>
		<td width="50%"><%= bloodType %></td>
		</td>
	</tr>

	<tr>
		<td width="50%">�g��</td>
		<td width="50%"><%= height %></td>

	</tr>
</table>
		
<br/>
<form name="patientCreateForml" method="POST" action="submitPatientCreate">
	<input type="hidden" name="name" value="<%= name %>">
	<input type="hidden" name="bloodType" value="<%= bloodType %>">
	<input type="hidden" name="height" value="<%= height %>">
	<input type="submit" name="submit" value=" �ǉ����s">
</form>
<br />

<br/>
<form name="patientCreateForm2" method="POST" action="submitPatientCreate">
	<input type="hidden" name="name" value="<%= name %>">
	<input type="hidden" name="bloodType" value="<%= bloodType %>">
	<input type="hidden" name="height" value="<%= height %>">
	<input type="submit" name="submit" value="���͂��Ȃ���">
</form>
<br /><br />




<a href = "displaypatientList">���҈ꗗ�ɖ߂�</a>
</body>
</html>	