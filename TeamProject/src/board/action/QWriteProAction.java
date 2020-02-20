package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.QWriteProService;
import vo.ActionForward;

public class QWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// 작성자 답변 등록 method()
		QWriteProService q_WriteProService = new QWriteProService();
		q_WriteProService.writeArticle();
		
		forward = new ActionForward();
		// 1:1 답변 작성한거 상세보기
		forward.setPath("./board/QDetail.jsp");
		
		return forward;
	}

}
