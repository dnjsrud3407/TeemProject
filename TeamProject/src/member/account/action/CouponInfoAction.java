package member.account.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import action.Action;
import member.account.svc.CouponInfoService;
import vo.ActionForward;
import vo.MemberBean;

public class CouponInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		String startDate=null;
//		String endDate=null;
		Date stardateDate=null;
		Date enddateDate=null;
		
		System.out.println("CouponInfoAction");
		
		String uID=request.getParameter("uID");
		
		
		CouponInfoService couponInfoService= new CouponInfoService();
		List<MemberBean> couponInfo =  new ArrayList<MemberBean>();
		
		couponInfo =couponInfoService.getCouponInfo(uID);
		
	  	  
		
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
			String startDate = new SimpleDateFormat("yyyy-mm-dd-hh:mm:ss").format(stardateDate);
			String endDate = new SimpleDateFormat("yyyy-mm-dd-hh:mm:ss").format(enddateDate);
			
			
			//compareTo 앞에있는 오늘날짜가 끝나는 날짜보다 크 다면 result는 0보다 큰 숫자가 된다
			int result = today.compareTo(endDate);
			

			
			if (memberBean.getCouponStatus()=="사용") {
				//만료시
				memberBean.setCouponStatus("사용");
				
			}else if(memberBean.getCouponStatus()=="사용안함"){
				memberBean.setCouponStatus("사용안함");
			}
			
			if (result>0) {
				memberBean.setCouponStatus("만료");
			}
			
			
			
		}//for 문 끝
		
		  for (MemberBean memberBean : couponInfo) {
			
			System.out.println("--*현재쿠폰상태==="+memberBean.getCouponStatus());
		}


	  
		
		
		
		request.setAttribute("couponInfo",couponInfo);
		forward = new ActionForward();
		forward.setPath("/member/couponInfo.jsp");
		
		return forward;
	}

}
