<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	
	// 모든 세션값을 삭제하고 돌아가기
	// 문10. 
	session.removeAttribute("session_member");
%>
	<!-- login.jsp로 돌아가기 -->
	<script type="text/javascript"> location.href="login.jsp"; </script>
