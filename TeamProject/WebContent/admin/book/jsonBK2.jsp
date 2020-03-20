<%@page import="admin.book.svc.BKService"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 등록 시 사용하는 BK1
String BK1 = request.getParameter("BK1");
// 소분류 기본값
out.print("<option value='선택하세요'>선택하세요</option>");

// 수정 시 사용하는 BeforeBK1, BeforeBK2
String BeforeBK1 = request.getParameter("BeforeBK1");
String BeforeBK2 = request.getParameter("BeforeBK2");

JSONArray BKList = null;
BKService bKateService = new BKService(); 
BKList = bKateService.getBKList("BK1, BK2", "BK2");
if(BeforeBK1 == null && BeforeBK2 == null){		// 글 등록 시
	// 대분류 선택할 경우
	if(!BK1.equals("선택하세요")){
		
		for(int i=0;i<BKList.size();i++){
	JSONObject jbb = (JSONObject)BKList.get(i);
	if(BK1.equals((String)jbb.get("BK1"))){
		out.print("<option value='"+ (String)jbb.get("BK2") +"'>"+ (String)jbb.get("BK2") +"</option>");
	} 
		}
	}
} else {	// 글 수정 시 수정
	for(int i=0;i<BKList.size();i++){
		JSONObject jbb = (JSONObject)BKList.get(i);
		// 수정하기 전 카테고리 가져와서 selected 상태로
		if(BeforeBK1.equals((String)jbb.get("BK1"))){
	if(BeforeBK2.equals((String)jbb.get("BK2"))){
		out.print("<option selected value='"+ (String)jbb.get("BK2") +"'>"+ (String)jbb.get("BK2") +"</option>");
	} else {
		out.print("<option value='"+ (String)jbb.get("BK2") +"'>"+ (String)jbb.get("BK2") +"</option>");
	}
		} 
	}
}
%>

