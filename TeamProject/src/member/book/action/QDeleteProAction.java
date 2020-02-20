package member.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;


public class QDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("QDeleteProAction");
		
		ActionForward forward = null;
		
//		int num = Integer.parseInt(request.getParameter("num"));
//		String page = request.getParameter("page");
//		
//		boolean isRightUser = false;
//		QDeleteProAction qDeleteProAction = new QDeleteProAction();
//		isRightUser = qDeleteProAction.isQuestionWriter(num, request.getParameter("board_pass"));
//		

//		if(!isRightUser) {
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('삭제 권한이 없습니다!')");
//			out.println("history.back()");
//			out.println("</script>");
//		} else {
//			//삭제작업진행 
////			System.out.println("삭제 완료!");
//			boolean isDeleteSuccess = reviewDeleteProService.removeReview(num);
//			
//			if(!isDeleteSuccess) {
//				response.setContentType("text/html; charset=UTF-8");
//
//				PrintWriter out = response.getWriter();
//
//				out.println("<script>");
//				out.println("alert('글 삭제 실패!!')");
//				out.println("histroy.back()");
//				out.println("</script>");
//
//			}else {
//				forward = new ActionForward();
//				forward.setPath("BoardList.bo?=page" + page);
//				forward.setRedirect(true);
//			}
//		}
		
		forward = new ActionForward();
		forward.setPath("Book.book");
		forward.setRedirect(true);

		return forward;
	}

}
