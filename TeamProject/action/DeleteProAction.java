package member.account.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.action.Action;
import member.account.svc.DeleteProService;
import vo.ActionForward;

public class DeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("DeleteProAction");
		
		
		DeleteProService memberDeleteProService=new DeleteProService();
		
		
		
		
		forward = new ActionForward();
		forward.setPath("/index.jsp");
		return forward;
	}

}
