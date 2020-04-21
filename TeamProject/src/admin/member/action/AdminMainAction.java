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
		// 주문현황 가져오기
		
		// 이번달 매출현황
		
		// 상품 가져오기
		
		// 달별 매출 통계
		
		// 공지사항 5개
//		ArrayList<BoardBean> boardList = adminMainService
		// 이벤트 5개
		
		// 답변 게시글 - 상품문의
		kID = 102;
		ArrayList<BoardBean> qboardList = adminMainService.getBoardList(kID, page, limit);
		
		// 답변 게시글 - 상품후기
		
		// 답변 게시글 - 1:1문의
		
		
		request.setAttribute("qboardList",qboardList);
		forward = new ActionForward();
		forward.setPath("/admin/adminMain.jsp");
		
		return forward;
	}

}
