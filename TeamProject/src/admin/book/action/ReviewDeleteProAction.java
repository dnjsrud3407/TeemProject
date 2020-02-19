package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.ReviewDeleteProService;
import vo.ActionForward;

public class ReviewDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		ReviewDeleteProService reviewDeleteProService = new ReviewDeleteProService();
		reviewDeleteProService.deleteArticle();
		
		forward = new ActionForward();
		forward.setPath("ReviewList.abook");
		forward.setRedirect(true);
		return forward;
	}

}
