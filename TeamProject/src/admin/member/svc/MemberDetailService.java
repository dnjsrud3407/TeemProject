package admin.member.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;


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
		
//		switch (member.getGrade()) {
//		case 1:
//			
//			break;
//		case 2:
//			
//			break;
//		case 3:
//				
//			break;
//		case 4:
//				
//			break;
//		case 5:
//					
//			break;
//		case 6:
//				
//			break;
//		case 7:
//				
//			break;
//		case 8:
//				
//			break;
//		case 9:
//		
//			break;
//		case 10:
//				
//			break;
//		case 11:
//				
//			break;
//		default:
//			break;
//		}

				
		close(con);
		
		return member;
	}

}
