package member.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.order.svc.OrderCancelFormService;
import vo.ActionForward;

public class OrderCancelFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("OrderCancelFormAction");
	
		
		OrderCancelFormService orderCancelFormService = new OrderCancelFormService();
		
		
		
		forward = new ActionForward();
		forward.setPath("/member/OrderCencelForm.jsp");
		return forward;
	}

}
