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
		//String error = (String)request.getAttribute("error");
		String error = (String)session.getAttribute("error");
		System.out.println("JSP :" + getClass().getName());
		if(error != null){
%>
	<font color="red"><%= error %></font>
	
<% 
	}
 %>	
	
<form name="patientCreateFrom" method="POST" action="displayPatientCreateConfirm">
<table border="1" width="400">
	<tr>
		<td width="50%">ID</td>
		<td width="50%"></td>
	
	</tr>
	<tr>
		<td width="50%">���O</td>
		<td width="50%"><input type="text" name="name" value="<%= name %>"></td>
	
	</tr>
	<tr>
		<td width="50%">���t�^</td>
		<td width="50%">
			<input type="radio" name="bloodType" value="A" <%= bloodType.equals("A") ? "checked" : "" %>> A
			<input type="radio" name="bloodType" value="B" <%= bloodType.equals("B") ? "checked" : "" %>> B
			<input type="radio" name="bloodType" value="O" <%= bloodType.equals("O") ? "checked" : "" %>> O
		</td>
	</tr>

	<tr>
		<td width="50%">�g��</td>
		<td width="50%"><input type="text" name="height" value="<%= height %>" size="4"> cm</td>

	</tr>
</table>
<br />
<input type="submit" name="submit" value="�ǉ��m�F">
</form>
<br /><br />

<a href = "displayPatientList">���҈ꗗ�ɖ߂�</a>
</body>
</html>	