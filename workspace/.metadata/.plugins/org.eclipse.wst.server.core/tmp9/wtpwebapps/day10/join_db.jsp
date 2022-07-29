<%@page import="com.koreait.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %> <!-- 받아온 request 한글인코딩 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="com.koreait.beans.MemberBean"/>
	<!-- 
		각각 전달되는 파라미터 값을 따로 처리해주야 하지만, *로 해주면 한번에 해결가능하다. 
		member.setUserId( request.getParameter("userid"));
	-->
<%-- 	<jsp:setProperty property="userid" name="member"/> --%>
<%-- 	<jsp:setProperty property="userpw" name="member"/> --%>
	<jsp:setProperty property="*" name="member"/>
	<!-- 외부에서 전달된  name속성과 필드의 이름(멤버빈클래스의 변수 이름)이 같으면 value가 자동으로 세팅된다. -->
	<%
		MemberDAO mdao = new MemberDAO();
		if( mdao.join(member) ){	// 회원가입 성공
	%>
	
		<script type="text/javascript">
			alert("회원가입 성공!")
			location.href="login_view.jsp";
		</script>
		
	<% }else { 	// 회원가입  실패  %>
	
		<script type="text/javascript">
			alert("회원가입 실패!")
			location.href="join_view.jsp";
		</script>
		
	<% } %>
</body>
</html>