package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {

		ActionForward forward = new ActionForward();
		
		BoardDAO bdao = new BoardDAO(); 
		
		// 전체 게시글의 수
		int totalCnt = bdao.getBoardCnt();
		req.setAttribute("totalCnt", totalCnt);
		
		
		// 페이징 처리
		// 현재 넘겨받은 페이지
		String temp = req.getParameter("page");
		int page =0;
		
//		if( temp == null ) {	// 내용이 없으면 임의로 페이지 번호 1번으로 
//			page = 1;
//		}else {
//			page = Integer.parseInt(temp);
//		}
		// 삼항연산자로 바꾸기
		page = temp == null? 1: Integer.parseInt(temp);
		
		// 페이지 처리[1][2]...[10] : 10개씩
		int pageSize = 10;
		
		// 1페이지 안에 들어있는 목록의 수
		// 1페이지 endRow = 10, 4페이지 endRow = 40
		int endRow = page*10;
		// 1페이지 startRow = 1, 4페이지 startRow = 31
		int startRow = endRow -9;
		
		// [1][2]...[10] : [1], [11][12]...[20] : [11]
		int startPage = (page -1) / pageSize*pageSize + 1;
		// [1][2]...[10] : [10], [11][12]...[20] : [20]
		int endPage = startPage + pageSize -1;
		int totalPage = (totalCnt -1)/pageSize +1;
		
//		System.out.println("endRow : " + endRow);
//		System.out.println("startRow : " + startRow);
//		System.out.println("startPage : " + startPage);
//		System.out.println("endPage : " + endPage);
//		System.out.println("totalPage : " + totalPage);
		System.out.println("-------------------------");
		
		// 마지막페이지가 전체페이지수 보다 작은경우 처리
		endPage = endPage > totalPage ? totalPage : endPage;
		
		// 페이지에 관련된 것 넣기
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", page);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		
		
		// 전체목록리스트가 담긴 객체를 통으로 집어넣기
		req.setAttribute("boardList", bdao.getBoardList(startRow, endRow));
		
		
		// 목록을 forward방식으로 보내주기
		forward.setRedirect(false);
		forward.setPath(req.getContextPath() + "/app/board/boardlist.jsp");
		
		
		return forward;
	}
	
	
	
	
}
