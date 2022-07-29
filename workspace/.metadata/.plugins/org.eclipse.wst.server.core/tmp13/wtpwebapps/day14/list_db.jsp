<%@page import="com.koreait.beans.MemberBean"%>
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
		MemberDAO mdao = new MemberDAO();
		// 한꺼번에 받아오기
		request.setAttribute("list", mdao.getList());
		pageContext.forward("searchview.jsp");
	%>
</body>
</html>