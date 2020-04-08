package admin.book.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardBean;


public class QnReWriteProService {

	// boardNum 생성
	public int getBoardNum() {
		int boardNum = 0;
		BoardDAO boardDAO = new BoardDAO();
        Connection con = getConnection();
        boardDAO.setConnection(con);
        
        boardNum = boardDAO.selectMaxNum();
        
        close(con);
		
		return boardNum;
	}
	

	// 답변 글 적기
	public void writeAnswerBoard(BoardBean board) {
		BoardDAO boardDAO = new BoardDAO();
        Connection con = getConnection();
        boardDAO.setConnection(con);
		
        int insertCount = boardDAO.insertAnswerBoard(board);
        int updateCount = 0;
        
        // 답변 글 작성 성공 시 문의글 boardReSeq 를 1로 바꿔야함
        if(insertCount > 0) {
        	updateCount = boardDAO.updateReSeqPlus(board.getBoardReRef());
        	if(updateCount > 0) {
        		commit(con);
        	} else {
        		rollback(con);
        	}
        } else {
        	rollback(con);
        }
        
        close(con);
	}

}
