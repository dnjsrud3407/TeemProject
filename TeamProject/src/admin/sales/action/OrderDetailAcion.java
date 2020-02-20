package admin.sales.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;
import vo.OrderBean;

public class OrderDetailAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberDetailAcion");
//		int num = Integer.parseInt(request.getParameter("num"));
//		String page = request.getParameter("page");
//				
//		OrderDetailService orderDetailService = new OrderDetailService();
//		OrderBean book = orderDetailService.getOrder(num);
		
//		if(book != null) {
//			reviewDetailService.plusReadcount(board_num);
//		}
		
//		request.setAttribute("book", book);
//		request.setAttribute("page", page);

		ActionForward forward = null;
		
		forward = new ActionForward();
		forward.setPath("./admin/order/order_detail.jsp");
		
		return forward;
	}

}
