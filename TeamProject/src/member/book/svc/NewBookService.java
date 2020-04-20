package member.book.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BookDAO;
import vo.BookBean;

public class NewBookService {

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
