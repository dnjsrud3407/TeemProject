package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.QDeleteProService;
import vo.ActionForward;

public class QDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		QDeleteProService qDeleteProService = new QDeleteProService();
		qDeleteProService.deleteArticle();
		
		forward = new ActionForward();
		forward.setPath("QList.abook");
		forward.setRedirect(true);
		return forward;
	}

}
