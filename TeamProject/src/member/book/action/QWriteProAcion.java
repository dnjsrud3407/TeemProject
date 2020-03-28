package member.book.action;

import static db.JdbcUtil.*;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import dao.BookDAO;
import member.book.svc.QWriteProService;
import vo.ActionForward;
import vo.BookBean;

public class QWriteProAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("QWriteProAcion");
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
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");

		QWriteProService qWriteProService = new QWriteProService();
		boolean isWriteSuccess = qWriteProService.registQuestions(bookBean);
		
		forward = new ActionForward();
		forward.setPath("Book.book"); 
		forward.setRedirect(true); 
		
		return forward;
	}

}
