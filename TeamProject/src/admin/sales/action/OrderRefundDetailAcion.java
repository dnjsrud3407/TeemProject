package admin.sales.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;


public class OrderRefundDetailAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OrderRefundDetailAcion");
//		int num = Integer.parseInt(request.getParameter("num"));
//		String page = request.getParameter("page");
//				
//		OrderRefundDetailService orderRefundDetailService = new OrderRefundDetailService();
//		OrderBean order = orderRefundDetailService.getOrder(num);
////		
//		if(book != null) {
//			orderRefundDetailService.plusReadcount(board_num);
//		}
		
//		request.setAttribute("book", book);
//		request.setAttribute("page", page);

		ActionForward forward = null;
		
		forward = new ActionForward();
		forward.setPath("./admin/order/order_refund_detail.jsp");
		
		return forward;
	}

}
