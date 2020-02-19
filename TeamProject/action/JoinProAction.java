package member.account.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.action.Action;
import vo.ActionForward;

public class JoinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("JoinProAction");
		
		
		forward = new ActionForward();
		forward.setPath("/member/login.jsp");
		return forward;
	}

}
