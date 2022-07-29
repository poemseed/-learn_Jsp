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
	<!-- http://localhost:9090/jstl/jstl_test4.jsp?userid=test&userpw=12341234 -->
	<!-- 
		userid = admin -> 관리자, userid = apple -> 김사과, 그 외 비회원, 
		userid가 empty 빈값이면  form태그 다시  보여줄 것 
	-->
	
	<c:choose>
		<%--  param.userid가 empty일때  --%>
		<c:when test="${empty param.userid }">
			<form> <!-- action을 기입하지 않으면   submit하면 나자신의 페이지를 다시 요청함  -->
				아이디 <input type="text" name="userid"><br>
				비밀번호 <input type="password" name="userpw"><br>
				<input type="submit">
			</form>
		</c:when>
		<%-- param.userid가 empty가 아닌 경우 --%>
		<c:otherwise>
			<c:set var="userid" value="${param.userid }"/>
			<c:set var="userpw" value="${param.userpw }"/>
			<!-- 관리자, 김사과, 비회원 -->
			<c:choose>
				<c:when test="${userid == 'admin' }">관리자</c:when>
				<c:when test="${userid == 'apple' }">김사과</c:when>
				<c:otherwise>비회원</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
</body>
</html>