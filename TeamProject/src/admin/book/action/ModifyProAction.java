package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.ModifyProService;
import vo.ActionForward;

public class ModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		ModifyProService modifyProService = new ModifyProService();
		modifyProService.modifyArticle();
		
		forward = new ActionForward();
		forward.setPath("./admin/book/detail.jsp");
		
		return forward;
	}

}
