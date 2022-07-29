package com.koreait.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// req, resp 받는걸 강제하기 위해 필요한 인터페이스
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp);
	
}
