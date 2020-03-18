<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Class.forName("com.mysql.jdbc.Driver");
//디비연결
String url = "jdbc:mysql://localhost:3306/bookshop";
String user = "root";
String password = "1234";
Connection con = DriverManager.getConnection(url, user, password);
//sql 구문
String sql = "select distinct BK1, BK2, BKLev from bookkategorie";
//rs = 실행
PreparedStatement pstmt = con.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
//조회 데이터가 있으면 자바빈 객체 생성
//rs 내용 배열에 담기
//List<BoardBean> boardList = new ArrayList<BoardBean>();
JSONArray BKList = new JSONArray();
while(rs.next()){
	// BoardBean 대신 JSONObject 사용
	JSONObject jbb = new JSONObject();
	jbb.put("BK2", rs.getString("BK2"));
	jbb.put("BKLev", rs.getString("BKLev"));
	BKList.add(jbb);
	
//	BoardBean bb = new BoardBean();
//	bb.setNum(rs.getInt("num"));
//	bb.setName(rs.getString("name"));
//	bb.setPass(rs.getString("pass"));
//	bb.setSubject(rs.getString("subject"));
//	boardList.add(bb);
}
%>
<%=BKList%>