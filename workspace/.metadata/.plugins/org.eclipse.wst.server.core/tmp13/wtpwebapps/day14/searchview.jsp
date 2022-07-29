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
	<form action="search_db.jsp">
		검색하실 회원의 ID <input type="text" name="userid">
		<input type="button" value="전체회원보기" onclick="location.href='list_db.jsp'">
		<input type="submit">
	</form>
	<hr>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>성별</th>
			<th>전화번호</th>
		</tr>
		<c:choose>	<%-- 아이디별 회원정보조회 --%>
			<c:when test="${!empty requestScope.user }">
				<c:set var="user" value="${requestScope.user }"/>
					<tr>
						<td>${user.userid }</td>
						<td>${user.userpw }</td>
						<td>${user.username }</td>
						<td>${user.usergender }</td>
						<td>${user.userphone }</td>
					</tr>
			</c:when>
			<c:otherwise>	<%-- 전체회원정보조회 --%>
				<c:forEach var="user" items="${requestScope.list }">
					<tr>
						<td>${user.userid }</td>
						<td>${user.userpw }</td>
						<td>${user.username }</td>
						<td>${user.usergender }</td>
						<td>${user.userphone }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>

