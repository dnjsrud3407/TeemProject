package admin.member.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.List;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberDetailService {

	public MemberBean getMember(String members) throws Exception {
		System.out.println("MemberListService - getMember");
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		MemberBean member = null;
		
		member = memberDAO.selectMember(members);
//		memberDAO.selectMemberList();
		
		close(con);
		
		return null;
	}

}
