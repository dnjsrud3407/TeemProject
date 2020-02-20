package member.book.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BookDAO;
import vo.BookBean;

public class ReviewDetailService {

	public BookBean getBook(int num) {

System.out.println("ReviewDetailService - getBook");
		
//		Connection con = getConnection();
//		BookDAO bookDAO = BookDAO.getInstance(); 
//		bookDAO.setConnection(con);
//		
//		BookBean book = null;
//
//		book = bookDAO.selectBook(num);
//
//		
//		
		
//		int updateCount = boardDAO.updateReadcount(board_num);
//		System.out.println("BoardDetailService - BoardDAO: updateReadcount");

		//		if(updateCount > 0) {
//			commit(con);
//			
//		}else {
//			rollback(con);
//		}
		
//		close(con);
		
		return null;
	}
	//조회수 증가용
	public void plusReadcount(int num) throws Exception {
		//게시글중 한개 클릭시
		System.out.println("ReviewDetailService - getArticle");
		
//		Connection con = getConnection();
//		BookDAO bookDAO = BookDAO.getInstance(); 
//		bookDAO.setConnection(con);
//		
//		int updateCount = bookDAO.updateReadcount(num);
//
//		if(updateCount > 0) {
//			commit(con);
//			
//		}else {
//			rollback(con);
//		}
//		
//		close(con);

	}

}
