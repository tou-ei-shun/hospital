<%@ page language="java" contentType ="text/html; charset = Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ page import="java.util.*,jp.co.mtrx.hms.service.*, jp.co.mtrx.hms.model.*" %> 
	
<!DOCTYPE html>
<html>
<head>
<title>患者一覧</title>
</head>
<body>
<h1>患者一覧</h1>
<br />

<%
	Service service = (Service)application.getAttribute("service");
	List<Patient> patients = service.getPatients();
%>
<table border="1" width="400">
<tr>
	<th width="20%">ID</th>
	<th width="20%">名前</th>
	<th width="20%">血液型</th>
	<th width="20%">身長</th>
	<th width="20%"></th>
</tr>
<%
	for(Patient patient : patients){
		if(patient == null)
		continue;//リストの実装は配列なのでnullがありえる
%>
	<tr>
		<td><a href="displayPatientUpdate?id=<%= patient.getId() %>"><%= patient.getId() %></a></td>
		<td><%= patient.getName() %></td>
		<td><%= patient.getBloodType() %></td>
		<td><%= patient.getHeight() %></td>
		<td><a href="displayPatientDeleteConfirm?id=<%= patient.getId() %>">削除</a></td>
	</tr>
<%
	}
%>
</table>
<br />
<a href ="displayPatientCreate">患者を追加する</a>
<br /><br />
<a href ="index.jsp">メインメニューに戻る</a>
</body>
</html>	