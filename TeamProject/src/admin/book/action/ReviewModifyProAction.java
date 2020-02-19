package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.ReviewModifyProService;
import vo.ActionForward;

public class ReviewModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		ReviewModifyProService reviewModifyProService = new ReviewModifyProService();
		reviewModifyProService.modifyArticle();
		
		forward = new ActionForward();
		forward.setPath("./admin/book/reviewDetail.jsp");
		
		return forward;
	}

}
