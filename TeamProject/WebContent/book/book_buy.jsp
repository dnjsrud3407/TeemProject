<%@page import="vo.CartBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Bootshop online Shopping cart</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<!--Less styles -->
   <!-- Other Less css file //different less files has different color scheam
    <link rel="stylesheet/less" type="text/css" href="themes/less/simplex.less">
    <link rel="stylesheet/less" type="text/css" href="themes/less/classified.less">
    <link rel="stylesheet/less" type="text/css" href="themes/less/amelia.less">  MOVE DOWN TO activate
    -->
    <!--<link rel="stylesheet/less" type="text/css" href="themes/less/bootshop.less">
    <script src="themes/js/less.js" type="text/javascript"></script> -->
    
<!-- Bootstrap style --> 
    <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css?ver=1" media="screen"/>
    <link href="themes/css/base.css?ver=1" rel="stylesheet" media="screen"/>
<!-- Bootstrap style responsive --> 
    <link href="themes/css/bootstrap-responsive.min.css?ver=1" rel="stylesheet"/>
    <link href="themes/css/font-awesome.css?ver=1" rel="stylesheet" type="text/css">
<!-- Google-code-prettify -->   
    <link href="themes/js/google-code-prettify/prettify.css?ver=1" rel="stylesheet"/>
<!-- fav and touch icons -->
    <link rel="shortcut icon" href="themes/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="themes/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="themes/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="themes/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="themes/images/ico/apple-touch-icon-57-precomposed.png">
    
    <!-- Cutomizing CSS -->
    <link href="css/order.css" rel="stylesheet">

  
    <!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" charset="utf-8">
function requestPay() {
    var IMP = window.IMP; // 생략가능
    IMP.init('imp39182007');
    var totalPrice = $("#finalPrice").val();
    var bookTitle = $("#payTitle").val();
    
    IMP.request_pay({
        pg : 'inicis', // version 1.1.0부터 지원.
        pay_method : 'card',
        merchant_uid : 'merchant_' + new Date().getTime(),
        name : bookTitle,
        amount : 100,
        buyer_email : 'iamport@siot.do',
        buyer_name : '구매자이름',
        buyer_tel : '010-1234-5678',
        buyer_addr : '서울특별시 강남구 삼성동',
        buyer_postcode : '123-456',
        m_redirect_url : 'https://www.yourdomain.com/payments/complete'
    }, function(rsp) {
        if ( rsp.success ) {
            document.fr.submit();
        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
        }
        alert(msg);
    });
}
function qtyRemove(cartNum){
	var removeUrl='CartRemove.book?cartNum=' + cartNum;
		if(confirm('삭제하시겠습니까?')){
			location.href=removeUrl;	
		}
}
// 쿠폰 적용
function couponDis(finalPrice){
	var beforePrice = parseInt(finalPrice);
	
	// 셀렉트에 선택된 num(value로) 구하기, volume(num를 id로 가지는)구하기 
	var num = "#" + $("#couponList option:selected").val();
	var volume = parseInt($(num).val());
	
	// 쿠폰이 없는 경우
	if(num == "#-1") {
		alert('사용가능한 쿠폰이 없습니다');
		volume = 0;		// 쿠폰 초기화
	} 
	// 쿠폰 선택하지 않고 적용 누른 경우
	else if(num == "#0") {
		alert('쿠폰을 선택해주세요');
		volume = 0;		// 쿠폰 초기화
	}
	
	$("#disCoupon").val(volume);
	// 사용한 포인트 가져오기
	var point = parseInt($("#disPoint").val());
	// 최종 결제금액 적용
	$("#finalPrice").val(beforePrice-point-volume);
}
// 포인트 적용
function pointDis(finalPrice, memberPoint){
	// 포인트 입력한 값, 사용자 포인트 값, 총 결제금액
	var point = parseInt($("#pointInput").val());
	var memberPoint = parseInt(memberPoint);
	var beforePrice = parseInt(finalPrice);
	
	// 입력한 포인트가 보유한 포인트 보다 클 때
	if(point > memberPoint) {
		alert('사용가능한 포인트는 ' + memberPoint + 'P 입니다.');
		$("#pointInput").val(0);	// 포인트 Input 박스 초기화
		point = 0;	// 포인트 초기화
	}
	$("#disPoint").val(point);
	// 사용한 쿠폰값 가져오기
	var coupon = parseInt($("#disCoupon").val());
	// 최종 결제금액 적용
	$("#finalPrice").val(beforePrice-point-coupon);
}
</script>
  </head>
<body>
<div id="header">
<div class="container">
<div id="welcomeLine" class="row">
    <!-- <div class="span6"></div> -->
    <div class="">
	    <span style="padding-left: 30px;font-size: 15px;">
	    	<c:if test="${sessionScope.uID ne null}"> 
		        welcome ${sessionScope.uID}님
		    </c:if></span>
	    <div class="pull-right">
	    	<c:set var="strAdmin" value="<%= new String[]{\"admin\",\"admin1\",\"admin2\",\"admin3\",\"admin4\"} %>"/>
	    	<c:forEach var = "i" items="${strAdmin }">
	    		<c:if test="${sessionScope.uID.equals(i)}">
	    		 	<a href="AdminMain.adm">관리자</a> |
	    		</c:if>
	    	</c:forEach>
	    	<c:if test="${sessionScope.uID.equals('admin')}">
<!-- 		    <a href="AdminMain.adm">관리자</a> | -->
		    </c:if>
		    <c:if test="${sessionScope.uID ne null}"> 
		        <a href="LogoutPro.me">로그아웃</a> |
		    </c:if>
		    <c:if test="${sessionScope.uID eq null}">
		        <a href="Login.me">로그인</a> |
		    </c:if>
		    <c:if test="${sessionScope.uID ne null}">
	        </c:if>
	        <c:if test="${sessionScope.uID eq null}">
	        <a href="JoinForm.me">회원가입</a> |
	        </c:if>
	        <a href="OrderList.mo">마이페이지</a> |
	        <a href="helpCenter.jsp">고객센터</a>
	        <a href="BookCart.book"><span class="btn btn-mini btn-primary"><i class="icon-shopping-cart icon-white"></i> [ ${cartList.size()} ] 장바구니 </span> </a> 
	    </div>
    </div>
</div>
<!-- Navbar ================================================== -->
<div id="logoArea" class="navbar">
<a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
</a>
  <div class="navbar-inner">
    <a class="brand" href="index.jsp"><img src="themes/images/logo.png?ver=1" alt="Bootsshop"/></a>
<!--    검색하는 창 -->
    <form class="form-inline navbar-search pull-right" method="post" action="products.html" >
        <input id="srchFld" class="srchTxt" type="text" />
        <button type="submit" id="submitButton" class="btn btn-primary">검색</button>
    </form>
    <ul id="topMenu" class="nav">
     <li><a href="">로드맵</a></li>
     <li><a href="BookList.book">교재구매</a></li>
     <li><a href="NoticeList.bo">이벤트</a></li>
    </ul>
  </div>
</div>
</div>
</div>
<!-- Header End====================================================================== -->

<div id="mainBody">
	<div class="container">
	<div class="row">

<!-- Sidebar ================================================== -->
    <jsp:include page="../inc/menu.jsp"></jsp:include>
<!-- Sidebar end=============================================== -->
	<!-- 결제하는 Form -->		
	<form class="form-horizontal" action="BookBuyPro.book" name="fr" method="post">
	
	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.jsp">Home</a> <span class="divider">/</span></li>
		<li class="active"> 주문/결제</li>
    </ul>
	<h3>  SHOPPING CART [ <small>${cartList.size()} Item(s) </small>]<a href="products.html" class="btn btn-large pull-right"><i class="icon-arrow-left"></i> Continue Shopping </a></h3>	
	<hr class="soft"/>
	
	<!-- 상품목록 보여주는 테이블 -->
		<table class="table table-bordered">
             <thead>
               <tr>
                 <th>상품</th>
                 <th>상품명</th>
                 <th>수량변경</th>
                 <th>총가격</th>
			</tr>
             </thead>
             <tbody>
             <c:forEach var="cart" items="${cartList }" varStatus="status">
             	<input type="hidden" name="bookID${status.index }" value="${cart.bookID }">
             	<input type="hidden" name="bookTitle${status.index }" value="${cart.bookTitle }">
             	<input type="hidden" name="bookPrice${status.index }" value="${cart.bookPrice }">
             	<input type="hidden" name="bookEA${status.index }" value="${cart.bookEA }">
             	<c:choose>
             		<c:when test="${fn:length(cartList) > 1}">
             			<input type="hidden" id="payTitle" value="${cart.bookTitle } 외 ${fn:length(cartList)}건">
             		</c:when>
            		<c:otherwise>
             			<input type="hidden" id="payTitle" value="${cart.bookTitle }">
             		</c:otherwise>   
             	</c:choose>           	      	
               <tr>
                 <td><img width="60" src="./upload/${cart.bookImage }" alt="상품이미지"/></td>
                 <td>${cart.bookTitle}</td>
			     <td>${cart.bookEA }</td>
                 <td>${cart.bookPrice * cart.bookEA}</td>
               </tr>
             </c:forEach>  
			</tbody>
         </table>
	<hr class="soft"/>
	<br><br>
	<input type="hidden" name="recName" value="${memberBean.u_name }">
	<input type="hidden" name="recPhone" value="${memberBean.tell_num }">
	<input type="hidden" name="orderAddress" value="${memberBean.address2 }">
	<!-- 배송지 Table -->	
    <table class="table">
	  <tr><th>배송지 </th></tr>
	  <tr> 
		<td>
		  ${memberBean.u_name } / ${memberBean.tell_num } <br>
		  ${memberBean.address2 }
		</td>
	   </tr>
    </table>
    <br>
    <c:set var="finalPrice" value="${totalPrice + shipPrice }"></c:set>
    <!-- 할인 Table -->	
    <table class="table">
	  <tr><th>할인적용 </th></tr>
	  <tr> 
		<td>할인 쿠폰&nbsp;&nbsp;
		  <select name="couponList" id="couponList">
		  	<c:choose>
		  		<c:when test="${fn:length(couponList) < 1}">
		  			<option value="-1">사용가능한 쿠폰이 없습니다</option>
		  		</c:when>
		  		<c:otherwise>
				  	<option value="0">선택하세요</option>
				  	<c:forEach var="coupon" items="${couponList }" varStatus="status">
				  		<option value="${coupon.num }">${coupon.coupon_name }</option>
				  	</c:forEach>
		  		</c:otherwise>
		  	</c:choose>
		  </select>
		  <c:forEach var="coupon" items="${couponList }" varStatus="status">
	  		<input type="hidden" id="${coupon.num }" value="${coupon.volume }">
		  </c:forEach>
		  <input type="button" value="쿠폰적용" onclick="couponDis(${finalPrice})">
		</td>
	   </tr>
	   <tr>
	   	<td>
	   		포인트 사용 (${memberBean.point }P 보유)&nbsp;&nbsp;<input type="text" name="point" id="pointInput" placeholder="포인트를 입력해주세요">
	   		<input type="button" value="포인트적용" onclick="pointDis(${finalPrice}, ${memberBean.point })">
	   	</td>
	   </tr>
    </table>
    <br>

	<hr class="soft"/>
	
		<table class="table table-bordered">
		 <tr><th>결제예정금액 </th></tr>
		 <tr> 
		 <td>
		   <div class="control-group">
			 <label class="control-label">총 상품금액 </label>
			 <div class="controls">
			   <input type="text" name="totalPrice" id="totalPrice" value="${totalPrice }" readonly="readonly">
			 </div>
		   </div>
		   <div class="control-group">
			 <label class="control-label">배송비 </label>
			 <div class="controls">
			  	   <input type="text" name="shipPrice" value="${shipPrice }" readonly="readonly">
			 </div>
		   </div>
		   <div class="control-group">
			 <label class="control-label">할인쿠폰 </label>
			 <div class="controls">
			  	   <input type="text" name="disCoupon" id="disCoupon" value="0" readonly="readonly">
			 </div>
		   </div>
		    <div class="control-group">
			 <label class="control-label">포인트사용 </label>
			 <div class="controls">
			  	   <input type="text" name="disPoint" id="disPoint" value="0" readonly="readonly">
			 </div>
		   </div>
		   <div class="control-group">
			 <label class="control-label">최종 결제금액 </label>
			 <div class="controls">
			   <input type="text" name="finalPrice" id="finalPrice" value="${finalPrice }" readonly="readonly">
			 </div>
		   </div>
		 </td>
		 </tr>
       </table>		
           <div class="centerBtn">
             <input type="button" class="btn btn-large" onclick="location.href='Main.me'" value="쇼핑계속하기"> 
    	   <input type="button" class="btn btn-large" value="주문하기" onclick="requestPay()">
  	     </div> 
   </form>				  
	
</div>
</div></div>
</div>
<!-- MainBody End ============================= -->
<!-- Footer ================================================================== -->
	<div  id="footerSection">
	<div class="container">
		<div class="row">
			<div class="span3">
				<h5>ACCOUNT</h5>
				<a href="login.html">YOUR ACCOUNT</a>
				<a href="login.html">PERSONAL INFORMATION</a> 
				<a href="login.html">ADDRESSES</a> 
				<a href="login.html">DISCOUNT</a>  
				<a href="login.html">ORDER HISTORY</a>
			 </div>
			<div class="span3">
				<h5>INFORMATION</h5>
				<a href="contact.html">CONTACT</a>  
				<a href="register.html">REGISTRATION</a>  
				<a href="legal_notice.html">LEGAL NOTICE</a>  
				<a href="tac.html">TERMS AND CONDITIONS</a> 
				<a href="faq.html">FAQ</a>
			 </div>
			<div class="span3">
				<h5>OUR OFFERS</h5>
				<a href="#">NEW PRODUCTS</a> 
				<a href="#">TOP SELLERS</a>  
				<a href="special_offer.html">SPECIAL OFFERS</a>  
				<a href="#">MANUFACTURERS</a> 
				<a href="#">SUPPLIERS</a> 
			 </div>
			<div id="socialMedia" class="span3 pull-right">
				<h5>SOCIAL MEDIA </h5>
				<a href="#"><img width="60" height="60" src="themes/images/facebook.png" title="facebook" alt="facebook"/></a>
				<a href="#"><img width="60" height="60" src="themes/images/twitter.png" title="twitter" alt="twitter"/></a>
				<a href="#"><img width="60" height="60" src="themes/images/youtube.png" title="youtube" alt="youtube"/></a>
			 </div> 
		 </div>
		<p class="pull-right">&copy; Bootshop</p>
	</div><!-- Container End -->
	</div>
<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<script src="themes/js/jquery.js" type="text/javascript"></script>
	<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="themes/js/google-code-prettify/prettify.js"></script>
	
	<script src="themes/js/bootshop.js"></script>
    <script src="themes/js/jquery.lightbox-0.5.js"></script>
	
	<!-- Themes switcher section ============================================================================================= -->
<div id="secectionBox">
<link rel="stylesheet" href="themes/switch/themeswitch.css" type="text/css" media="screen" />
<script src="themes/switch/theamswitcher.js" type="text/javascript" charset="utf-8"></script>
	<div id="themeContainer">
	<div id="hideme" class="themeTitle">Style Selector</div>
	<div class="themeName">Oregional Skin</div>
	<div class="images style">
	<a href="themes/css/#" name="bootshop"><img src="themes/switch/images/clr/bootshop.png" alt="bootstrap business templates" class="active"></a>
	<a href="themes/css/#" name="businessltd"><img src="themes/switch/images/clr/businessltd.png" alt="bootstrap business templates" class="active"></a>
	</div>
	<div class="themeName">Bootswatch Skins (11)</div>
	<div class="images style">
		<a href="themes/css/#" name="amelia" title="Amelia"><img src="themes/switch/images/clr/amelia.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="spruce" title="Spruce"><img src="themes/switch/images/clr/spruce.png" alt="bootstrap business templates" ></a>
		<a href="themes/css/#" name="superhero" title="Superhero"><img src="themes/switch/images/clr/superhero.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="cyborg"><img src="themes/switch/images/clr/cyborg.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="cerulean"><img src="themes/switch/images/clr/cerulean.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="journal"><img src="themes/switch/images/clr/journal.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="readable"><img src="themes/switch/images/clr/readable.png" alt="bootstrap business templates"></a>	
		<a href="themes/css/#" name="simplex"><img src="themes/switch/images/clr/simplex.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="slate"><img src="themes/switch/images/clr/slate.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="spacelab"><img src="themes/switch/images/clr/spacelab.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="united"><img src="themes/switch/images/clr/united.png" alt="bootstrap business templates"></a>
		<p style="margin:0;line-height:normal;margin-left:-10px;display:none;"><small>These are just examples and you can build your own color scheme in the backend.</small></p>
	</div>
	<div class="themeName">Background Patterns </div>
	<div class="images patterns">
		<a href="themes/css/#" name="pattern1"><img src="themes/switch/images/pattern/pattern1.png" alt="bootstrap business templates" class="active"></a>
		<a href="themes/css/#" name="pattern2"><img src="themes/switch/images/pattern/pattern2.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern3"><img src="themes/switch/images/pattern/pattern3.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern4"><img src="themes/switch/images/pattern/pattern4.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern5"><img src="themes/switch/images/pattern/pattern5.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern6"><img src="themes/switch/images/pattern/pattern6.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern7"><img src="themes/switch/images/pattern/pattern7.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern8"><img src="themes/switch/images/pattern/pattern8.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern9"><img src="themes/switch/images/pattern/pattern9.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern10"><img src="themes/switch/images/pattern/pattern10.png" alt="bootstrap business templates"></a>
		
		<a href="themes/css/#" name="pattern11"><img src="themes/switch/images/pattern/pattern11.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern12"><img src="themes/switch/images/pattern/pattern12.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern13"><img src="themes/switch/images/pattern/pattern13.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern14"><img src="themes/switch/images/pattern/pattern14.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern15"><img src="themes/switch/images/pattern/pattern15.png" alt="bootstrap business templates"></a>
		
		<a href="themes/css/#" name="pattern16"><img src="themes/switch/images/pattern/pattern16.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern17"><img src="themes/switch/images/pattern/pattern17.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern18"><img src="themes/switch/images/pattern/pattern18.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern19"><img src="themes/switch/images/pattern/pattern19.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern20"><img src="themes/switch/images/pattern/pattern20.png" alt="bootstrap business templates"></a>
		 
	</div>
	</div>
</div>
<span id="themesBtn"></span>
</body>
</html>