package dao;

import java.sql.Connection;

import vo.MemberBean;

public class MemberDAO {
public MemberDAO() {}
	
	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() { 
		return instance;
	}
	// ----------------------------------------------------
	Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}

	public static MemberBean selectreviews(int num) {
		MemberBean member = null;
		
		return member;
	}

	public boolean isArticleWriter(int num, String parameter) {
		// TODO Auto-generated method stub
		return false;
	}

	public int updateMember(MemberBean member) {
		// TODO Auto-generated method stub
		return 0;
	}

}
