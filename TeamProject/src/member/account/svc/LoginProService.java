package member.account.svc;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;
import static db.JdbcUtil.*;

public class LoginProService {

	public int isLoginMember(MemberBean member) {
		int loginResult = 0;	
		
		Connection con = getConnection();
		
		MemberDAO mDAO = MemberDAO.getInstance();
		
		loginResult = mDAO.selectMember(member);
				
		close(con);
		
		return loginResult;
	}

}
