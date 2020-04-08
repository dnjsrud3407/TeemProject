package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

public class QDeleteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// 파라미터로 답변글번호(boardNum), 사용자 문의글 번호(boardReRef) 가져오기
		String boardNum = request.getParameter("boardNum");
		String boardReRef = request.getParameter("boardReRef");
		
		request.setAttribute("boardNum", boardNum);
		request.setAttribute("boardReRef", boardReRef);
		
		forward = new ActionForward();
		forward.setPath("./admin/book/qDeleteForm.jsp");
		
		return forward;
	}

}
