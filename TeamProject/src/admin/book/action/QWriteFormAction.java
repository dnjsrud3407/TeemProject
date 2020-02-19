package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.QDetailService;
import vo.ActionForward;

public class QWriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		System.out.println("QWriteFormAction");
		// 사용자가 상품 문의한 것을 불러옴
		QDetailService qDetailService = new QDetailService();
		qDetailService.getArticle();
		
		forward = new ActionForward();
		forward.setPath("./admin/book/qWriteForm.jsp");
		return forward;
	}

}
