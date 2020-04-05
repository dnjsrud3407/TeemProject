package board.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import action.Action;
import board.svc.QDetailService;
import board.svc.QListService;
import vo.ActionForward;
import vo.BoardBean;

public class QListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("QListAction");
		int boardNum=0;
		
		//-----------1:1문의내역 불러오기----------
		HttpSession session=request.getSession();
		String uID=(String) session.getAttribute("uID");
		
		QListService q_ListService = new QListService();
		List<BoardBean> QList =q_ListService.getList(uID);
		
			 
			 request.setAttribute("QList",QList);
		
		forward = new ActionForward();
		forward.setPath("/board/QList.jsp");
		return forward;
	}

}
