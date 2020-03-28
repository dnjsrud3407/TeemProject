package member.book.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.BookDAO;
import vo.BookBean;

public class QWriteProService {

	public boolean registQuestions(BookBean bookBean) {
		
		System.out.println("QWriteProService - registQuestions");
		boolean isWriteSuccess = false;
//		Connection con = getConnection();
//		BookDAO bookDAO = BookDAO.getInstance();
//		
		Connection con = getConnection();
		
		BookDAO bookDAO = BookDAO.getInstance();
		
		bookDAO.insertQuestion(bookBean);
//		int insertCount = bookDAO.insertQuestion(bookBean);
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
		
		return isWriteSuccess;	}

}
