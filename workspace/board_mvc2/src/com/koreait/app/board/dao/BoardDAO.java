package com.koreait.app.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.board.mybatis.SqlMapConfig;

public class BoardDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;
	
	public BoardDAO() {
		// autocommit
		sqlsession = factory.openSession(true);
	}
	
	// 글목록 불러오기
	public List<BoardDTO> getBoardList(int startRow, int endRow) {
		// 시작목록과 끝목록 보내기위한 객체
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		
		// 글목록 전달하면서 시작과 끝 글목록까지 넣기
		List<BoardDTO> boardlist = sqlsession.selectList("Board.getBoardList", datas);
		
		return boardlist;
	}
	
	// 글목록 수 불러오기
	public int getBoardCnt() {
		
		return sqlsession.selectOne("Board.getBoardCnt");
	}
	
	// 글쓰기
	public boolean insertBoard(BoardDTO board) {
		boolean result = false;
		
		// board에 담겨진 내용 보내기
		// sqlsession.insert("Board.insertBoard", board);
		
		// 결과값이 성공이라면 1임
		if( sqlsession.insert("Board.insertBoard", board) == 1 ) {
			result = true;
		}
		
		return result;
	}

	// 글내용 확인하기
	public BoardDTO getDetail(int boardnum) {
		// xml에 전달하고 받아와서 넘기기
		return (BoardDTO)sqlsession.selectOne("Board.getDetail", boardnum);
		
	}
	
	// 조회수 update하기
	public void updateReadCount(int boardnum) {
		
		sqlsession.update("Board.updateReadCount",boardnum);
		
		
	}
	
	// 글쓰기 후 글보기로 화면 전환하기
	public int getSeq() {
		
		return sqlsession.selectOne("Board.getSeq");
	}

	// 댓글쓰기
	public boolean addReply(ReplyDTO reply) {
		boolean result = false;
//		sqlsession.insert("Board.insertReply", reply);
		
		if( sqlsession.insert("Board.addReply", reply) != 0 ) {
			
			result = true;
		}
			
		return result;
	}
	
	// 댓글 가져오기
	public List<ReplyDTO> getReplys(int boardnum) {
		
		List<ReplyDTO> list = sqlsession.selectList("Board.getReplys", boardnum);
		
		return list;
	}
	
	// 댓글 삭제하기
	public boolean deleteReply(int replynum) {
		boolean result = false;
		if( sqlsession.delete("Board.deleteReply", replynum) == 1 ) {
			result = true;
		}
		return result;
	}
	
	// 댓글 수정하기
	public boolean updateReply(int replynum, String replycontents) {
		boolean result = false;
		
		// 데이터 hashmap에 담아서 보내기
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("replynum", replynum);
		datas.put("replycontents", replycontents);
		
		if( sqlsession.update("Board.updateReply", datas ) != 0 ) {
			result = true;
		}
		
		return result;
		
	}
	
	
	
	
}
