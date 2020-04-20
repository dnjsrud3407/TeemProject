package admin.sales.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.member.svc.MemberModifyProService;
import admin.sales.svc.OrderModifyProService;
import vo.ActionForward;
import vo.MemberBean;
import vo.OrderBean;

public class OrderModifyProAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OrderModifyProAcion");
		
		ActionForward forward = null;
		String uID = request.getParameter("uID");
		OrderModifyProService orderModifyProService = new OrderModifyProService();

		OrderBean order = new OrderBean();
//		order.setuID(uID);
		order.setOrderStatus(request.getParameter("orderStatus"));

//		System.out.println(member.getuID());
//
//		System.out.println(member.getPoint());
//		System.out.println(member.getGrade());
//
		boolean isModifySuccess = orderModifyProService.modifyOrder(order);
	
		if(!isModifySuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 실패!')");
			out.println("history.back()");
//			out.println("location.href='Login.me'");
			out.println("</script>");
		} else {
			
			forward = new ActionForward();
			forward.setPath("MemberDetail.adm?uID=" + uID);
			forward.setRedirect(true);
		}
//	}
	
	return forward;
	}

}
