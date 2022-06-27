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
		<h1><a href="viewstudent.jsp">View All Records</a><br/>  </h1>

		<h2>Add New Student

			<form action="AddStudentServlet" method="post">
			<table>
			<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>

			<tr><td>English:</td><td>
			<input type="number" name="english_marks"/></td></tr>

			<tr><td>Hindi:</td><td><input type="number" name="hindi_marks"/></td></tr>
			<tr><td>Maths:</td><td><input type="number" name="maths_marks"/></td></tr>
			<tr><td>Science:</td><td><input type="number" name="science_marks"/></td></tr>
			<tr><td>Social Science:</td><td><input type="number" name="socialscience_marks"/></td></tr>


			<tr><td colspan="2"><input type="submit" value="Add Student"/></td></tr>
			</table>
			</form>
			</h2>
	</center>
	<br/><a href="index.jsp">Home</a>
</body>
</html>