package admin.book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.ListService;
import vo.ActionForward;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		System.out.println("상품 문의 내역 보기");
		
		ListService listService = new ListService();
		ArrayList list = listService.getList();
		
		forward = new ActionForward();
		forward.setPath("./admin/book/list.jsp");
		
		return forward;
	}

}
