package com.koreait.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Do1 {
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		req.setAttribute("result", "do1으로 보내기!");	// 업무처리
		return "do1.jsp";							// 응답
	}
	
	
}
