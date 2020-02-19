<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="Q_List.bo">1:1문의 내역</a><br>
사용자가 질문한 내용 표시 <br>
관리자가 답변한 내용 표시 <br>
<input type="button" value="답변하기" onclick="location.href='Q_WriteForm.bo'">
<input type="button" value="답변수정" onclick="location.href='Q_ModifyForm.bo'">
<input type="button" value="답변삭제" onclick="location.href='Q_DeleteForm.bo'">
</body>
</html>