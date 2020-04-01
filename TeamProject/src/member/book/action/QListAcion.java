package member.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.book.svc.QListService;
import vo.ActionForward;
import vo.BookBean;

public class QListAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("QListAcion - ActionForward");
		
//		int num = Integer.parseInt(request.getParameter("num"));

//		QListService qListService = new QListService();
//		BookBean question = qListService.getQuestion(num);
		
		ActionForward action = new ActionForward();
		action.setPath("/book/book.jsp");

		
		return action;
	}

}
