package board.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.BoardBean;

import static db.JdbcUtil.*;
public class QListService {

	public ArrayList<BoardBean> getList(String uID) {
		System.out.println("Q_ListService.getList( String uID)");
		
		
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		
		
			ArrayList<BoardBean> QList = dao.getOneonOneQList(uID);
		
			close(con);
		
		return QList;
	}

}
