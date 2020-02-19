package member.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

public class OrderRefundFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("OrderRefundFormAction");
		
		forward = new ActionForward();
		forward.setPath("/member/orderRefundForm.jsp");
		return forward;
	}

}
