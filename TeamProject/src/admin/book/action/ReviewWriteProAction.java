package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.ReviewWriteProService;
import vo.ActionForward;

public class ReviewWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// 작성자 답변 등록 method()
		ReviewWriteProService reviewWriteProService = new ReviewWriteProService();
		reviewWriteProService.writeArticle();
		
		forward = new ActionForward();
		// 후기 작성한거 상세보기
		forward.setPath("./admin/book/reviewDetail.jsp");
		
		return forward;
	}

}
