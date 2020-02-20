<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
주문목록조회

<form action="OrderDetail.mo" method="post">
<input type="submit" value="주문한거">

</form>
<form action="OrderCancel.mo" method="post">
<input type="submit" value="주문취소">

</form>
<form action="OrderDelivery.mo" method="post">
<input type="submit" value="배송조회">

</form>
<form action="OrderExchange.mo" method="post">
<input type="submit" value="교환신청">

</form>
<form action="OrderRefund.mo" method="post">
<input type="submit" value="반품신청">

</form>
</body>
</html>