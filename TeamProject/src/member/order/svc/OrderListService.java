package member.order.svc;
import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDAO;
import vo.OrderBean;


public class OrderListService {

	public ArrayList<OrderBean> getOrderList(String uId) {
		
		System.out.println("OrderListService.getOrderList");
		
		
		
		 Connection con = getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setConnection(con);
		
		ArrayList<OrderBean> list = dao.getOrderList(uId);
		
	
		
		close(con);
		
		return list;
		
		
		
		
	}
//
//	public List<OrderBean> getOrderCP(String uId) {
//		System.out.println("OrderListService.getOrderCP");
//
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		ArrayList<OrderBean> orderListCP= null;
//		
//		
//		
//	
//		
//		 Connection con = getConnection();
//		OrderDAO dao = OrderDAO.getInstance();
//		dao.setConnection(con);
//		return dao.getOrderListCP(uId);
//	}
//	
//	

	public List<OrderBean> orderList() {
		System.out.println("OrderListService - orderList");
		
		 Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		
		List<OrderBean> orderList = orderDAO.orderList();
//		System.out.println("orderList : " + orderList);
		close(con);
		return orderList;		
	}

}
