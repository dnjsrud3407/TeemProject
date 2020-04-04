package member.book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import action.Action;
import member.book.svc.BookCartProService;
import member.book.svc.BookLikeProService;
import member.book.svc.BookListService;
import vo.ActionForward;
import vo.BookBean;
import vo.CartBean;

public class BookCartProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BookCartProAction");
		
		ActionForward forward = null;
		
		int bookID =Integer.parseInt(request.getParameter("bookID"));
		System.out.println(bookID);
		BookCartProService bookCartProService = new BookCartProService();
		
		// bookID에  해당하는 상품 정보 가져오기
		BookBean bookBean= bookCartProService.getCartBook(bookID);
		
		HttpSession session = request.getSession();
		String uID = (String)session.getAttribute("uID");
		System.out.println(uID);
		
		
		CartBean cartBean = bookCartProService.getCartList(uID);
//		
//		// 카트에 상품 추가
//		bookCartProService.addCart(bookBean);
		
		forward = new ActionForward();
		forward.setPath("Book.book");
		forward.setRedirect(true);
				
		
		return forward;
	}

}
