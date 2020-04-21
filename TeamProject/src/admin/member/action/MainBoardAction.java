package admin.member.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.member.svc.MainBoardService;
import vo.ActionForward;
import vo.BoardBean;

public class MainBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int kID = 0; 
		if(request.getParameter("type") != null || request.getParameter("type") != "") {
			kID = Integer.parseInt(request.getParameter("type"));
		}
		
		int page = 1; int limit = 5;
		MainBoardService mainBoardService = new MainBoardService();
		ArrayList<BoardBean> boardList = null;
		boardList = mainBoardService.getBoardList(kID, page, limit);
		
		// 출력 함수 
    	response.setContentType("text/html; charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	out.print("<tr>");
    	out.print("<td class=\"boardTitle\" onclick=\"getBoard(102)\">상품문의</td>");
    	out.print("<td class=\"boardTitle\" onclick=\"getBoard(103)\">상품후기</td>");
    	out.print("<td class=\"boardTitle\" onclick=\"getBoard(109)\">1:1문의</td>");
    	out.print("</tr>");
    	out.print("<tr></tr>");
    	
    	for (int i = 0; i < boardList.size(); i++) {
    		out.print("<tr>");
    		out.print("<td colspan=\"2\">"+boardList.get(i).getBoardTitle()+"</td>");
    		out.print("<td>"+boardList.get(i).getBoardRegTime()+"</td>");
    		out.print("</tr>");
		}
    	
		return null;
	}

}
