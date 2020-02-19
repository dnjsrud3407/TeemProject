package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.Notice_WriteProService;
import vo.ActionForward;

public class Notice_WriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		Notice_WriteProService notice_WriteProService = new Notice_WriteProService();
		notice_WriteProService.writeArtice();
		
		forward = new ActionForward();
		// Notice 작성한거 상세보기
		forward.setPath("./board/Notice_Detail.jsp");
		
		return forward;
	}

}
