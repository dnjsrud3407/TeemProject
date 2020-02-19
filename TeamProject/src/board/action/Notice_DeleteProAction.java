package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.Notice_DeleteProService;
import vo.ActionForward;

public class Notice_DeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		Notice_DeleteProService notice_DeleteProService = new Notice_DeleteProService();
		notice_DeleteProService.deleteArticle();
		
		forward = new ActionForward();
		forward.setPath("Notice_List.bo");
		forward.setRedirect(true);
		return forward;
	}

}
