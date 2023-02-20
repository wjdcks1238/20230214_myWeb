package kh.board.model.service;

import java.sql.Connection;
import java.util.List;

import kh.board.model.dao.BoardDao;
import kh.board.model.vo.BoardVo;
import kh.common.jdbc.JDBCTemplate;

public class BoardService {
	//overloading
	public List<BoardVo> getBoardList(int srnum, int ernum){
		List<BoardVo> result = null;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getBoardList(conn, srnum, ernum);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public List<BoardVo> getBoardList(){
		List<BoardVo> result = null;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getBoardList(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int getCountBoard() {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getCountBoard(conn);
		JDBCTemplate.close(conn);
		
		return result;
	}
}
