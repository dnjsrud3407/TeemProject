<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
    <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css" media="screen"/>
    <link href="themes/css/base.css" rel="stylesheet" media="screen"/>
<!-- Bootstrap style responsive -->	
	<link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet"/>
	<link href="themes/css/font-awesome.css" rel="stylesheet" type="text/css">
<!-- Google-code-prettify -->	
	<link href="themes/js/google-code-prettify/prettify.css" rel="stylesheet"/>
<!-- fav and touch icons -->
    <link rel="shortcut icon" href="themes/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="themes/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="themes/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="themes/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="themes/images/ico/apple-touch-icon-57-precomposed.png">
	<link href="css/nav.css?ver=1" rel="stylesheet" type="text/css">
	<style type="text/css" id="enject"></style>
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

			<c:if test="${sessionScope.isAdmin eq true }">
				<a href="AdminMain.adm">관리자</a> |
			</c:if>	

<!-- 		로그인 안했을 때 -->
	        <c:if test="${sessionScope.uID eq null}">
	        	<a href="JoinForm.me">회원가입</a> |
	        	<a href="helpCenter.jsp">고객센터</a> |
		        <a href="#login" role="button" data-toggle="modal" style="padding-right:0"><span class="btn btn-mini btn-success" style="font-size: 14px;">Login</span></a>
	        </c:if>
	        
<!-- 	        로그인 했을 때 -->
	         <c:if test="${sessionScope.uID ne null}"> 
		        <a href="LogoutPro.me">로그아웃</a> |
		        <a href="OrderList.mo">마이페이지</a> |
		        <a href="helpCenter.jsp">고객센터</a> |
		        <a href="CartList.book"><span class="btn btn-mini btn-primary"><i class="icon-shopping-cart icon-white"></i>장바구니 </span> </a>
		    </c:if>
		<div id="login" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false" >
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
			<h3>Login Block</h3>
		  </div>
		  <div class="modal-body">
			<form action="./LoginPro.me" class="form-horizontal loginFrm" method="post">
			  <div class="control-group">								
				<input type="text" id="inputId" name="uID" placeholder="Id">
			  </div>
			  <div class="control-group" style="margin-bottom: 20px;">
				<input type="password" id="inputPassword" name="pw" placeholder="Password">
			  </div>
			 
			<button type="submit" class="btn btn-success">로그인</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">로그인 취소</button>
			<a href="FindId.me" class="btn">아이디 찾기</a>
			<a href="FindPass.me" class="btn">비밀번호 찾기</a>
			</form>		
		  </div>
	</div> 
	    </div>
    </div>
</div>
<!-- Navbar =================================================== -->
<div>
    <a class="brand" href="Main.me"><img src="themes/images/logo.png?ver=1" alt="Bootsshop"/></a>
    <form class="form-inline navbar-search pull-right" method="get" action="BookSearchList.book?page=1" onsubmit="return checkSearch()">
        <input id="srchFld" name="bookTitle" class="srchTxt" type="text" placeholder="책 검색"/>
        <button type="submit" id="submitButton" class="btn btn-primary">검색</button>
    </form>
</div>
</div>
<div id="menu" style="position: relative; left:10px; z-index: 1;">
    <jsp:include page="../inc/nav.jsp"></jsp:include>
</div>
</div>
<!-- Header End====================================================================== -->
<div id="mainBody">
	<div class="container">
	<div class="row">
<!-- Sidebar ================================================== -->
	
<!-- Sidebar end=============================================== -->
	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Login</li>
    </ul>
	<h3> Find Password</h3>	
	<hr class="soft"/>
	
	<div class="row">
		
		<div class="span1"> &nbsp;</div>
		<div class="span4">
			<div class="well" style="width: 500px;height: 285px;margin: 100px; padding: 20px;">
			<h3 style="margin-top: 10px;">Find Password</h3>
			<form action="./FindPassPro.me" name="LoginForm" method="post">
			  <div class="control-group">
				<label class="control-label" for="inputId">Id</label>
				<div class="controls">
				  <input class="span3"  type="text" id="uID" name="uID" placeholder="Id">
				</div>
			  </div>
			  <div class="control-group">
				<label class="control-label" for="inputMobilePhone">Mobile Phone</label>
				<div class="controls">
				  <input type="text" class="span3"  id="Phone_num" name="Phone_num" placeholder="Mobile Phone">
				</div>
			  </div>
			  <div class="control-group">
				<div class="controls">
				  <button type="submit" class="btn" style="margin-right: 15px;">Next</button> 
				  <button type="button" class="btn" style="margin-right: 15px;" onclick="location.href='JoinForm.me'">Resigter</button> 
				</div>
				  <div style="margin-top: 20px; ">
				  	<c:if test="${passOk == 1}">
						<c:if test="${findPass ne null }">
							${uID} 님의 비밀번호는 <b>${findPass}</b>입니다.
						</c:if>
					</c:if>
					<c:if test="${passOk == -1}">
						<c:if test="${findPass eq null}">
							<script>
								alert("일치하는 회원정보가 없습니다");
							</script>
					</c:if>		
					</c:if>
					</div>
			  </div>
			</form>
		</div>
		</div>
	</div>	
	
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

<span id="themesBtn"></span>
</body>
</html>