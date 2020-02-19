package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.ReviewDetailService;
import vo.ActionForward;

public class ReviewDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		System.out.println("ReviewDetailAction");
		
		// 사용자가 후기 작성한 것을 불러옴
		// and 관리자가 작성한 것도 불러옴
		ReviewDetailService reviewDetailService = new ReviewDetailService();
		reviewDetailService.getArticle();
		
		forward = new ActionForward();
		forward.setPath("./admin/book/reviewDetail.jsp");
		return forward;
	}

}
