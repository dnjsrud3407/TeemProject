package admin.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;



public class MemberListAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberListAcion");
		
//		int num = Integer.parseInt(request.getParameter("num"));
//
//		MemberListService memberListService = new MemberListService();
//		MemberBean member = memberListService.getMember(num);
		
		ActionForward action = new ActionForward();
		action.setPath("/admin/member/member_list.jsp");

		return action;
	}

}
