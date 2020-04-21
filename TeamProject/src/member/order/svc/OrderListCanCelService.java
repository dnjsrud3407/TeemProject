package member.order.svc;
import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDAO;
import vo.MemberBean;
import vo.OrderBean;


public class OrderListCanCelService {

	public ArrayList<OrderBean> getOrderCanCelList(String uId) {
		
		System.out.println("OrderListCanCelService.getOrderList");
		
		
		 Connection con = getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setConnection(con);
		
		ArrayList<OrderBean> list = dao.getOrderListCanCel(uId);
		
		
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


	public List<MemberBean> getCouponList(String uId) {
		System.out.println("OrderListService.getMypagePointInfo");
		 Connection con = getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setConnection(con);
		
		
		ArrayList<MemberBean> couponList=dao.getCouponList(uId);
		close(con);
		return couponList;
	}
	
	

}
