<%@page import="admin.book.svc.BKateService"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
JSONArray BKList = null;
BKateService bKateService = new BKateService(); 
BKList = bKateService.getBKList("BK1", "BK1");
%>
<%=BKList%>