<%@ page language="java" contentType ="text/html; charset = Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ page import="java.util.*,jp.co.mtrx.hms.service.*, jp.co.mtrx.hms.model.*" %> 
	
<!DOCTYPE html>
<html>
<head>
<title>Š³ŽÒíœ</title>
</head>
<body>
<h1>Š³ŽÒíœ</h1>
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
		<td width="50%">–¼‘O</td>
		<td width="50%"><%= patient.getName() %></td>
	
	</tr>
	<tr>
		<td width="50%">ŒŒ‰tŒ^</td>
		<td width="50%"><%= patient.getBloodType() %></td>
		</td>
	</tr>

	<tr>
		<td width="50%">g’·</td>
		<td width="50%"><%= patient.getHeight() %> cm</td>

	</tr>
</table>
<br />

<form name="patientDeleteForm" method="POST" action="submitPatientDelete">
<input type="hidden" name ="id" value="<%= id %>">
<input type="submit" name="submit" value="íœŽÀs">
</form>
<br /><br />

<a href = "displayPatientList">Š³ŽÒˆê——‚É–ß‚é</a>
</body>
</html>	