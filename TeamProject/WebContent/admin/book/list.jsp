<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<a href="./admin/adminMain.jsp">메인으로</a>
상품 내역<br>
<input type="text"><input type="button" value="상품검색" onclick="location.href='Search.abook'">
<ul>
    <li><a href="Detail.abook">1번 상품</a><input type="button" value="수정하기" onclick="location.href='ModifyForm.abook'"></li>
    <li>2번 상품</li>
    <li>3번 상품</li>
    <li>4번 상품</li>
</ul>
<input type="button" value="삭제하기" onclick="location.href='DeleteForm.abook'">
</body>
</html>