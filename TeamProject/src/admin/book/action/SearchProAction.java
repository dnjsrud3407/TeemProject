package admin.book.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.SearchService;
import admin.book.svc.WriteProService;
import vo.ActionForward;
import vo.BookBean;
import vo.PageInfo;

public class SearchProAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        WriteProService writeProService = new WriteProService();
        
        // 제품번호, 제품이름, 출판사, 카테고리(대, 레벨, 소) 파라미터
        String bookID = request.getParameter("bookID");
        String bookTitle = request.getParameter("bookTitle");
        String bookPublisher = request.getParameter("bookPublisher");
        String BK1 = request.getParameter("BK1Category");
        String BK2 = request.getParameter("BK2Category");
        String BK3 = request.getParameter("BK3Category");
        // 재고, 전시 체크여부
        String bookEA = request.getParameter("bookEA");
        String bookisView = request.getParameter("bookisView");
        
        // Map 에 저장
        Map<Object, Object> searchList = new HashMap<Object, Object>();
    	searchList.put("bookID", bookID);
        searchList.put("bookTitle", bookTitle);
        searchList.put("bookPublisher", bookPublisher);
        searchList.put("BK1", BK1);
        searchList.put("BK2", BK2);
        searchList.put("BK3", BK3);
        searchList.put("bookEA", bookEA);
        searchList.put("bookisView", bookisView);
        
        // map 객체 key값 들고오기
        ArrayList keyList = new ArrayList(searchList.keySet());

        // map객체(key값으로 서치)이 null 이나 비어 있는 값이면 삭제
        for(int i = 0; i < keyList.size(); i++) {
	        if(searchList.get(keyList.get(i)) == null || searchList.get(keyList.get(i)).equals("") || searchList.get(keyList.get(i)).equals("선택하세요")) {
	        	searchList.remove(keyList.get(i));
	        }
        }
        
        // ================= 페이징 =================
        // 현재 페이지 번호 및 한 페이지당 게시글 수//
 		int page = 1;
 		int limit = 10;
 		
 		SearchService searchService = new SearchService(); 
 		ArrayList<BookBean> bookList = searchService.getSearchBookList(searchList, page, limit);

 		int listCount = bookList.size();
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
		
		PageInfo pageInfo = new PageInfo(page, maxPage, startPage, endPage, pageBlock, listCount);
		
		request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("bookList", bookList);
        
        forward = new ActionForward();
        forward.setPath("./admin/book/list.jsp");
        
        return forward;
    }

}
