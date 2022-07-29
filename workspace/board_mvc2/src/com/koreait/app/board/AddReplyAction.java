package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.dao.ReplyDTO;

public class AddReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		
		BoardDAO bdao = new BoardDAO();
		
		// 입력된 값받기
		int boardnum = Integer.parseInt(req.getParameter("boardnum") );
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String replycontents = req.getParameter("replycontents");
		
		// DTO에 담아 값 넘기기
		ReplyDTO reply = new ReplyDTO();
		reply.setBoardnum(boardnum);
		reply.setUsername(username);
		reply.setPassword(password);
		reply.setReplycontents(replycontents);
		
//		bdao.addReply(reply);
		
		if( bdao.addReply(reply) ) {
			// redirect방식으로 보내주기
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/board/BoardView.bo?boardnum=" + boardnum );
		}
		
			
		
		return forward;
	}

}
