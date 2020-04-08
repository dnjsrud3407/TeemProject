package admin.book.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import admin.book.svc.DeleteProService;
import admin.book.svc.QnReDeleteProService;
import vo.ActionForward;

public class QDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// ============ 파라미터로 글 번호, 글 참조번호(문의자 글번호), 입력받은 비밀번호 가져오기
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		int boardReRef = Integer.parseInt(request.getParameter("boardReRef"));
		String pw = request.getParameter("pw");
		
		// session 에서 관리자 아이디 가져오기
		HttpSession session = request.getSession();
		String uID = (String)session.getAttribute("uID");
		
		// 관리자 비밀번호 일치 여부
		DeleteProService deleteProService = new DeleteProService();
		boolean isRightUser = deleteProService.isRightUser(uID, pw);
		
		QnReDeleteProService qDeleteProService = new QnReDeleteProService();

		if(!isRightUser) { // 관리자 비밀번호 불일치 시 
		    response.setContentType("text/html; charset=UTF-8");
		    PrintWriter out = response.getWriter();
		    out.println("<script>");
		    out.println("alert('비밀번호가 일치하지 않습니다!')");
		    out.println("history.back()");
		    out.println("</script>");
		} else {
			// 답변 글 삭제하기
			boolean isRemoveBoard = qDeleteProService.deleteBoard(boardNum, boardReRef);
			if(!isRemoveBoard) {	// 답변 삭제 실패된 경우
				response.setContentType("text/html; charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>");
                out.println("alert('답변 삭제 실패!')");
                out.println("history.back()");
                out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setPath("QList.abook");
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}
