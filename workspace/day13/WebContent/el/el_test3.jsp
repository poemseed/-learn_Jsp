<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("result") %><br>
	${result }<br>
	<!-- 배열을 el로 가져오기 -->
	${names[0] }<br>
	${names[1] }<br>
	<!-- Map을 el로 가져오기 -->
	${notice.id }<br>
	${notice.title }<br>
	<hr>
	<!-- 파라미터값 el에서 바로 받아오기 -->
	${param.num }
	<hr>
	${param.num >= 3}<br>
	${param.num ge 3}<br>
	<hr>
	${empty param.num }<br>		<!-- 파라미터값이 비어있니 -->
	${not empty param.num }<br>	<!-- 파라미터값이 안 비어있니  -->
	<hr>
	${empty param.num ? '값이 비어있습니다.':param.num }<br>	<!-- 조건연산자 - 파라미터값이 비어있니 ? 파라미터값이 있을때 없을때 -->
	
	
</body>
</html>