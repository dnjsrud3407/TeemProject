package member.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.book.svc.ExchangeFormService;
import vo.ActionForward;

public class ExchangeFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ActionForward forward = null;
		System.out.println("ExchangeFormAction");
		
		
		ExchangeFormService memberBoardExchangeFormService = new ExchangeFormService();
		
		
		
		
		forward = new ActionForward();
		forward.setPath("/member/OrderExchangeForm.jsp");
		return forward;
	}

}
