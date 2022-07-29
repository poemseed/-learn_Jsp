<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	request.setCharacterEncoding("UTF-8");

	// 파라미터를 받아오기
	String ans = request.getParameter("ans");
	
	// 화면에 출력할 결과 문자열
	String result = null;
	
	// null이거나 빈문자열이 들어왔을때
	if( ans == null || ans.equals("")){
		result = "응답내용이 없습니다.";
	}else{

		int user_select = Integer.parseInt(ans);
		
		if( user_select == 300 ){
			result = "정답입니다.";
		}else{
			result = "정답이 아닙니다.";
		}
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
		<div class='page-header'>
			<h1>응답결과</h1>
		</div>
		<div><p><%= result %></p></div>
		
	</div>
</body>
</html>
