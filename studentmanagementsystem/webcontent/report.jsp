<%@page import="studentmanagementsyatem.bean.Student"%>
<%@page import="java.util.List"%>
<%@page import="studentmanagementsyatem.dao.OperationDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h1>
		Rank Based Report
	</h1>
	<%
		OperationDao od = new OperationDao();
		List<Student> list = od.display_Rankbased();
	%>

	<table border="1" width="90%">
	<tr>
	<th>Rank</th>
	<th>RollNo</th>
	<th>Name</th>
	<th>English</th>
	<th>Hindi</th>
	<th>Maths</th>
	<th>Science</th>
	<th>Social_Science</th>
	<th>Total_marks</th>
	</tr>
	
		<%
		for(Student s: list)
		{
	%>	
	<tr>
		<td><%=s.getRank()%></td>
		<td><%=s.getId()%></td>
		<td><%=s.getStud_name()%></td>
		<td><%=s.getEnglish_marks()%></td>
		<td><%=s.getHindi_marks()%></td>
		<td><%=s.getMaths_marks()%></td>
		<td><%=s.getScience_marks()%></td>
		<td><%=s.getSocialscience_marks()%></td>
		<td><%=s.getTotal_marks()%></td>
		  
		
	</tr>
	<%
	}
	%>	
	</table>
	<br/><a href="index.jsp">Home</a>
	</center>
</body>
</html>