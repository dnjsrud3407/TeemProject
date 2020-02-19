package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.QModifyProService;
import vo.ActionForward;

public class QModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		QModifyProService qModifyProService = new QModifyProService();
		qModifyProService.modifyArticle();
		
		forward = new ActionForward();
		forward.setPath("./admin/book/qDetail.jsp");
		
		return forward;
	}

}
