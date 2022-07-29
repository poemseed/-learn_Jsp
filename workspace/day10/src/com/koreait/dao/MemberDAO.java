package com.koreait.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.koreait.beans.MemberBean;

public class MemberDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	public boolean join(MemberBean member) {
		String sql = "INSERT INTO TBL_MEMBER VALUES ( ?, ?, ?, ?, ?)";
		int result = 0;
		
		try {
			conn = DBConnection.getConnection();
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
		conn = DBConnection.getConnection();
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
	} catch(Exception e) {
		System.out.println("알 수 없는 오류");
		e.printStackTrace();
	}
	
	
	return member;
}
	
	
	
}
