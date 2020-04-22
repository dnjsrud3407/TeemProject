package admin.member.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.member.svc.MainBoardService;
import admin.sales.svc.OrderCompListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.OrderBean;

public class AdminMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		int page = 1; int limit = 5; int kID = 0;
		MainBoardService adminMainService = new MainBoardService();
		// 상품 가져오기
		ArrayList<Integer> bookEAList = adminMainService.getBookEA();

		String orderStatus = ""; 
		int cashe = 0;
		OrderCompListService orderCompListService = new OrderCompListService();
		
		// 주문현황 가져오기
		ArrayList<Integer> orderList = new ArrayList<Integer>();
		orderStatus = "결제완료";
		orderList.add(orderCompListService.getOrderCount(orderStatus));
		orderStatus = "배송중";
		orderList.add(orderCompListService.getOrderCount(orderStatus));
		orderStatus = "배송완료";
		orderList.add(orderCompListService.getOrderCount(orderStatus));
		
		
		// ============================ 이번달 매출현황
		ArrayList<Integer> salesCasheList = new ArrayList<Integer>();

		// -- 총 금액 구하기
		orderStatus = "";		
		cashe = orderCompListService.orderComplList(orderStatus);
		salesCasheList.add(cashe);
		
		// -- 취소/반품 금액 구하기
		int cancelCashe = 0;
		orderStatus = "취소완료";		
		cancelCashe = orderCompListService.orderComplList(orderStatus);

		orderStatus = "반품완료";		
		cancelCashe += orderCompListService.orderComplList(orderStatus);
		salesCasheList.add(cancelCashe);
		
		// -- 매출액(총 금액-cancelCashe) 금액 구하기
		salesCasheList.add(cashe - cancelCashe);
		// ================================================================================
		
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
		request.setAttribute("orderList", orderList);
		request.setAttribute("salesCasheList", salesCasheList);
		request.setAttribute("bookEAList", bookEAList);
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("eventList", eventList);
		request.setAttribute("qList", qList);
		forward = new ActionForward();
		forward.setPath("/admin/adminMain.jsp");
		
		return forward;
	}

}
