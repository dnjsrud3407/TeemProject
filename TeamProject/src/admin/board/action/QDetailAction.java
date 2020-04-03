package admin.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.board.svc.BoardService;
import vo.ActionForward;
import vo.BoardBean;

public class QDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
ActionForward forward = null;
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		// 서블릿에 리퀘스트 객체로 카테고리 정보를 포함되어있다고 가정
		String k1 = request.getParameter("k1");
		String k2 = request.getParameter("k2");
		// DB 작업을 위한 BoardService 객체와 글 정보를 담아올 BoardBean 객체 선언
		BoardService boardService = new BoardService();
		BoardBean bb = null;
		// BoardService 객체의 getArticle() 메서드를 호출(BoardBean 객체 반환)
		bb = boardService.getArticle(boardNum, k1, k2);
		
		// 
		// 
		forward = new ActionForward();
		
		if(bb != null) {
			// 받아온 글 정보가 있다면 해당 글 정보를 표시할 jsp 파일로 이동
			//
		} else {
			// 받아온 글 정보가 없다면 메시지 호출 후 글 목록으로 보내기
			//
			//
		}
		
		return forward;
	}

}
