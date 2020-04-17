package member.order.svc;
import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.OrderDAO;
import vo.OrderBean;

public class OrderDetailService {

	public ArrayList<OrderBean> orderDetail(int orderNum) {
		
		//디비연결
		System.out.println("OrderDetailService.orderDetail(int orderNum)");
		
		Connection con = getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setConnection(con);

		ArrayList<OrderBean> list = dao.orderDetail(orderNum);
		
		
		
		close(con);
	
		return list;
				
		
	}

}
