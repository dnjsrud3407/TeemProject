package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.QModifyFormService;
import vo.ActionForward;

public class QModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("BoardQModifyFormAction");
		
		QModifyFormService boardQModifyFormService = new QModifyFormService();
		
		
		
		
		forward = new ActionForward();
		forward.setPath("/member/QModifyForm.jsp");
		
		return forward;
	}

}
