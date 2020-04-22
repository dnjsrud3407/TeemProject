package admin.sales.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.sales.svc.OrderCompListService;
import member.order.svc.OrderListService;
import vo.ActionForward;
import vo.OrderBean;

public class OrderCompListAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OrderCompListAcion");
		ActionForward forward = null;
//		int num = Integer.parseInt(request.getParameter("num"));
////
//		OrderListService orderListService = new OrderListService();
//		OrderBean order = orderListService.getOrder(num);
		
		ActionForward action = new ActionForward();
		String orderNum = request.getParameter("order_ID");
		String orderStatus = request.getParameter("orderStatus");
		//삭제필요한지확인
//		admin.sales.svc.OrderListService mind = null;
		
	
		OrderListService orderListService = new OrderListService();
//		List<OrderBean> orderList = orderListService.orderList();
		List<OrderBean> orderList = orderListService.orderComplList(orderStatus);

//		OrderBean order = new OrderBean();
		request.setAttribute("orderList", orderList);
//		request.setAttribute("order", order);
		System.out.println("orderStatus : " + orderStatus);
		forward = new ActionForward();
		forward.setPath("/admin/order/order_comp_list.jsp?orderStatus='");
//		forward.setPath("/admin/order/order_comp_list.jsp?type=" + orderStatus);

		
		return forward;
	}

}
