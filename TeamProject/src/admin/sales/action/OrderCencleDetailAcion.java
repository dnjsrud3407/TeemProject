package admin.sales.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.sales.svc.OrderCencelDetailService;
import vo.ActionForward;
import vo.OrderBean;

public class OrderCencleDetailAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OrderCencleDetailAcion");
//		int num = Integer.parseInt(request.getParameter("num"));
//		String page = request.getParameter("page");
//				
//		OrderCencelDetailService orderCencelDetailService = new OrderCencelDetailService();
//		OrderBean order = orderCencelDetailService.getOrder(num);
//		
//		if(book != null) {
//			orderCencelDetailService.plusReadcount(board_num);
//		}
		
//		request.setAttribute("book", book);
//		request.setAttribute("page", page);

		ActionForward forward = null;
		
		forward = new ActionForward();
		forward.setPath("./admin/order/order_cancel_detail.jsp");
		
		return forward;
	}

}
