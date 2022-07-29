package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;

public class BoardViewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		BoardDAO bdao = new BoardDAO();
		
		int boardnum = Integer.parseInt( req.getParameter("boardnum") );
		
		// 조회수를 업데이트하기(전체항목 가져오기전에 위치하면 조회수가 먼저 업데이트가 된다)
		bdao.updateReadCount(boardnum);
		
		// 조회수가 업데이트 된 후에 받아온거 다시 front로 넘기기때문에 업데이트 일어난 것을 셀렉트해옴
		req.setAttribute("board", bdao.getDetail(boardnum) );
		
		
		// 댓글내용 담아서 보내주기
//		bdao.getReplys(boardnum);
		// 댓글내용전달
		req.setAttribute("replylist", bdao.getReplys(boardnum));
		
		// 목록을 forward방식으로 보내주기
		forward.setRedirect(false);
		forward.setPath("/app/board/boardview.jsp");

		
		return forward;
	}

}
