package admin.sales.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import dao.OrderDAO;
import vo.OrderBean;

public class OrderCompListService {


	public List<OrderBean> orderComplList(OrderBean orderStatus) {
		System.out.println("OrderListService - orderList");
		
		 Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		
		List<OrderBean> orderList = orderDAO.orderComplList(orderStatus);
	//	System.out.println("orderList : " + orderList);
		close(con);
		return orderList;	
	}


}
