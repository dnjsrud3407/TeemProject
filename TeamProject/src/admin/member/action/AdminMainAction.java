package admin.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.member.svc.MainBoardService;
import vo.ActionForward;
import vo.BoardBean;

public class AdminMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		int page = 1; int limit = 5; int kID = 0;
		MainBoardService adminMainService = new MainBoardService();
		// 상품 가져오기
		ArrayList<Integer> bookEAList = adminMainService.getBookEA();

		
		// 주문현황 가져오기
		
		// 이번달 매출현황
		
		
		// 달별 매출 통계
		
		
		// 공지사항 5개
		kID = 100;
		ArrayList<BoardBean> noticeList = adminMainService.getNaEBoardList(kID, page, limit);
		// 이벤트 5개
		kID = 101;
		ArrayList<BoardBean> eventList = adminMainService.getNaEBoardList(kID, page, limit);
		// 답변 게시글 - 상품문의
		kID = 102;
		ArrayList<BoardBean> qList = adminMainService.getBoardList(kID, page, limit);
		
		
		// request 파라미터 넘기기
		request.setAttribute("bookEAList", bookEAList);
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("eventList", eventList);
		request.setAttribute("qList", qList);
		forward = new ActionForward();
		forward.setPath("/admin/adminMain.jsp");
		
		return forward;
	}

}
