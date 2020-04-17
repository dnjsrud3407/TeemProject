package member.account.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.account.svc.CouponInfoService;
import member.account.svc.PointInfoService;
import member.account.svc.SearchProService;
import vo.ActionForward;
import vo.MemberBean;
import vo.OrderBean;

public class SearchProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("mypage의 주문목록 searchProAction");
		
		
		HttpSession session=request.getSession();
		String uId=(String) session.getAttribute("uID");
		String startDate = request.getParameter("searchStartDate");
		String endDate = request.getParameter("searchEndDate");
		
		
		List<OrderBean> orderList = new ArrayList<OrderBean>();
		
		SearchProService searchProService = new SearchProService();
		orderList=searchProService.getSearchOrderList(startDate,endDate,uId);
		
		
		
		
		
		
		//--------------------총 포인트 가져오기---------------------------------------------
		
		PointInfoService pointInfoService= new PointInfoService();
			
				List<MemberBean> pointInfo=pointInfoService.getPointInfo(uId);
			
				int totalPoint =0; 
			
				for (MemberBean pointInfo2 : pointInfo) {
					
					if (pointInfo2.getPointAction()==1) {
						System.out.println("포인트 획득");
						totalPoint+=pointInfo2.getPointValue();
						System.out.println(totalPoint);
		
					}else {
						System.out.println("포인트 사용");
					}
				}
			
				request.setAttribute("totalPoint",totalPoint);
				
	//----------------보유 쿠폰 갯수 가져오기 (사용가능만!)-----------------------------
		Date stardateDate=null;
		Date enddateDate=null;
		CouponInfoService couponInfoService= new CouponInfoService();		
		List<MemberBean> couponInfo =  new ArrayList<MemberBean>(); //one
		
		couponInfo =couponInfoService.getCouponInfo(uId);
		
	  	  
		
		for (MemberBean memberBean : couponInfo) {
			
			
			//쿠폰의 시작날짜와 끝나는 날짜를 가져온다
			stardateDate=memberBean.getCouponReg_date();
			enddateDate=memberBean.getCouponEnd_date();
			
			//현제 시스템 날짜를 가져온다
			Calendar calendar = Calendar.getInstance();
			java.util.Date date = calendar.getTime();
			
			//가져온 현재 날짜를 String으로 변환,format으로 형식맞춰줌
			String today = (new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(date));
			
			
			//쿠폰의 시작날짜와 끝나는 날짜를 String으로 변환 format으로 형식 맞춰줌
			String startDate2 = new SimpleDateFormat("yyyy-mm-dd-hh:mm:ss").format(stardateDate);
			String endDate2 = new SimpleDateFormat("yyyy-mm-dd-hh:mm:ss").format(enddateDate);
			
			
			//compareTo 앞에있는 오늘날짜가 끝나는 날짜보다 크 다면 result는 0보다 큰 숫자가 된다
			int result = today.compareTo(endDate2);
			

			
			if (memberBean.getCouponStatus()=="사용") {//쿠폰사용시
				memberBean.setCouponStatus("사용");
				
			}else if(memberBean.getCouponStatus()=="사용안함"){ //사용하지 않고 만료되지않은 살아있는 쿠폰
				memberBean.setCouponStatus("사용안함");
			}
			
			if (result>0) { //쿠폰기한 지났을때
				memberBean.setCouponStatus("만료");
			}
			
		}//for 문 끝
		
		request.setAttribute("couponInfo",couponInfo);
		
		
		
		
		
		
		request.setAttribute("orderList",orderList);
		
		forward = new ActionForward();
		forward.setPath("mypage.jsp");
		
		return forward;
	}

}
