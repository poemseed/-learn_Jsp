package com.koreait.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DoFrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	
	
	}
	
	// get방식이든 post방식이든 이 메서드로 들어옴
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파싱결과인 url확인하기
		System.out.println("URI : " + req.getRequestURI() );
		// url받아오기
		String requestURI = req.getRequestURI();
		String responseURI = null;
		
		if( requestURI.equals("/fc/do1.do") ) {
			// do1.do 에 대한 업무처리
//			req.setAttribute("result", "do1를 요청보내기!"); 				// 업무처리 - 자바영역에서 해줄거임
//			req.getRequestDispatcher("do1.jsp").forward(req, resp);	// 응답처리 - 페이지 이동시키기
			
			responseURI = new Do1().execute(req, resp);				// 업무처리를 자바에서 따로 해주고 다시 받음
			
		}else if( requestURI.equals("/fc/do2.do") ) {
			// do2.do 에 대한 업무처리
//			req.setAttribute("result", "do2를 요청보내기!");
//			req.getRequestDispatcher("do2.jsp").forward(req, resp);
			
			responseURI = new Do2().execute(req, resp);
			
		}else if( requestURI.equals("/fc/do3.do") ) {
			// do3.do 에 대한 업무처리
//			req.setAttribute("result", "do3를 요청보내기!");
//			req.getRequestDispatcher("do3.jsp").forward(req, resp);
			
			responseURI = new Do3().execute(req, resp);
		}
		
		// 응답 처리부분(페이지이동시키기)이 공통됌(요청파라미터만 다름) 그래서 응답처리를 한꺼번에 해줌
		req.getRequestDispatcher(responseURI).forward(req, resp);
		
		
		
	}
	
	
	
}
