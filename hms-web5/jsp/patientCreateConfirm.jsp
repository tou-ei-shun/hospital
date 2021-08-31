<%@ page language="java" contentType ="text/html; charset = Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ page import="java.util.*,jp.co.mtrx.hms.service.*, jp.co.mtrx.hms.model.*" %> 
	
<!DOCTYPE html>
<html>
<head>
<title>Š³ŽÒ’Ç‰Á</title>
</head>
<body>
<h1>Š³ŽÒ’Ç‰Á</h1>
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
		<td width="50%">–¼‘O</td>
		<td width="50%"><%= name %></td>
	
	</tr>
	<tr>
		<td width="50%">ŒŒ‰tŒ^</td>
		<td width="50%"><%= bloodType %></td>
		</td>
	</tr>

	<tr>
		<td width="50%">g’·</td>
		<td width="50%"><%= height %></td>

	</tr>
</table>
		
<br/>
<form name="patientCreateForml" method="POST" action="submitPatientCreate">
	<input type="hidden" name="name" value="<%= name %>">
	<input type="hidden" name="bloodType" value="<%= bloodType %>">
	<input type="hidden" name="height" value="<%= height %>">
	<input type="submit" name="submit" value=" ’Ç‰ÁŽÀs">
</form>
<br />

<br/>
<form name="patientCreateForm2" method="POST" action="submitPatientCreate">
	<input type="hidden" name="name" value="<%= name %>">
	<input type="hidden" name="bloodType" value="<%= bloodType %>">
	<input type="hidden" name="height" value="<%= height %>">
	<input type="submit" name="submit" value="“ü—Í‚µ‚È‚¨‚·">
</form>
<br /><br />




<a href = "displaypatientList">Š³ŽÒˆê——‚É–ß‚é</a>
</body>
</html>	