package member.order.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.order.svc.OrderDetailService;
import vo.ActionForward;
import vo.MemberBean;
import vo.OrderBean;

public class OrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("OrderDetailAction");
		
		HttpSession session=request.getSession();
		String uId=(String) session.getAttribute("uID");
		String orderNum=request.getParameter("orderNum");
		
//		System.out.println("가져온 주문번호"+orderNum);
		
		OrderDetailService orderDetailService = new OrderDetailService();
		
		
		ArrayList<OrderBean> orderDetailList=orderDetailService.orderDetail(orderNum);
		List<OrderBean> orderDetailList2 = new ArrayList<OrderBean>();//포인트가져오는 
		orderDetailList2=orderDetailService.getMypagePointInfo(uId);
		MemberBean memberBean = orderDetailService.getCouponInfo(uId,orderNum);

//		int bookPrice=orderBean.getBookPrice();
//		int orderEA=orderBean.getBookEA(); 
//		int pointValue=orderBean.getPointValue();
//		int deliveryCost=2500; //배송비 고정

		
//		int total=bookPrice*orderEA-pointValue+deliveryCost;
		
//		if (total>=10000) {
//			total=-2500;
//		}
		
		
		//쿠폰에 대해 지정된게 없으므로,
		//여기서 if (각 쿠폰이름) {총 금액에서 -} 따로 지정
		//지금은 포인트만 했음
		String pointOrderNum="";
		int point=0;
		int total = 0;
		int ea=0;
		int price=0;
		int couponsale=0;
	
		//총 금액을 계산하기 위해서
		for (OrderBean orderBean : orderDetailList) {
			
			for (OrderBean orderBean2 : orderDetailList2) {
				System.out.println("orderBean2    : "+orderBean2.getOrderNum()); //포인트
				System.out.println("orderBean     : "+orderBean.getOrderNum());
//						
//				if(orderBean2.getOrderNum().equals(orderBean.getOrderNum())) {
//					point=orderBean2.getPointValue();
//					System.out.println("포인트사용함"+point);
//				}else {
//					System.out.println("포인트사용안함"+point);
//					point=0;
//				} 
				
			};	
			
			ea=orderBean.getBookEA();
			price=orderBean.getBookPrice();
			//쿠폰 volum를 가져오지않았음 수정할것
			couponsale=orderBean.getVolume();
			System.out.println("쿠폰금액가져오기"+couponsale);
			System.out.println("포인트금액가져오기"+point);
			total+=(ea*price)-point-couponsale;
			System.out.println(total);
		};
		
		request.setAttribute("couponInfo",memberBean);//쿠폰
		request.setAttribute("orderDetailList",orderDetailList);
		request.setAttribute("total", total);
		request.setAttribute("orderDetailList2", orderDetailList2); //포인트표시
		
		
		

		forward = new ActionForward();
		forward.setPath("/member/OrderDetail.jsp");
		return forward;
	}

}
