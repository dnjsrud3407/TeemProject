package vo;

import java.sql.Date;

public class OrderBean {
	
	public  OrderBean() {}

	
	
	int orderNum; //주문번호
	String order_ID; //주문자 아이디 
	String bookTitle;//책 이름                book 테이블
	int bookID; //상품번호        이거 order_detail 테이블
	int orderEA; //주문갯수                     order_detail 테이블
	String orderAddress; //주문자 주소
	Date orderTime; //주문시간
	String orderStatus; //주문상태
	Date lastModTime; //주문상태 바꾼시간
	int couponHistory_num; //쿠폰번호 
	String coupon_name;    //coupon 테이블
	
	int coupon_num;        //couponhistory 테이블 num
	
	String pointContent;   //pointhistory 테이블
	int pointValue;
	
	
	
	String bookOriginImage;
	String bookPublisher;
	int bookPrice;
	String u_name;
	String address2;
	String phone_num;
	String tell_num;
	String email;
	
	
	
//	--------------
//	orderNum
//	order_ID
	int bookEA;
//	orderTime
//	orderStatus
//	orderAddress
//	bookID
//	bookTitle
//	bookOriginImage
//	bookPublisher
//	bookPrice
//	u_name
//	address2
//	phone_num
//	tell_num
//	email
//	coupon_name
	String couponStatus;
	Boolean pointAction;
//	pointContent
	Date pointRegTime;
//	pointValue
	String orderRec; //수령인
	
	//mypage(orderList)
	public OrderBean(int orderNum, String order_id,String bookTitle,int bookID, int orderEA, String orderAddress, Date orderTime,
			String orderStatus, Date lastModTime, int couponHistory_num,String coupon_name,int bookPrice) {
		super();
		this.orderNum = orderNum;
		this.order_ID = order_id;
		this.bookTitle = bookTitle;
		this.bookID = bookID;
		this.orderEA = orderEA;
		this.orderAddress = orderAddress;
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
		this.lastModTime = lastModTime;
		this.couponHistory_num = couponHistory_num;
		this.coupon_name = coupon_name;
		this.bookPrice = bookPrice;
	}
	
	//orderDetail
	public OrderBean(int orderNum, String order_id,int orderEA,Date orderTime, String orderStatus,String orderAddress, 
			int bookID, String bookTitle,
			String bookOriginImage, String bookPublisher, int bookPrice,
			String u_name,String address2,String phone_num,String tell_num,String email)
	     {
		super();
		this.orderNum = orderNum;
		this.order_ID = order_id;
		this.orderEA = orderEA;
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
		this.orderAddress = orderAddress;
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.bookOriginImage = bookOriginImage;
		this.bookPublisher = bookPublisher;
		this.bookPrice = bookPrice;
		this.u_name = u_name;
		
		this.address2 = address2;
		this.phone_num = phone_num;
		this.tell_num = tell_num;
		this.email = email;
	}
	
	
	//수정후 mypage 의 orderlist 포인트는 아직 ㄴㄴ
	
	public OrderBean(int orderNum, String order_ID, int bookEA,Date orderTime,String orderStatus,
			String orderAddress,int bookID,String bookTitle,String bookOriginImage,String bookPublisher,
			int bookPrice,String u_name,String address2,String phone_num,String tell_num,String email,String coupon_name,
			String couponStatus,String orderRec)
	     {
		super();
		this.orderNum = orderNum;
		this.order_ID = order_ID;
		this.bookEA = bookEA;
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
		this.orderAddress = orderAddress;
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.bookOriginImage = bookOriginImage;
		this.bookPublisher = bookPublisher;
		this.bookPrice = bookPrice;
		this.u_name = u_name;
		
		this.address2 = address2;
		this.phone_num = phone_num;
		this.tell_num = tell_num;
		this.email = email;
		
		this.coupon_name = coupon_name;
		this.couponStatus = couponStatus;
//		this.pointAction = pointAction;
//		this.pointContent = pointContent;
//		this.pointRegTime = pointRegTime;
//		this.pointValue = pointValue;
		this.orderRec = orderRec;
	}
	
	
	//오버로딩 orderDetail
	public OrderBean(int orderNum, String order_ID, int bookEA,Date orderTime,String orderStatus,
			String orderAddress,int bookID,String bookTitle,String bookOriginImage,String bookPublisher,
			int bookPrice,String u_name,String address2,String phone_num,String tell_num,String email,String coupon_name,
			String couponStatus,Boolean pointAction,String pointContent,Date pointRegTime,int pointValue,String orderRec)
	     {
		super();
		this.orderNum = orderNum;
		this.order_ID = order_ID;
		this.bookEA = bookEA;
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
		this.orderAddress = orderAddress;
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.bookOriginImage = bookOriginImage;
		this.bookPublisher = bookPublisher;
		this.bookPrice = bookPrice;
		this.u_name = u_name;
		
		this.address2 = address2;
		this.phone_num = phone_num;
		this.tell_num = tell_num;
		this.email = email;
		
		this.coupon_name = coupon_name;
		this.couponStatus = couponStatus;
		this.pointAction = pointAction;
		this.pointContent = pointContent;
		this.pointRegTime = pointRegTime;
		this.pointValue = pointValue;
		this.orderRec = orderRec;
	}
	
	
	
	

	public String getOrder_ID() {
		return order_ID;
	}

	public void setOrder_ID(String order_ID) {
		this.order_ID = order_ID;
	}

	public int getBookEA() {
		return bookEA;
	}

	public void setBookEA(int bookEA) {
		this.bookEA = bookEA;
	}

	public String getCouponStatus() {
		return couponStatus;
	}

	public void setCouponStatus(String couponStatus) {
		this.couponStatus = couponStatus;
	}

	public Boolean getPointAction() {
		return pointAction;
	}

	public void setPointAction(Boolean pointAction) {
		this.pointAction = pointAction;
	}

	public Date getPointRegTime() {
		return pointRegTime;
	}

	public void setPointRegTime(Date pointRegTime) {
		this.pointRegTime = pointRegTime;
	}

	public String getOrderRec() {
		return orderRec;
	}

	public void setOrderRec(String orderRec) {
		this.orderRec = orderRec;
	}

	public String getBookTitle() {
		return bookTitle;
	}




	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}




	public String getCoupon_name() {
		return coupon_name;
	}


	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}


	public int getCoupon_num() {
		return coupon_num;
	}


	public void setCoupon_num(int coupon_num) {
		this.coupon_num = coupon_num;
	}


	public String getPointContent() {
		return pointContent;
	}


	public void setPointContent(String pointContent) {
		this.pointContent = pointContent;
	}


	public int getPointValue() {
		return pointValue;
	}


	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}





	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookOriginImage() {
		return bookOriginImage;
	}

	public void setBookOriginImage(String bookOriginImage) {
		this.bookOriginImage = bookOriginImage;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getTell_num() {
		return tell_num;
	}

	public void setTell_num(String tell_num) {
		this.tell_num = tell_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getOrder_id() {
		return order_ID;
	}
	public void setOrder_id(String order_ID) {
		this.order_ID = order_ID;
	}
	public int getbookID() {
		return bookID;
	}
	public void setbookID(int bookID) {
		this.bookID = bookID;
	}
	public int getOrderEA() {
		return orderEA;
	}
	public void setOrderEA(int orderEA) {
		this.orderEA = orderEA;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getLastModTime() {
		return lastModTime;
	}
	public void setLastModTime(Date lastModTime) {
		this.lastModTime = lastModTime;
	}
	public int getCouponHistory_num() {
		return couponHistory_num;
	}
	public void setCouponHistory_num(int couponHistory_num) {
		this.couponHistory_num = couponHistory_num;
	}
	
	
	


	
}
