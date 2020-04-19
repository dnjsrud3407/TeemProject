package member.book.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.account.svc.CouponInfoService;
import member.account.svc.ModifyFormService;
import member.book.svc.CartListService;
import vo.ActionForward;
import vo.CartBean;
import vo.MemberBean;

public class BookBuyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String recName = request.getParameter("recName");
		String recPhone = request.getParameter("recPhone");
		String orderAddress = request.getParameter("orderAddress");
		String cNum = request.getParameter("couponList");
		String point = request.getParameter("point");
		String bookID1 = request.getParameter("bookID1");
		String bookTitle1 = request.getParameter("bookTitle1");
		String bookPrice1 = request.getParameter("bookPrice1");
		String bookEA1 = request.getParameter("bookEA1");
		System.out.println("사용한 쿠폰 Historynum" + cNum);
		System.out.println("사용한  point : " + point);
		System.out.println("결제된 bookID1 : " + bookID1);
		System.out.println("결제된 bookTitle1 : " + bookTitle1);
		System.out.println("결제된 bookPrice1 : " + bookPrice1);
		System.out.println("결제된 bookEA1 : " + bookEA1);
		
		
		
		System.out.println("결제 완료");
		
		return forward;
	}

}
