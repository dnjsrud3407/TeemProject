package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

public class DeleteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// list.jsp 에서 1~n개 삭제하는 경우 || detail.jsp 에서 1개 삭제하는 경우  모두 포함
		String[] bookIDList = request.getParameterValues("bookIDList");
		
		request.setAttribute("bookIDList", bookIDList);
		
		forward = new ActionForward();
		forward.setPath("./admin/book/deleteForm.jsp");
		
		return forward;
	}

}
