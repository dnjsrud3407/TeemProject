package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.QDetailService;
import vo.ActionForward;

public class QDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		System.out.println("Q_DetailAction");
		
		// 사용자가 1:1 작성한 것을 불러옴
		// and 관리자가 작성한 것도 불러옴
		QDetailService q_DetailService = new QDetailService();
		q_DetailService.getArticle();
		
		forward = new ActionForward();
		forward.setPath("./board/QDetail.jsp");
		return forward;
	}

}
