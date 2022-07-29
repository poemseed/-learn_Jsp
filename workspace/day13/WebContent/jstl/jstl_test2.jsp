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
	<!-- 제어 조건문 -->
	<c:set var="num" value="100"/>
	<c:if test="${num gt 50 }">
		<script type="text/javascript">
			alert("이 수는 50보다 큽니다.")
		</script>
	</c:if>
	
	<c:if test="${num gt 30 }">
		<script type="text/javascript">
			alert("이 수는 30보다 큽니다.")
		</script>
	</c:if>
	
	
	
</body>
</html>