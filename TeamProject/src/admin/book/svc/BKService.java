package admin.book.svc;

import java.sql.Connection;

import org.json.simple.JSONArray;

import dao.BookDAO;

import static db.JdbcUtil.*;


public class BKService {

	public JSONArray getBKList(String col, String type) {
		Connection con = getConnection();
		BookDAO bookDAO = BookDAO.getInstance();
		bookDAO.setConnection(con);
		
		JSONArray BKList = bookDAO.selectBKList(col, type);
		
		close(con);
		
		return BKList;
	}

}
