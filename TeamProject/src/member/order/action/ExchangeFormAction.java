package member.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.order.svc.ExchangeFormService;
import vo.ActionForward;

public class ExchangeFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ActionForward forward = null;
		System.out.println("ExchangeFormAction");
		
		
		//OrderListAction Service와ㅏ 같음 아직수정하진않을것
		ExchangeFormService exchangeFormService = new ExchangeFormService();
		
		
		
		
		forward = new ActionForward();
		forward.setPath("/member/OrderExchangeForm.jsp");
		return forward;
	}

}
