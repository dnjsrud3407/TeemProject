package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import action.Action;
import admin.book.svc.DetailService;
import vo.ActionForward;
import vo.BookBean;

public class DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// bookID, BKID 파라미터로 가져오기
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		// int BKID = Integer.parseInt(request.getParameter("BKID"));
		
		// 제품 상세보기//
		DetailService detailService = new DetailService();
		BookBean book = detailService.getArticle(bookID);
		// 카테고리 정보 가져오기
		//JSONArray BKCategorie = detailService.getBKCategorie(BKID);

		// 가져온 book, BKCategorie request 객체에 넣기
		request.setAttribute("book", book);
		//request.setAttribute("BKCategorie", BKCategorie);
		
		forward = new ActionForward();
		forward.setPath("./admin/book/detail.jsp");
		
		return forward;
	}

}
