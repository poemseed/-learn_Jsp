package com.koreait.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class CalcServlet2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// 요청에 대한 한글 처리
		arg0.setCharacterEncoding("UTF-8");
		// 응답에 대한 한글 처리     
		arg1.setCharacterEncoding("UTF-8");
		arg1.setContentType("text/html charset=UTF-8"); 
		
		// session 객체
		HttpSession session= arg0.getSession();
		
		PrintWriter out = arg1.getWriter();
		
		String value_ = arg0.getParameter("value");
		String op = arg0.getParameter("operator");
		
		int value = 0;
		
		if( !value_.equals("") ) {
			value = Integer.parseInt(value_);
		}
		
		// 계산
		if( op.equals("=") ) {
			// session 저장된 값
			int x = (Integer)session.getAttribute("value");
			// 2번째로 요청보낸 값
			int y = value;	
			String operator = (String)session.getAttribute("op");	// session에 저장된 부등호 값 가져오기
			
			int result = 0;
			
			if(operator.equals("+")) {		// session에 저장된 부등호 값이 +면 두 수를 더하고
				result = x + y;
			}else {							// 아니면 뺀다
				result = x - y;		
			}
			
			// 결과값 출력
			out.println("결과값 : " + result );
			
		}else {	// op값이 + 또는 - 이면, session에 저장
			session.setAttribute("value", value);
			session.setAttribute("op", op);
		}
		
		
		
		
		
		
		
		
	}
}
