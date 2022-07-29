<%@page import="com.koreait.dao.MemberDAO"%>
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
		
		
// 		Connection conn = DBConnection.getConnection();
// 		String sql = "SELECT age FROM MEMBER WHERE name = ?";
// 		PreparedStatement pstm = conn.prepareStatement(sql);
		
// 		pstm.setString(1, name);
// 		ResultSet rs = pstm.executeQuery();
		
		String name = request.getParameter("name");
		MemberDAO mda = new MemberDAO();
		int age = mda.getAge(name);
	%>
	
	<%
		if(age != 0 ){
			
	%>
		이름: <%=name %><br>
		나이: <%=age %><br>
	<%
		}else{
	%>
		찾는이름이 없습니다.
	<%
		} 
	%>
	<input type="button" value="다시 검색하기" onclick="location.href='age_search.jsp'">
</body>
</html>