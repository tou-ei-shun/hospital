<%@ page language="java" contentType ="text/html; charset = Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ page import="java.util.*,jp.co.mtrx.hms.service.*, jp.co.mtrx.hms.model.*" %> 
	
<!DOCTYPE html>
<html>
<head>
<title>患者追加</title>
</head>
<body>
<h1>患者追加</h1>
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
		<td width="50%">名前</td>
		<td width="50%"><%= patient.getName() %></td>
	
	</tr>
	<tr>
		<td width="50%">血液型</td>
		<td width="50%"><%= patient.getBloodType() %></td>
		</td>
	</tr>

	<tr>
		<td width="50%">身長</td>
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
		<td width="50%">名前</td>
		<td width="50%"><%= name %></td>
	
	</tr>
	<tr>
		<td width="50%">血液型</td>
		<td width="50%"><%= bloodType %></td>
		</td>
	</tr>

	<tr>
		<td width="50%">身長</td>
		<td width="50%"><%= height %> cm</td>

	</tr>
</table>
<br/>
<form name="patientUpdateForm1" method="POST" action="submitPatientUpdate">
	<input type="hidden" name="id" value="<%= id %>">
	<input type="hidden" name="name" value="<%= name %>">
	<input type="hidden" name="bloodType" value="<%= bloodType %>">
	<input type="hidden" name="height" value="<%= height %>">
	<input type="submit" name="submit" value="更新実行">
</form>
<br />

<br/>
<form name="patientCreateForm2" method="POST" action="displayPatientUpdate">
	<input type="hidden" name="id" value="<%= id %>">
	<input type="hidden" name="name" value="<%= name %>">
	<input type="hidden" name="bloodType" value="<%= bloodType %>">
	<input type="hidden" name="height" value="<%= height %>">
	<input type="submit" name="submit" value="入力しなおす">
</form>
<br /><br />
<a href="displayPatientList">患者一覧に戻る</a>

</body>
</html>	