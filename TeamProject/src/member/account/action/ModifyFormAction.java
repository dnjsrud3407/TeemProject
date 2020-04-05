package member.account.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.account.svc.ModifyFormService;
import vo.ActionForward;
import vo.MemberBean;

public class ModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("ModifyFormAction");
		
		//여기는 원래 해당유저의 아이디를 가지고가서 수정폼에 정보를 출력 할 수 있게 만든 곳이다
		
		//근데 비밀번호 맞는지부터 체크해야한다고
		
		//그럼 비밀번호 passCheck부터 실행 후 int든 boolean이든 성공여부를 반환받아서 
		//성공시 if문을 사용하여 폼을 보여주는게 2번째가 된다
		
	
		
		String pw=request.getParameter("pw");
		HttpSession session = request.getSession();
		String uID=(String) session.getAttribute("uID");
		
		
		//modifyFormService 에 체크패스 메서드를 넣는다
		
		
		ModifyFormService modifyFormService =new ModifyFormService();
		int pwCheck=modifyFormService.checkPass2(uID,pw);
		
		
		
		if (pwCheck>0) {
			
			MemberBean memberBean=modifyFormService.getMemberInfo(uID);
			request.setAttribute("memberBean",memberBean);
			forward = new ActionForward();
			forward.setPath("/member/modify.jsp");
			
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>"); 
			out.println("alert('비밀번호를 확인 하세요')");
			out.println("history.back()");
			out.println("</script>"); 
		}
		
		
		
		
	
		
		
	
	
		
		
		return forward;
	}

}
