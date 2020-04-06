package member.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.order.svc.OrderDetailService;
import vo.ActionForward;
import vo.OrderBean;

public class OrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("OrderDetailAction");
		
		int orderNum=Integer.parseInt(request.getParameter("orderNum"));
		
		System.out.println("가져온 주문번호"+orderNum);
		
		OrderDetailService orderDetailService = new OrderDetailService();
		
		
		OrderBean orderBean=orderDetailService.orderDetail(orderNum);
		

		int bookPrice=orderBean.getBookPrice();
		int orderEA=orderBean.getBookEA(); 
		int pointValue=orderBean.getPointValue();
		int deliveryCost=2500; //배송비 고정

		//만원이상 결제시 배송비 무료?
		
		int total=bookPrice*orderEA-pointValue+deliveryCost;
		
		if (total>=10000) {
			total=-2500;
		}
		
		
		//쿠폰에 대해 지정된게 없으므로,
		//여기서 if (각 쿠폰이름) {총 금액에서 -} 따로 지정
		//지금은 포인트만 했음
		
		
		request.setAttribute("orderBean",orderBean);
		request.setAttribute("total", total);
		
		
		

		forward = new ActionForward();
		forward.setPath("/member/OrderDetail.jsp");
		return forward;
	}

}
