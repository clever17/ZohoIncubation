<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Student Management System</title>  
</head>  
<body> 

	<%
		if(session!=null)
		{
			String email =(String) session.getAttribute("email");
		}
		else
		{
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
	%>


	<center> 
	<h1>Student Management</h1>  
		<h2>
		<a href="addstudent.jsp">Add Student</a>
		&nbsp;&nbsp;&nbsp;
		<a href="viewstudent.jsp">View Students</a>
		&nbsp;&nbsp;&nbsp;
		<a href="LogoutServlet">Logout</a>
    	</h2>
    	<h2>
    		Operation:
    		&nbsp;&nbsp;&nbsp;
    	</h2>
		<h3>
		<a href="report.jsp">Rank Based Report</a>
		&nbsp;&nbsp;&nbsp;
		<a href="averagemarks.jsp">Average Marks</a>
		&nbsp;&nbsp;&nbsp;
		<a href="marks_higher.jsp">Student having marks > average</a>
		&nbsp;&nbsp;&nbsp;
		<a href="academic_details.jsp">Top Scorer</a>
		&nbsp;&nbsp;&nbsp;
		<a href="academic_details.jsp">Academic Details</a>
		&nbsp;&nbsp;&nbsp;
		<a href="subject_count.jsp">Subject count of Higher marks</a>
		</h3>
		
  </center>
</body>  
</html>  
