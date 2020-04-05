package board.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.BoardBean;

public class QDetailService {


	public BoardBean getOneonOnegetArticle(int boardNum) {
		//1:1문의 상세내용
		System.out.println("QDetailService getOneonOnegetArticle(int boardNum)");
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		
		BoardBean boardBean = dao.getOneonOnegetArticle(boardNum);
		 
		
		close(con);
		
		return boardBean;
	}


	public BoardBean getOneonOnegetAnswer(int boardNum) {
		//1:1문의 상세내용 답변
		System.out.println("QDetailService getOneonOnegetAnswer(int boardNum)");
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		BoardBean boardBean2 = dao.getOneonOnegetAnswer(boardNum);
		
		close(con);
		return boardBean2;
	}


	
	public void getArticle() {
		
	}
}
