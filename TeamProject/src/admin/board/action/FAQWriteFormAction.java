package admin.board.action;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import admin.board.svc.BoardService;
import vo.ActionForward;
import vo.BoardBean;
import vo.FileBean;

public class FAQWriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		BoardService boardService = new BoardService();

		ArrayList<String> k2List = boardService.getk2List("FAQ");
		String page = request.getParameter("page");
		
		// FAQ 카테고리 목록
		request.setAttribute("k2List", k2List);
		request.setAttribute("page", page);
		
		forward = new ActionForward();
		
		forward.setPath("/admin/board/FAQWriteForm.jsp");
		
		return forward;
	}

}
