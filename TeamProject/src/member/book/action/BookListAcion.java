package member.book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.ListService;
import member.book.svc.BookListService;
import vo.ActionForward;
import vo.BookBean;
import vo.PageInfo;

public class BookListAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		int page = 1;
		int limit = 6;
		int bk2 = Integer.parseInt(request.getParameter("bk2"));
		
		
		
		//page 파라미터가 존재할 경우 파라미터에 전달된 데이터를 현재 페이지번호로 대체
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page")); //정수로 변환하여 저장
		}
		
		System.out.println(page);
		
		//svc에 만들기
		BookListService bookListService = new BookListService();
		
		// 책 목록 가져오기
		ArrayList<BookBean> bookList = bookListService.getBookList(page, limit, bk2);
		
		// 책 전체 개수
		int listCount = bookListService.getListCount();
		
		// 1. 총 페이지 수 계산
		int maxPage = listCount / limit + (listCount % limit == 0 ? 0 : 1);
		// 페이징 사이즈(한 화면 페이지 번호 개수)
		int pageBlock = 6;
		// 2. 시작 페이지 번호
		int startPage = ((page - 1) / pageBlock) * pageBlock + 1;
		// 3. 마지막 페이지 번호
		int endPage = startPage + pageBlock - 1;
		
		// 마지막 페이지 번호가 총 페이지 수보다 클 경우
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(page, maxPage, startPage, endPage, pageBlock, listCount);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("bookList", bookList);

//		System.out.println("총 게시물 수 : " + listCount);
//		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>(); //null값줘도됨 어짜피 만들어서 리턴할거라서
//		ArrayList<BoardBean> articleList = boardListService.articleList(page,limit);
		
//		int maxPage = (int)((double)listCount / limit + 0.95);
//		int startPage = (((int)((double)page / 10 + 0.9)) - 1) + 1;
//		int endPage = startPage + 10 - 1;
//		if(endPage > maxPage) {
//			endPage = maxPage;
//		}
		
		
//		PageInfo pageInfo = new PageInfo(page, maxPage, startPage, endPage, listCount);
//		request.setAttribute("pageInfo", pageInfo);
//		request.setAttribute("articleList", articleList);
		
		forward = new ActionForward();
		forward.setPath("/book/book_list.jsp");
		//재사용
		
		return forward;

	}

}
