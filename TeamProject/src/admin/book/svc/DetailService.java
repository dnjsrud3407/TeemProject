package admin.book.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BookDAO;
import vo.BookBean;

public class DetailService {

	public BookBean getArticle(int bookID) {
	    Connection con = getConnection();
	    BookDAO bookDAO = BookDAO.getInstance();
	    bookDAO.setConnection(con);
	    
	    BookBean book = bookDAO.selectBook(bookID);
	    
	    close(con);

	    return book;
	}

}
