package member.book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.book.svc.BookCartProService;
import member.book.svc.BookLikeProService;
import member.book.svc.BookListService;
import vo.ActionForward;
import vo.BookBean;

public class BookCartProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BookCartProAction");
		
		ActionForward forward = null;
		
		int bookID =Integer.parseInt(request.getParameter("bookID"));
		System.out.println(bookID);
		BookCartProService bookCartProService = new BookCartProService();
		
		// 카트에 담긴 상품 정보 가져오기
		BookBean bookBean = bookCartProService.getCartBook(bookID);
		
		// 카트에 상품 추가
		ArrayList<BookBean> bookCartList = bookCartProService.addCart(bookBean);
		
		forward = new ActionForward();
		forward.setPath("Book.book");
		forward.setRedirect(true);
				
		
		return forward;
	}

}
