package member.book.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BookDAO;
import vo.BookBean;

public class NewBookService {

	// Main에서 새로운 책 들고옴 
	public ArrayList<BookBean> getMiddleBookList() {
		ArrayList<BookBean> bookList = null;
		Connection con = getConnection();
		BookDAO bookDAO = BookDAO.getInstance();
		bookDAO.setConnection(con);
		
		bookList = bookDAO.selectMiddleBookList();
		
		close(con);
		
		return bookList;
	}
	
}
