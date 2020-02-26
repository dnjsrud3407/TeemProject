package member.account.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;
import vo.MemberBean;

public class JoinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("JoinProAction");
		
		// 파라미터 가져오기
		String uID = request.getParameter("uID");
		String pw = request.getParameter("pw");
		String u_name = request.getParameter("u_name");
		String address = request.getParameter("address");
		String phone_num = request.getParameter("phone_num");
		String email = request.getParameter("email");
		String tell_num = request.getParameter("tell_num");
		String address2 = request.getParameter("address2");
		int point = Integer.parseInt(request.getParameter("point"));
		int grade = Integer.parseInt(request.getParameter("grade"));
		
		// 파라미터 -> MemberBean 객체에 저장
		MemberBean member = new MemberBean(uID, pw, u_name, address, phone_num, email, 
				tell_num, address2, point, grade);
		
		// MemberJoinProService 클래스의 joinMember() 메서드 호출하여 추가 작업 요청
				// => 파라미터 : MemberBean      리턴타입 : boolean
		forward = new ActionForward();
		forward.setPath("/member/login.jsp");
		return forward;
	}

}
