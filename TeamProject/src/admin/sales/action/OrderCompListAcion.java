package admin.sales.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.sales.svc.OrderCompListService;
import vo.ActionForward;
import vo.OrderBean;

public class OrderCompListAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OrderCompListAcion");
		
//		int num = Integer.parseInt(request.getParameter("num"));
//
//		OrderCompListService orderCompListService = new OrderCompListService();
//		OrderBean order = orderCompListService.getOrder(num);
//		
		ActionForward action = new ActionForward();
		action.setPath("/admin/order/order_comp_list.jsp");
		
		return action;
	}

}
