package member.book.svc;

import vo.BookBean;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BookDAO;

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

	public ArrayList<BookBean> addCart(BookBean bookBean) {
		// TODO Auto-generated method stub
		
		
		return null;
		
	}

}
