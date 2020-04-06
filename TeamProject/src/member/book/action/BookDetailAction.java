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
		int listCount = 0;
		// bookID
		int bookID = 0;
		
		if(request.getParameter("bookID") != null) {
			bookID = Integer.parseInt(request.getParameter("bookID"));
		}
		
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

		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(page);
		pageInfo.setLimit(limit);
		pageInfo.setK1(k1);
		
		ArrayList<BoardBean> articleQnaList = qListService.getQnaBoard(pageInfo, bookID);
		
		// 상품문의 전체글 개수 들고올지 상품후기 전체 글 개수 들고올지 판별
		if(pageInfo.getK1().equals("상품문의")) {
			listCount = qListService.qnaListCount(bookID, k1);
			
			
		} else if(pageInfo.getK1().equals("상품후기")) {
			listCount = 0;
		}
		//전체 글 개수 가져오기
		
		//System.out.println(listCount);	
		// 1. 총 페이지 수 계산
		int maxPage = listCount / limit + (listCount % limit == 0 ? 0 : 1);
		// 페이징 사이즈
		int pageBlock = 10;
		// 2. 시작 페이지 번호
		int startPage = ((page - 1) / pageBlock) * pageBlock + 1;
		// 3. 마지막 페이지 번호
		int endPage = startPage + pageBlock - 1;
		
		// 마지막 페이지 번호가 총 페이지 수보다 클 경우
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		pageInfo = new PageInfo(page, maxPage, startPage, endPage, pageBlock, listCount);
		// 가져온 book request 객체에 넣기
		request.setAttribute("book", book);
		request.setAttribute("articleQnaList", articleQnaList);
		request.setAttribute("pageInfo", pageInfo);

		forward = new ActionForward();
		forward.setPath("./book/book.jsp");

		return forward;
	}

}
