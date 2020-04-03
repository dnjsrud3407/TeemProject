package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

public class QSearchProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String boardRegTime_Before = request.getParameter("boardRegTime_Before");
		String boardRegTime_After = request.getParameter("boardRegTime_After");
		
		System.out.println("boardRegTime_Before : " + boardRegTime_Before);
		System.out.println("boardRegTime_After : " + boardRegTime_After);
		
		forward = new ActionForward();
		forward.setPath("./admin/book/qSearchList.jsp");
		return forward;
	}

}
