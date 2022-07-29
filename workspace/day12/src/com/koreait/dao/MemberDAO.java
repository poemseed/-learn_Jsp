package com.koreait.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.beans.MemberBean;
import com.koreait.mybatis.SqlMapConfig;

public class MemberDAO {
	// dbcp로 database받아오기위한 변수
	Context context;
	DataSource dataSource;
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	// mybatis로 sql문을 받아오기 위한 변수
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;
	
	// 생성자
	public MemberDAO() {
		// autocommit
		sqlsession = factory.openSession(true);
	}
	
	public boolean join(MemberBean member) {
		String sql = "INSERT INTO TBL_MEMBER VALUES ( ?, ?, ?, ?, ?)";
		int result = 0;
		
		try {
//			conn = DBConnection.getConnection();
			
			// dbcp로 db데이터 가져오기
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			conn = dataSource.getConnection();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, member.getUserid());
			pstm.setString(2, member.getUserpw());
			pstm.setString(3, member.getUsername());
			pstm.setString(4, member.getUsergender());
			pstm.setString(5, member.getUserphone());
			
			// executeUpdate()
			// - SQL DML(데이터 조작어) 행의 수 return
			// - 결과값이 없는 경우 0 return
			result = pstm.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		if( result != 0 ) {
			// 성공
			return true;
		}else {
			// 실패
			return false;
		}
		
	}
		
	// login
	// 선생님
//	public boolean login(String userid, String userpw) {
//		String sql = "SELECT * FROM TBL_MEMBER tm WHERE USERID = ? AND USERPW = ?";
//		boolean flag = false;
//		
//		try {
//			conn = DBConnection.getConnection();
//			pstm = conn.prepareStatement(sql);
//			
//			pstm.setString(1, userid);
//			pstm.setString(2, userpw);
//			
//			rs = pstm.executeQuery();
//			
//			if( rs.next() ) {
//				flag = true;
//			}
//			
//		}catch (SQLException e) {
//			System.out.println("DB 접속 오류");
//			e.printStackTrace();
//		} catch(Exception e) {
//			System.out.println("알 수 없는 오류");
//			e.printStackTrace();
//		}
//		
//		
//		return flag;
//	}
	
	// login 할때 모든것들 받아오기
	public MemberBean login(String userid, String userpw) {
	String sql = "SELECT * FROM TBL_MEMBER tm WHERE USERID = ? AND USERPW = ?";
	MemberBean member = null;
	
	try {
//		conn = DBConnection.getConnection();
		
		context = new InitialContext();
		dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		conn = dataSource.getConnection();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, userid);
		pstm.setString(2, userpw);
		
		rs = pstm.executeQuery();
		
			if( rs.next() ) {
				member = new MemberBean();
				member.setUserid(rs.getString(1));
				member.setUserpw(rs.getString(2));
				member.setUsername(rs.getString(3));
				member.setUsergender(rs.getString(4));
				member.setUserphone(rs.getString(5));
			}
		
		}catch (SQLException e) {
			System.out.println("DB 접속 오류");
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} 
		
		
		return member;
	}
	
	
	/*
	// 아이디 중복체크 
	public boolean checkid(String userid) {
		String sql = "SELECT count(*) FROM TBL_MEMBER WHERE USERID = ?";
		boolean result = false;
		
		try {
//			conn = DBConnection.getConnection();
			
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			conn = dataSource.getConnection();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userid);
			rs = pstm.executeQuery();
			
			if( rs.next()) {
				// 중복된 아이디가 있을때 true 없을때 false
				if( rs.getInt(1) == 1 ) {
					result = true;	
				}
			}
			
			
		}catch (SQLException e) {
			System.out.println("DB 접속 오류");
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	*/
	// mybatis로 sql문 받아오기 위해 재구현
	public boolean checkId(String userid) {
		boolean result = false;
		int cnt = 0;	//받아온 cnt를 넣기위한 변수
		// Member.checkId	: member.xml에 namespace인 Member의미, select id인 checkid의미
		// userid는 가져오는 변수
		cnt = sqlsession.selectOne("Member.checkId", userid);
		if( cnt >= 1 ) {
			result = true;
		}

		return result;
	}
	
	
	
}
