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
	<h1>
		Subject Count of Higher Marks
	</h1>
	<%
		Connection conn = DbConnection.getConnection();
		
			String sql="select count(name) as English from student where english >= (select avg(english) from student) union all"
			+ " select count(name) as Hindi from student where hindi >= (select avg(hindi) from student) union all"
			+ " select count(name) as Maths from student where maths >= (select avg(maths) from student) union all"
			+ " select count(name) as Science from student where science >= (select avg(science) from student) union all"
			+ " select count(name) as SocialScience from student where social_science >= (select avg(social_science) from student)";
	
			String sql1="select english, hindi, maths, science, social_science from student";
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			java.sql.PreparedStatement pss = conn.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			ResultSet rs1 = pss.executeQuery();
			
			java.sql.ResultSetMetaData rsmd = rs1.getMetaData();
			int r=rsmd.getColumnCount();
	%>
	
	
	<table border="1" width="20%" >
	<%
	int i=1;
	while(rs.next()) {
	%>
	  <tr>
    	<th><%=rsmd.getColumnName(i)%></th>
 	 </tr>
 	 <tr>
    <th><%=rs.getString(1)%></th>
 	</tr>
 	 <%
 	 i++;
 	 }%>
	</table>	
	
	<br/><a href="index.jsp">Home</a>
	
</body>
</html>