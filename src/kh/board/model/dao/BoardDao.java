package kh.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import kh.board.model.vo.BoardVo;
import static kh.common.jdbc.JDBCTemplate.*;

public class BoardDao {
	public List<BoardVo> getBoardList(Connection conn, int srnum, int ernum){
		List<BoardVo> result = null;
		String sql="select * "
			    + "from (select rownum rn, tbl_1.* "
			    + "from (select rownum xn, BOARD_NUM, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT "
	    		+ ", BOARD_ORIGINAL_FILENAME, BOARD_RENAME_FILENAME, BOARD_DATE "
	    		+ ", BOARD_LEVEL, BOARD_REF, BOARD_REPLY_SEQ, BOARD_READCOUNT "
	    		+ "from board "
	    		+ "order by board_ref desc, board_reply_seq asc) tbl_1 "
	    		+ ") tbl_2 "
	    		+ "where rn between ? and ?";
		//"안에는 ; 없애야함. /r/n도 없애기"
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, srnum);
			pstmt.setInt(2, ernum);
			rs = pstmt.executeQuery();
			result = new ArrayList<BoardVo>();
			//다중행
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setBoardContent(rs.getString("board_Content"));
				vo.setBoardDate(rs.getDate("board_Date"));
				vo.setBoardLevel(rs.getInt("board_Level"));
				vo.setBoardNum(rs.getInt("board_Num"));
				vo.setBoardOriginalFilename(rs.getString("board_Original_Filename"));
				vo.setBoardReadcount(rs.getInt("board_Readcount"));
				vo.setBoardRef(rs.getInt("Board_Ref"));
				vo.setBoardRenameFilename(rs.getString("board_Rename_Filename"));
				vo.setBoardReplySeq(rs.getInt("board_Reply_Seq"));
				vo.setBoardTitle(rs.getString("board_Title"));
				vo.setBoardWriter(rs.getString("board_Writer"));
				result.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
	
	public List<BoardVo> getBoardList(Connection conn){
		List<BoardVo> result = null;
		String sql="select BOARD_NUM, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT"
				+ ", BOARD_ORIGINAL_FILENAME, BOARD_RENAME_FILENAME"
				+ ", BOARD_DATE, BOARD_LEVEL, BOARD_REF, BOARD_REPLY_SEQ "
				+ ", BOARD_READCOUNT from board\r\n"
				+ "    order by board_ref desc, board_reply_seq asc";
		//"안에는 ; 없애야함. /r/n도 없애기"
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<BoardVo>();
			//다중행
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setBoardContent(rs.getString("board_Content"));
				vo.setBoardDate(rs.getDate("board_Date"));
				vo.setBoardLevel(rs.getInt("board_Level"));
				vo.setBoardNum(rs.getInt("board_Num"));
				vo.setBoardOriginalFilename(rs.getString("board_Original_Filename"));
				vo.setBoardReadcount(rs.getInt("board_Readcount"));
				vo.setBoardRef(rs.getInt("Board_Ref"));
				vo.setBoardRenameFilename(rs.getString("board_Rename_Filename"));
				vo.setBoardReplySeq(rs.getInt("board_Reply_Seq"));
				vo.setBoardTitle(rs.getString("board_Title"));
				vo.setBoardWriter(rs.getString("board_Writer"));
				result.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
	
	public int getCountBoard(Connection conn) {
		int result = 0;
		String sql = "select count(*) cnt from board";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		System.out.println("dao:" + result);
		return result;
	}

}
