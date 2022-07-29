package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;

public class UpdateReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		BoardDAO bdao = new BoardDAO();
		
		// 댓글번호와 수정된 댓글내용 가져오기
		int replynum = Integer.parseInt(req.getParameter("replynum"));
		String boardnum = req.getParameter("boardnum");
		String replycontents = req.getParameter("reply" + replynum);
		
		if( bdao.updateReply(replynum, replycontents) ) {
			// redirect로 보내기
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/board/BoardView.bo?boardnum=" + boardnum);
			
		}
		
		
		return forward;
	}

}
