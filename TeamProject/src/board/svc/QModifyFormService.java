package board.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardBean;

public class QModifyFormService {

	public BoardBean getOneonOnegetArticle(int boardNum) {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		
		BoardBean boardBean = dao.getOneonOnegetArticle(boardNum);
		System.out.println(	boardBean.getK1());
		System.out.println(	boardBean.getK2());
		
		
		close(con);
		
		return boardBean;
	}

}
