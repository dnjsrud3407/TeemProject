package member.book.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
import dao.BookDAO;
import vo.BoardBean;
import vo.BookBean;

public class ReviewModifyProService {
	public BoardBean getReviews(int boardNum, String boardWriter, int kID) throws Exception {
		System.out.println("ReviewModifyProService - getReviews()");
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		BoardBean boardBean = boardDAO.getReviews(boardNum, boardWriter, kID);

		close(con);
		
		return boardBean;
	}
	
	public boolean modifyReview(BoardBean boardBean) {
		System.out.println("ReviewModifyProService - modifyReview()");

		int updateCount = 0;
		boolean isModifySuccess = false;
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);

		updateCount = boardDAO.updateReview(boardBean);

		
		if(updateCount > 0) {
			commit(con);
			isModifySuccess = true;
		} else {
			rollback(con);
		}

		close(con);
		
		return isModifySuccess;
		}
}
