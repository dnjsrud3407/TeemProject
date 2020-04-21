package member.account.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.book.svc.NewBookService;
import vo.ActionForward;
import vo.BookBean;

public class Main implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		NewBookService newBookService = new NewBookService();  
		// main에서 새로운 책 들고옴
		ArrayList<BookBean> bookList = newBookService.getMiddleBookList();
		
		request.setAttribute("bookList",bookList);
		forward = new ActionForward();
		forward.setPath("index.jsp");
		return forward;
	}

}
