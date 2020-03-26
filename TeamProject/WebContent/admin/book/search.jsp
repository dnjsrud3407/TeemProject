<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="vo.BookBean"%>
<%@page import="admin.book.svc.SearchService"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="admin.book.svc.BKService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//제품번호, 제품이름, 출판사, 카테고리(대, 레벨, 소) 파라미터
	String bookID = request.getParameter("bookID");
	String bookTitle = request.getParameter("bookTitle");
	String bookPublisher = request.getParameter("bookPublisher");
	String BK1 = request.getParameter("BK1");
	String BK2 = request.getParameter("BK2");
	String BK3 = request.getParameter("BK3");
	// 재고, 전시 체크여부
	String bookEA = request.getParameter("bookEA");
	String bookisView = request.getParameter("bookisView");
	
	// Map 에 저장
	Map<Object, Object> searchList = new HashMap<Object, Object>();
	searchList.put("bookID", bookID);
	searchList.put("bookTitle", bookTitle);
	searchList.put("bookPublisher", bookPublisher);
	searchList.put("BK1", BK1);
	searchList.put("BK2", BK2);
	searchList.put("BK3", BK3);
	searchList.put("bookEA", bookEA);
	searchList.put("bookisView", bookisView);
	// map 객체 key값 들고오기
	ArrayList keyList = new ArrayList(searchList.keySet());
	
	String searchSql = "";
	for(int i = 0; i < keyList.size(); i++) {
		// map객체(key값으로 서치)이 null 이 아니면
	    if(!(searchList.get(keyList.get(i)) == null || searchList.get(keyList.get(i)).equals("") || searchList.get(keyList.get(i)).equals("null") || searchList.get(keyList.get(i)).equals("선택하세요"))) {
	    	// map객체로 부터 sql 구문 만들기//
	    	// key값에 따라 sql 구문 다르게
	    	if(keyList.get(i).equals("bookID")) {
	    		// 만약 bookID 값이 체크 되었다면
	    		searchSql += " and " + keyList.get(i) + "=" + searchList.get(keyList.get(i));
	    	} else if(keyList.get(i).equals("bookEA")) {
				// 만약 bookEA 값이 체크 되었다면
				searchSql += " and " + keyList.get(i) + "<" + 10;
			} else if(keyList.get(i).equals("bookisView")) {
				// 만약 bookisView 값이 체크 되었다면
				searchSql += " and " + keyList.get(i) + "=false";
			} else {	// 그 밖의 컬럼 : 전부 문자열
				searchSql += " and " + keyList.get(i) + "='" + searchList.get(keyList.get(i)) + "'";
			}
	    }
	}

	// ================= 페이징 =================
	// 현재 페이지 번호 및 한 페이지당 게시글 수//
	int nowPage = 1;
	int limit = 10;
	
	String stringPage = request.getParameter("page");

	// 파라미터에 page값이 없는 경우
	if(stringPage == null || stringPage.trim().equals("null")) {
		nowPage = 1;
	} else {
		nowPage = Integer.parseInt(stringPage);
	}
		

	SearchService searchService = new SearchService(); 
	// 게시글 개수
	int listCount = searchService.getSearchListCount(searchSql);
	
	// === bookList 가져오기
	ArrayList<BookBean> bookList = searchService.getSearchBookList(searchSql, nowPage, limit);
	System.out.println(searchSql);
	
	JSONArray jbookList = new JSONArray();
	for(int i=0; i<bookList.size(); i++){
		JSONObject jbb = new JSONObject();
		jbb.put("bookID", ""+bookList.get(i).getBookID()+"");
		jbb.put("bookTitle", bookList.get(i).getBookTitle());
		jbb.put("bookPublisher", bookList.get(i).getBookPublisher());
		jbb.put("bookPublishedDate", ""+bookList.get(i).getBookPublishedDate()+"");
		jbb.put("bookPrice", ""+bookList.get(i).getBookPrice()+"");
		jbb.put("bookEA", ""+bookList.get(i).getBookEA()+"");
		jbb.put("bookisView", ""+bookList.get(i).isBookisView()+"");
		jbb.put("salesVolume", ""+bookList.get(i).getSalesVolume()+"");
		jbb.put("saveRatio", ""+bookList.get(i).getSaveRatio()+"");
		jbb.put("BK1", bookList.get(i).getBK1());
		jbb.put("BK2", bookList.get(i).getBK2());
		jbb.put("BK3", bookList.get(i).getBK3());
		jbookList.add(jbb);
	}
	System.out.println(jbookList);
	
// 	JSONObject json = new JSONObject();
// 	json.put("jbookList", jbookList);
%>
<%=jbookList%>


