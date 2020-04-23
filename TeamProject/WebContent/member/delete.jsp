<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Bookshop online Shopping cart</title>
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
	
	<style type="text/css">
	
	
	
	</style>

<script type="text/javascript">
	function checkId(id) {
		// 4 ~ 12자리 아이디 영문,숫자 조합 유효성 검사
		// => 영문자로 시작하고 영문자 또는 숫자의 조합으로 4 ~ 12 자리
		// 1. 정규표현식 지정
		var regex = /^[A-Za-z][A-Za-z0-9]{3,11}$/;
		
		// 2. 체크 후 메세지 표시할 공간의 태그 id 값 가져오기
		var element = document.getElementById('checkIdResult'); // checkIdResult 값을 ID 로 갖는 태그 찾기
		
		// 3. 정규표현식을 통한 유효성 검사 수행(정규표현식 저장 변수명.exec() 를 사용)
		// 함수 호출 시 전달받은 파라미터(id) 의 값을 정규표현식으로 검사
		if(regex.exec(id.value)) { // 유효성 검사를 통과했을 경우
// 			alert('유효성 검사 통과');	
			// 지정된 태그 내에 메세지 표시
			element.innerHTML = "사용 가능한 아이디";
		} else { // 유효성 검사를 통과하지 못했을 경우
// 			alert('유효성 검사 탈락');
			element.innerHTML = "사용 불가능한 아이디";
		}
	}
	
	function checkPasswd(passwd) {
		// 8 ~ 16자리 패스워드 영문,숫자,특수문자 조합 유효성 검사
		// 1. 정규표현식 지정
		// 1) 길이 체크 : 8 ~ 16자리. 영문 대문자&소문자&숫자&특수문자(!@#$%^_)
		var lengthRegex = /^[A-Za-z0-9!@#$%^_]{8,16}$/;
		// 2) 대문자 체크
		var upperCaseRegex = /[A-Z]/;
		// 3) 소문자 체크
		var lowerCaseRegex = /[a-z]/;
		// 4) 숫자 체크
		var digitRegex = /[0-9]/;
		// 5) 특수문자 체크
		var specCharRegex = /[!@#$%^_]/;
		
// 		// 2. 체크 후 메세지 표시할 공간의 태그 id 값 가져오기
		var element = document.getElementById('checkPasswdResult'); // checkPasswdResult 값을 ID 로 갖는 태그 찾기
		
// 		// 3. 정규표현식을 통한 유효성 검사 수행(정규표현식 저장 변수명.exec() 를 사용)
// 		// 함수 호출 시 전달받은 파라미터(id) 의 값을 정규표현식으로 검사
		// 길이, 대문자, 소문자, 숫자, 특수문자 체크를 모두 통과했을 경우
		if(lengthRegex.exec(passwd.value) && upperCaseRegex.exec(passwd.value) &&
				lowerCaseRegex.exec(passwd.value) && digitRegex.exec(passwd.value) &&
					specCharRegex.exec(passwd.value)) {
// 			alert('유효성 검사 통과');	
			// 지정된 태그 내에 메세지 표시
			element.innerHTML = "적합한 패스워드";
		} else { // 유효성 검사를 통과하지 못했을 경우
// 			alert('유효성 검사 탈락');
			element.innerHTML = "적합하지 않은 패스워드";
		}
	}
	
	
	
	function deleteuser(){  

		alert("탈퇴 하시겠습니까?");
	}  
	
	
</script>	
  </head>
<body>

<%
String uID=(String)session.getAttribute("uID");
if(uID==null){%>
	
	<script type="text/javascript">
	alert("로그인이 필요합니다");
	 location.href = "Login.me";
// 	history.back();
	
	</script>
<%}%>



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
	<jsp:include page="/member/left.jsp"></jsp:include>
<!-- Sidebar end=============================================== -->
	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">회원탈퇴</li>
    </ul>
	<h3>회원탈퇴</h3>	
	<div class="well">
	<!--
	<div class="alert alert-info fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div>
	<div class="alert fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div>
	 <div class="alert alert-block alert-error fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply</strong> dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div> -->
	<form class="form-horizontal" action="DeletePro.me" method="post">
		<h4 style="border-bottom: 1px solid gray; text-align: center; line-height: 200%">고객님의 개인정보 보호를 위해 본인확인을 진행합니다.<br>
비밀번호를 입력해주세요.

		</h4>
		<div class="control-group">
<!-- 		<label class="control-label">Title <sup>*</sup></label> -->
		<div class="controls">
<!-- 		<select class="span1" name="days"> -->
<!-- 			<option value="">-</option> -->
<!-- 			<option value="1">Mr.</option> -->
<!-- 			<option value="2">Mrs</option> -->
<!-- 			<option value="3">Miss</option> -->
<!-- 		</select> -->
		</div>
		</div>
	
		 <div class="control-group">
			<label class="control-label" for="inputPassword" style="position: relative; top: 2px; left: 90px">비밀번호 <sup></sup></label>
			<div class="controls">
			  <input type="password" id="inputPassword"  name="pw" placeholder="8~16자리 영문,숫자,특수문자 조합" onkeyup="checkPasswd(this)" required="required" style="position: relative; top: -18px; left: 90px"><button onClick="javascript:deleteuser()" type="submit" id="submitButton" class="btn btn-primary" style="margin:20px; position: relative; top: -18px; left: 90px">확인</button>
			  <span id="checkPasswdResult"></span>
			</div>
		 </div>
	
	</form>
	
</div>

</div>
</div>
</div>
</div>
<!-- MainBody End ============================= -->
<!-- Footer ================================================================== -->
	 <div  id="footerSection">
    <div class="container">
        <div class="row">
            <div class="span3">
                <h5><a href="NoticeList.bo">공지사항/이벤트</a></h5>
             </div>
            <div class="span3">
                <h5><a href="FAQList.bo">고객센터</a></h5>
             </div>
            <div class="span3">
                <h5>회사이름</h5>
                FAX: 02-0000-0000 <br>
                E-mail: xxx@xxx.xxx<br>  
                부산시 OO구 OO로 00 <a href="#">약도</a>  
             </div>
            <div id="socialMedia" class="span3 pull-right">
                <h5>SOCIAL MEDIA </h5>
                <a href="#"><img width="60" height="60" src="themes/images/facebook.png" title="facebook" alt="facebook"/></a>
                <a href="#"><img width="60" height="60" src="themes/images/twitter.png" title="twitter" alt="twitter"/></a>
                <a href="#"><img width="60" height="60" src="themes/images/youtube.png" title="youtube" alt="youtube"/></a>
             </div> 
         </div>
        <p class="pull-right">&copy; BookShop</p>
    </div><!-- Container End -->
    </div>
<!-- Placed at the end of the document so the pages load faster ============================================= -->
    <script src="themes/js/jquery.js" type="text/javascript"></script>
    <script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="themes/js/google-code-prettify/prettify.js"></script>
    
    <script src="themes/js/bootshop.js"></script>
    <script src="themes/js/jquery.lightbox-0.5.js"></script>
</body>
</html>

