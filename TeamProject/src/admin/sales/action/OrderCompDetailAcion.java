package admin.sales.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.sales.svc.OrderCompDetailService;
import vo.ActionForward;
import vo.OrderBean;

public class OrderCompDetailAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OrderCompDetailAcion");
//		int num = Integer.parseInt(request.getParameter("num"));
//		String page = request.getParameter("page");
//				
//		OrderCompDetailService orderCompDetailService = new OrderCompDetailService();
//		OrderBean order = orderCompDetailService.getOrder(num);
////		
//		if(book != null) {
//			orderCompDetailService.plusReadcount(board_num);
//		}
		
//		request.setAttribute("book", book);
//		request.setAttribute("page", page);

		ActionForward forward = null;
		
		forward = new ActionForward();
		forward.setPath("./admin/order/order_comp_detail.jsp");
		
		return forward;
	}

}
