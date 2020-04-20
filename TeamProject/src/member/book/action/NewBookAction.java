package member.book.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.book.svc.NewBookService;
import vo.ActionForward;
import vo.BookBean;

public class NewBookAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NewBookService newBookService = new NewBookService();  
		ArrayList<BookBean> bookList = newBookService.getMiddleBookList();
		
		// 출력 함수 - 지금은 새로운 책이지만 학원가서 1,2,3 단계로 바꾸자//
    	response.setContentType("text/html; charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	out.print("<div class='item active'>");
    	out.print("<ul class='thumbnails'>");
    	for(int i = 0; i < 4; i++) {
    		out.print("<li class='span3'>");
    		out.print("<div class='thumbnail' style='height:"+"250px"+"'>");
    		out.print("<i class='tag'></i>");
    		out.print("<a href='Book.book?bookID=" + bookList.get(i).getBookID() + "'><img src=\"upload/" + bookList.get(i).getBookImage() + "\" alt=\"\"></a>");
    		out.print("<div class='caption'>");
    		out.print("<h5>"+bookList.get(i).getBookTitle()+"</h5>");
    		out.print(bookList.get(i).getBookPublisher()+" | "+bookList.get(i).getBookPrice());
    		out.print("</div>");
    		out.print("</div>");
    		out.print("</li>");
    	}
    	out.print("</ul>");
    	out.print("</div>");
    	
    	out.print("<div class='item'>");
    	out.print("<ul class='thumbnails'>");
    	for(int i = 4; i < 8; i++) {
    		out.print("<li class='span3'>");
    		out.print("<div class='thumbnail' style='height:"+"250px"+"'>");
    		out.print("<i class='tag'></i>");
    		out.print("<a href='Book.book?bookID=" + bookList.get(i).getBookID() + "'><img src=\"upload/" + bookList.get(i).getBookImage() + "\" alt=\"\"></a>");
    		out.print("<div class='caption'>");
    		out.print("<h5>"+bookList.get(i).getBookTitle()+"</h5>");
    		out.print(bookList.get(i).getBookPublisher()+" | "+bookList.get(i).getBookPrice());
    		out.print("</div>");
    		out.print("</div>");
    		out.print("</li>");
    	}
    	out.print("</ul>");
    	out.print("</div>");
    	
		return null;
	}

}
