package admin.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.board.svc.BoardService;
import vo.ActionForward;

public class EventDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		BoardService boardService = new BoardService();
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String k1 = request.getParameter("k1");
		
		int deleteCount = boardService.deleteArticle(boardNum, k1);
		
		if(deleteCount != 0) {
			// 글 삭제 성공 시 반응
		} else {
			// 글 삭제 실패 시 반응
		}
		
		return forward;
	}

}
