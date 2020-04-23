package admin.sales.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.sales.svc.OrderCompDetailModifyService;
import admin.sales.svc.OrderModifyProService;
import vo.ActionForward;
import vo.OrderBean;

public class OrderCompDetailModifyPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
System.out.println("OrderModifyProAcion");
		
		ActionForward forward = null;
		String orderNum = request.getParameter("orderNum");
		OrderCompDetailModifyService orderCompDetailModifyService = new OrderCompDetailModifyService();
//		OrderModifyProService orderModifyProService = new OrderModifyProService();

		OrderBean order = new OrderBean();
		order.setOrderNum(orderNum);
		order.setOrderStatus(request.getParameter("orderStatus"));
		System.out.println("getOrderNum : " + order.getOrderNum());
		System.out.println("DetailForm에서 가져온 getOrderStatus : " + order.getOrderStatus());
//      
//		boolean isModifySuccess = orderModifyProService.modifyOrder(order);
		boolean isModifySuccess = orderCompDetailModifyService.modifyOrder(order);
		
		System.out.println("isModifySuccess : " + isModifySuccess);
		if(!isModifySuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 실패!')");
			out.println("history.back()");
//			out.println("location.href='Login.me'");
			out.println("</script>");
			
		} else {
			
			System.out.println("OrderCompList.adm?orderStatus=" + order.getOrderStatus());
			String status = order.getOrderStatus();
			forward = new ActionForward();
//			forward.setPath("OrderCompList.adm?orderStatus=" + order.getOrderStatus());
			forward.setPath("OrderCompList.adm?orderStatus=" + status);
//			forward.setPath("OrderDetail.adm?orderNum=" + orderNum + "&orderStatus=" + request.getParameter("orderStatus"));
			forward.setRedirect(true);
		}
//	}
	
	return forward;
	}
	

}
