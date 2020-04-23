<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>마이페이지</title>
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
     <link href="themes/css/mycus.css?ver=1" rel="stylesheet"/>
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
	<style type="text/css" id="enject"></style>
	<style type="text/css">
	
	 .btn2{border: 1px solid #D9D4D4; text-align: center; margin: 2px; padding: 3px;}
	
	</style>
	
	<style type="text/css">
	
	
	
	#neamam{border-top: none; 
	border-left: none;
	 border-right: none;}
	
	
	#neamam2{
	border-top:solid;
	}
	
  
/*   #menu { */

/*     height: 50px; */

/*     background: #333; */

/* } */

#menu {
    height: 50px;
    background: #333;
}

.main1 {

    width: 600px;

    height: 100%;

    margin: 0 auto;

}

ul.main3 {
    position: absolute;
    /* left: auto; */
    margin-bottom: -20px;
    margin-left: -2px;
}


.main1>li {

    float: left;

    width: 20%;

    line-height: 50px;

    text-align: center;

    position: relative;

}



.main1>li:hover .main2 {

    left: 0;

}



.main1>li a {

    display: block;

}



.main1>li a:hover {

    background: #B21016;

    color: #fff;

    font-weight: bold;

}

li>a{ color: #fff; }

.main2 {

    position: absolute;

    top: 50px;

    left: -9999px;

    background: #ccc;

    width: 120%;

}


.main2>li {

    position: relative;

}

.main2>li:hover .main3 {

    left: 100%;

}

.main2>li a, .main3>li a {

    border-radius: 10px;

    margin: 10px;

}

.main3 {
    position: absolute;

    top: 0;

    background: #6BD089;

    width: 120%;

    left: -9999px;

    /*left: 100%;*/

    /*display: none;*/
}


.main3>li a:hover {

    background: #085820;

    color: #fff;

}



ul{

    list-style:none;

    list-style-type:none;

    } 



  
	
	
	
	
	
	</style>
	
	  
<script src="./js/jquery-3.4.1.js"></script>


        
<script type="text/javascript">
  // 책 검색하는 작업
  function checkSearch() {
	if($("#srchFld").val() == "") {
		alert('검색어를 입력하세요');
		return false;
	} else {
		return true;
	}
  }
  function getMiddle(type) {
	  // type = 0 -> 베스트 셀러
	  // type = 1 -> 1단계 책
	  // type = 2 -> 2단계 책
	  // type = 3 -> 3단계 책
	  $.ajax({
		  type:"POST",
		  url:"MiddleBook.book?type=" + type,
		  success: function(msg2){	// 베스트셀러
		  	  $(".middle_banner").html(msg2);
		  }
	  });
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
   <div class="">
	    <span style="padding-left: 30px;font-size: 15px;">
	    	<c:if test="${sessionScope.uID ne null}"> 
		        welcome ${sessionScope.uID}님
		    </c:if></span>
	    <div class="pull-right">
		    <a href="AdminMain.adm">관리자</a> |
		    <c:if test="${sessionScope.uID ne null}"> 
		        <a href="LogoutPro.me">로그아웃</a> |
		    </c:if>
		    <c:if test="${sessionScope.uID eq null}">
		        <a href="Login.me">로그인</a> |
		    </c:if>
		     <c:if test="${sessionScope.uID eq null}">
	        <a href="JoinForm.me">회원가입</a> |
	         </c:if>
	        <a href="OrderList.mo">마이페이지</a> |
	        <a href="helpCenter.jsp">고객센터</a>
		<a href="BookCart.book"><span class="btn btn-mini btn-primary"><i class="icon-shopping-cart icon-white"></i> [ num ] 장바구니 </span> </a> 
	</div>
	</div>
<!-- </div> -->
<!-- Navbar ================================================== -->
<!-- <div id="logoArea" class="navbar"> -->
<!-- <a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar"> -->
<!-- 	<span class="icon-bar"></span> -->
<!-- 	<span class="icon-bar"></span> -->
<!-- 	<span class="icon-bar"></span> -->
<!-- </a> -->
<div>
    <form class="form-inline navbar-search pull-right" method="get" action="BookSearchList.book?page=1" onsubmit="return checkSearch()">
        <input id="srchFld" name="bookTitle" class="srchTxt" type="text" placeholder="책 검색"/>
        <button type="submit" id="submitButton" class="btn btn-primary">검색</button>
    </form>
</div>




    <a class="brand" href="Main.me"><img src="themes/images/logo.png?ver=1" alt="Bootsshop"/></a>

    
<div id="menu" style="position: relative; left:10px; z-index: 1;">

    <ul class="main1" >

        <li><a href="BookListALL.book">전체 교재</a>

            <ul class="main2">

<!--                 <li><a href="#">소메뉴1</a></li> -->

<!--                 <li><a href="#">소메뉴2</a> -->

<!--                     <ul class="main3"> -->

<!--                         <li><a href="#">2단소메뉴1</a></li> -->

<!--                         <li><a href="#">2단소메뉴2</a></li> -->

<!--                         <li><a href="#">2단소메뉴3</a></li> -->

<!--                     </ul> -->

<!--                 </li> -->

<!--                 <li><a href="#">교재구매3</a> -->

<!--                     <ul class="main3"> -->

<!--                         <li><a href="#">2단소메뉴4</a></li> -->

<!--                         <li><a href="#">2단소메뉴5</a></li> -->

<!--                         <li><a href="#">2단소메뉴6</a></li> -->

<!--                     </ul> -->

<!--                 </li> -->

            </ul>

        </li>

        <li><a href="BookListALL.book">교재구매</a>

            <ul class="main2">

                <li><a href="BookList.book?bk2=1">1단계</a>

                    <ul class="main3">

                        <li><a href="BookList.book?bk2=1">HTML5/CSS3</a></li>

<!--                         <li><a href="#">JavaScript</a></li> -->

<!--                         <li><a href="#">2단소메뉴9</a></li> -->

                    </ul>

                </li>

                <li><a href="BookList.book?bk2=2">2단계</a>

                    <ul class="main3">

                        <li><a href="BookList.book?bk2=2">JavaScript</a></li>

<!--                         <li><a href="#">jsp</a></li> -->
<!--                         <li><a href="#">MySQL</a></li> -->
<!-- 						 <li><a href="#">Oracle</a></li>  -->

                    </ul>

                </li>

                <li><a href="BookList.book?bk2=3">3단계</a>

                    <ul class="main3">

                        <li><a href="BookList.book?bk2=3">Jquery/Ajax/Jason/JSTL</a></li>

                        <li><a href="BookList.book?bk2=3">Spring</a></li>

<!--                         <li><a href="#">2단소메뉴15</a></li> -->

                    </ul>

                </li>

            </ul>

        </li>
        
     

        <li><a href="Event.adb">이벤트</a>

            <ul class="main2">

<!--                 <li><a href="#">소메뉴1</a></li> -->

<!--                 <li><a href="#">소메뉴2</a></li> -->

<!--                 <li><a href="#">소메뉴3</a> -->

<!--                     <ul class="main3"> -->

<!--                         <li><a href="#">2단소메뉴16</a></li> -->

<!--                         <li><a href="#">2단소메뉴17</a></li> -->

<!--                         <li><a href="#">2단소메뉴18</a></li> -->

<!--                     </ul> -->

<!--                 </li> -->

            </ul>

        </li>
        
        
        <li><a href="#">공지사항</a>
        
        
        </li>

        <li><a href="#">FAQ</a>

<!--             <ul class="main2"> -->

<!--                 <li><a href="#">소메뉴1</a></li> -->

<!--                 <li><a href="#">소메뉴2</a></li> -->

<!--                 <li><a href="#">소메뉴3</a></li> -->

<!--             </ul> -->

        </li>

    </ul>

</div>
<!--   <div class="navbar-inner"> -->
<!--     <a class="brand" href="index.jsp"><img src="themes/images/logo.png" alt="Bootsshop"/></a> -->
<!-- 		<form class="form-inline navbar-search" method="post" action="products.html" > -->
<!-- 		<input id="srchFld" class="srchTxt" type="text" /> -->
<!-- 		  <select class="srchTxt"> -->
<!-- 			<option>All</option> -->
<!-- 			<option>CLOTHES </option> -->
<!-- 			<option>FOOD AND BEVERAGES </option> -->
<!-- 			<option>HEALTH & BEAUTY </option> -->
<!-- 			<option>SPORTS & LEISURE </option> -->
<!-- 			<option>BOOKS & ENTERTAINMENTS </option> -->
<!-- 		</select>  -->
<!-- 		  <button type="submit" id="submitButton" class="btn btn-primary">Go</button> -->
<!--     </form> -->
<!--     <ul id="topMenu" class="nav pull-right"> -->
<!-- 	 <li class=""> -->
<!-- 	<div id="login" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false" > -->
<!-- 		  <div class="modal-header"> -->
<!-- 			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button> -->
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
<!-- 	</div> -->
<!-- 	</li> -->
<!--     </ul> -->
<!--   </div> -->
</div>
</div>
</div>