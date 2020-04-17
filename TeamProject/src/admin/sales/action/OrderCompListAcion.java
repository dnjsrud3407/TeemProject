package admin.sales.action;

import java.util.ArrayList;

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
		String uId = request.getParameter("order_ID");
		
		//삭제필요한지확인
//		admin.sales.svc.OrderListService mind = null;
		
	
		OrderListService orderListService = new OrderListService();
		ArrayList<OrderBean> orderList = orderListService.getOrderList(uId);
 
		request.setAttribute("orderList", orderList);
		
		forward = new ActionForward();
		forward.setPath("/admin/order/order_comp_list.jsp");
		
		return forward;
	}

}
