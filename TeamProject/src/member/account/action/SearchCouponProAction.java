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
import member.account.svc.SearchCouponProService;
import vo.ActionForward;
import vo.MemberBean;

public class SearchCouponProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		Date stardateDate=null;
		Date enddateDate=null;
		
		System.out.println("SearchCouponProAction");
		
		HttpSession session = request.getSession();
		String uID=(String) session.getAttribute("uID");
		String startDate2 = request.getParameter("searchStartDate");
		String endDate2 = request.getParameter("searchEndDate");
		
		
		SearchCouponProService searchCouponProService = new SearchCouponProService();
		
		
		List<MemberBean> couponInfo =  new ArrayList<MemberBean>(); //one
		couponInfo =searchCouponProService.getCouponInfo(uID,startDate2,endDate2);
		
		
		
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
				memberBean.setCouponStatus("사용");
				
			}else if(memberBean.getCouponStatus()=="사용안함"){
				memberBean.setCouponStatus("사용안함");
//				couponInfo2.add(memberBean); //여기까지함 만약 사용안함이라면 grid one에 따로 뿌려주어야 하기 때문에 이름을 다르게..함?
			}
			
			if (result>0) { //쿠폰기한 지났을때
				memberBean.setCouponStatus("만료");
			}
			
		}//for 문 끝
		
		
		
		request.setAttribute("couponInfo",couponInfo);
		forward = new ActionForward();
		forward.setPath("/member/couponInfo.jsp");
		
		return forward;
	}

}
