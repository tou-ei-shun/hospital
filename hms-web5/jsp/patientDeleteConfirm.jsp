<%@ page language="java" contentType ="text/html; charset = Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ page import="java.util.*,jp.co.mtrx.hms.service.*, jp.co.mtrx.hms.model.*" %> 
	
<!DOCTYPE html>
<html>
<head>
<title>���ҍ폜</title>
</head>
<body>
<h1>���ҍ폜</h1>
<br />

<%
	String id = request.getParameter("id");
	
	Service service = (Service)application.getAttribute("service");
	
	Patient patient = service.getPatient(Integer.parseInt(id));
%>

<table border="1" width="400">
<tr>
		<td width="50%">ID</td>
		<td width="50%"><%= patient.getId() %></td>
	
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

<form name="patientDeleteForm" method="POST" action="submitPatientDelete">
<input type="hidden" name ="id" value="<%= id %>">
<input type="submit" name="submit" value="�폜���s">
</form>
<br /><br />

<a href = "displayPatientList">���҈ꗗ�ɖ߂�</a>
</body>
</html>	