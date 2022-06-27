<%@page import="studentmanagementsyatem.dao.StudentDao"%>
<%@page import="studentmanagementsyatem.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>
<% 
	StudentDao sd= new StudentDao();
	int id=Integer.parseInt(request.getParameter("id"));
	Student s = sd.getStudent(id);
%>

	<center>
		<h1><a href="viewstudent.jsp">View All Records</a><br/>  </h1>

		<h2>Edit Student

			<form action="EditServlet" method="post">
			<table>
			<tr><td	>RollNo:</td><td><input type="number" name="id" value="<%=s.getId() %>"/></td></tr>
			<tr><td>Name:</td><td><input type="text" name="name" value="<%=s.getStud_name()%>"/></td></tr>

			<tr><td>English:</td><td>
			<input type="number" name="english_marks" value="<%=s.getEnglish_marks() %>"  /></td></tr>

			<tr><td>Hindi:</td><td><input type="number" name="hindi_marks" value="<%=s.getHindi_marks() %>" /></td></tr>
			<tr><td>Maths:</td><td><input type="number" name="maths_marks" value="<%=s.getMaths_marks()%>"/></td></tr>
			<tr><td>Science:</td><td><input type="number" name="science_marks" value="<%=s.getScience_marks() %>"  /></td></tr>
			<tr><td>Social Science:</td><td><input type="number" name="socialscience_marks" value="<%=s.getSocialscience_marks()%>"/></td></tr>


			<tr><td colspan="2"><input type="submit" value="Edit Student"/></td></tr>
			</table>
			</form>
			</h2>
	</center>
	

</body>
</html>