package member.account.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.account.svc.ModifyFormService;
import vo.ActionForward;

public class ModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("ModifyAction");
		
		ModifyFormService modifyFormService =new ModifyFormService();
		
		forward = new ActionForward();
		forward.setPath("/member/modify.jsp");
		
		return forward;
	}

}
