package admin.book.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;

public class QListService {

	// 상품 문의 게시글 개수 가져오기
	public int getListCount(int kID) {
		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		listCount = boardDAO.selectListCount(kID);
		
		return listCount;
	}

}
