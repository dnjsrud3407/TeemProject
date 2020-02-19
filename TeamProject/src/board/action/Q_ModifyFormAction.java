package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.Q_DetailService;
import vo.ActionForward;

public class Q_ModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// 사용자가 1:1 작성한 것을 불러옴
		// and 관리자가 작성한 것도 불러옴
		Q_DetailService q_DetailService = new Q_DetailService();
		q_DetailService.getArticle();
		
		forward = new ActionForward();
		forward.setPath("./board/Q_ModifyForm.jsp");
		
		return forward;
	}

}
