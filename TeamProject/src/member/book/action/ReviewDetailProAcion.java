package member.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.book.svc.ReviewDetailService;
import vo.ActionForward;
import vo.BookBean;

public class ReviewDetailProAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ReviewDetailProAcion");
//		int num = Integer.parseInt(request.getParameter("num"));
//		String page = request.getParameter("page");
//				
//		ReviewDetailService reviewDetailService = new ReviewDetailService();
//		BookBean book = reviewDetailService.getBook(num);
		
//		if(book != null) {
//			reviewDetailService.plusReadcount(board_num);
//		}
		
//		request.setAttribute("book", book);
//		request.setAttribute("page", page);

		ActionForward forward = null;
		
		forward = new ActionForward();
		forward.setPath("./book/review_detail.jsp");
		
		return forward;
	}

}
