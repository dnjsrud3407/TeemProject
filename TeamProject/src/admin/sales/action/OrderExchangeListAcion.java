package admin.sales.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.sales.svc.OrderExchangeListService;
import vo.ActionForward;
import vo.OrderBean;

public class OrderExchangeListAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
System.out.println("OrderExchangeListAcion");
		
//		int num = Integer.parseInt(request.getParameter("num"));
//
//		OrderExchangeListService orderExchangeListService = new OrderExchangeListService();
//		OrderBean order = orderExchangeListService.getOrder(num);
		
		ActionForward action = new ActionForward();
		action.setPath("/admin/order/order_ex_list.jsp");
		
		return action;
	}

}
