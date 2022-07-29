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
	<!-- 변수선언, scope: 어느 범위까지 사용하는지, page: pageContext 영역 -->
	<!-- jstl로 만들어진 값은 setAttribute로 값을 넣기 때문에 el로 값을 가지고 올 수 있다. -->
	<c:set var="userid" value="apple" scope="page"/>
	회원아이디 : <c:out value="${userid }" /><br>
	회원아이디 : ${userid }
	<hr>
	<%-- <c:set>이 사이에 들어가는 값이 value</c:set> --%>
	<c:set var="userid" scope="session">java01</c:set> 
	<c:set var="username" scope="session">김자바</c:set>
	회원아이디 : ${userid }<br>					<!-- page가 session보다 더 범위가 작아서  page의 value인 apple이 나온다  -->
	회원이름 : ${username }<br>
	회원아이디 : ${sessionScope.userid }<br>		<!-- session에 있는 value값을 가져오기 위해서는 sessionScope사용 -->
	회원이름 : ${sessionScope.username }<br>
</body>
</html>