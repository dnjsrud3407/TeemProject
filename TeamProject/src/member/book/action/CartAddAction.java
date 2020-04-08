package member.book.action;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import action.Action;
import member.book.svc.CartAddService;

import vo.ActionForward;
import vo.BookBean;
import vo.CartBean;

public class CartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CartAddAction");
		
		ActionForward forward = null;
		
		int bookID =Integer.parseInt(request.getParameter("bookID"));
		int qty = 1;
		System.out.println(request.getParameter("qty"));
		if(request.getParameter("qty") != null) {
			qty = Integer.parseInt(request.getParameter("qty"));
		}

		System.out.println(qty);
	
		System.out.println(bookID);
		
		CartAddService bookCartProService = new CartAddService();
		
		// bookID에  해당하는 상품 정보 가져오기
		BookBean bookBean= bookCartProService.getCartBook(bookID);
		
		// 세션의 속성을 가져와서 uID에 저장
		HttpSession session = request.getSession();
		String uID = (String)session.getAttribute("uID");
		System.out.println("사용자이름 :" + uID);
		
//		// 카트에 상품 추가
		ArrayList<CartBean> cartList = bookCartProService.addCart(bookBean, uID, qty);
		
		session.setAttribute("cartList", cartList);
		
		forward = new ActionForward(); 
		forward.setPath("CartList.book"); 
		forward.setRedirect(true); 
			
	
		return forward;
	}

}
