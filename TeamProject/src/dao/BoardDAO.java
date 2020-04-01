package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.BoardBean;

public class BoardDAO {
	public BoardDAO() {}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	// 상품 문의 게시글 개수 가져오기
	public int selectListCount(int kID) {
		int listCount = 0;
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM board WHERE kID=?";
        try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, kID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
            if(rs != null) {close(rs);}
            if(pstmt != null) {close(pstmt);}
        }
        
		return listCount;
	}

	// 상품 문의 게시글 들고오기
	public ArrayList<BoardBean> selectList(int kID, int page, int limit) {
		ArrayList<BoardBean> qList = new ArrayList<BoardBean>();
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 답변 안 된 글(boardReSeq=0)이 우선적으로 보여지고
        // 다음에는 최근글 부터 보여짐
        String sql = "SELECT board.*, book.bookTitle FROM board"
        		+ " JOIN book ON board.bookID = book.bookID"
        		+ " WHERE kID=? AND boardReLev=?"
        		+ " ORDER BY boardReSeq asc, boardReRef desc LIMIT ?,?";
		int startRow = (page - 1) * limit;
        try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, kID);
			pstmt.setInt(2, 0);	// 문의글만 보기
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, limit);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardBean board = new BoardBean(
						rs.getInt("boardNum"), 
						rs.getString("boardWriter"), 
						rs.getString("boardTitle"), 
						rs.getString("boardContent"), 
						rs.getDate("boardRegTime"), 
						rs.getInt("boardReRef"), 
						rs.getInt("boardReLev"), 
						rs.getInt("boardReSeq"), 
						rs.getInt("bookID"), 
						rs.getString("bookTitle")
						);
				qList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            if(rs != null) {close(rs);}
            if(pstmt != null) {close(pstmt);}
        }
		
		return qList;
	}

	// 사용자 문의글 가져오기
	public BoardBean selectBoard(int boardNum) {
		BoardBean board = null;
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT board.*, book.bookTitle FROM board" + 
        		" JOIN book ON board.bookID = book.bookID WHERE boardNum=?";
        try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardBean(
						boardNum, 
						rs.getString("boardWriter"), 
						rs.getString("boardTitle"), 
						rs.getString("boardContent"), 
						rs.getDate("boardRegTime"), 
						rs.getInt("boardReRef"), 
						rs.getInt("boardReLev"), 
						rs.getInt("boardReSeq"), 
						rs.getInt("bookID"), 
						rs.getString("bookTitle")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            if(rs != null) {close(rs);}
            if(pstmt != null) {close(pstmt);}
        }
        
		return board;
	}

	// 답변 등록 시 게시글 번호 구하기 (게시글 중 최대값 구하기)
	public int selectMaxNum() {
		int maxNum = 0;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = "SELECT MAX(boardNum) FROM board";
	    try {
	        pstmt = con.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        if(rs.next()) {
	            maxNum = rs.getInt(1) + 1;  // 게시글 번호 최대값 + 1
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if(rs != null) {close(rs);}
	        if(pstmt != null) {close(pstmt);}
	    }
	    
		return maxNum;
	}
	
	// 답변 등록 하기
	public int insertAnswerBoard(BoardBean board) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
	    String sql = "INSERT INTO board(boardNum,kID,boardWriter,boardTitle,boardContent,boardRegTime,boardReRef,boardReLev,bookID)"
	    		+ "VALUES (?,?,?,?,?,now(),?,?,?)";
	    try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board.getBoardNum());
			pstmt.setInt(2, board.getkID());
			pstmt.setString(3, board.getBoardWriter());
			pstmt.setString(4, board.getBoardTitle());
			pstmt.setString(5, board.getBoardContent());
			pstmt.setInt(6, board.getBoardReRef());
			pstmt.setInt(7, board.getBoardReLev());
			pstmt.setInt(8, board.getBookID());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if(pstmt != null) {close(pstmt);}
	    }
	    
	    return insertCount;
	}

	// 답변 등록 성공 시 문의 글 Seq+1 시키기
	public int updateReSeq(int boardReRef) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE board SET boardReSeq=boardReSeq+1 WHERE boardNum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardReRef);
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if(pstmt != null) {close(pstmt);}
	    }
		
		return insertCount;
	}
}
