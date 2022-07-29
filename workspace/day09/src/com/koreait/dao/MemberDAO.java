package com.koreait.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.koreait.beans.MemberBean;

public class MemberDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	// age_db.jsp -> getAge
	public int getAge(String name) {
		int age = 0;
		String sql = "SELECT age FROM MEMBER WHERE name = ?";
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);	// ?: param
			rs = pstm.executeQuery();
			
			if( rs.next() ) {
				age = rs.getInt(1);		// return age
			}
			
		} catch (SQLException e) {
			System.out.println("DB 접속 오류");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("알 수 없는 오류");
			e.printStackTrace();
		}
		
		
		
		return age;
		
	}
	
	
	public ArrayList<MemberBean> selectAll() {
		String sql = "SELECT * FROM MEMBER";
		ArrayList<MemberBean> result = new ArrayList<MemberBean>();
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while( rs.next() ) {
				MemberBean member = new MemberBean();
				member.setName(rs.getString(1));
				member.setAge(rs.getInt(2));
				result.add(member);
			}
			
		} catch (SQLException e) {
			System.out.println("DB 접속 오류");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("알 수 없는 오류");
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
}
