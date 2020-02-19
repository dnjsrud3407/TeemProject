package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.DetailService;
import vo.ActionForward;

public class DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// 제품 상세보기
		DetailService detailService = new DetailService();
		detailService.getArticle();
		
		forward = new ActionForward();
		forward.setPath("./admin/book/detail.jsp");
		return forward;
	}

}
