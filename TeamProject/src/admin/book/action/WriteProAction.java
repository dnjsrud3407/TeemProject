package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.WriteProService;
import vo.ActionForward;

public class WriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		WriteProService writeProService = new WriteProService();
		writeProService.writeArtice();
		
		forward = new ActionForward();
		// 책 등록한거 상세보기
		forward.setPath("./admin/book/detail.jsp");
		
		return forward;
	}

}
