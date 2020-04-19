package member.book.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.OrderDAO;
import vo.OrderBean;

public class BookBuyProService {

	public int insertOrder(OrderBean orderBean) {
		Connection con = null;
		con = getConnection();
		
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		//
		int updateCount = orderDAO.insertOrder(orderBean);
		
		if(updateCount > 0) {
			int updateBookCount = orderDAO.updateBookEA(orderBean.getOrderList());
			if(updateBookCount > 0) {
				commit(con);
			} else {
				rollback(con);
			}
			
		} else {
			rollback(con);
		}
		
		//
		close(con);
		
		return updateCount;
	}

}
