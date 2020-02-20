package dao;

import java.sql.Connection;

import vo.MemberBean;
import vo.OrderBean;

public class OrderDAO {
public OrderDAO() {}
	
	private static OrderDAO instance = new OrderDAO();

	public static OrderDAO getInstance() { 
		return instance;
	}
	// ----------------------------------------------------
	Connection con;

	public OrderBean selectOrder(int num) {
		return null;
	}

	public int updateReadcount(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
