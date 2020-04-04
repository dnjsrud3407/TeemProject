package member.book.svc;

import vo.BookBean;
import vo.CartBean;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BookDAO;
import dao.CartDAO;

public class BookCartProService {

	
	// 카트에 담긴 책 정보를 가져오는 메서드
	public BookBean getCartBook(int bookID) {

		Connection con = getConnection();
		
		BookDAO bookDAO = BookDAO.getInstance();
		
		bookDAO.setConnection(con);
		
		BookBean bookBean = bookDAO.selectBook(bookID);
		System.out.println(bookBean.getBookTitle());
		
		close(con);
		
		return bookBean;
	}

	// 세션에 해당되는 카트리스트 가져오는 메서드
	public CartBean getCartList(String uID) {
		CartBean cartBean = null;
		
		Connection con = getConnection();
		
		CartDAO cartDAO = CartDAO.getInstance();
		
		cartDAO.setConnection(con);
		
		cartBean = cartDAO.getCartList(uID);
		
		
		return cartBean;
	}



//	public ArrayList<CartBean> addCart(BookBean bookBean) {
//		// TODO Auto-generated method stub
//		
//		
//		ArrayList<CartBean> bookCartList = 
//		
//		
////		bookCartList.add(bookBean);
//						
//		
//		return null;
//		
//	}

}
