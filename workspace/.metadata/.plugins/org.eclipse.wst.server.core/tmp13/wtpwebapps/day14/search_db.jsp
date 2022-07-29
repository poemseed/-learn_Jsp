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
		String userid = request.getParameter("userid");
		// sql문으로 db에서 받아온 정보를 MemberBean에 담아줌
		MemberBean user = mdao.searchById(userid);
		request.setAttribute("user", user);
		// searchview로 정보 보내줌
		pageContext.forward("searchview.jsp");
	%>
</body>
</html>