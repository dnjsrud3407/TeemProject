package member.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.book.svc.ReviewModifyProService;
import vo.ActionForward;
import vo.BookBean;

public class QModifyFormAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		System.out.println("QModifyFormAction");
//		int board_num = Integer.parseInt(request.getParameter("board_num"));
//		String page = request.getParameter("page");
//		
//		BookBean question = null;
//		QModifyProService qModifyProService = new QModifyProService();
//		question = qModifyProService.getReviews(num);
	
//		request.setAttribute("question", question);
//		request.setAttribute("page", page);

		ActionForward forward = new ActionForward();
		forward.setPath("/book/Q_modify.jsp");
		
		return forward;	
	}

}
