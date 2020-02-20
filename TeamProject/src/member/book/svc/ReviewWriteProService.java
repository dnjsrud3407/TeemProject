package member.book.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BookDAO;
import vo.BookBean;

public class ReviewWriteProService {

	public boolean registReview(BookBean bookBean) {
		System.out.println("ReviewWriteProService - registReview");
//		Connection con = getConnection();
//		BookDAO bookDAO = BookDAO.getInstance();
//		
//		int insertCount = bookDAO.insertBooks(bookBean);
//		boolean isWriteSuccess = false;
//		
//		if(insertCount > 0) {
//			commit(con);
//			bookDAO.updateBoard_re_ref(bookBean);
//			commit(con);
//			
//			isWriteSuccess = true;
//		}else {
//			rollback(con);
//		}
//		close(con);
		
		return false;

	}

}
