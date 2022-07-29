<%@page import="java.sql.PreparedStatement"%>
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
	<%
		// 예전 방식으로 잘 사용하지 않지만 알아두어야 한다.
		// 오라클에 접근하기 위한 기본 설정, 정보 접속을 원하는 오라클계정정보의 아이디와 패스워드
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "wjsp";
		String password = "wjsp";
	
		Class.forName(driver);
		System.out.println("jdbc driver 로딩 성공!");
		
		// DriverManager 연결정보로 직접적인 커넥션
		conn = DriverManager.getConnection(url, user, password);
		System.out.println("오라클 연결 성공!");
		
		// insert, delete, update
		// create, drop
		String sql = "INSERT INTO car(carnum, BRAND, COLOR, PRICE) values('3', 'Benz', 'White', 100000000)";
// 		String sql = "update car set brand = 'k7' where brand = 'Benz' ";
// 		String sql = "delete car where carnum = 3";
// 		String sql = "create table people( peoplenum varchar2(20), name varchar2(20), age number(10), CONSTRAINT people_pk PRIMARY KEY (peoplenum) )";
// 		String sql = "drop table people";		

		int check = 0;
		PreparedStatement pstm = conn.prepareStatement(sql);
		check = pstm.executeUpdate();
		
		System.out.println("check : " + check);
		
	%>
</body>
</html>