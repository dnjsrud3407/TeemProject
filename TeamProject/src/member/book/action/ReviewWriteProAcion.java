package member.book.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import vo.ActionForward;
import vo.BookBean;

public class ReviewWriteProAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ReviewWriteProAcion");

		ActionForward forward = null;
		BookBean bookBean = null;
		
//		String saveFolder = "/upload";
//		ServletContext context = request.getServletContext();
//		String realFolder = context.getRealPath(saveFolder);
//		int fileSize = 1024 * 1024 * 5;
//		MultipartRequest multi = new MultipartRequest(
//				request, 
//				realFolder, 
//				fileSize, 
//				"UTF-8",  
//				new DefaultFileRenamePolicy());
//
////		ReviewWriteProService reviewWriteProService = new ReviewWriteProService();
////		boolean isWriteSuccess = reviewWriteProService.registReview(bookBean);
//		
		forward = new ActionForward();
		forward.setPath("Book.book"); 
		forward.setRedirect(true); 
		
		return forward;
	}

}
