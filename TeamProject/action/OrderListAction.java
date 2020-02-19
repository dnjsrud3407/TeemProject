package member.account.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.action.Action;
import member.account.svc.OrderListService;
import vo.ActionForward;

public class OrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("OrderListAction");
		
		OrderListService memberBoardOrderListService= new OrderListService();
		
		

		forward = new ActionForward();
		forward.setPath("member/OrdList.jsp");
		return forward;
	
	}

}
