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
		String data = "Hello";
		
		// pageContext	: 현재 페이지
		pageContext.setAttribute("data", data);
	%>
		<!-- \ : 문자열 그대로 출력  -->
					<!-- data는 키값의미 -->
		\${data } : ${data }<br>
<%-- 		${10+20 }<br> --%>
<%-- 		${10>3 }<br> --%>
</body>
</html>