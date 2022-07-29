<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getParameter("username") %>님 어서오세요<br>
	<%=request.getParameter("userbirth") %>
	<!-- 	redirect 방식을 쓰면 값이 날아가서(손실됌) null값이 출력됌  -->
</body>
</html>