<%@page import="java.sql.ResultSet"%>
<%@page import="studentmanagementsyatem.dbconn.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	
		Connection conn = DbConnection.getConnection();
		
		String sq1="select name , english from student ";
		String sq2="select name , hindi from student";
		String sq3="select name , maths from student";
		String sq4="select name , science from student";
		String sq5="select name, social_science from student";
		
		java.sql.PreparedStatement ps1 = conn.prepareStatement(sq1);
		java.sql.PreparedStatement ps2 = conn.prepareStatement(sq2);
		java.sql.PreparedStatement ps3 = conn.prepareStatement(sq3);
		java.sql.PreparedStatement ps4 = conn.prepareStatement(sq4);
		java.sql.PreparedStatement ps5 = conn.prepareStatement(sq5);
		
		
		ResultSet rs1 = ps1.executeQuery();
		ResultSet rs2 = ps2.executeQuery();
		ResultSet rs3 = ps3.executeQuery();
		ResultSet rs4 = ps4.executeQuery();
		ResultSet rs5 = ps5.executeQuery();
	%>
	<h1>Academics Details</h1>
	
	<table border="1" width="50%" >
	 
 	<caption>English</caption>

	<% while(rs1.next()){ %>
 	<tr>
    <th><%=rs1.getString(1)%></th>
    <td><%=rs1.getInt(2)%></td>
 	</tr>
	<%} %>
	</table>
	
	<!-- Hindi -->
	<table border="1" width="50%" >
	 
 	<caption>Hindi</caption>

	<% while(rs2.next()){ %>
 	<tr>
    <th><%=rs2.getString(1)%></th>
    <td><%=rs2.getInt(2)%></td>
 	</tr>
	<%} %>
	</table>
	
	<!-- Maths -->
	<table border="1" width="50%" >
	 
 	<caption>Maths</caption>

	<% while(rs3.next()){ %>
 	<tr>
    <th><%=rs3.getString(1)%></th>
    <td><%=rs3.getInt(2)%></td>
 	</tr>
	<%} %>
	</table>
	
	<!-- Science -->
	<table border="1" width="50%" >
	 
 	<caption>Science</caption>

	<% while(rs4.next()){ %>
 	<tr>
    <th><%=rs4.getString(1)%></th>
    <td><%=rs4.getInt(2)%></td>
 	</tr>
	<%} %>
	</table>
	
	<!-- Social Science -->
	<table border="1" width="50%" >
	 
 	<caption>Social_Science</caption>

	<% while(rs5.next()){ %>
 	<tr>
    <th><%=rs5.getString(1)%></th>
    <td><%=rs5.getInt(2)%></td>
 	</tr>
	<%} %>
	</table>
	<br/><a href="index.jsp">Home</a>
</body>
</html>