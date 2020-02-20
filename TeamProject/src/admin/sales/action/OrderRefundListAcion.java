package admin.sales.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.sales.svc.OrderRefundListService;
import vo.ActionForward;
import vo.OrderBean;

public class OrderRefundListAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
System.out.println("OrderRefundListAcion");
		
//		int num = Integer.parseInt(request.getParameter("num"));
//
//		OrderRefundListService OoderRefundListService = new OrderRefundListService();
//		OrderBean order = OoderRefundListService.getOrder(num);
		
		ActionForward action = new ActionForward();
		action.setPath("/admin/order/order_refund_list.jsp");
		
		return action;
	}

}
