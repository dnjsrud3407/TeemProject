package admin.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.member.svc.memberDeleteProService;
import vo.ActionForward;

public class MemberDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ReviewDeleteProAction");
		
		ActionForward forward = null;
		
		String uID = request.getParameter("uID");
//		String page = request.getParameter("page");
////		
		memberDeleteProService memberDeleteProService = new memberDeleteProService();
		boolean isAdminUser = memberDeleteProService.isAdminWriter(uID, request.getParameter("pw"));

		if(!isAdminUser) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 권한이 없습니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			//삭제작업진행 
////			System.out.println("삭제 완료!");
			boolean isDeleteSuccess = memberDeleteProService.removeMember(uID);
//			
			if(!isDeleteSuccess) {
				response.setContentType("text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();

				out.println("<script>");
				out.println("alert('글 삭제 실패!!')");
				out.println("histroy.back()");
				out.println("</script>");

			}else {
				forward = new ActionForward();
				forward.setPath("MemberList.adm");
				forward.setRedirect(true);
			}
		}
		
		forward = new ActionForward();
		forward.setPath("MemberList.adm");
		forward.setRedirect(true);

		return forward;

	}

}
