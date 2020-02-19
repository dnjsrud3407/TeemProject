package member.account.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.action.Action;
import member.account.svc.LoginProService;
import vo.ActionForward;

public class LoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("LoginProAction");
		
		
		LoginProService memberLoginProService= new LoginProService();
//		memberLoginProService.Login(id,pass);
		forward = new ActionForward();
		forward.setPath("");
		forward.setRedirect(true);
		return forward;
	}

}
