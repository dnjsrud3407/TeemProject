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

	// 메인에서 주문현황 들고옴
	public int getOrderCount(String orderStatus) {
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		
		int orderCount = orderDAO.getOrderCount(orderStatus);
		
		close(con);
		return orderCount;
	}

	// 메인에서 사용할 결제완료 매출
	public int orderComplList(String orderStatus) {
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		
		int cashe = orderDAO.orderComplList(orderStatus);

		close(con);
		return cashe;
	}



}
