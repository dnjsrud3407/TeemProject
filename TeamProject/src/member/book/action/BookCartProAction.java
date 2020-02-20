package member.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.book.svc.BookLikeProService;
import vo.ActionForward;

public class BookCartProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BookCartProAction");
		
		ActionForward forward = null;
		
//		BookCartProService bookCartProService = new BookCartProService();

		
		forward = new ActionForward();
		forward.setPath("Book.book");
		forward.setRedirect(true);
				
		
		return forward;
	}

}
