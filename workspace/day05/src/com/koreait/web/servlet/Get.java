package com.koreait.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class Get extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		if( arg0.getMethod().equals("GET") ) {
			System.out.println("GET 요청입니다.");
		}else if( arg0.getMethod().equals("POST") ) {
			System.out.println("POST 요청입니다.");
		}
		
		// 부모의 서비스메서드에 값을 호출해서 넘겨줘야 doget, dopost 사용가능
		super.service(arg0, arg1);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 메소드가 호출되었습니다.");
	
	
	
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메소드가 호출되었습니다.");
	
	
	
	
	
	}
	
	
	
	
	
}
