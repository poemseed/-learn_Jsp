package com.koreait.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calc")
public class Calc extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost호출");
		doProcess(req, resp);
		
		// 방법 1. doGet메서드에 이미 구현되어있다면 호출을 통해서 그 안에 내용 사용하기
		// doGet(req, resp);
		
		
	}
	
	/*
	 * 20220530 - 사용자 요청에 의해 사용하지 않게 됌
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 요청");
		doProcess(req, resp);
		
		// 방법1일때 doGet안에 구현된 내용
		// int num1 = Integer.parseInt(req.getParameter("num1"));
		// int num2 = Integer.parseInt(req.getParameter("num2"));
		
		// PrintWriter out = resp.getWriter();
		// out.println("<html><body>" + (num1 + num2) + "</body></html>");
	
	}
	
	// 방법2. 공통 메서드로 따로 관리
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>" + (num1 + num2) + "</body></html>");
	}
	
	
	
	
	
	
}
