<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <!--Constom styles -->
    <link href="css/main.css?ver=1" rel="stylesheet" type="text/css">
    <style type="text/css" id="enject"></style>
  </head>
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
  
//   $(document).ready(function() {
// 	  $.ajax({
// 		  type:"POST",
// 		  url:"NewBook.book",
// 		  success: function(msg2){	// 베스트셀러
// 		  	  $(".middle_banner").html(msg2);
// 		  }
// 	  });
//   });
</script>
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
	        <a href="CartList.book"><span class="btn btn-mini btn-primary"><i class="icon-shopping-cart icon-white"></i> [ num ] 장바구니 </span> </a> 
	    </div>
    </div>
</div>
<!-- Navbar ================================================== -->
<div id="logoArea" class="navbar">
  <div class="navbar-inner">
    <a class="brand" href="Main.me"><img src="themes/images/logo.png?ver=1" alt="Bootsshop"/></a>
	<!--    검색하는 창 -->
    <form class="form-inline navbar-search pull-right" method="get" action="BookSearchList.book?page=1" onsubmit="return checkSearch()">
        <input id="srchFld" name="bookTitle" class="srchTxt" type="text" placeholder="책 검색"/>
        <button type="submit" id="submitButton" class="btn btn-primary">검색</button>
    </form>
    <ul id="topMenu" class="nav">
     <li><a href="">로드맵</a></li>
     <li><a href="BookList.book">교재구매</a></li>
     <li><a href="Event.adb">이벤트</a></li>
    </ul>
  </div>
</div>
</div>
</div>
<!-- Header End====================================================================== -->
<div id="carouselBlk">
    <div id="myCarousel" class="carousel slide">
        <div class="carousel-inner">
          <div class="item active">
          <div class="container">
            <a href="NoticeDetail.bo"><img style="width:100%" src="themes/images/carousel/1.png" alt="special offers"/></a>
            <div class="carousel-caption">
                  <h4>Second Thumbnail label</h4>
                  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                </div>
          </div>
          </div>
          <div class="item">
          <div class="container">
            <a href="NoticeDetail.bo"><img style="width:100%" src="themes/images/carousel/2.png" alt=""/></a>
                <div class="carousel-caption">
                  <h4>Second Thumbnail label</h4>
                  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                </div>
          </div>
          </div>
          <div class="item">
          <div class="container">
            <a href="NoticeDetail.bo"><img src="themes/images/carousel/3.png" alt=""/></a>
            <div class="carousel-caption">
                  <h4>Second Thumbnail label</h4>
                  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                </div>
            
          </div>
          </div>
           <div class="item">
           <div class="container">
            <a href="NoticeDetail.bo"><img src="themes/images/carousel/4.png" alt=""/></a>
            <div class="carousel-caption">
                  <h4>Second Thumbnail label</h4>
                  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                </div>
           
          </div>
          </div>
           <div class="item">
           <div class="container">
            <a href="NoticeDetail.bo"><img src="themes/images/carousel/5.png" alt=""/></a>
            <div class="carousel-caption">
                  <h4>Second Thumbnail label</h4>
                  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            </div>
          </div>
          </div>
           <div class="item">
           <div class="container">
            <a href="NoticeDetail.bo"><img src="themes/images/carousel/6.png" alt=""/></a>
            <div class="carousel-caption">
                  <h4>Second Thumbnail label</h4>
                  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                </div>
          </div>
          </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
      </div> 
</div>
<div id="mainBody">
    <div class="container">
    <div class="row">
<!-- Sidebar ================================================== -->
    <jsp:include page="./inc/menu.jsp"></jsp:include>
<!-- Sidebar end=============================================== -->
        <div class="span9">     
            <div class="well well-small">
            <div class="row-fluid">
            <div id="featured" class="carousel slide">
              <div class="carousel-inner middle_banner">
	              <div class="carousel-inner">
	              <div class="item active">
	              <ul class="thumbnails">
	              	<c:forEach var="book" items="${bookList }" begin="0" end="3" varStatus="status">
		                <li class="span3">
		                  <div class="thumbnail" style="height: 250px">
		                  <i class="tag"></i>
		                    <a href="Book.book?bookID=${book.bookID }"><img src="upload/${book.bookImage}" alt="${book.bookTitle }"></a>
		                    <div class="caption">
		                      <h5>${book.bookTitle }</h5>
		                      ${book.bookPublisher } | ${book.bookPrice }
		                    </div>
		                  </div>
		                </li>
	              	</c:forEach>
	              </ul>
	              </div>
	              <div class="item" >
	              <ul class="thumbnails">
	                <c:forEach var="book" items="${bookList }" begin="4" end="7" varStatus="status">
		                <li class="span3">
		                  <div class="thumbnail" style="height: 250px">
		                  <i class="tag"></i>
		                    <a href="Book.book?bookID=${book.bookID }"><img src="upload/${book.bookImage}" alt="${book.bookTitle }"></a>
		                    <div class="caption">
		                      <h5>${book.bookTitle }</h5>
		                      ${book.bookPublisher } | ${book.bookPrice }
		                    </div>
		                  </div>
		                </li>
	              	</c:forEach>
	              </ul>
	              </div>
	              </div>
              </div>
              <a class="left carousel-control" href="#featured" data-slide="prev">‹</a>
              <a class="right carousel-control" href="#featured" data-slide="next">›</a>
              </div>
              <div style="margin-left: 145px;">
              	  <h4 style="float: left; display: inline-block; margin: 15px;"><a href="BookList.book">새로나온책</a></h4>
                  <h4 style="float: left; display: inline-block; margin: 15px;"><a href="BookList.book">1단계</a></h4>
                  <h4 style="float: left; display: inline-block; margin: 15px;"><a href="BookList.book">2단계</a></h4>
                  <h4 style="float: left; display: inline-block; margin: 15px;"><a href="BookList.book">3단계</a></h4>
              </div>
              </div>
        </div>
        <h4>베스트셀러 </h4>
              <ul class="thumbnails">
                <li class="span3">
                  <div class="thumbnail">
                    <a  href="Book.book"><img src="themes/images/products/6.jpg" alt=""/></a>
                    <div class="caption">
                      <h5>책 이름</h5>
                      <p>간단한 소개</p>
                      <h4 style="text-align:center"><a class="btn" href="Book.book"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a></h4>
                    </div>
                  </div>
                </li>
                <li class="span3">
                  <div class="thumbnail">
                    <a  href="Book.book"><img src="themes/images/products/7.jpg" alt=""/></a>
                    <div class="caption">
                      <h5>Product name</h5>
                      <p> 
                        Lorem Ipsum is simply dummy text. 
                      </p>
                     <h4 style="text-align:center"><a class="btn" href="Book.book"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a></h4>
                    </div>
                  </div>
                </li>
                <li class="span3">
                  <div class="thumbnail">
                    <a  href="Book.book"><img src="themes/images/products/8.jpg" alt=""/></a>
                    <div class="caption">
                      <h5>Product name</h5>
                      <p> 
                        Lorem Ipsum is simply dummy text. 
                      </p>
                       <h4 style="text-align:center"><a class="btn" href="Book.book"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a></h4>
                    </div>
                  </div>
                </li>
                <li class="span3">
                  <div class="thumbnail">
                    <a  href="Book.book"><img src="themes/images/products/9.jpg" alt=""/></a>
                    <div class="caption">
                      <h5>Product name</h5>
                      <p> 
                        Lorem Ipsum is simply dummy text. 
                      </p>
                      <h4 style="text-align:center"><a class="btn" href="Book.book"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a></h4>
                    </div>
                  </div>
                </li>
                <li class="span3">
                  <div class="thumbnail">
                    <a  href="Book.book"><img src="themes/images/products/10.jpg" alt=""/></a>
                    <div class="caption">
                      <h5>Product name</h5>
                      <p> 
                        Lorem Ipsum is simply dummy text. 
                      </p>
                      <h4 style="text-align:center"><a class="btn" href="Book.book"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a></h4>
                    </div>
                  </div>
                </li>
                <li class="span3">
                  <div class="thumbnail">
                    <a  href="Book.book"><img src="themes/images/products/11.jpg" alt=""/></a>
                    <div class="caption">
                      <h5>Product name</h5>
                      <p> 
                        Lorem Ipsum is simply dummy text. 
                      </p>
                       <h4 style="text-align:center"><a class="btn" href="Book.book"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a></h4>
                    </div>
                  </div>
                </li>
              </ul> 

        </div>
        </div>
    </div>
</div>
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