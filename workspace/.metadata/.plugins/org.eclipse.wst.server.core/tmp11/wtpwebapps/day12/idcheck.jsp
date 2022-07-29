<%@page import="com.koreait.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		String userid = request.getParameter("userid");
		MemberDAO mdao = new MemberDAO();
		// 중복된 아이디가 없을 때 false 반환함 그래서 조건이 false여야 쓸수 있는 아이디임
		if( !mdao.checkId(userid) ){
			// 중복된 아이디가 없을 경우
			out.print("ok");
		}else{
			// 중복된 아이디가 있을 경우
			out.print("not-ok");
		}
		
	%>
