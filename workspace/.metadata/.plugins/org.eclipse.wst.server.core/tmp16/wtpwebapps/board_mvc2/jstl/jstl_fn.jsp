<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- 이 페이지에서 JSTL을 사용하겠다는 태그라이브러리 선언문 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!-- jstl function쓸떄 선언문 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		HashMap map = new HashMap();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
	
	%>
	
	<c:set var="map" value="<%=map %>"/>
	<c:set var="str1" value="jstlfn"/>
	<c:set var="str2" value="jstlfn배워봅시다"/>
	
	<h1>Function 태그</h1>
	
	<!-- length(obj) : obj가 collection인 경우 저장된 항목의 개수, 문자인 경우 문자열의 길이를 반환 -->
	length(map)	: ${fn:length(map) }<br>	<!-- map의 길이 가져오기 -->
	length(str1): ${fn:length(str1) }<br>
	length(str2): ${fn:length(str2) }<br>
	
	<!-- toUpperCase(str)	: str를 대문자로 변환 -->
	<!-- toLowerCase(str)	: str를 소문자로 변환 -->
	toUpperCase(str1)	: ${fn:toUpperCase(str1) }<br>
	toLowerCase(str1)	: ${fn:toLowerCase(str1) }<br>
	
	<!-- replace(str, src, dest)	: str에 있는 src를 dest로 변환 -->
	replace(str1, src, dest)	: ${fn:replace(str1, "f", "^") }
	
	
	
	
</body>
</html>



