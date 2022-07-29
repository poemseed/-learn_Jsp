<%@page import="com.koreait.beans.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.koreait.dao.MemberDAO"%>
<%@page import="java.sql.DriverManager"%>
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
	<jsp:useBean id="mdao" class="com.koreait.dao.MemberDAO" />
	<%
		// DB Connection
		// ...
		// ...
// 		Connection conn = null;
//     	String driver = "oracle.jdbc.driver.OracleDriver";
//     	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//     	String user = "wjsp";
//     	String password = "wjsp";
    
//     	Class.forName(driver);
//      	conn = DriverManager.getConnection(url, user, password);
     	
		ArrayList<MemberBean> result = mdao.selectAll();
     	
	%>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
	
	<%
		for(MemberBean member : result){
	%>
		<tr>
			<td><%=member.getName() %></td>
			<td><%=member.getAge() %></td>
		</tr>
	<% } %>
	</table>
	<input type="button" value="다시 검색하기" onclick="location.href='age_search.jsp'">
</body>
</html>