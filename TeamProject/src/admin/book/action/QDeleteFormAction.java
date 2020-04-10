package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

public class QDeleteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// 파라미터로 답변글번호(boardRe_refList) 가져오기
		String[] boardRe_refList = request.getParameterValues("boardRe_refList");
		
		request.setAttribute("boardRe_refList", boardRe_refList);
		
		forward = new ActionForward();
		forward.setPath("./admin/book/qDeleteForm.jsp");
		
		return forward;
	}

}
