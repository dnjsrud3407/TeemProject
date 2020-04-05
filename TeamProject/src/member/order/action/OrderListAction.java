package member.order.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.order.svc.OrderListService;
import vo.ActionForward;
import vo.OrderBean;

public class OrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("ddddddddddddOrderListAction");
		
		
		HttpSession session=request.getSession();
		String uId=(String) session.getAttribute("uID");
//		System.out.println("리시트액션에서 찍은 세션아이디"+uId);

		OrderListService orderListService= new OrderListService();
		
	
		
		List<OrderBean> orderList = new ArrayList<OrderBean>();
		orderList=orderListService.getOrderList(uId);
		//주문목록 액션 페이지
		//마이페이지를 누르면 주문목록페이지가 뜬다tg5
		
		int bookPrice=0;
		int orderEA=0;
		int pointValue=0;
		int deliveryCost=2500; //배송비 고정
		int total = 0;
		
			
			for (int i = 0; i < orderList.size(); i++) {
				 bookPrice=orderList.get(i).getBookPrice();
				 orderEA=orderList.get(i).getBookEA();
				 pointValue=orderList.get(i).getPointValue();
				 System.out.println(bookPrice+","+orderEA+","+pointValue);
				 total=bookPrice*orderEA-pointValue+deliveryCost;
				 System.out.println("총금액"+total);
//				 if (total>=10000) {
//					 total=(total-2500);
//					 System.out.println("총금액2"+total);
//				 }
				 request.setAttribute("total", total);
				 
			}
		
			request.setAttribute("orderList",orderList);
		
		
		

		forward = new ActionForward();
		forward.setPath("mypage.jsp");
		return forward;
	
	}

}
