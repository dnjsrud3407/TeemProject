package member.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.book.svc.ReviewModifyProService;
import vo.ActionForward;
import vo.BookBean;

public class ReviewModifyFormAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		System.out.println("ReviewModifyFormAction");
//		int board_num = Integer.parseInt(request.getParameter("board_num"));
//		String page = request.getParameter("page");
//		
//		BookBean views = null;
//		ReviewModifyProService viewModifyProService = new ReviewModifyProService();
//		views = viewModifyProService.getReviews(num);
	
//		request.setAttribute("article", article);
//		request.setAttribute("page", page);

		ActionForward forward = new ActionForward();
		forward.setPath("/book/review_modify.jsp");
		
		return forward;	}

}
