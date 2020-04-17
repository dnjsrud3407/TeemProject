package member.order.action;

import java.util.ArrayList;

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
		
		
		ArrayList<OrderBean> orderDetailList=orderDetailService.orderDetail(orderNum);
		

//		int bookPrice=orderBean.getBookPrice();
//		int orderEA=orderBean.getBookEA(); 
//		int pointValue=orderBean.getPointValue();
//		int deliveryCost=2500; //배송비 고정

		//만원이상 결제시 배송비 무료?
		
//		int total=bookPrice*orderEA-pointValue+deliveryCost;
		
//		if (total>=10000) {
//			total=-2500;
//		}
		
		
		//쿠폰에 대해 지정된게 없으므로,
		//여기서 if (각 쿠폰이름) {총 금액에서 -} 따로 지정
		//지금은 포인트만 했음
		
		int total = 0;
		int ea=0;
		int price=0;
		int couponsale=0;
		//총 금액을 계산하기 위해서
		for (OrderBean orderBean : orderDetailList) {
			ea=orderBean.getBookEA();
			price=orderBean.getBookPrice();
			//쿠폰 volum를 가져오지않았음 수정할것
			//saveRatio 이거는 뭐지? 
			couponsale=Integer.parseInt(orderBean.getVolume());
			total+=(ea*price)+2500-couponsale;
			System.out.println(total);
		};
		
		
		request.setAttribute("orderDetailList",orderDetailList);
		request.setAttribute("total", total);
		
		
		

		forward = new ActionForward();
		forward.setPath("/member/OrderDetail.jsp");
		return forward;
	}

}
