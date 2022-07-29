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
		// 로그아웃하면 세션정보를 삭제해줘야 사용자의 정보를 보호할수있음
		session.removeAttribute("session_id");
		// 페이지 이동시키기
		response.sendRedirect("login_view.jsp");
	%>
</body>
</html>