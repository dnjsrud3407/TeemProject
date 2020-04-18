package member.book.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		String cID = request.getParameter("couponList");
		String point = request.getParameter("point");
		System.out.println("사용한 쿠폰 id" + cID);
		System.out.println("사용한  point" + point);
		System.out.println("결제 완료");
		
		return forward;
	}

}
