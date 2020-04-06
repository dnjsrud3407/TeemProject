package vo;

import java.sql.Date;

public class MemberBean {
	
	
	private String uID;
	private String pw;
	private String u_name;
	private String address;
	private String phone_num;
	private String email;
	private String tell_num; 
	private String address2;
	private int point;
	private int grade;
	private Date joinDate;
	

	//---쿠폰조회---
	private String coupon_name;
	private String couponStatus;
	private Date couponReg_date;
	private Date couponEnd_date;
	
//	포인트조회
	private int pointValue;
	private int pointAction; // tinyint 형 0 =false 1 = true
	private int pID;
	private String ownerID;
	private Date pointRegTime;
	private String pointContent;
	
	
	
	
	public MemberBean() {}
	
	public MemberBean(String uID, String pw) {
		super();
		this.uID = uID;
		this.pw = pw;
	}


	public MemberBean(String uID, String pw, String u_name, String address, String phone_num, String email,
			String tell_num, String address2, int point, int grade, Date joinDate) {
		super();
		this.uID = uID;
		this.pw = pw;
		this.u_name = u_name;
		this.address = address;
		this.phone_num = phone_num;
		this.email = email;
		this.tell_num = tell_num;
		this.address2 = address2;
		this.point = point;
		this.grade = grade;
		this.joinDate = joinDate;
	}
	
//---김봉주---------------------------------------------------
	
	
	//회원가입
	public MemberBean(String uID, String pw, String u_name, String address, String phone_num, String email,
			String tell_num, String address2, int point, int grade) {
		super();
		this.uID = uID;
		this.pw = pw;
		this.u_name = u_name;
		this.address = address;
		this.phone_num = phone_num;
		this.email = email;
		this.tell_num = tell_num;
		this.address2 = address2;
		this.point = point;
		this.grade = grade;
	}
	
	
	
	
	//회원정보 수정
	public MemberBean(String uID, String pw, String u_name, String address, String phone_num, String email,
			String tell_num, String address2) {
		super();
		this.uID = uID;
		this.pw = pw;
		this.u_name = u_name;
		this.address = address;
		this.phone_num = phone_num;
		this.email = email;
		this.tell_num = tell_num;
		this.address2 = address2;

	}
	
	//쿠폰조회
	public MemberBean(String coupon_name,String couponStatus,Date couponReg_date,Date couponEnd_date) {
		super();
		this.coupon_name = coupon_name;
		this.couponStatus = couponStatus;
		this.couponReg_date = couponReg_date;
		this.couponEnd_date = couponEnd_date;
			
		}
		
//포인트조회
	public MemberBean(int pID,String ownerID,Date pointRegTime,String pointContent,int pointValue,int pointAction) {
		super();
		this.pID = pID;
		this.ownerID = ownerID;
		this.pointRegTime = pointRegTime;
		this.pointContent = pointContent;
		this.pointValue = pointValue;
		this.pointAction = pointAction;
			
		}
		

	public String getuID() {
		return uID;
	}
	public void setuID(String uID) {
		this.uID = uID;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTell_num() {
		return tell_num;
	}
	public void setTell_num(String tell_num) {
		this.tell_num = tell_num;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getCoupon_name() {
		return coupon_name;
	}

	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}

	public String getCouponStatus() {
		return couponStatus;
	}

	public void setCouponStatus(String couponStatus) {
		this.couponStatus = couponStatus;
	}

	public Date getCouponReg_date() {
		return couponReg_date;
	}

	public void setCouponReg_date(Date couponReg_date) {
		this.couponReg_date = couponReg_date;
	}

	public Date getCouponEnd_date() {
		return couponEnd_date;
	}

	public void setCouponEnd_date(Date couponEnd_date) {
		this.couponEnd_date = couponEnd_date;
	}

	public int getPointValue() {
		return pointValue;
	}

	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}

	public int getPointAction() {
		return pointAction;
	}

	public void setPointAction(int pointAction) {
		this.pointAction = pointAction;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public String getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}

	public Date getPointRegTime() {
		return pointRegTime;
	}

	public void setPointRegTime(Date pointRegTime) {
		this.pointRegTime = pointRegTime;
	}

	public String getPointContent() {
		return pointContent;
	}

	public void setPointContent(String pointContent) {
		this.pointContent = pointContent;
	}

	
}
