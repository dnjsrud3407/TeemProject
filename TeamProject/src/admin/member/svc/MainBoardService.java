package admin.member.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.BoardBean;

public class MainBoardService {

	// 메인에서 상품문의, 상품후기, 1:1문의 가져오기
	public ArrayList<BoardBean> getBoardList(int kID, int page, int limit) {
		ArrayList<BoardBean> boardList = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		boardList = boardDAO.selectList(kID, page, limit);
		
		close(con);
		
		return boardList;
	}

}
