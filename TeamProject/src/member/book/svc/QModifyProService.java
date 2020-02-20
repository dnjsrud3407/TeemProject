package member.book.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BookDAO;
import vo.BookBean;

public class QModifyProService {

	public boolean getQuestion(int num, String parameter) throws Exception {
		System.out.println("QModifyProService - isWriter");
		boolean isWriter = false;
		
//		Connection con = getConnection();
//		BookDAO bookDAO = new BookDAO();
//		bookDAO.setConnection(con);;
//		
//		isWriter = bookDAO.isWriter(num, pass);
//		
//		close(con);
		return isWriter;
	}

	public boolean modifyQuestion(BookBean question) {
		System.out.println("QModifyProService - isQWriter");
		int updateCount = 0;
		boolean isModifySuccess = false;
		
//		Connection con = getConnection();
//		BookDAO bookDAO = new BookDAO();
//		bookDAO.setConnection(con);
//		
//		updateCount = bookDAO.updateQuestion(question);
//				
//		if(updateCount > 0) {
//			commit(con);
//			isModifySuccess = true;
//		} else {
//			rollback(con);
//		}
//
//		close(con);
		return isModifySuccess;
	}
}
