package admin.book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.QListService;
import vo.ActionForward;

public class QListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		System.out.println("상품 문의 내역 보기");
		
		QListService qListService = new QListService();
		ArrayList list = qListService.getList();
		
		forward = new ActionForward();
		forward.setPath("./admin/book/qList.jsp");
		
		return forward;
	}

}
