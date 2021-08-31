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
		<td width="50%">名前</td>
		<td width="50%"><input type="text" name="name" value="<%= name %>"></td>
	
	</tr>
	<tr>
		<td width="50%">血液型</td>
		<td width="50%">
			<input type="radio" name="bloodType" value="A" <%= bloodType.equals("A") ? "checked" : "" %>> A
			<input type="radio" name="bloodType" value="B" <%= bloodType.equals("B") ? "checked" : "" %>> B
			<input type="radio" name="bloodType" value="O" <%= bloodType.equals("O") ? "checked" : "" %>> O
		</td>
	</tr>

	<tr>
		<td width="50%">身長</td>
		<td width="50%"><input type="text" name="height" value="<%= height %>" size="4"> cm</td>

	</tr>
</table>
<br />
<input type="submit" name="submit" value="追加確認">
</form>
<br /><br />

<a href = "displayPatientList">患者一覧に戻る</a>
</body>
</html>	