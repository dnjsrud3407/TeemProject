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


	public List<OrderBean> getMypagePointInfo(String uId) {
		System.out.println("OrderListService.getMypagePointInfo");
		 Connection con = getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setConnection(con);
		
		ArrayList<OrderBean> list2=dao.getMypagePointInfo(uId);
		
		close(con);
		return list2;
	}
	
	

}
