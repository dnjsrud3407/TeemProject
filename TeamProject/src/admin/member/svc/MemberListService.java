package admin.member.svc;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberListService {

	public MemberBean getMember(int num) {
		System.out.println("MemberListService - getMember");
		
//		MemberDAO memberDAO = MemberDAO.getInstance();
		
		MemberBean member = null;
//		member = MemberDAO.selectreviews(num);
		
		
		return member;
	}

}
