package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.Notice_DetailService;
import board.svc.Q_DetailService;
import vo.ActionForward;

public class Notice_DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// Notice 작성한 것을 불러옴
		Notice_DetailService notice_DetailService = new Notice_DetailService();
		notice_DetailService.getArticle();
		
		forward = new ActionForward();
		forward.setPath("./board/Notice_Detail.jsp");
		return forward;
	}

}
