package admin.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import action.Action;
import admin.member.svc.MemberListService;
import vo.ActionForward;
import vo.MemberBean;



public class MemberListAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberListAcion");
		ActionForward action = null;
		
		String uId = request.getParameter("uId");
//		int num = Integer.parseInt(request.getParameter("num"));

		MemberListService memberListService = new MemberListService();
		List memberList = memberListService.getMemberList();
		
		request.setAttribute("memberList", memberList);
		action.setPath("/admin/member/member_list.jsp");
		
		return action;
	}

}
