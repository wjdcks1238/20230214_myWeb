package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static kh.common.jdbc.JDBCTemplate.*;
import kh.member.controller.vo.MemberVo;

public class MemberDao {
	
	//회원가입
	public int enroll(Connection conn, MemberVo vo) {
		int result = -1;
			String query="insert into test_member values";
			query += "(?,?,?,?)";
			
			PreparedStatement pstmt = null;
			
			try {
				pstmt = conn.prepareStatement(query);
				//? 채워주기
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPasswd());
				pstmt.setString(3, vo.getName());
				pstmt.setString(4, vo.getEmail());
				//pstmt실행
				result = pstmt.executeUpdate();
				//결과값 result에 대입
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			System.out.println("DAO enroll return: " + result);
		return result;
	}
}
