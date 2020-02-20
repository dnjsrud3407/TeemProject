package board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.QListService;
import vo.ActionForward;

public class QListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		System.out.println("1:1 문의 내역 보기");
		
		QListService q_ListService = new QListService();
		ArrayList list = q_ListService.getList();
		
		forward = new ActionForward();
		forward.setPath("./board/QList.jsp");
		
		return forward;
	}

}
