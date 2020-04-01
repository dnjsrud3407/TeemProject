package member.book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import action.Action;
import admin.book.svc.DetailService;
import member.book.svc.BookDetailService;
import member.book.svc.QListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.BookBean;
import vo.PageInfo;

public class BookDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		// bookID
		int bookID = Integer.parseInt(request.getParameter("bookID"));

		// 상품 상세보기//
		BookDetailService bookDetailService = new BookDetailService();
		BookBean book = bookDetailService.getArticle(bookID);

		// 상품문의하기 //
		int page = 1;
		int limit = 10;
		String k1 = "상품문의";

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		QListService qListService = new QListService();

		// 책하나의 상품문의 전체 글 개수 가져오기
		int listCount = qListService.qnaListCount(bookID, k1);
//		System.out.println(listCount);
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(page);
		pageInfo.setLimit(limit);
		pageInfo.setK1(k1);
		System.out.println(bookID);
		ArrayList<BoardBean> articleQnaList = qListService.getQnaBoard(pageInfo, bookID);

		// 가져온 book request 객체에 넣기
		request.setAttribute("book", book);
//		request.setAttribute("artcleQnaList", articleQnaList);

		forward = new ActionForward();
		forward.setPath("./book/book.jsp");

		return forward;
	}

}
