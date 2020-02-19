package board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.Notice_ListService;
import vo.ActionForward;

public class Notice_ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		System.out.println("Notice 문의 내역 보기");
		
		Notice_ListService notice_ListService = new Notice_ListService();
		ArrayList list = notice_ListService.getList();
		
		forward = new ActionForward();
		forward.setPath("./board/Notice_List.jsp");
		
		return forward;
	}

}
