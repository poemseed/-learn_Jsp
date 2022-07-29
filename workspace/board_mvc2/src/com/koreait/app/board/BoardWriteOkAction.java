package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.dao.BoardDTO;

public class BoardWriteOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		
		BoardDAO bdao = new BoardDAO();
		
		// 입력된 값 받아오기
		String boardtitle = req.getParameter("boardtitle");
		String boardcontent = req.getParameter("boardcontent");
		String username = req.getParameter("username");
		
		// DTO에 담아 값 넘겨주기
		BoardDTO board = new BoardDTO();
		board.setBoardtitle(boardtitle);
		board.setBoardcontent(boardcontent);
		board.setUsername(username);
		
		
		// redirect방식으로 보내주기
		forward.setRedirect(true);
		
		// 담아 bao로 보내기
		// bdao.insertBoard(board);
		// 결과에 따라 화면 보여주기
		if( bdao.insertBoard(board) ) {	// 성공시
			
//			forward.setPath(req.getContextPath() + "/board/Boardlist.bo");
			// 목록말고 글상세보여주기
			int boardnum = bdao.getSeq();
			forward.setPath(req.getContextPath() + "/board/BoardView.bo?boardnum=" + boardnum );
			
		}else {							// 실패시
			
			forward.setPath(req.getContextPath() + "/board/BoardWrite.bo");
			
		}
		
		
		
		return forward;
	}

}
