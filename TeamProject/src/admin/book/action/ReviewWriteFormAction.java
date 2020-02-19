package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.ReviewDetailService;
import vo.ActionForward;

public class ReviewWriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		System.out.println("ReviewWriteFormAction");
		// 사용자가 상품 후기한 것을 불러옴
		ReviewDetailService reviewDetailService = new ReviewDetailService();
		reviewDetailService.getArticle();
		
		forward = new ActionForward();
		forward.setPath("./admin/book/reviewWriteForm.jsp");
		return forward;
	}

}
