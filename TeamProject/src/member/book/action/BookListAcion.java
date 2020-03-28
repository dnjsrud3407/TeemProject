package member.book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.book.svc.BookListService;
import vo.ActionForward;
import vo.PageInfo;

public class BookListAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		int page = 1;
		int limit = 10;
		
		//page 파라미터가 존재할 경우 파라미터에 전달된 데이터를 현재 페이지번호로 대체
		
//		if(request.getParameter("page") != null) {
//			page = Integer.parseInt(request.getParameter("page")); //정수로 변환하여 저장
//		}
//		//svc에 만들기
//		BookListService bookListService = new BookListService();
//		
		// 전체 책 가져오기 
//		int listCount = bookListService.getBookList();
//		//서비스갔다가 돌아온것임
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
