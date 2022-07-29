<%@page import="com.koreait.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- 이 페이지에서 JSTL을 사용하겠다는 태그라이브러리 선언문 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 전체회원보기 버튼 눌렀을때  -->
	<%
		MemberDAO mdao = new MemberDAO();
		request.setAttribute("list", mdao.userAll());
		pageContext.forward("searchview.jsp");
	%>
	
</body>
</html>