package member.account.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.action.Action;
import member.account.svc.FindIdProService;
import vo.ActionForward;

public class FindIdProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("FindIdProAction");
		
		FindIdProService findIdProService = new FindIdProService();
		
		
		return forward;
	}

}
