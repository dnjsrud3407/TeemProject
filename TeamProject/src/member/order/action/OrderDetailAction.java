package member.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.order.svc.OrderDetailService;
import vo.ActionForward;

public class OrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("OrderDetailAction");
		
		
		OrderDetailService OrderDetailService = new OrderDetailService();
		

		forward = new ActionForward();
		forward.setPath("/member/OrderDetail.jsp");
		return forward;
	}

}
