package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.board.action.FAQDeleteProAction;
import admin.board.action.FAQDetailAction;
import admin.board.action.FAQModifyFormAction;
import admin.board.action.FAQModifyProAction;
import admin.board.action.FAQWriteFormAction;
import admin.board.action.FAQWriteProAction;
import admin.board.action.NoticeDeleteProAction;
import admin.board.action.NoticeDetailAction;
import admin.board.action.NoticeModifyProAction;
import admin.board.action.NoticeWriteProAction;
import admin.board.action.FAQListAction;
import admin.board.action.NoticeListAction;
import admin.board.action.NoticeModifyFormAction;
//import admin.board.action.MemberQListAction;
import admin.board.action.QWriteProAction;
//import admin.board.action.MemberQdetailAction;
import vo.ActionForward;

@WebServlet("*.adb")
public class AdminBoardController extends HttpServlet {
	
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String command = request.getServletPath();
		System.out.println(command);
		
		Action action = null;
		ActionForward forward = null;
		
		// 서블릿 주소에 따라 각각 다른 작업을 수행
		if (command.equals("/QAnswerWriteForm.adb")) {//	1:1 문의 답변 작성 폼
			forward = new ActionForward();
			forward.setPath("/admin/QWriteForm.jsp");
			
		} else if(command.equals("/QList.adb")) {//1:1 문의 목록 보기 (미답변 글 위주)
			
//			action = new MemberQListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Qdetail.adb")) {//1:1 문의 내용 보기
			
//			action = new MemberQdetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
            
            //
            // FAQ 관련
            //
        } else if(command.equals("/FAQ.adb")) { // --- FAQ
			// FAQ 목록 FAQListAction()
			action = new FAQListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/FAQWrite.adb")) {
            // --- FAQ 작성 폼 
            action = new FAQWriteFormAction();
            
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
            
        } else if(command.equals("/FAQWritePro.adb")) {
            // --- FAQ 작성 작업 FAQWriteProAction()
            action = new FAQWriteProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/FAQDetail.adb")) {
            // --- FAQ 상세보기
            action = new FAQDetailAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/FAQModifyForm.adb")) {
            // --- FAQ 수정 폼 (관리자가 작성한 내용 불러옴)
            action = new FAQModifyFormAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/FAQModifyPro.adb")) {
            // --- FAQ 수정 작업 
            action = new FAQModifyProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/FAQDeleteForm.adb")) {
            // --- FAQ 삭제 폼
            forward = new ActionForward();
            forward.setPath("./board/FAQDeleteForm.jsp");
        } else if(command.equals("/FAQDeletePro.adb")) {
            // --- FAQ 삭제 작업 
            action = new FAQDeleteProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            //
            // 공지 관련
            //
        } else if(command.equals("/notice.adb")) { // --- Notice
            // Notice 목록 NoticeListAction()
            action = new NoticeListAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/noticeWrite.adb")) {
            // --- Notice 작성 폼 
            forward = new ActionForward();
            forward.setPath("./board/NoticeWriteForm.jsp");
        } else if(command.equals("/noticeWritePro.adb")) {
            // --- Notice 작성 작업 NoticeWriteProAction()
            action = new NoticeWriteProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/noticeDetail.adb")) {
            // --- Notice 상세보기
            action = new NoticeDetailAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/noticeModify.adb")) {
            // --- Notice 수정 폼 (관리자가 작성한 내용 불러옴)
            action = new NoticeModifyFormAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/noticeModifyPro.adb")) {
            // --- Notice 수정 작업 
            action = new NoticeModifyProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/NoticeDeleteForm.adb")) {
            // --- Notice 삭제 폼
            forward = new ActionForward();
            forward.setPath("./board/NoticeDeleteForm.jsp");
        } else if(command.equals("/noticeDeletePro.adb")) {
            // --- Notice 삭제 작업 
            action = new NoticeDeleteProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/event.adb")) {
            // --- Notice 삭제 작업 
            action = new NoticeDeleteProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/eventWrite.adb")) {
            // --- Notice 삭제 작업 
            action = new NoticeDeleteProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  else if(command.contentEquals("/failed.adb")) {
        	forward = new ActionForward();
        	forward.setPath("/admin/board/failedMSG.jsp");
        }
	
		

		//=================================================================================
        // ActionForward 객체의 포워딩 방식
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}else {
			System.out.println("ActionFoward 이 null입니다");
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
