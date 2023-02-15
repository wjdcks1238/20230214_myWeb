package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static kh.common.jdbc.JDBCTemplate.*;
import kh.member.controller.vo.MemberVo;

public class MemberDao {
	
	public MemberVo myInfo(Connection conn, String id) {
		MemberVo result = null;
		String sql = "select ID, NAME, EMAIL from test_member";
		sql += "where id=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new MemberVo();
				result.setEmail(rs.getString("email"));
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
			}
		} catch(Exception e) {
			
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	//로그인
	public MemberVo login(Connection conn, MemberVo vo) {
		MemberVo result = null;
//  desc test_member;	
//		------ -------- ------------ 
//		ID     NOT NULL VARCHAR2(15) 
//		PASSWD NOT NULL VARCHAR2(15) 
//		NAME   NOT NULL VARCHAR2(20) 
//		EMAIL           VARCHAR2(30)
		String sql = "select ID, NAME, EMAIL from test_member";
		sql += "where id=? and passwd=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new MemberVo();
				result.setEmail(rs.getString("email"));
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
			}
		} catch(Exception e) {
			
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	
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
