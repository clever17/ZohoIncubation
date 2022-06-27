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
	%>

	

	<h1>
		Average Marks
	</h1>

	<table border="1" width="90%">
	  <tr>
    <th>Subjects:</th>
    <td>Average Marks</td>
 	 </tr>
 	 <tr>
    <th>English:</th>
    <td><%=list.get(0)%></td>
 	 </tr>
  	<tr>
    <th>Hindi:</th>
    <td><%=list.get(1)%></td>
 	 </tr>
 	 <tr>
    <th>Maths:</th>
    <td><%=list.get(2)%></td>
 	 </tr>
 	 <tr>
    <th>Science:</th>
    <td><%=list.get(3)%></td>
 	 </tr>
 	 <tr>
    <th>Social_Science:</th>
    <td><%=list.get(4)%></td>
 	 </tr>
	</table>
	<br/><a href="index.jsp">Home</a>
	
</body>
</html>