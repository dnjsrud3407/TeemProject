package admin.sales.svc;

import java.sql.Connection;
import java.util.List;

import dao.MemberDAO;
import dao.OrderDAO;
import static db.JdbcUtil.*;
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
	
	public List<OrderBean> selectOrder(String orderNum) {
		System.out.println("OrderListService - orderBookTotal");
		
		 Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		
		List<OrderBean> order = orderDAO.selectOrder(orderNum);
				
		close(con);
		
		return order;
	}
}
