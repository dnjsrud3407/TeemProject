package member.book.svc;

import java.sql.Connection;

import dao.BookDAO;

import static db.JdbcUtil.*;

public class BookListService {

	public int getListCount() {
		
		Connection con = getConnection();
		
		BookDAO bookDAO = BookDAO.getInstance();
		
		
		
		return 0;
	}

}
