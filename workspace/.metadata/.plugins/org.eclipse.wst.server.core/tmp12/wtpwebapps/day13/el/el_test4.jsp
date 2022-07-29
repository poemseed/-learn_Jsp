<%@page import="java.util.ArrayList"%>
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
	<%
		ArrayList<String> arList = new ArrayList<>();
		arList.add("Hello");
		arList.add("JSP");
		arList.add("EL");
		arList.add("JSTL");
		pageContext.setAttribute("list", arList);
	%>
	
	${list }
	<!-- ArrayList안에 요소들을 하나씩 꺼내기 -->
	
	
	
</body>
</html>