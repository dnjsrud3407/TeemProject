package admin.book.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BookDAO;

import static db.JdbcUtil.*;

import vo.BookBean;

public class ListService {

	public ArrayList<BookBean> getBookList() {
		Connection con = getConnection();
		BookDAO bookDAO = BookDAO.getInstance();
		bookDAO.setConnection(con);
		
		ArrayList<BookBean> bookList = bookDAO.selectBookList();
		
		close(con);
		
		return bookList;
	}

}
