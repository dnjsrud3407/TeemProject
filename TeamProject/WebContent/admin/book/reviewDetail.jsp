<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<a href="./admin/adminMain.jsp">메인으로</a><br>
사용자가 작성한 후기<br>
<br>
관리자가 답변한 내용<br>
<input type="button" value="답변하기" onclick="location.href='ReviewWriteForm.abook'">
<input type="button" value="수정하기" onclick="location.href='ReviewModifyForm.abook'">
<input type="button" value="삭제하기" onclick="location.href='ReviewDeleteForm.abook'">
</body>
</html>