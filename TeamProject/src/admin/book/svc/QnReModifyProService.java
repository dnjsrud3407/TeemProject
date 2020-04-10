package admin.book.svc;

import vo.BoardBean;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;

public class QnReModifyProService {

	// 상품 문의 답변 수정
	public void modifyAnswerBoard(BoardBean board) {
		BoardDAO boardDAO = new BoardDAO();
        Connection con = getConnection();
        boardDAO.setConnection(con);
		
        int updateCount = boardDAO.updateAnswerBoard(board);
        
        if(updateCount > 0) {
        	commit(con);
        } else {
        	rollback(con);
        }
        
        close(con);
	}



}
