<%@page import="java.sql.ResultSet"%>
<%@page import="studentmanagementsyatem.dbconn.DbConnection"%>
<%@page import="java.sql.Connection"%>
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

	<%
			OperationDao od = new OperationDao();
			List<Float> list = od.average_Mark();
			Connection conn = DbConnection.getConnection();
			
			
			String sql1="select name, english as 'English' from student where english >= (select avg(english) from student)";
			String sql2="select name, hindi as Hindi from student where hindi >= (select avg(hindi) from student)";
			String sql3="select name, maths as Maths from student where maths >= (select avg(maths) from student)";
			String sql4="select name, science as Science from student where science >= (select avg(science) from student)";
			String sql5="select name, social_science as SocialScience from student where social_science >= (select avg(social_science) from student)";
	
			java.sql.PreparedStatement ps1 = conn.prepareStatement(sql1);
			java.sql.PreparedStatement ps2 = conn.prepareStatement(sql2);
			java.sql.PreparedStatement ps3 = conn.prepareStatement(sql3);
			java.sql.PreparedStatement ps4 = conn.prepareStatement(sql4);
			java.sql.PreparedStatement ps5 = conn.prepareStatement(sql5);
			
			
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			ResultSet rs3 = ps3.executeQuery();
			ResultSet rs4 = ps4.executeQuery();
			ResultSet rs5 = ps5.executeQuery();
			
	%>
	
	
	<h1 style="text-align: center">
		Students who have higher marks than Average
	</h1>
	
	<table border="1" width="50%" >
	  <tr>
    <th>English:</th>
    <td><%=list.get(0)%></td>
 	 </tr>
 	
 	<%
 		while(rs1.next()){
 		
 	%>
 	<tr>
    <th><%=rs1.getString(1) %></th>
    <td><%=rs1.getInt(2)%></td>
 	</tr>
	<%} 
	%>
	</table>
	<!-- Hindi -->
	<table border="1" width="50%" >
	  <tr>
    <th>Hindi:</th>
    <td><%=list.get(1)%></td>
 	 </tr>
 	
 	<%
 		while(rs2.next()){
 		
 	%>
 	<tr>
    <th><%=rs2.getString(1) %></th>
    <td><%=rs2.getInt(2)%></td>
 	</tr>
	<%} 
	%>
	</table>
	
	<!-- Maths -->
	
	
	<table border="1" width="50%" >
	  <tr>
    <th>Maths:</th>
    <td><%=list.get(2)%></td>
 	 </tr>
 	
 	<%
 		while(rs3.next()){
 		
 	%>
 	<tr>
    <th><%=rs3.getString(1) %></th>
    <td><%=rs3.getInt(2)%></td>
 	</tr>
	<%} 
	%>
	</table>
	
	<!-- Science -->
	
	<table border="1" width="50%" >
	  <tr>
    <th>Science:</th>
    <td><%=list.get(3)%></td>
 	 </tr>
 	
 	<%
 		while(rs4.next()){
 		
 	%>
 	<tr>
    <th><%=rs4.getString(1) %></th>
    <td><%=rs4.getInt(2)%></td>
 	</tr>
	<%} 
	%>
	</table>
	
	<!-- Social Science -->
	
	<table border="1" width="50%" >
	  <tr>
    <th>Social Science:</th>
    <td><%=list.get(4)%></td>
 	 </tr>
 	
 	<%
 		while(rs5.next()){
 		
 	%>
 	<tr>
    <th><%=rs5.getString(1) %></th>
    <td><%=rs5.getInt(2)%></td>
 	</tr>
	<%} 
	%>
	</table>
	
	<br/><a href="index.jsp">Home</a>
</body>
</html>