package member.order.svc;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.OrderDAO;
import vo.OrderBean;

public class OrderDetailService {

	public OrderBean orderDetail(int orderNum) {
		
		//디비연결
		System.out.println("OrderDetailService.orderDetail(int orderNum)");
		
		Connection con = getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setConnection(con);

		return dao.orderDetail(orderNum);
		
	}

}
