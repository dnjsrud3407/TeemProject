package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.QWriteProService;
import vo.ActionForward;

public class QWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// 작성자 답변 등록 method()
		QWriteProService qWriteProService = new QWriteProService();
		qWriteProService.writeArticle();
		
		forward = new ActionForward();
		// 1:1 답변 작성한거 상세보기
		forward.setPath("./admin/book/qDetail.jsp");
		
		return forward;
	}

}
