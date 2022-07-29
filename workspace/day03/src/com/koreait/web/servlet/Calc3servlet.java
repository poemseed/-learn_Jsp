package com.koreait.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc3")
public class Calc3servlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// 같은 name을 가진 여러개의 input값을 요청받았을 때 배열로 처리하기
		String[] numStr = arg0.getParameterValues("num");
		
		int result = 0;
		
		for( int i = 0; i < numStr.length; i++ ) {
			int num = Integer.parseInt( numStr[i] );
			result += num;
		}
		
		arg1.getWriter().println("result is " + result );
	
	
	
	
	
	
	
	}
}
