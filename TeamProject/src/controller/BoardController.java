package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.action.FAQ_DeleteProAction;
import board.action.FAQ_DetailAction;
import board.action.FAQ_ListAction;
import board.action.FAQ_ModifyFormAction;
import board.action.FAQ_ModifyProAction;
import board.action.FAQ_WriteProAction;
import board.action.Notice_DeleteProAction;
import board.action.Notice_DetailAction;
import board.action.Notice_ListAction;
import board.action.Notice_ModifyFormAction;
import board.action.Notice_ModifyProAction;
import board.action.Notice_WriteProAction;
import board.action.QDeleteProAction;
import board.action.QModifyFormAction;
import board.action.QModifyProAction;
import board.action.QWriteFormProAction;
import board.action.QWriteListAction;
import board.action.Q_DeleteProAction;
import board.action.Q_DetailAction;
import board.action.Q_ListAction;
import board.action.Q_ModifyFormAction;
import board.action.Q_ModifyProAction;
import board.action.Q_WriteFormAction;
import board.action.Q_WriteProAction;
import board.action.QdetailAction;
import vo.ActionForward;

@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String command = request.getServletPath();
		System.out.println(command);
		
		Action action = null;
		ActionForward forward = null;
		
		// 서블릿 주소에 따라 각각 다른 작업을 수행
		if (command.equals("/QWriteForm.bo")) {//
			forward = new ActionForward();
			forward.setPath("/QWriteForm.jsp");
		} else if(command.equals("/WriteFormPro.bo")) {//
			action = new QWriteFormProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/QModify.bo")) {//1:1문의 수정폼
			
			action = new QModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/QModifyPro.bo")) {//1:1문의 수정
			
			action = new QModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/QDeletePro.bo")) {//1:1문의 삭제
			
			action = new QDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/QWriteList.bo")) {//1:1 문의내역보기
			
			action = new QWriteListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Qdetail.bo")) {//1:1 문의내역보기
			
			action = new QdetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Q_List.bo")) { // ---------------------- 관리자 Area --- 1:1 
			// 1:1 목록 Q_ListAction()
			action = new Q_ListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Q_WriteForm.bo")) {
            // --- 1:1 답변 작성 폼 (사용자가 작성한 내용을 불러와야 함)
            action = new Q_WriteFormAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/Q_WritePro.bo")) {
            // --- 1:1 작성 작업 Q_WriteProAction()
            action = new Q_WriteProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/Q_Detail.bo")) {
			// 1:1 답변 상세보기
			action = new Q_DetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Q_ModifyForm.bo")) {
			// 1:1 글 수정하기 폼 (사용자가 작성한 내용 & 관리자가 작성한 내용 불러옴)
			action = new Q_ModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Q_ModifyPro.bo")) {
			// 1:1 글 수정 작업 
			action = new Q_ModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Q_DeleteForm.bo")) {
			// 1:1 글 삭제 폼
		    forward = new ActionForward();
            forward.setPath("./board/Q_DeleteForm.jsp");
		} else if(command.equals("/Q_DeletePro.bo")) {
            // --- 1:1 글 삭제 작업 
            action = new Q_DeleteProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/FAQ_List.bo")) { // --- FAQ
			// FAQ 목록 FAQ_ListAction()
			action = new FAQ_ListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/FAQ_WriteForm.bo")) {
            // --- FAQ 작성 폼 
            forward = new ActionForward();
            forward.setPath("./board/FAQ_WriteForm.jsp");
        } else if(command.equals("/FAQ_WritePro.bo")) {
            // --- FAQ 작성 작업 FAQ_WriteProAction()
            action = new FAQ_WriteProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/FAQ_Detail.bo")) {
            // --- FAQ 상세보기
            action = new FAQ_DetailAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/FAQ_ModifyForm.bo")) {
            // --- FAQ 수정 폼 (관리자가 작성한 내용 불러옴)
            action = new FAQ_ModifyFormAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/FAQ_ModifyPro.bo")) {
            // --- FAQ 수정 작업 
            action = new FAQ_ModifyProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/FAQ_DeleteForm.bo")) {
            // --- FAQ 삭제 폼
            forward = new ActionForward();
            forward.setPath("./board/FAQ_DeleteForm.jsp");
        } else if(command.equals("/FAQ_DeletePro.bo")) {
            // --- FAQ 삭제 작업 
            action = new FAQ_DeleteProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/Notice_List.bo")) { // --- Notice
            // Notice 목록 Notice_ListAction()
            action = new Notice_ListAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/Notice_WriteForm.bo")) {
            // --- Notice 작성 폼 
            forward = new ActionForward();
            forward.setPath("./board/Notice_WriteForm.jsp");
        } else if(command.equals("/Notice_WritePro.bo")) {
            // --- Notice 작성 작업 Notice_WriteProAction()
            action = new Notice_WriteProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/Notice_Detail.bo")) {
            // --- Notice 상세보기
            action = new Notice_DetailAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/Notice_ModifyForm.bo")) {
            // --- Notice 수정 폼 (관리자가 작성한 내용 불러옴)
            action = new Notice_ModifyFormAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/Notice_ModifyPro.bo")) {
            // --- Notice 수정 작업 
            action = new Notice_ModifyProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(command.equals("/Notice_DeleteForm.bo")) {
            // --- Notice 삭제 폼
            forward = new ActionForward();
            forward.setPath("./board/Notice_DeleteForm.jsp");
        } else if(command.equals("/Notice_DeletePro.bo")) {
            // --- Notice 삭제 작업 
            action = new Notice_DeleteProAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
