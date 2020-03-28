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

	
}
