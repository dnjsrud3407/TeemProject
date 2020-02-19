package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.QDetailService;
import vo.ActionForward;

public class QModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// 사용자가 상품 문의 작성한 것을 불러옴
		// and 관리자가 작성한 것도 불러옴
		QDetailService qDetailService = new QDetailService();
		qDetailService.getArticle();
		
		forward = new ActionForward();
		forward.setPath("./admin/book/qModifyForm.jsp");
		
		return forward;
	}

}
