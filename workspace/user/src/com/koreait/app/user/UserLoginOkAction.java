package com.koreait.app.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.user.dao.UserDAO;
import com.koreait.app.user.dao.UserDTO;

public class UserLoginOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		UserDAO udao = new UserDAO();	//db커넥션
		
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		// udao.login(userid, userpw)이 참, 거짓을 리턴해줌
		if( udao.login(userid, userpw)  ) {	// 로그인 성공시
			forward.setPath("/app/main/mainview.jsp");
			
		}else {								// 로그인 실패시 forward방식으로 화면이동
			forward.setPath("/app/user/loginview.jsp?flag=false");	// flag=false - 로그인이 실패했을시를 alert창 띄우기위해 작성 
		}															// 로그인할때나 실패했을 때 똑같은 로그인화면으로 보여주기때문에 사용
		
		forward.setRedirect(false);	// forward방식으로 페이지이동 처리전달. if문과 else문안에 각각넣어도 되지만 공통되기때문에 밖으로 뻄

		
		return forward;
	}
		
		
		
		
		
		

}
