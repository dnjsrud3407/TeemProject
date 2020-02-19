package admin.book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.SearchService;
import vo.ActionForward;

public class SearchProAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
//      System.out.println("상품 검색하기");
        
        SearchService searchService = new SearchService(); 
        ArrayList list = searchService.getList();
        
        forward = new ActionForward();
        forward.setPath("./admin/book/list.jsp");
        
        return forward;
    }

}
