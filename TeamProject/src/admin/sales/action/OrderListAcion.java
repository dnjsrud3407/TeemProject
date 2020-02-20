package admin.sales.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.sales.svc.OrderListService;
import vo.ActionForward;
import vo.OrderBean;

public class OrderListAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OrderListAcion");
		
//		int num = Integer.parseInt(request.getParameter("num"));
////
//		OrderListService orderListService = new OrderListService();
//		OrderBean order = orderListService.getOrder(num);
		
		ActionForward action = new ActionForward();
		action.setPath("/admin/order/order_list.jsp");

		return action;
	}

}
