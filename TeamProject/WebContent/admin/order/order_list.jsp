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
<h2>order_list.jsp</h2>

<section id = "writeButton">	
		<h2><a href="OrderDetail.adm">주문 리스트목록입니다</a></h2>
	<!-- 		<a href="ReviewDetail.book">제품교한 디테일입니다</a><br> -->
<!-- 		<br> -->
		<a href="OrderDeliveryList.adm"><input type="button" value="배송 진행리스트"></a>
		
<!-- 		<a href="ReviewDetail.book">주문취소 디테일입니다</a><br> -->
<!-- 		<br> -->
		<a href="OrderCencleList.adm"><input type="button" value="주문취소 진행리스트"></a>
<!-- 		<a href="ReviewWriteForm.book"><input type="button" value="리뷰작성"></a> -->

		
<!-- 		<a href="QDetail.book">제품반품 디테일입니다</a><br> -->
<!-- 		<br> -->
		<a href="OrderRefundList.adm"><input type="button" value="제품반품 진행리스트"></a>
		
<!-- 		<a href="ReviewDetail.book">제품교한 디테일입니다</a><br> -->
<!-- 		<br> -->
		<a href="OrderExchangeList.adm"><input type="button" value="제품교환 진행리스트"></a> <br>
		<br>
		
		<a href="OrderCompList.adm"><input type="button" value="거래완료 진행리스트"></a>
		
		
	</section>
</body>
</html>