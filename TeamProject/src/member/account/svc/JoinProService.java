package member.account.svc;


import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

import static db.JdbcUtil.*;


public class JoinProService {

	
	public boolean joinMember(MemberBean member) {
		boolean isJoinSuccess = false;
		
		Connection con = getConnection();
		
		MemberDAO mDAO = MemberDAO.getInstance();
		
		mDAO.setConnection(con);
		
		int insertCount = mDAO.insertMember(member);
		
		if(insertCount > 0) {
			commit(con);
			isJoinSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isJoinSuccess;
	}

	public boolean deleteMember(MemberBean member) {
		// TODO Auto-generated method stub
		boolean isDeleteUser = false;
		int loginResult = 1;
		
		Connection con = getConnection();
		
		MemberDAO mDAO = MemberDAO.getInstance();
		
		loginResult = mDAO.deleteMember(member);
		
		if(loginResult == -1) {
			isDeleteUser = true;
		}
		
		return isDeleteUser;
	}
}	
	
	
	

