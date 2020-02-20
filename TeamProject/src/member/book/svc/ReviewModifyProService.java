package member.book.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BookDAO;
import vo.BookBean;

public class ReviewModifyProService {
	public boolean getReviews(int num, String pass) throws Exception {
		System.out.println("ReviewModifyProService - getReviews()");

		boolean isReviewWriter = false;
		
//		Connection con = getConnection();
//		BookDAO bookDAO = new BookDAO();
//		bookDAO.setConnection(con);;
//		
////		isReviewWriter = bookDAO.isReviewWriter(num, pass);
//		
//		close(con);
		return isReviewWriter;
	}
	
	public boolean modifyReview(BookBean review) {
		System.out.println("ReviewModifyProService - modifyReview()");

		int updateCount = 0;
		boolean isModifySuccess = false;
		
//		Connection con = getConnection();
//		BookDAO bookDAO = new BookDAO();
//		bookDAO.setConnection(con);
//		
//		updateCount = bookDAO.updateReview(review);
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
