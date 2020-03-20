package admin.member.svc;

import java.sql.Connection;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import dao.MemberDAO;
import static db.JdbcUtil.*;
import vo.MemberBean;

public class MemberListService {

	public List getMemberList() {
		System.out.println("MemberListService - getMember");
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		List memberList = memberDAO.memberList();
		
		close(con);
		
		return memberList;
	}


}
