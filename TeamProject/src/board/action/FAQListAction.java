package board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.FAQListService;
import board.svc.QListService;
import vo.ActionForward;

public class FAQListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		System.out.println("FAQ 문의 내역 보기");
		
		FAQListService faq_ListService = new FAQListService();
		ArrayList list = faq_ListService.getList();
		
		forward = new ActionForward();
		forward.setPath("./board/FAQ_List.jsp");
		
		return forward;
	}

}
