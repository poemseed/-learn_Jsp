package com.koreait.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cnt")
public class CntServlet extends HttpServlet{
	/*
	 * CntServlet을 servlet class를 사용하여
	 * 사용자 url요청	: http://localhost:9090/cnt?cnt=5
	 * 화면 출력 내용		: 1: 안녕 servlet
	 * 				  2: 안녕 servlet
	 * 				  3: 안녕 servlet
	 * 				  4: 안녕 servlet
	 * 				  5: 안녕 servlet
	 * 
	 * 사용자 url요청	: http://localhost:9090/cnt?	null or ""
	 * 화면 출력 내용		: 1: 안녕 servlet
	 * 				  ...
	 * 				  100 : 안녕 servlet
	*/
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// 한글 인코딩처리
		arg1.setCharacterEncoding("UTF-8");
		arg1.setContentType("text/html charset=UTF-8");
		
		// 웹화면에 보여주기
		PrintWriter out = arg1.getWriter();
		
		// arg0 cnt라는 키값으로 받아오기
		String paramCnt = arg0.getParameter("cnt");
		
		
//		int cnt = 0;
//		
//		if( paramCnt != null && !paramCnt.equals("") ) {
//			cnt = Integer.parseInt(paramCnt);
//			// cnt만큼 출력
//			for( int i = 0; i < cnt; i++ ) {
//				out.println( (i+1) + ": 안녕 servlet <br>");
//			}
//		}else {
//			for(int i = 0; i < 100; i++ ) {
//				out.println( (i+1) + ": 안녕 servlet <br>");
//			}
//		}
		
		
		// 선생님
		int cnt = 100;
		
		if( paramCnt != null && !paramCnt.equals("") ) {
			cnt = Integer.parseInt(paramCnt);
		}
		
		for( int i = 0; i < cnt; i++ ) {
			out.println( (i+1) + ": 안녕 servlet <br>");
		
		}
		
		
		
		
	}
	
	
	
	
}
