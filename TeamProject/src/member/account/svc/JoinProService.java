package member.account.svc;


import java.sql.Connection;

import dao.MemberDAO;

import static db.JdbcUtil.*;


public class JoinProService {

	
	public boolean joinMember() {
		boolean isJoinSucess = false;
		
		Connection con = getConnection();
		
		MemberDAO mDAO = MemberDAO.getInstance();
		
		mDAO.setConnection(con);
		
		return isJoinSucess;
	}
}	
	
	
	

