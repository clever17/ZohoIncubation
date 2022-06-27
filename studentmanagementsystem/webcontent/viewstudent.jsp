<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
</head>
<body>
	
	<%@page import="studentmanagementsyatem.dao.*" %>
	<%@page import="studentmanagementsyatem.bean.*" %>
	<%@page import="java.util.*" %>
	
	<h1>
		Student List
	</h1>
	
	<%
		StudentDao student = new StudentDao();
		List<Student> list = student.getStudents();
		request.setAttribute("list", list);
	%>
	
	<table border="1" width="90%">
	<tr>
	<th>RollNo</th>
	<th>Name</th>
	<th>English</th>
	<th>Hindi</th>
	<th>Maths</th>
	<th>Science</th>
	<th>Social_Science</th>
	<th>Total_marks</th>
	<th>Edit</th>
	<th>Delete</th>
	</tr>
	<%
		for(Student s: list)
		{
	%>	
	<tr>
		<td><%=s.getId()%></td>
		<td><%=s.getStud_name()%></td>
		<td><%=s.getEnglish_marks()%></td>
		<td><%=s.getHindi_marks()%></td>
		<td><%=s.getMaths_marks()%></td>
		<td><%=s.getScience_marks()%></td>
		<td><%=s.getSocialscience_marks()%></td>
		<td><%=s.getTotal_marks()%></td>
		<td><a href="editform.jsp?id=<%=s.getId()%>">Edit</a></td>  
		<td><a href="DeleteServlet?id=<%=s.getId()%>">Delete</a></td>
	</tr>
	<%
	}
	%>	
	</table>
	<br/><a href="addstudent.jsp">Add New Student</a>  
	
	<br/><a href="index.jsp">Home</a>
</body>
</html>