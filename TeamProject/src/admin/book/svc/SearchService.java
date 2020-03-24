package admin.book.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import dao.BookDAO;
import vo.BookBean;

public class SearchService {

	public ArrayList<BookBean> getSearchBookList(Map<Object, Object> searchList, int page, int limit) {
		Connection con = getConnection();
		BookDAO bookDAO = BookDAO.getInstance();
		bookDAO.setConnection(con);
		
		ArrayList<BookBean> bookList = bookDAO.selectSearchBookList(searchList, page, limit);
		
		close(con);
		
		return bookList;
	}

}
