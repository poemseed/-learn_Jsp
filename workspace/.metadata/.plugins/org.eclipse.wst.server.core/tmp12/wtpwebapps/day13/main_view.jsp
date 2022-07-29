<%@page import="com.koreait.beans.MemberBean"%>
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
		// session에 저장된 id 가져오기
 		// String userid = (String)session.getAttribute("session_id");
		MemberBean member = (MemberBean)session.getAttribute("session_id");
		// 다른 브라우저에서도 이용하는 것 방지
 		//if( userid != null ){
		if( member != null ){
	%>
	<script>
		alert("<%=member.getUsername() %>님 안녕하세요!");
	</script>
	<p>
		어서오세요, <%=member.getUserid()%>(<%=member.getUsername() %>)님 
		<input type="button" value="로그아웃" onclick="location.href='logout_db.jsp'">
	</p>
	<%}else { %>
		<script type="text/javascript">
			alert("로그인 후 이용하세요");
			location.href = "login_view.jsp";
		</script>
	<%} %>
</body>
</html>