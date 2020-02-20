package admin.sales.svc;

import dao.MemberDAO;
import dao.OrderDAO;
import vo.MemberBean;
import vo.OrderBean;

public class OrderListService {

	public OrderBean getOrder(int num) {
		System.out.println("OrderListService - getOrder");
		
//		OrderDAO orderDAO = OrderDAO.getInstance();
		
		OrderBean order = null;
//		order = orderDAO.selectOrder(num);
		
		
		return order;	
		}

}
