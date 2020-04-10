package admin.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import admin.board.svc.BoardService;
import vo.ActionForward;
import vo.PageInfo;

public class FAQDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FAQ DeletePro");
		ActionForward forward = null;
		HttpSession session = request.getSession();
		
		BoardService boardService = new BoardService();
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String k1 = request.getParameter("k1");
		
		// k2는 페이징용이다.
		String page = request.getParameter("page");
		String k2 = request.getParameter("k2");
		
		int deleteCount = boardService.deleteArticle(boardNum, k1);
		
		forward = new ActionForward();
		
		if(deleteCount != 0) {
			// 글 삭제 성공 시 반응
			if(k2 != "") {
				forward.setPath("./FAQ.adb?page="+page+"&k2="+k2);
			} else {
				forward.setPath("./FAQ.adb?page="+page);
			}
			forward.setRedirect(true);
		} else {
			// 글 삭제 실패 시 반응
			session.setAttribute("ErrorMSG", "게시글 삭제에 실패하였습니다.");
			forward.setPath("failed.adb");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
