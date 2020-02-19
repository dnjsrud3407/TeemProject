package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.Notice_ModifyProService;
import vo.ActionForward;

public class Notice_ModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		Notice_ModifyProService notice_ModifyProService = new Notice_ModifyProService();
		notice_ModifyProService.modifyArticle();
		
		forward = new ActionForward();
		forward.setPath("./board/Notice_Detail.jsp");
		
		return forward;
	}

}
