package member.book.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dao.BookDAO;
import vo.BoardBean;
import vo.BookBean;
import vo.PageInfo;

import static db.JdbcUtil.*;

public class QListService {
	
//	public BookBean getQuestion(int num) {
//		
//		BookDAO bookDAO = BookDAO.getInstance();
//		
//		BookBean questions = bookDAO.selectQuestion(num);
//		
//		
//		return questions;
//	}

	// 책  하나의 상품 문의 리스트 개수 가져오기
	public int qnaListCount(int bookID, String k1) {
		int listCount = 0;

		Connection con = getConnection();

		BoardDAO boardDAO = BoardDAO.getInstance();

		boardDAO.setConnection(con);

		int kID = boardDAO.get_kID(k1);

		if (kID == 102) {
			listCount = boardDAO.qnaListCount(bookID, kID);
		} 
		
		close(con);
		
		return listCount;
	}
	

	// 책 하나의 상품에  글  10개씩 가져오기
	public ArrayList<BoardBean> getQnaBoard(PageInfo pageInfo, int bookID) {
		ArrayList<BoardBean> articleQnaList = null;
		
		System.out.println(bookID);
		Connection con = getConnection();
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		boardDAO.setConnection(con);
		
		articleQnaList = boardDAO.selectArticleList(pageInfo, bookID);
		
		for(int i=0; i<articleQnaList.size(); i++) {
			System.out.println(articleQnaList.get(i).getBoardNum());
		}

		close(con);
		
		return articleQnaList;
	}

	
}
