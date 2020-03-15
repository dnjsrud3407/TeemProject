package admin.book.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.BookDAO;
import vo.BookBean;

public class WriteProService {

	// bookID 생성
    public int getBookID() {
        int bookID = 0;
        BookDAO bookDAO = new BookDAO();
        Connection con = getConnection();
        bookDAO.setConnection(con);
        
        bookID = bookDAO.getMaxNum();
        close(con);
        
        return bookID;
    }
    
    // 책 등록
	public boolean writeArticle(BookBean book) {
	    boolean iswriteArticleSuccess = false;
	    BookDAO bookDAO = new BookDAO();
	    Connection con = getConnection();
	    bookDAO.setConnection(con);
	    
	    int insertCount = bookDAO.insertBook(book);
	    
	    if(insertCount > 0) {
	        iswriteArticleSuccess = true;
	        commit(con);
	    } else {
	        iswriteArticleSuccess = false;
	        rollback(con);
	    }
	    close(con);
	    return iswriteArticleSuccess;
	}

}
