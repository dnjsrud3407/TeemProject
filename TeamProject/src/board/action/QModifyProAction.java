package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.QModifyProService;
import vo.ActionForward;

public class QModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("hi");
		ActionForward forward = null;
		QModifyProService q_ModifyProService = new QModifyProService();
		q_ModifyProService.modifyArticle();
		
		forward = new ActionForward();
		forward.setPath("./board/QDetail.jsp");
		
		return forward;
	}

}
