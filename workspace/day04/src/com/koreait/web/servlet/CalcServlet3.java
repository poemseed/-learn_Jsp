package com.koreait.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc3")
public class CalcServlet3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// 요청에 대한 한글 처리
		arg0.setCharacterEncoding("UTF-8");
		// 응답에 대한 한글 처리     
		arg1.setCharacterEncoding("UTF-8");
		arg1.setContentType("text/html charset=UTF-8"); 
		
		// cookie 객체배열
		Cookie[] cookies = arg0.getCookies();
		
		PrintWriter out = arg1.getWriter();
		
		String value_ = arg0.getParameter("value");
		String op = arg0.getParameter("operator");
		
		int value = 0;
		
		if( !value_.equals("") ) {
			value = Integer.parseInt(value_);
		}
		
		// 계산
		if( op.equals("=") ) {
			// cookie 저장된 값
			int x = 0;
			// 2번째 값
			int y = value;
			
			// cookies 꺼내기
			for( Cookie c : cookies ) {
				if( c.getName().equals("value") ) {	// 네임이 벨류와 일치 할때
					x = Integer.parseInt( c.getValue() );
					break;
				}
			}
			
			String operator = "";
			
			for( Cookie c : cookies ) {
				if( c.getName().equals("op") ) {	// 네임이 op와 일치 할때
					operator = c.getValue();
					break;
				}
			}
			
			int result = 0;
			
			if(operator.equals("+")) {		// cookie에 저장된 부등호 값이 +면 두 수를 더하고
				result = x + y;
			}else {							// 아니면 뺀다
				result = x - y;		
			}
			
			// 결과값 출력
			out.println("결과값 : " + result );
			
		}else {	// op값이 + 또는 - 이면, cookies에 저장
			// cookies는 문자열 형태만 담을 수 있다.
			Cookie valueCookie = new Cookie("value", String.valueOf(value) );	// value는 int타입이라서 String.valueOf로 스트링으로 바꿈
			Cookie opCookie = new Cookie("op", op);
			
			// 사용자에게 cookie가 전달된다.
			arg1.addCookie(valueCookie);
			arg1.addCookie(opCookie);
			
			// 빈화면으로 전환하지 않고 다시 그 페이지에 있는 것처럼 다음 숫자를 넣을 수 있게 만들기
			arg1.sendRedirect("calc3.html");			
		}
		
		
		
		
		
		
		
		
	}
}
