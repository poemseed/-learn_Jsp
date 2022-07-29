package com.koreait.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

//		PrintWriter out = arg1.getWriter();
//		
//		String x = arg0.getParameter("x");
//		String y = arg0.getParameter("y");
//		int numX = 0;
//		int numY = 0;
//		
//		if( x != null && !x.equals("") && y != null && !y.equals("") ) {
//			numX = Integer.parseInt(x);
//			numY = Integer.parseInt(y);
//			out.println( "result is " + (numX + numY) );
//		}
		
		// 선생님
		String xStr = arg0.getParameter("x");
		String yStr = arg0.getParameter("y");
		
		int X = 0;
		int Y = 0;
		
		if( xStr != null && !xStr.equals("") ) {
			X = Integer.parseInt(xStr);
			System.out.println("X is " + X );
		}
		if( yStr != null && !yStr.equals("") ) {
			Y = Integer.parseInt(yStr);
			System.out.println("Y is " + Y );
		}
		
		int result = X + Y;
		arg1.getWriter().println("result is " + result );
		
	
	
	
	}
}
