package admin.book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.ListService;
import vo.ActionForward;
import vo.BookBean;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		ListService listService = new ListService();
		ArrayList<BookBean> bookList = listService.getBookList();
		
		request.setAttribute("bookList", bookList);
		
		if(bookList == null) {
			System.out.println("리스트가 비었음");
		}
		forward = new ActionForward();
		forward.setPath("./admin/book/list.jsp");
		
		return forward;
	}

}
