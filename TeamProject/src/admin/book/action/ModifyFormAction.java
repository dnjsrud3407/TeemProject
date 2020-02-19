package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.DetailService;
import vo.ActionForward;

public class ModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		System.out.println("ModifyFormAction");
		
		// 책 상세정보 가져옴
		DetailService detailService = new DetailService();
		detailService.getArticle();
		
		forward = new ActionForward();
		forward.setPath("./admin/book/modifyForm.jsp");
		
		return forward;
	}

}
