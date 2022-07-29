<%@page import="com.koreait.beans.MemberBean"%>
<%@page import="com.koreait.dao.MemberDAO"%>
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
		MemberDAO mdao = new MemberDAO();
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		// MemberDAO에 login 메서드 만들어서
		// 결과값을 boolean return
		// if( mdao.login(userid, userpw) ){
			// 로그인성공한 다음에 session에 아이디 저장하기
			// session.setAttribute("session_id", userid);
		
		MemberBean member = mdao.login(userid, userpw);	
		if( member != null ){
			// 로그인성공한 다음에 session에 member객체 통으로 저장하기
			session.setAttribute("session_id", member);
		
	%>
	
		<script type="text/javascript">
			location.href="main_view.jsp"
		</script>
		
	<% }else{ %>
	
		<script type="text/javascript">
			alert("로그인 실패")
			location.href="login_view.jsp";
		</script>
		
	<% } %>
</body>
</html>