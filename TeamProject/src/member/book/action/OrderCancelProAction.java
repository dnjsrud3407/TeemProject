package member.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.book.svc.OrderCancelProService;
import vo.ActionForward;

public class OrderCancelProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		System.out.println("OrderCancelProAction");
		
		OrderCancelProService  orderCancelProService = new OrderCancelProService();
	
		
		
		forward = new ActionForward(); 
		forward.setPath("OrderList.mb");
		forward.setRedirect(true);
		

		return forward;
	}

}
