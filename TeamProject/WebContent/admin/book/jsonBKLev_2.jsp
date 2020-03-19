<%@page import="org.json.simple.JSONObject"%>
<%@page import="admin.book.svc.BKateService"%>
<%@page import="org.json.simple.JSONArray"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//등록 시 사용하는 BK1, BK2
String BK1 = request.getParameter("BK1");
String BK2 = request.getParameter("BK2");
// 레벨 기본값
out.print("<option value='선택하세요'>선택하세요</option>");

//수정 시 사용하는 BeforeBK1, BeforeBK2
String BeforeBK1 = request.getParameter("BeforeBK1");
String BeforeBK2 = request.getParameter("BeforeBK2");
String BeforeBKLev = request.getParameter("BeforeBKLev");

JSONArray BKList = null;
BKateService bKateService = new BKateService(); 
BKList = bKateService.getBKList("BK1, BK2, BKLev", "BKLev");

if(BeforeBK1 == null && BeforeBK2 == null){		// 글 등록 시
	if(!BK1.equals("선택하세요") && !BK2.equals("선택하세요")){
		// 대분류, 소분류 선택할 경우
		for(int i=0;i<BKList.size();i++){
			JSONObject jbb = (JSONObject)BKList.get(i);
			if(BK1.equals((String)jbb.get("BK1")) && BK2.equals((String)jbb.get("BK2"))){
				out.print("<option value='" + (String)jbb.get("BKLev") +"'>"+ (String)jbb.get("BKLev") +"</option>");
			} 
		}
	}
} else {	// 글 수정 시
	for(int i=0;i<BKList.size();i++){
		JSONObject jbb = (JSONObject)BKList.get(i);
		// 수정하기 전 카테고리 가져와서 selected 상태로
		if(BeforeBK1.equals((String)jbb.get("BK1")) && BeforeBK2.equals((String)jbb.get("BK2"))){
			if(BeforeBKLev.equals((String)jbb.get("BKLev"))){
				out.print("<option selected value='" + (String)jbb.get("BKLev") +"'>"+ (String)jbb.get("BKLev") +"</option>");
			} else {
				out.print("<option value='" + (String)jbb.get("BKLev") +"'>"+ (String)jbb.get("BKLev") +"</option>");
			}
		} 
	}
}
%>