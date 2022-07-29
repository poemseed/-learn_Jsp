package com.koreait.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class MyServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		// 한글 깨지는 것에 대한 처리
		arg1.setCharacterEncoding("UTF-8");
		arg1.setContentType("text/html charset=UTF-8");
		
		String paramCnt = arg0.getParameter("cnt");
		System.out.println("paramCnt : " + paramCnt );
		int cnt = 0;
		
		// null이 아니고 빈문자열이 아닐때
		if( paramCnt != null && !paramCnt.equals("")) {
			cnt = Integer.parseInt(paramCnt);
		}else {
			cnt = 100;
		}
		
		// 사용자에게 받은 cnt=3 처리하기
		// 웹에서는 String으로 받아오기 때문에 wrapper class로 숫자로 변형
		// null과 ""빈 문자열은 에러
//		int cnt = Integer.parseInt( arg0.getParameter("cnt") );
		
		System.out.println("cnt : " + cnt );
		
		PrintWriter out = arg1.getWriter();
		out.println("안녕 Servlet Annotation!");
		
		
		
	}
	
	
	
}
