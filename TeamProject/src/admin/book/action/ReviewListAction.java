package admin.book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.ReviewListService;
import vo.ActionForward;

public class ReviewListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		System.out.println("상품 문의 내역 보기");
		
		ReviewListService reviewListService = new ReviewListService();
		ArrayList list = reviewListService.getList();
		
		forward = new ActionForward();
		forward.setPath("./admin/book/reviewList.jsp");
		
		return forward;
	}

}
