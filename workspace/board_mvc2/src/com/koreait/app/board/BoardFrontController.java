package com.koreait.app.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionForward;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String requestURI = req.getRequestURI();
		ActionForward forward = null;
		
		switch(requestURI) {
			case "/board/Boardlist.bo":
				forward = new BoardListAction().execute(req, resp);
				break;
				
			case "/board/BoardWrite.bo":	// 글쓰기 페이지로 이동 : java로직이 필요없이 단순 redirect로 페이지 이동
				forward = new ActionForward(true, req.getContextPath() + "/app/board/boardwrite.jsp");
				break;
			// 글쓰기
			case "/board/BoardWriteOk.bo":
				forward = new BoardWriteOkAction().execute(req,resp);
				break;
			// 글내용 확인
			case "/board/BoardView.bo":
				forward = new BoardViewAction().execute(req, resp);
				break;
			// 댓글 작성
			case "/board/AddReply.bo":
				forward = new AddReplyAction().execute(req, resp);
				break;
			// 댓글 삭제
			case "/board/DeleteReply.bo":
				forward = new DeleteReplyAction().execute(req, resp);
				break;
			// 댓글 수정
			case "/board/UpdateReply.bo":
				forward = new UpdateReplyAction().execute(req, resp);
				break;
		}
		
//		if( requestURI.equals("/board/Boardlist.bo") ) {
//			forward = new BoardListAction().execute(req, resp);
//		}
		
		
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
