package member.account.svc;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class ModifyFormService {

	public MemberBean getMemberInfo(String uID) {
		System.out.println("ModifyFormService.getMemberInfo(String uID)");
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		
		
		
		return dao.getMemberInfo(uID);
		
		
	}

	public int checkPass2(String uID, String pw) {
		System.out.println("ModifyFormService.checkPass(String uID)");

		int pwCheck =0;
		
		Connection con  = getConnection();
		
		MemberDAO dao = MemberDAO.getInstance();
		
		dao.setConnection(con);
		
		
		 pwCheck=dao.checkPass2(uID,pw);
		
		 System.out.println("회원정보수정 비밀번호체크  성공여부 "+pwCheck);
		
		 
		 
		 
		 
		
		return pwCheck;
	}

}
