package member.account.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.account.svc.ModifyService;
import vo.ActionForward;

public class ModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("ModifyAction");
		
		ModifyService ModifyService =new ModifyService();
		
		forward = new ActionForward();
		forward.setPath("/modify.jsp");
		
		return forward;
	}

}
