package admin.book.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import admin.book.svc.WriteProService;
import vo.ActionForward;
import vo.BookBean;

public class WriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		// 파일 업로드 설정
		String saveFolder = "/upload";
		ServletContext context = request.getServletContext(); 
        String realFolder = context.getRealPath(saveFolder);
        int fileSize = 1024 * 1024 * 10;
        
        MultipartRequest multi = new MultipartRequest(
                request,
                realFolder,      
                fileSize, 
                "UTF-8", 
                new DefaultFileRenamePolicy()  
                );
        
        // 서버에 저장되는 상품 이미지 이름
        String bookImage = multi.getFilesystemName((String)multi.getFileNames().nextElement());
        // 상품 이미지
        String bookOriginImage = multi.getOriginalFileName((String)multi.getFileNames().nextElement());
        
        WriteProService writeProService = new WriteProService();

        // ===== 책 카테고리 찾기
        String BKLev = multi.getParameter("BKLev");
        int bookKategorie_BKID = writeProService.getBKLev(BKLev);
        
        // ===== 날짜 값 Date로 변환하기
        String publishedDate = multi.getParameter("bookPublishedDate"); // 날짜 값
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");   // 날짜 형식
        Date bookPublishedDate = format.parse(publishedDate);
        
        // ==== 공개 / 비공개 여부 설정
        boolean bookisView = false;
        String bookisViewStr = multi.getParameter("bookisView");
        if (bookisViewStr.equals("true")) { // 공개로 설정 시
            bookisView = true;
        }

        // bookID 구하기
        int bookID = writeProService.getBookID();
        
        // form 태그에서 책 정보 가져오기 (북 카테고리는 아직 미완성)
        BookBean book = new BookBean(
                bookID,
                multi.getParameter("bookTitle"), 
                bookOriginImage, 
                bookImage, 
                multi.getParameter("bookPublisher"), 
                bookPublishedDate,
                Integer.parseInt(multi.getParameter("bookPrice")), 
                Integer.parseInt(multi.getParameter("bookEA")), 
                multi.getParameter("bookIntroduce"), 
                bookisView,
                Float.parseFloat(multi.getParameter("saveRatio")),
                bookKategorie_BKID
                );
        // 책 등록하는 클래스
		boolean iswriteArticleSuccess = writeProService.writeArticle(book);
		
		if(iswriteArticleSuccess) {   // 등록 성공 시
		    forward = new ActionForward();
		    // 책 등록한거 상세보기
		    forward.setPath("Detail.abook?bookID=" + book.getBookID());
		    forward.setRedirect(true);
		} else {
		 // 실패시
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            out.println("<script>");        
            out.println("alert('게시물 등록 실패')");
            // 이전 페이지로 돌아가기
            out.println("history.back()");       
            out.println("</script>");
		}
		
		return forward;
	}

}
