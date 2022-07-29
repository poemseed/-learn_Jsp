package com.koreait.app.user.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.user.mybatis.SqlMapConfig;


public class UserDAO {
	// mybatis로 db연결
	
	// mybatis로 sql문을 받아오기 위한 변수
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;
	   
	// 생성자
	public UserDAO() {
	   // autocommit
	   sqlsession = factory.openSession(true);
	}
	
	// 회원가입
	public boolean join(UserDTO user) {
		boolean result =false;
		
		if( sqlsession.insert("User.join", user) != 0 ) {
			result = true;
		}
		
		return result;
	}
	
	// 로그인
	public boolean login(String userid, String userpw) {
		boolean result = false;
		
		// DB에서 해시맵에 객체로 아이디와 비밀번호를 담아서 던져주기위해 사용
		HashMap<String, String> datas = new HashMap<>();
		datas.put("userid", userid);
		datas.put("userpw", userpw);
		
		// 해시맵에 담긴 아이디와 비밀번호를 datas에 담아 값을 던져준다
		// 아이디와 비번이 일치하는 사람이 있으면 결과값은 1이 오니깐 1과 비교
		if( (Integer)sqlsession.selectOne("User.login", datas) == 1 ) {
			result = true;
		}
		
		return result;
	}
	
	

}
