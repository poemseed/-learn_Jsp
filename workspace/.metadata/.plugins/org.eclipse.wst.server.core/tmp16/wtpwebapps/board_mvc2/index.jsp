<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 이 페이지에서 JSTL을 사용하겠다는 태그라이브러리 선언문 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!-- jstl function쓸떄 선언문 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_mvc2</title>
</head>
<body>
<c:set var="nowPage" value="${requestScope.nowPage }"/>
	<a href="">[글쓰기]</a><br>
	<a href="${pageContext.request.contextPath }/board/Boardlist.bo">[글목록]</a>
</body>
</html>