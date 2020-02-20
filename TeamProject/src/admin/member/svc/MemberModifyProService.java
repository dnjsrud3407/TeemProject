package admin.member.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberModifyProService {

	public boolean isAdminWriter(int num, String parameter) {
		

		boolean isArticleWriter = false;
//		
//		Connection con = getConnection();
//		MemberDAO memberDAO = new MemberDAO();
//		memberDAO.setConnection(con);;
//		
//		isArticleWriter = memberDAO.isArticleWriter(num, parameter);
//		
//		close(con);
		return isArticleWriter;		
	}

	public boolean modifyMember(MemberBean member) {
		System.out.println("6.BoardModifyService - modifyArticle");
		int updateCount = 0;
		boolean isModifySuccess = false;
//		
//		Connection con = getConnection();
//		MemberDAO memberDAO = new MemberDAO();
//		memberDAO.setConnection(con);
//		
//		updateCount = memberDAO.updateMember(member);
//				
//		if(updateCount > 0) {
//			commit(con);
//			isModifySuccess = true;
//		} else {
//			rollback(con);
//		}
//
//		close(con);
		return isModifySuccess;
	}

}
