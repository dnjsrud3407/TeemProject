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
import vo.BoardBean;
import vo.BookBean;

public class QWriteProAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("QWriteProAcion");
		ActionForward forward = null;
		BoardBean boardBean = null;
		
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
		int  kID = Integer.parseInt(request.getParameter("kID"));
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		String uID = request.getParameter("uID");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		System.out.println(bookID + "," + uID + "," + boardTitle + ","  + boardContent);
		
		boardBean = new BoardBean(kID,uID,boardTitle, boardContent, bookID);
		QWriteProService qWriteProService = new QWriteProService();
		boolean isWriteSuccess = qWriteProService.registQuestions(boardBean);
		
		forward = new ActionForward();
		forward.setPath("Book.book"); 
		forward.setRedirect(true); 
		
		return forward;
	}

}
