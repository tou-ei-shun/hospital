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
		//String id =(String)request.getAttribute("id");
		//String name = (String)request.getAttribute("name");
		//String bloodType = (String)request.getAttribute("bloodType");
		//String height = (String)request.getAttribute("height");
		
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
		String bloodType = (String)session.getAttribute("bloodType");
		String height = (String)session.getAttribute("height");
		System.out.println("JSP :" + getClass().getName());
		
		
		
		
		
		
		
		Service service = (Service)application.getAttribute("service");
		Patient patient = service.getPatient(Integer.parseInt(id));
 %>	
Before :<br />
<table border="1" width="400">
	<tr>
		<td width="50%">ID</td>
		<td width="50%"><%= id %></td>
	
	</tr>
	<tr>
		<td width="50%">���O</td>
		<td width="50%"><%= patient.getName() %></td>
	
	</tr>
	<tr>
		<td width="50%">���t�^</td>
		<td width="50%"><%= patient.getBloodType() %></td>
		</td>
	</tr>

	<tr>
		<td width="50%">�g��</td>
		<td width="50%"><%= patient.getHeight() %> cm</td>

	</tr>
</table>
<br />

After :<br />

<table border="1" width="400">
	<tr>
		<td width="50%">ID</td>
		<td width="50%"><%= id %></td>
	
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
		<td width="50%"><%= height %> cm</td>

	</tr>
</table>
<br/>
<form name="patientUpdateForm1" method="POST" action="submitPatientUpdate">
	<input type="hidden" name="id" value="<%= id %>">
	<input type="hidden" name="name" value="<%= name %>">
	<input type="hidden" name="bloodType" value="<%= bloodType %>">
	<input type="hidden" name="height" value="<%= height %>">
	<input type="submit" name="submit" value="�X�V���s">
</form>
<br />

<br/>
<form name="patientCreateForm2" method="POST" action="displayPatientUpdate">
	<input type="hidden" name="id" value="<%= id %>">
	<input type="hidden" name="name" value="<%= name %>">
	<input type="hidden" name="bloodType" value="<%= bloodType %>">
	<input type="hidden" name="height" value="<%= height %>">
	<input type="submit" name="submit" value="���͂��Ȃ���">
</form>
<br /><br />
<a href="displayPatientList">���҈ꗗ�ɖ߂�</a>

</body>
</html>	