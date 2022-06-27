<%@page import="java.sql.ResultSet"%>
<%@page import="studentmanagementsyatem.dbconn.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top Scorer</title>
</head>
<body>
	<%
		Connection conn = DbConnection.getConnection();
		
		String sql1="select tbl.name, tbl.english from student tbl join ( select max(english) as MaxMarks from student) tbl1 on tbl1.MaxMarks=tbl.english";
		String sql2=" select tbl.name, tbl.hindi from student tbl join ( select max(hindi) as MaxMarks from student) tbl1 on tbl1.MaxMarks=tbl.hindi";
		String sql3=" select tbl.name, tbl.maths from student tbl join ( select max(maths) as MaxMarks from student) tbl1 on tbl1.MaxMarks=tbl.maths";
		String sql4=" select tbl.name, tbl.science from student tbl join ( select max(science) as MaxMarks from student) tbl1 on tbl1.MaxMarks=tbl.science";
		String sql5=" select tbl.name, tbl.social_science from student tbl join ( select max(social_science) as MaxMarks from student) tbl1 on tbl1.MaxMarks=tbl.social_science";
		
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
	<h1>Top Scorer</h1>
	
	<table border="1" width="20%" >
	  <tr>
    <th>English:</th>
 	 </tr>
	<%
		while(rs1.next()){
	%>
 	<tr>
    <th><%=rs1.getString(1)%></th>
 	</tr>
	 <%} %>
	</table>
	
	<table border="1" width="20%" >
	  <tr>
    <th>Hindi:</th>
 	 </tr>
	<%
		while(rs2.next()){
	%>
 	<tr>
    <th><%=rs2.getString(1)%></th>
 	</tr>
	 <%} %>
	 </table>
	 
	 <table border="1" width="20%" >
	  <tr>
    <th>Maths:</th>
 	 </tr>
	<%
		while(rs3.next()){
	%>
 	<tr>
    <th><%=rs3.getString(1)%></th>
 	</tr>
	 <%} %>
	 </table>
	 
	 <table border="1" width="20%" >
	  <tr>
    <th>Science:</th>
 	 </tr>
	<%
		while(rs4.next()){
	%>
 	<tr>
    <th><%=rs4.getString(1)%></th>
 	</tr>
	 <%} %>
	</table>
	
	<table border="1" width="20%" >
	  <tr>
    <th>Social Science:</th>
 	 </tr>
	<%
		while(rs5.next()){
	%>
 	<tr>
    <th><%=rs5.getString(1)%></th>
 	</tr>
	 <%} %>
	</table>
	
	<br/><a href="index.jsp">Home</a>
</body>
</html>