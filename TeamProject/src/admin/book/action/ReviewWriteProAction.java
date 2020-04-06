package admin.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import admin.book.svc.QWriteProService;
import admin.book.svc.ReviewWriteProService;
import vo.ActionForward;
import vo.BoardBean;

public class ReviewWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// 페이지, 후기글 ReRef, bookID 파라미터와 답변 제목,내용 불러오기
		String page = request.getParameter("page");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		int boardReRef = Integer.parseInt(request.getParameter("boardReRef"));
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		
		
		// 관리자 id 가져오기
		HttpSession session = request.getSession();
		String boardWriter = (String)session.getAttribute("uID");
		
		QWriteProService qWriteProService = new QWriteProService();
		
		// 게시글 번호 생성
		int boardNum = qWriteProService.getBoardNum();
		
		BoardBean board = new BoardBean(
				boardNum, 
				103, 
				boardWriter, 
				boardTitle, 
				boardContent, 
				boardReRef, 
				1, 
				bookID);
		
		qWriteProService.writeAnswerBoard(board);
		
		forward = new ActionForward();
		
		// 후기 작성한거 상세보기
		forward.setPath("ReviewDetail.abook?boardReRef=" + boardReRef + "&page=" + page);
		forward.setRedirect(true);
		
		return forward;
	}

}
