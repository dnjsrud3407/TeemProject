package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.DeleteProService;
import vo.ActionForward;

public class DeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		DeleteProService deleteProService = new DeleteProService();
		deleteProService.deleteArticle();
		
		forward = new ActionForward();
		forward.setPath("List.abook");
		forward.setRedirect(true);
		return forward;
	}

}
