package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.CartBean;

import static db.JdbcUtil.*;

public class CartDAO {
	
	public CartDAO() {}
	
	private static CartDAO instance = new CartDAO();

	public static CartDAO getInstance() {
		return instance;
	}

	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null; 
	
	public void setConnection(Connection con) {
		this.con = con;
	}


	// 세션에 해당하는 카트리스트 가져오는 메서드
	public CartBean getCartList(String uID) {
		// TODO Auto-generated method stub
		CartBean cartBean = null;
		
		String sql = "select cartNum, bookImage, bookTitle, cart.bookEA, bookPrice*cart.bookEA totalPrice,"
				+ " user_uID, book_bookID from cart join book on bookID = book_bookID where user_uID=?";
				
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uID);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cartBean = new CartBean();
				cartBean.setCartNum(rs.getInt("cartNum"));
				cartBean.set
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cartBean;
	}
	
	
	
	
}
