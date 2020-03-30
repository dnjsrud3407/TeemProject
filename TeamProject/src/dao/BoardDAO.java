package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		}
        
		return listCount;
	}
}
