package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.MemberBean;
import vo.OrderBean;
import vo.OrderDetailBean;

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
			String orderNum="";

			try {
				String sql = 
								  "select * from order_detail orderD join book book \n"+ 
								  "on orderD.bookID = book.bookID\n"+ 
								  "join order_tb tb\n"+ 
								  "on tb.orderNum = orderD.orderNum\n"+ 
								  "join user user\n"+ 
								  "on tb.order_ID = user.uID\n"+ 
								  "join couponhistory coponH\n"+ 
								  "on coponH.num = tb.couponHistory_num \n" + 
								  "join coupon cp\n"+ 
								  "on coponH.cID = cp.cID\n"+ 
								  "where tb.order_ID=?";

						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, uId);
						rs = pstmt.executeQuery();
						
						OrderBean orderBean = null;
						orderList = new ArrayList<OrderBean>();

				while (rs.next()) {

					 orderBean = new OrderBean(
							rs.getString("orderNum"),
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
							rs.getString("orderRec"),
							rs.getInt("orderDetailCode"),
							rs.getInt("bookKategorie_BKID"),
							rs.getString("paymentType"),
							rs.getString("bookIntroduce"),
							rs.getFloat("saveRatio"),
							rs.getInt("volume"),
							rs.getInt("couponAction")
							 );
					orderList.add(orderBean);
				}
				
				
				for (int i = 0; i < orderList.size(); i++) {
					
					System.out.println(orderList.get(i).getOrderNum());
				}

					
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			return orderList;
			
		
		}
	
		//mypage에 표시할 포인트를 따로 조회
		public ArrayList<OrderBean> getMypagePointInfo(String uId) {
			System.out.println("OrderDAO.getMypagePointInfo(String uId)");
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<OrderBean> orderList2 = null;
			
			try {
				String sql ="select * from pointhistory where ownerID=?";
									pstmt=con.prepareStatement(sql);
									pstmt.setString(1,uId);
									rs = pstmt.executeQuery();
									
									
									orderList2 = new ArrayList<OrderBean>();
									OrderBean orderBean = null;
				while(rs.next()) {
					orderBean=new OrderBean(
							rs.getInt("pID"),
							rs.getString("ownerID"),
							rs.getDate("pointRegTime"),
							rs.getString("pointContent"),
							rs.getInt("pointValue"),
							rs.getInt("pointAction"),
							rs.getString("orderNum")
							);
					orderList2.add(orderBean);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rs);
			}
			return orderList2;
	    }


	
	//주문상세
public ArrayList<OrderBean> orderDetail(int orderNum) {
	System.out.println("OrderDAO.orderDetail(orderNum)");
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<OrderBean> orderList = null;
	OrderBean orderBean = null;
	String uID=null;
	
	try {
		String sql=
				 "select *\n" + 
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
						  "where tb.orderNum=? group by orderD.orderDetailCode";
		
							pstmt=con.prepareStatement(sql);
							pstmt.setInt(1,orderNum);
							rs = pstmt.executeQuery();
		
							orderList = new ArrayList<OrderBean>();

		while(rs.next()) {
			orderBean=new OrderBean(

					rs.getString("orderNum"),
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
					rs.getInt("pointAction"),
					rs.getString("pointContent"),
					rs.getDate("pointRegTime"),
					rs.getInt("pointValue"),
					rs.getString("orderRec"),
					rs.getInt("orderDetailCode"),
					rs.getInt("bookKategorie_BKID"),
					rs.getString("paymentType"),
					rs.getString("bookIntroduce"),
					rs.getFloat("saveRatio"),
					rs.getInt("volume"),
					rs.getInt("couponAction"),
					rs.getInt("totalPrice")
					);
					
			orderList.add(orderBean);
			for (OrderBean orderBean2 : orderList) {
		
				System.out.println(		"결제타입 가져오기"+orderBean2.getPaymentType());
			}
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
		close(rs);
	}
	return orderList;

}	

	
	
	
//OrderDetail 테이블의 OrderDetailNum으로 판별하는 주문상세
public OrderBean orderVeryDetail(int orderDetailNum) {
	System.out.println("OrderDAO.orderDetail(orderNum)");
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	OrderBean orderBean = null;
	
	try {
		String sql=
				 "select *\n"+ 
				 "from order_detail orderD join book book\n"+ 
				 "on orderD.bookID = book.bookID\n"+ 
				 "join order_tb tb\n" + 
				 "on tb.orderNum = orderD.orderNum\n"+ 
				 "join user user\n"+ 
				 "on tb.order_ID = user.uID\n"+ 
				 "join couponhistory coponH\n"+ 
				 "on coponH.num = tb.couponHistory_num \n"+ 
				 "join coupon cp\n"+ 
				 "on coponH.cID = cp.cID\n"+ 
				 "join pointhistory point\n"+ 
				 "on point.ownerID = user.uID\n"+ 
				 "where orderD.orderDetailCode=?";
		
							pstmt=con.prepareStatement(sql);
							pstmt.setInt(1,orderDetailNum);
							rs = pstmt.executeQuery();
		while(rs.next()) {
			orderBean=new OrderBean(
					rs.getString("orderNum"),
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
					rs.getInt("pointAction"),
					rs.getString("pointContent"),
					rs.getDate("pointRegTime"),
					rs.getInt("pointValue"),
					rs.getString("orderRec"),
					rs.getInt("orderDetailCode"),
					rs.getInt("bookKategorie_BKID"),
					rs.getString("paymentType"),
					rs.getString("bookIntroduce"),
					rs.getFloat("saveRatio"),
					rs.getInt("volume"),
					rs.getInt("couponAction"),
					rs.getInt("totalPrice")
					);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
		close(rs);
	}
	return orderBean;

}	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//mypage = 주문목록 검색하기
	public ArrayList<OrderBean> getOrderList(String startDate, String endDate, String uId) { // 아이디별 주문목록 가져오기
		System.out.println("OrderDAO.getOrderList(String startDate, String endDate, String uId)");
		System.out.println(startDate+","+endDate);

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderBean> orderList = null;

		try {
			String sql = 
							  "select *\n" + 
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
							  "where tb.order_ID=? and tb.orderTime >=? and tb.orderTime <= date_add(?,interval 1 day)";
			
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, uId);
					pstmt.setString(2, startDate);
					pstmt.setString(3, endDate);
					rs = pstmt.executeQuery();
					
					OrderBean orderBean = null;
					orderList = new ArrayList<OrderBean>();

			while (rs.next()) {

				orderBean = new OrderBean(
						rs.getString("orderNum"),
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
						rs.getString("orderRec"),
						rs.getInt("orderDetailCode"),
						rs.getInt("bookKategorie_BKID"),
						rs.getString("paymentType"),
						rs.getString("bookIntroduce"),
						rs.getFloat("saveRatio"),
						rs.getInt("volume"),
						rs.getInt("couponAction")
						)
						 ;
				orderList.add(orderBean);
			}
			
			if (rs.next()==false) {
				System.out.println("가져올 데이터 없음");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return orderList;
	}


		
		//주문 상태변경
		public int updateOrderStatus(int orderNum, String changeOrderStatus) {
			int right=0;
			String sqlchange = "";
			PreparedStatement pstmt = null;
			
			if (changeOrderStatus=="반품") {
				sqlchange="반품";
				System.out.println("DAO 반품신청");
			}else if(changeOrderStatus=="교환") {
				sqlchange="교환";
				System.out.println("DAO 교환신청");
			}else if(changeOrderStatus=="취소") {
				sqlchange="취소";
				System.out.println("DAO 취소신청");
			}else if(changeOrderStatus=="확정") {
				sqlchange="확정";
				System.out.println("DAO 확정신청");
			};
			

			try {
				String sql = "update order_tb set orderStatus=? where orderNum=?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,sqlchange);//관리자는 반품처리해줘야함
				pstmt.setInt(2,orderNum);
				right = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return right;
		}

		public int insertOrder(OrderBean orderBean) {
			int insertCount = 0;
			PreparedStatement pstmt = null;
			
			String sql = "INSERT INTO order_tb(orderNum, order_ID, orderRec, orderAddress, orderTime, "
					+ "orderStatus, lastModTime, paymentType, couponHistory_num, totalPrice) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, orderBean.getOrderNum()); pstmt.setString(2, orderBean.getOrder_ID());
				pstmt.setString(3, orderBean.getOrderRec()); pstmt.setString(4, orderBean.getAddress2());
				pstmt.setTimestamp(5, new Timestamp(orderBean.getOrderTime().getTime()));
				pstmt.setString(6, orderBean.getOrderStatus());
				pstmt.setTimestamp(7, new Timestamp(orderBean.getLastModTime().getTime()));
				pstmt.setString(8, orderBean.getPaymentType());
				if(orderBean.getCoupon_num() > 0) {pstmt.setInt(9, orderBean.getCoupon_num());} else {pstmt.setNull(9, Types.INTEGER); } 
				pstmt.setInt(10, orderBean.getTotalPrice());
				
				int order_tb_count = pstmt.executeUpdate();
				
				if(order_tb_count > 0) {
					sql = "INSERT INTO order_detail(bookID, orderNum, bookTitle, bookPrice, bookEA) "
						+ "VALUES(?, ?, ?, ?, ?)";
					int order_detail_count = 0;
					for(OrderDetailBean orderDetail : orderBean.getOrderList()) {
						pstmt = con.prepareStatement(sql);
						
						pstmt.setInt(1, orderDetail.getBookID()); pstmt.setString(2, orderDetail.getOrderNum());
						pstmt.setString(3, orderDetail.getBookTitle()); pstmt.setInt(4, orderDetail.getBookPrice());
						pstmt.setInt(5, orderDetail.getBookEA());
						
						order_detail_count += pstmt.executeUpdate();
					}
					if(order_detail_count == orderBean.getOrderList().size()) {
						insertCount = 1;
					}
				
				}
				
				if(insertCount > 0) {
					sql = "UPDATE user SET address2=? WHERE uID=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, orderBean.getAddress2()); pstmt.setString(2, orderBean.getOrder_ID());
					
					insertCount = pstmt.executeUpdate();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return insertCount;
		}

		public int updateBookEA(List<OrderDetailBean> orderList) {
			// TODO Auto-generated method stub
			PreparedStatement pstmt = null;
			int updateBookCount = 0;
			
			String sql ="UPDATE book SET bookEA=bookEA-?, salesVolume=salesVolume+? WHERE bookID=?";
			
			try {
				for(OrderDetailBean orderDetailBean : orderList) {
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, orderDetailBean.getBookEA()); pstmt.setInt(2, orderDetailBean.getBookEA());
					pstmt.setInt(3, orderDetailBean.getBookID());
					
					updateBookCount += pstmt.executeUpdate();
				}
				if(updateBookCount != orderList.size()) {
					updateBookCount = 0;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return updateBookCount;
		}

		public int couponUpdate(int coupon_num, String id) {
			PreparedStatement pstmt = null;
			int couponUpdateCount = 0;
			
			String sql ="UPDATE couponHistory SET couponStatus=? WHERE cID=? AND uID=?";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "used"); pstmt.setInt(2, coupon_num); pstmt.setString(3, id);
				
				couponUpdateCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return couponUpdateCount;
		}


		public int setPointHistory(String id, int usedPoint, int totalPrice, String orderNum) {
			PreparedStatement pstmt = null;
			int setPointHistoryCount = 0;
			String sql ="";
			int changedPoint = 0;
			
			// pointAction  사용은 0 / 적립은 1
			try {
				sql = "INSERT INTO pointHistory(ownerID, pointRegTime, pointContent, pointValue, pointAction, orderNum) VALUES(?, now(), ?, ?, ?, ?)";
				if(usedPoint != 0) { // 사용 포인트가 0이 아닐 때
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id); pstmt.setString(2, "상품 금액 차감"); pstmt.setInt(3, usedPoint); pstmt.setInt(4, 0); // 사용
					pstmt.setString(5, orderNum);
				
					setPointHistoryCount = pstmt.executeUpdate();
					if(setPointHistoryCount > 0) {
						changedPoint = -usedPoint;
						setPointHistoryCount = 0;
					} else {
						return 0;
					}
					
				}
				
				int savedPoint = (int)(totalPrice * 0.05);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id); pstmt.setString(2, "상품 구매 적립"); pstmt.setInt(3, savedPoint); // 일괄 5퍼센트 적립
				pstmt.setInt(4, 1); // 적립
				setPointHistoryCount = pstmt.executeUpdate();
				if(setPointHistoryCount > 0) {
					changedPoint += savedPoint;
					setPointHistoryCount = 0;
				} else {
					return 0;
				}
				
				sql = "UPDATE user SET point=point+? WHERE uID=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, changedPoint); pstmt.setString(2, id);
				
				setPointHistoryCount = pstmt.executeUpdate();
				if(setPointHistoryCount > 0) {
				} else {
					return 0;
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return setPointHistoryCount;
		}

		public List<OrderBean> orderList() {
			System.out.println("OrderDAO - orderList()");
			List<OrderBean> list = new ArrayList();
			List<OrderBean> listDetail = new ArrayList();
			List<OrderBean> list2 = new ArrayList();

			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			
			try {
				String sql = "select orderTime, orderNum, order_ID, paymentType, orderStatus from order_tb";
//				String sql = "select * from order_tb";

				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					OrderBean ob = new OrderBean();
					ob.setOrderTime(rs.getDate("orderTime"));
					ob.setOrderNum(rs.getString("orderNum"));
					ob.setOrder_id(rs.getString("order_ID"));				
//					ob.setBookPrice(rs.getInt("bookPrice")); 
					ob.setPaymentType(rs.getString("paymentType"));
					ob.setOrderStatus(rs.getString("orderStatus"));
//					
//					ob.setOrderRec(rs.getString("orderRec"));				
//					ob.setOrderAddress(rs.getString("orderAddress"));				
//					ob.setLastModTime(rs.getDate("lastModTime"));				
//					ob.setCouponHistory_num(rs.getInt("couponHisstory_num"));				


					sql = "select * from order_detail where orderNum=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, rs.getString("orderNum"));
					rs2 = pstmt.executeQuery();
					
					int totalBook=0;
					
					while (rs2.next()) {
						
						totalBook+=rs2.getInt("bookPrice")*rs2.getInt("bookEA");
						
					}
					ob.setBookPrice(totalBook);
				
					list.add(ob);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
			
			return list;
		}
		
		//주문한 책 목록 불러오기
		public List<OrderBean> selectOrder(String orderNum) {
			System.out.println("OrderDAO - orderList()");
			List<OrderBean> order = new ArrayList<OrderBean>();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "select * from order_detail WHERE orderNum=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, orderNum);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					OrderBean orderBean = new OrderBean();
					orderBean.setOrderDetailCode(rs.getInt("orderDetailCode"));
					orderBean.setbookID(rs.getInt("bookID"));
//					order.setBookKategorie_BKID(rs.getInt("bookKategorie_BKID"));
					orderBean.setOrderNum(rs.getString("orderNum"));
					orderBean.setBookTitle(rs.getString("bookTitle"));
					orderBean.setBookPrice(rs.getInt("bookPrice"));
					orderBean.setBookEA(rs.getInt("bookEA"));
//					order.setPaymentType(rs.getString("paymentType"));
					order.add(orderBean);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}

			return order;
		}	
	
		//주문상세내용조회
		public OrderBean orderDetaile(String orderNum) {
			System.out.println("OrderDAO - orderList()");
			OrderBean orderDe = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "select * from order_tb WHERE orderNum=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, orderNum);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					orderDe = new OrderBean();
					orderDe.setOrderNum(rs.getString("orderNum"));
					orderDe.setOrder_id(rs.getString("order_ID"));	
					orderDe.setOrderRec(rs.getString("orderRec"));				
					orderDe.setOrderAddress(rs.getString("orderAddress"));				
					orderDe.setOrderTime(rs.getDate("orderTime"));
					orderDe.setOrderStatus(rs.getString("orderStatus"));
					orderDe.setLastModTime(rs.getDate("lastModTime"));				
					orderDe.setPaymentType(rs.getString("paymentType"));
					orderDe.setCouponHistory_num(rs.getInt("couponHistory_num"));				
					orderDe.setTotalPrice(rs.getInt("totalPrice"));				
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}

			return orderDe;
		}

		public int updateOrder(OrderBean order) {
			int updateCount = 0;
			
			PreparedStatement pstmt = null;

			try {
//				String sql = "UPDATE board SET board_name=?,board_subject=?,board_content=? WHERE board_num=?";
				String sql = "UPDATE order_tb SET orderStatus=? WHERE order_ID=?";
				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, article.getBoard_name());
				pstmt.setString(1, order.getOrderStatus());
				pstmt.setString(2, order.getOrder_ID());

				updateCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return updateCount;

		}

}