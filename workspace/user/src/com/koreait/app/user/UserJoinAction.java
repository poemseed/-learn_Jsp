package com.koreait.app.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.user.dao.UserDAO;
import com.koreait.app.user.dao.UserDTO;

public class UserJoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		UserDAO udao = new UserDAO();	// db연결
		UserDTO user = new UserDTO();	// 파라미터로 넘길 객체
		ActionForward forward = new ActionForward();	// forward 방식으로 넘길 
		
		// 넘어온 파라미터로 DTO에 값 set해주기
		user.setUserid(req.getParameter("userid"));
		user.setUserpw(req.getParameter("userpw"));
		user.setUsername(req.getParameter("username"));
		user.setUserphone(req.getParameter("userphone"));
		user.setUseraddr(req.getParameter("useraddr"));
		
		if( udao.join(user) ) {	// 회원가입성공시
			forward.setRedirect(true);	//  redirect방식으로 전송
			forward.setPath(req.getContextPath() + "/app/user/loginview.jsp");
		}else {					// 회원가입실패시
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "index.jsp" );
		}
		
		
		return forward;
	}
	
	
}
