package admin.sales.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;
import dao.OrderDAO;
import vo.OrderBean;

public class OrderModifyProService {

	public boolean modifyOrder(OrderBean order) {
		System.out.println("BoardModifyService - modifyMember");
		int updateCount = 0;
		boolean isModifySuccess = false;
		
		Connection con = getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setConnection(con);
		
		updateCount = dao.updateOrder(order);
				
		if(updateCount > 0) {
			commit(con);
			isModifySuccess = true;
		} else {
			rollback(con);
		}

		close(con);
		return isModifySuccess;
	}

}
