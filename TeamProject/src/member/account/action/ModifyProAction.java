package member.account.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.account.svc.ModifyFormService;
import member.account.svc.ModifyProService;
import vo.ActionForward;

public class ModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("ModifyProAction");
		
		ModifyProService modifyProAction =new ModifyProService();
		
		forward = new ActionForward();
		forward.setPath("index.jsp");
		forward.setRedirect(true);
		return forward;
		
		
	}

}
