<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin 메인</title>
</head>
<body>
	<ul>
		<li><a href="">회원관리</a></li>
		<li><a href="">주문 / 매출 조회</a></li>
		<li>제품관리
            <ul>
                <li><a href="../List.abook">제품목록(수정/삭제/검색)</a></li>
                <li><a href="../WriteForm.abook">제품등록</a></li>
                <li><a href="../ReviewList.abook">상품후기(답변/수정/삭제)</a></li>
                <li><a href="../QList.abook">상품문의(답변작성/수정/삭제)</a></li>
                <li><a href="../RefundList.abook">상품반품(엑셀)</a></li>
                <li><a href="../BuyList.abook">물량추가(엑셀)</a></li>
            </ul>
        </li>
		<li>게시판관리
            <ul>
                <li><a href="../Q_List.bo">1:1답변목록(답변/수정/삭제)</a></li>
                <li><a href="../FAQ_List.bo">FAQ목록(답변/수정/삭제)</a></li>
                <li><a href="../Notice_List.bo">배너 - 공지사항/이벤트목록(작성/수정/삭제)</a></li>
            </ul>
        </li>
	</ul>
</body>
</html>