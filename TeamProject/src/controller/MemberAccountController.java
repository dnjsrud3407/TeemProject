package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.account.action.DeleteProAction;
import member.account.action.FindIdProAction;
import member.account.action.FindPassProAction;
import member.account.action.JoinProAction;
import member.account.action.LoginProAction;
import member.account.action.LogoutProAction;
import member.account.action.ModifyAction;
import member.account.action.OffInfoAction;
import vo.ActionForward;

@WebServlet("*.me")
public class MemberAccountController extends HttpServlet {
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		
		
		request.setCharacterEncoding("utf-8");
		
		String command = request.getServletPath();
		System.out.println(command);
		
		
		Action action = null;
	ActionForward forward = null;
	
	if (command.equals("/Login.me")) {//
		forward = new ActionForward();
		forward.setPath("/member/login.jsp");
		
	}else if(command.equals("/LoginPro.me")) {//�α��ι�ư����
		
		action = new LoginProAction();
		
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/LogoutPro.me")) {//�α׾ƿ�
		
		action = new LogoutProAction();
		
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/FindId.me")) {//���̵�ã�� ��
		forward = new ActionForward();
		forward.setPath("/member/findId.jsp");
		
	}else if(command.equals("/FindIdPro.me")) {//���̵�ã�� �׼�
		action = new FindIdProAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/FindPass.me")) {//
		forward = new ActionForward();
		forward.setPath("/member/findPass.jsp");
		
	}else if(command.equals("/FindPassPro.me")) {//
		action = new FindPassProAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/JoinForm.me")) {//회원가입
		forward = new ActionForward();
		forward.setPath("/member/join.jsp");
		
	}else if(command.equals("/JoinPro.me")) {//
		forward = new ActionForward();
		action = new JoinProAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/OffInfo.me")) {//
		action = new OffInfoAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/DeleteForm.me")) {//
		forward = new ActionForward();
		forward.setPath("/member/delete.jsp"); //
		
	}else if(command.equals("/DeletePro.me")) {
		action = new DeleteProAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/Modify.me")) {//
		action = new ModifyAction();
		forward = new ActionForward();
		forward.setPath("/member/modify.jsp"); //
		
	}
		
		 
		
		
		
		
		
		
		if (forward!=null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}else {
			System.out.println("ActionFoward객체 널");
		}
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	
	
	
}
