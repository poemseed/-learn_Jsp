package com.koreait.app.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionForward;

@WebServlet("*.us")
public class UserFrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	
	}
	
	// get이나 post방식 어떤거든 이쪽으로 보냄
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String requestURI = req.getRequestURI();
		ActionForward forward = null;
		
		if( requestURI.equals("/user/UserJoin.us") ) {
			forward = new UserJoinAction().execute(req, resp);
			
		}else if(requestURI.equals("/user/userLogin.us")) {					// 로그인화면으로 넘어가기
			forward = new ActionForward(false, "/app/user/loginview.jsp");	// forward방식으로 페이지이동
		}else if(requestURI.equals("/user/userLoginOk.us") ) {				// 로그인하기
			forward = new UserLoginOkAction().execute(req, resp);
		}
		
		// 변수 forward로 받은걸 화면으로 넘겨주는 일괄처리 
		if( forward != null ) {
			if( forward.isRedirect() ) {	// redirect방식
				resp.sendRedirect(forward.getPath());
			}else {							// forward방식
				RequestDispatcher disp = req.getRequestDispatcher(forward.getPath());
				disp.forward(req, resp);
			}
			
		}
		
		
	}
	
	
}
