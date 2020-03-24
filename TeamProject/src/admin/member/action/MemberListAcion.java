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
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		String uId = request.getParameter("uId");
//		int num = Integer.parseInt(request.getParameter("num"));

		MemberListService memberListService = new MemberListService();
		int memListCount = memberListService.getListCount();
		
		ArrayList<MemberBean> memberList = null;
		memberList = memberListService.getMemberList(page, limit);
		
		int maxPage = (int)((double)memListCount / limit + 0.95);
		int startPage = (((int)((double)page / 10 + 0.9)) -1 ) * 10 + 1;
		int endPage = startPage + 10 - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		
		
		request.setAttribute("memListCount", memListCount);
		action.setPath("/admin/member/member_list.jsp");
		
		return action;
	}

}
