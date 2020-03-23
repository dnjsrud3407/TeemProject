package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import action.Action;
import admin.book.svc.DetailService;
import vo.ActionForward;
import vo.BookBean;

public class ModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// bookID, BKID 파라미터로 가져오기//
		int bookID = Integer.parseInt(request.getParameter("bookID"));
        
        // 제품 상세보기
        DetailService detailService = new DetailService();
        BookBean book = detailService.getArticle(bookID);
		
        // 가져온 book request 객체에 넣기
        request.setAttribute("book", book);
		
		forward = new ActionForward();
		forward.setPath("./admin/book/modifyForm.jsp");
		
		return forward;
	}

}
