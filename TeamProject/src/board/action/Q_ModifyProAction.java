package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.Q_ModifyProService;
import vo.ActionForward;

public class Q_ModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("hi");
		ActionForward forward = null;
		Q_ModifyProService q_ModifyProService = new Q_ModifyProService();
		q_ModifyProService.modifyArticle();
		
		forward = new ActionForward();
		forward.setPath("./board/Q_Detail.jsp");
		
		return forward;
	}

}
