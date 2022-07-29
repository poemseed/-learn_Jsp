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
	<c:forEach var="i" begin="1" end="9" step="1">
		5 X ${i } = ${5*i }<br>
	</c:forEach>

</body>
</html>