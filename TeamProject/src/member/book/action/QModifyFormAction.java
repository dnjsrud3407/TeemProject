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


		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		System.out.println(boardNum);
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("/book/Q_modify.jsp");
		
		return forward;	
	}

}
