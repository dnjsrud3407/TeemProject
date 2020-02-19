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
상품 후기 내역
<ul>
    <li><a href="ReviewDetail.abook">1번 상품</a>
        <input type="button" value="답변하기" onclick="location.href='ReviewWriteForm.abook'">
        <input type="button" value="수정하기" onclick="location.href='ReviewModifyForm.abook'"></li>
    <li>2번 상품</li>
    <li>3번 상품</li>
    <li>4번 상품</li>
</ul>
<input type="button" value="삭제하기" onclick="location.href='ReviewDeleteForm.abook'">
</body>
</html>