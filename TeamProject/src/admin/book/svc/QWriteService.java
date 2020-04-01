package admin.book.svc;

import java.sql.Connection;
import static db.JdbcUtil.*;

import dao.BoardDAO;
import vo.BoardBean;

public class QWriteService {

	// 사용자가 상품 문의한 것을 불러옴
	public BoardBean getBoard(int boardNum) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		BoardBean board = boardDAO.selectBoard(boardNum);
				
		close(con);
		
		return board;
	}

}
