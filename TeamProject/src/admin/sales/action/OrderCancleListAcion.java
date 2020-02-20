package admin.sales.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;
import vo.OrderBean;

public class OrderCancleListAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OrderCencleListAcion");
		
//		int num = Integer.parseInt(request.getParameter("num"));
//
//		OrderCancelListService orderCancelListService = new OrderCancelListService();
//		OrderBean order = orderCancelListService.getOrder(num);
//		
		ActionForward action = new ActionForward();
		action.setPath("./admin/order/order_cancel_list.jsp");
		
		return action;
	}

}
