package kh.member.model.service;

import java.sql.Connection;

import static kh.common.jdbc.JDBCTemplate.*;

import kh.common.jdbc.JDBCTemplate;
import kh.member.controller.vo.MemberVo;
import kh.member.model.dao.MemberDao;

public class MemberService {
	//회원가입
		public int enroll(MemberVo vo) {
			int result = -1;
			Connection conn = getConnection();
			result = new MemberDao().enroll(conn, vo);
			close(conn);
			return result;
		}
}
