<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	
		// request 영역에서 값 빼오기
		// attribute01.jsp에서 object로 넘어오기 때문에 String으로 타입을 맞춰야한다.
// 		String userid = (String)request.getAttribute("userid");
// 		String userpw = (String)request.getAttribute("userpw");
// 		String username = (String)request.getAttribute("username");
	
		// session 영역에서 값뺴오기
		String userid = (String)session.getAttribute("userid");
		String userpw = (String)session.getAttribute("userpw");
		String username = (String)session.getAttribute("username");

	%>
	
	아이디		: <%=userid %><br>
	비밀번호	: <%=userpw %><br>
	이름		: <%=username %><br>
	
</body>
</html>