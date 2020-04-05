package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	public OrderBean selectOrder(int num) {
		return null;
	}

	public int updateReadcount(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	//mypage
	public ArrayList<OrderBean> getOrderList(String uId) { // 아이디별 주문목록 가져오기
		System.out.println("OrderDAO.getOrderList(uId)");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderBean> orderList = null;

		try {

			String sql = 
							  "select tb.orderNum,tb.order_ID,orderD.bookEA,tb.orderTime,tb.orderStatus,tb.orderAddress,book.bookID,book.bookTitle,book.bookOriginImage,book.bookPublisher,book.bookPrice,\n" + 
							  "user.u_name,user.address2,user.phone_num,user.tell_num,user.email,\n" + 
							  "cp.coupon_name,coponH.couponStatus,\n" + 
							  "tb.orderRec\n" + 
							  "from order_detail orderD join book book\n" + 
							  "on orderD.bookID = book.bookID\n" + 
							  "join order_tb tb\n" + 
							  "on tb.orderNum = orderD.orderNum\n" + 
							  "join user user\n" + 
							  "on tb.order_ID = user.uID\n" + 
							  "join couponhistory coponH\n" + 
							  "on coponH.num = tb.couponHistory_num\n" + 
							  "join coupon cp\n" + 
							  "on coponH.cID = cp.cID\n" + 
							  "where tb.order_ID=?";

					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, uId);
					rs = pstmt.executeQuery();
					
					
					OrderBean orderBean = null;
					orderList = new ArrayList<OrderBean>();

			while (rs.next()) {

				 orderBean = new OrderBean(
						rs.getInt("orderNum"),
						rs.getString("order_ID"),
						rs.getInt("bookEA"),
						rs.getDate("orderTime"),
						rs.getString("orderStatus"),
						rs.getString("orderAddress"),
						rs.getInt("bookID"),
						rs.getString("bookTitle"),
						rs.getString("bookOriginImage"),
						rs.getString("bookPublisher"),
						rs.getInt("bookPrice"),
						rs.getString("u_name"),
						rs.getString("address2"),
						rs.getString("phone_num"),
						rs.getString("tell_num"),
						rs.getString("email"),
						rs.getString("coupon_name"),
						rs.getString("couponStatus"),
						rs.getString("orderRec"));
				orderList.add(orderBean);
			}
			
			
			for (int i = 0; i < orderList.size(); i++) {
				
				System.out.println(orderList.get(i).getOrderNum());
			}
//			
//			
//			sql="select * from pointhistory where ownerId=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, uId);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//			orderBean.setPointContent(rs.getString("pointContent"));
//			orderBean.setPointValue(rs.getInt("pointValue"));
			
//			     	}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return orderList;
		
	
	}
	
	
	
	

		//주문상세
	public OrderBean orderDetail(int orderNum) {
		System.out.println("OrderDAO.orderDetail(orderNum)");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		OrderBean orderBean = null;
		String uID=null;
		
		try {
			
			String sql=
					
					
					 "select tb.orderNum,tb.order_ID,orderD.bookEA,tb.orderTime,tb.orderStatus,tb.orderAddress,book.bookID,book.bookTitle,book.bookOriginImage,book.bookPublisher,book.bookPrice,\n" + 
							  "user.u_name,user.address2,user.phone_num,user.tell_num,user.email,\n" + 
							  "cp.coupon_name,coponH.couponStatus,\n" + 
							  "point.pointAction,point.pointContent,point.pointRegTime,point.pointValue,tb.orderRec\n" + 
							  "from order_detail orderD join book book\n" + 
							  "on orderD.bookID = book.bookID\n" + 
							  "join order_tb tb\n" + 
							  "on tb.orderNum = orderD.orderNum\n" + 
							  "join user user\n" + 
							  "on tb.order_ID = user.uID\n" + 
							  "join couponhistory coponH\n" + 
							  "on coponH.num = tb.couponHistory_num\n" + 
							  "join coupon cp\n" + 
							  "on coponH.cID = cp.cID\n" + 
							  "join pointhistory point\n" + 
							  "on point.ownerID = user.uID\n" + 
							  "where tb.orderNum=?";
			
								pstmt=con.prepareStatement(sql);
								pstmt.setInt(1,orderNum);
								rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				orderBean=new OrderBean(

						rs.getInt("orderNum"),
						rs.getString("order_ID"),
						rs.getInt("bookEA"),
						rs.getDate("orderTime"),
						rs.getString("orderStatus"),
						rs.getString("orderAddress"),
						rs.getInt("bookID"),
						rs.getString("bookTitle"),
						rs.getString("bookOriginImage"),
						rs.getString("bookPublisher"),
						rs.getInt("bookPrice"),
						rs.getString("u_name"),
						rs.getString("address2"),
						rs.getString("phone_num"),
						rs.getString("tell_num"),
						rs.getString("email"),
						rs.getString("coupon_name"),
						rs.getString("couponStatus"),
						rs.getBoolean("pointAction"),
						rs.getString("pointContent"),
						rs.getDate("pointRegTime"),
						rs.getInt("pointValue"),
						rs.getString("orderRec"));
						
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return orderBean;
		


    }	
	

}
