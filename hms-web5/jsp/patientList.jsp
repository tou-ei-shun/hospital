<%@ page language="java" contentType ="text/html; charset = Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ page import="java.util.*,jp.co.mtrx.hms.service.*, jp.co.mtrx.hms.model.*" %> 
	
<!DOCTYPE html>
<html>
<head>
<title>���҈ꗗ</title>
</head>
<body>
<h1>���҈ꗗ</h1>
<br />

<%
	Service service = (Service)application.getAttribute("service");
	List<Patient> patients = service.getPatients();
%>
<table border="1" width="400">
<tr>
	<th width="20%">ID</th>
	<th width="20%">���O</th>
	<th width="20%">���t�^</th>
	<th width="20%">�g��</th>
	<th width="20%"></th>
</tr>
<%
	for(Patient patient : patients){
		if(patient == null)
		continue;//���X�g�̎����͔z��Ȃ̂�null�����肦��
%>
	<tr>
		<td><a href="displayPatientUpdate?id=<%= patient.getId() %>"><%= patient.getId() %></a></td>
		<td><%= patient.getName() %></td>
		<td><%= patient.getBloodType() %></td>
		<td><%= patient.getHeight() %></td>
		<td><a href="displayPatientDeleteConfirm?id=<%= patient.getId() %>">�폜</a></td>
	</tr>
<%
	}
%>
</table>
<br />
<a href ="displayPatientCreate">���҂�ǉ�����</a>
<br /><br />
<a href ="index.jsp">���C�����j���[�ɖ߂�</a>
</body>
</html>	