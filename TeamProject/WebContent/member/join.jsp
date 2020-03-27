<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<style type="text/css" id="enject"></style>

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
</script>	
  </head>
<body>
<div id="header">
<div class="container">
<div id="welcomeLine" class="row">
    <div class="span6"></div>
    <div class="span6">
    <div class="pull-right">
        <a href="Login.me">로그인</a> |
        <a href="JoinForm.me">회원가입</a> |
        <a href="member.jsp">마이페이지</a> |
        <a href="helpCenter.jsp">고객센터</a>
        <a href="BookCart.book"><span class="btn btn-mini btn-primary"><i class="icon-shopping-cart icon-white"></i> [ num ] 장바구니 </span> </a> 
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
    <a class="brand" href="index.jsp"><img src="themes/images/logo.png" alt="Bookshop"/></a>
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
<!-- 	 <a href="#login" role="button" data-toggle="modal" style="padding-right:0"><span class="btn btn-large btn-success">Login</span></a> -->
<!-- 	<div id="login" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false" > -->
<!-- 		  <div class="modal-header"> -->
<!-- 			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> -->
<!-- 			<h3>Login Block</h3> -->
<!-- 		  </div> -->
<!-- 		  <div class="modal-body"> -->
<!-- 			<form class="form-horizontal loginFrm"> -->
<!-- 			  <div class="control-group">								 -->
<!-- 				<input type="text" id="inputEmail" placeholder="Email"> -->
<!-- 			  </div> -->
<!-- 			  <div class="control-group"> -->
<!-- 				<input type="password" id="inputPassword" placeholder="Password"> -->
<!-- 			  </div> -->
<!-- 			  <div class="control-group"> -->
<!-- 				<label class="checkbox"> -->
<!-- 				<input type="checkbox"> Remember me -->
<!-- 				</label> -->
<!-- 			  </div> -->
<!-- 			</form>		 -->
<!-- 			<button type="submit" class="btn btn-success">Sign in</button> -->
<!-- 			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button> -->
<!-- 		  </div> -->

<!-- Header End====================================================================== -->
<div id="mainBody">
	<div class="container">
	<div class="row">
<!-- Sidebar ================================================== -->
	 <div id="sidebar" class="span3">
        <ul id="sideManu" class="nav nav-tabs nav-stacked">
            <li class="subMenu open"><a> 단계별</a>
                <ul>
                <li><a class="active" href="BookList.book"><i class="icon-chevron-right"></i>1단계 </a></li>
                <li><a href="BookList.book"><i class="icon-chevron-right"></i>2단계</a></li>
                <li><a href="BookList.book"><i class="icon-chevron-right"></i>3단계</a></li>
                <li><a href="BookList.book"><i class="icon-chevron-right"></i>4단계</a></li>
                </ul>
            </li>
            <li class="subMenu"><a> 분야별 </a>
            <ul style="display:none">
                <li><a href="BookList.book"><i class="icon-chevron-right"></i>JAVA</a></li>
                <li><a href="BookList.book"><i class="icon-chevron-right"></i>JSP</a></li>                                              
                <li><a href="BookList.book"><i class="icon-chevron-right"></i>DATABASE</a></li> 
                <li><a href="BookList.book"><i class="icon-chevron-right"></i>HTML / CSS</a></li>
            </ul>
            </li>
        </ul>
        <br/>
    </div>
<!-- Sidebar end=============================================== -->
	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Registration</li>
    </ul>
	<h3> Registration</h3>	
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
	<form class="form-horizontal" action="JoinPro.me" method="post">
		<h4>Your personal information</h4>
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
			<label class="control-label" for="inputId">아이디 <sup>*</sup></label>
			<div class="controls">
			  <input type="text" id="inputId" placeholder="아이디" name="uID" required="required" onkeyup="checkId(this)">
			  <span id="checkIdResult"></span>
			</div>
		 </div>
		 <div class="control-group">
			<label class="control-label" for="inputPassword">비밀번호 <sup>*</sup></label>
			<div class="controls">
			  <input type="password" id="inputPassword"  name="pw" placeholder="8~16자리 영문,숫자,특수문자 조합" required="required"><!-- onkeyup="checkPasswd(this)" --> 
			  <span id="checkPasswdResult"></span>
			</div>
		 </div>
		 <div class="control-group">
			<label class="control-label" for="inputName">이름 <sup>*</sup></label>
			<div class="controls">
			  <input type="text" id="inputName" placeholder="이름" name="u_name" required="required">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="address">Address<sup>*</sup></label>
			<div class="controls">
			  <input type="text" id="address" placeholder="Adress" name="address" required="required"/> <span>Street address, P.O. box, company name, c/o</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="mobile">Mobile Phone<sup>*</sup></label>
			<div class="controls">
			  <input type="text" id="mobile" placeholder="Mobile Phone" name="phone_num" required="required"/> 
			</div>
		</div>	
		<div class="control-group">
		<label class="control-label" for="input_Email">Email <sup>*</sup></label>
		<div class="controls">
		  <input type="text" id="input_Email" placeholder="Email" name="email" required="required">
		</div>
	  </div>	  
	
		

	<div class="alert alert-block alert-error fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply</strong> dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div>	

		<h4>Additional information</h4>
		<div class="control-group">

		<div class="controls">

		</div>
		</div>	
		<div class="control-group">
			<label class="control-label" for="address2">Address (Line 2)</label>
			<div class="controls">
			  <input type="text" id="address2" placeholder="Adress line 2" name="address2"/> <span>Apartment, suite, unit, building, floor, etc.</span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="phone">Home phone</label>
			<div class="controls">
			  <input type="text" id="phone" placeholder="phone" name="tell_num"/> <span>You must register at least one phone number</span>
			</div>
		</div>
		
		
		
	<p><sup>*</sup>Required field</p>
	
	<div class="control-group">
			<div class="controls">
				<input type="hidden" name="email_create" value="1">
				<input type="hidden" name="is_new_customer" value="1">
				<input class="btn btn-large btn-success" type="submit" value="Register" />
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



