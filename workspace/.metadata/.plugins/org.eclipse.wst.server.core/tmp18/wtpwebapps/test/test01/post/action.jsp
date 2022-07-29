<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	request.setCharacterEncoding("UTF-8");

	// 파라미터를 받아오기
// 	String name = request.getParameter("user_name");
	
	// 화면에 출력할 결과 문자열
// 	String result = null;
	
	// null이거나 빈문자열이 들어왔을때
// 	if( name == null || name.equals("")){
// 		result = "이름을 입력하세요.";
// 	}else{
// 		result = name;
		
// 	}
	
	// 선생님
	String userName = request.getParameter("user_name");
	if( userName == null ){
		userName = "이름을 입력하세요.";
	}
	
	
	// 앞뒤 공백제거
	userName = userName.trim();
	if( userName.equals("")){
		userName = "이름을 입력하세요.";
	}
	 
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>My JSP Page</title>
	<!-- Twitter Bootstrap3 & jQuery -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css" />
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
<%-- 		<h3><%=result %></h3> --%>
		<h3><%=userName %></h3>
	</div>
</body>
</html>