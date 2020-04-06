package admin.book.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;

public class QDeleteProService {

	// 관리자 답변 게시글 삭제
	public boolean deleteBoard(int boardNum, int boardReRef) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		boolean isRemoveBoard = false;
		
		int deleteBoard = boardDAO.deleteBoard(boardNum);
		int updateCount = 0;
		
		// 답변 글 삭제 성공 시 문의글 boardReSeq 를 0으로 바꿔야함
		if(deleteBoard > 0) {
			updateCount = boardDAO.updateReSeqMinus(boardReRef);
			if(updateCount > 0) {
				isRemoveBoard = true;
				commit(con);
			} else {
				rollback(con);
			}
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isRemoveBoard;
	}

}
