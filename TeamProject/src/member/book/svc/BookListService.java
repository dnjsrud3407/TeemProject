package member.book.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BookDAO;
import vo.BookBean;

import static db.JdbcUtil.*;

public class BookListService {

	// 책 목록 가져오기
	public ArrayList<BookBean> getBookList(int page, int limit) {
		ArrayList<BookBean> bookList = null;
		
		Connection con = getConnection();
		
		BookDAO bookDAO = BookDAO.getInstance();
		
		bookDAO.setConnection(con);
		
		bookList = bookDAO.selectBookList(page, limit);
		
		close(con);
		
		return bookList;
	}

	// 책 목록 개수
		public int getListCount() {
			int listCount = 0;
			Connection con = getConnection();
			BookDAO bookDAO = BookDAO.getInstance();
			bookDAO.setConnection(con);
			
			listCount = bookDAO.selectListCount();
			
			close(con);
			
			return listCount;
		}

	

}
