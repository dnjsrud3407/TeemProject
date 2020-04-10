package member.book.svc;

import java.sql.Connection;
import dao.CartDAO;

import static db.JdbcUtil.*;

public class CartRemoveService {

	public void cartRemove(int cartNum, String uID) {
		// TODO Auto-generated method stub
		int cartRemoveResult = 0;
		
		Connection con = getConnection();
		
		CartDAO cartDAO = CartDAO.getInstance();
		
		cartDAO.setConnection(con);
		
		cartRemoveResult = cartDAO.cartRemove(cartNum, uID);
				
		if (cartRemoveResult > 0) {
			commit(con);
					
		} else {
			rollback(con);			
		}

			close(con);

			
	}



}
