<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img{
width: 400px;
height: 300px;
}
</style>
</head>
<body>
<h2>book.jsp</h2>

<section id = "writeButton">	
	
		<a href=""><img src="./img/abstract.jpg"></a>	<br>
		
		<a href="BookBuy.book"><input type="button" value="구매하기"></a>
		<a href="BookCart.book"><input type="button" value="장바구니"></a>
		<a href="BookLike.book"><input type="button" value="♡"></a><br>
	
		<br>
		<br>

		<a href="ReviewList.book"><input type="button" value="리뷰리스트 + 작성"></a><br>
<!-- 		<a href="ReviewWriteForm.book"><input type="button" value="리뷰작성"></a> -->

		<br>

		<a href="QList.book"><input type="button" value="문의 리스트 + 작성"></a>
		
	</section>
</body>
</html>