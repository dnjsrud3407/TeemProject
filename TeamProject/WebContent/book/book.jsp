<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Bootshop online Shopping cart - book_list.jsp</title>
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
    <link href=themes/css/base.css?ver=1 rel="stylesheet" media="screen"/>
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
    <div id="sidebar" class="span3" style="width: 120px;">
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
    <li><a href="products.html">Products</a> <span class="divider">/</span></li>
    <li class="active">product Details</li>
    </ul>	
	<div class="row">	  
			<div id="gallery" class="span3">
            <a href="themes/images/products/large/f1.jpg" title="Fujifilm FinePix S2950 Digital Camera">
				<img src="themes/images/products/large/3.jpg" style="width:100%" alt="Fujifilm FinePix S2950 Digital Camera"/>
            </a>
			<div id="differentview" class="moreOptopm carousel slide">
                <div class="carousel-inner">
                  <div class="item active">
                   <a href="themes/images/products/large/f1.jpg"> <img style="width:29%" src="themes/images/products/large/f1.jpg" alt=""/></a>
                   <a href="themes/images/products/large/f2.jpg"> <img style="width:29%" src="themes/images/products/large/f2.jpg" alt=""/></a>
                   <a href="themes/images/products/large/f3.jpg" > <img style="width:29%" src="themes/images/products/large/f3.jpg" alt=""/></a>
                  </div>
                  <div class="item">
                   <a href="themes/images/products/large/f3.jpg" > <img style="width:29%" src="themes/images/products/large/f3.jpgg" alt=""/></a>
                   <a href="themes/images/products/large/f1.jpg"> <img style="width:29%" src="themes/images/products/large/f1.jpg" alt=""/></a>
                   <a href="themes/images/products/large/f2.jpg"> <img style="width:29%" src="themes/images/products/large/f2.jpg" alt=""/></a>
                  </div>
                </div>
              <!--  
			  <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
              <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a> 
			  -->
              </div>
			  
<!-- 			 <div class="btn-toolbar"> -->
<!-- 			  <div class="btn-group"> -->
<!-- 				<span class="btn"><i class="icon-envelope"></i></span> -->
<!-- 				<span class="btn" ><i class="icon-print"></i></span> -->
<!-- 				<span class="btn" ><i class="icon-zoom-in"></i></span> -->
<!-- 				<span class="btn" ><i class="icon-star"></i></span> -->
<!-- 				<span class="btn" ><i class=" icon-thumbs-up"></i></span> -->
<!-- 				<span class="btn" ><i class="icon-thumbs-down"></i></span> -->
<!-- 			  </div> -->
<!-- 			</div> -->
			</div>
			<div class="span6">
				<h3>Fujifilm FinePix S2950 Digital Camera  </h3>
				<small>- (14MP, 18x Optical Zoom) 3-inch LCD</small>
				<hr class="soft"/>
				<form class="form-horizontal qtyFrm">
				  <div class="control-group">
					<label class="control-label"><span>$222.00</span></label>
					<div class="controls">
					<input type="number" class="span1" placeholder="Qty."/>
				  	  <button type="button" class="btn btn-large btn-primary pull-right" onclick="location.href='BookBuy.book'"> 구매하기</button>
					  <button type="button" class="btn btn-large btn-primary pull-right" onclick="location.href='BookCart.book'"> 장바구니 <i class=" icon-shopping-cart"></i></button>
					  <button type="button" class="btn btn-large btn-primary pull-right" onclick="location.href='BookLike.book'"> ♡ </button>	
					</div>
				  </div>
				</form>
				
				<hr class="soft"/>
				<h4>100 items in stock - </h4>
				<form class="form-horizontal qtyFrm pull-right">
				  <div class="control-group">
					<label class="control-label"><span>Color</span></label>
					<div class="controls">
					  <select class="span2">
						  <option>Black</option>
						  <option>Red</option>
						  <option>Blue</option>
						  <option>Brown</option>
						</select>
					</div>
				  </div>
				</form>
				<hr class="soft clr"/>
				<p>
				14 Megapixels. 18.0 x Optical Zoom. 3.0-inch LCD Screen. Full HD photos and 1280 x 720p HD movie capture. ISO sensitivity ISO6400 at reduced resolution. 
				Tracking Auto Focus. Motion Panorama Mode. Face Detection technology with Blink detection and Smile and shoot mode. 4 x AA batteries not included. WxDxH 110.2 ×81.4x73.4mm. 
				Weight 0.341kg (excluding battery and memory card). Weight 0.437kg (including battery and memory card).
				
				</p>
				<a class="btn btn-small pull-right" href="#detail">More Details</a>
				<br class="clr"/>
			<a href="#" name="detail"></a>
			<hr class="soft"/>
			</div>
			
			<div class="span9">
            <ul id="productDetail" class="nav nav-tabs">
              <li><a href="#bookqna" data-toggle="tab">상품문의</a></li>
              <li><a href="#review" data-toggle="tab">상품후기</a></li>
              <li class="active"><a href="#home" data-toggle="tab">Product Details</a></li>
              <li><a href="#profile" data-toggle="tab">Related Products</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
              <div class="tab-pane fade active in" id="home">
			  <h4>Product Information</h4>
                <table class="table table-bordered">
				<tbody>
				<tr class="techSpecRow"><th colspan="2">Product Details</th></tr>
				<tr class="techSpecRow"><td class="techSpecTD1">Brand: </td><td class="techSpecTD2">Fujifilm</td></tr>
				<tr class="techSpecRow"><td class="techSpecTD1">Model:</td><td class="techSpecTD2">FinePix S2950HD</td></tr>
				<tr class="techSpecRow"><td class="techSpecTD1">Released on:</td><td class="techSpecTD2"> 2011-01-28</td></tr>
				<tr class="techSpecRow"><td class="techSpecTD1">Dimensions:</td><td class="techSpecTD2"> 5.50" h x 5.50" w x 2.00" l, .75 pounds</td></tr>
				<tr class="techSpecRow"><td class="techSpecTD1">Display size:</td><td class="techSpecTD2">3</td></tr>
				</tbody>
				</table>
				
				<h5>Features</h5>
				<p>
				14 Megapixels. 18.0 x Optical Zoom. 3.0-inch LCD Screen. Full HD photos and 1280 x 720p HD movie capture. ISO sensitivity ISO6400 at reduced resolution. Tracking Auto Focus. Motion Panorama Mode. Face Detection technology with Blink detection and Smile and shoot mode. 4 x AA batteries not included. WxDxH 110.2 ×81.4x73.4mm. Weight 0.341kg (excluding battery and memory card). Weight 0.437kg (including battery and memory card).<br/>
				OND363338
				</p>

				<h4>Editorial Reviews</h4>
				<h5>Manufacturer's Description </h5>
				<p>
				With a generous 18x Fujinon optical zoom lens, the S2950 really packs a punch, especially when matched with its 14 megapixel sensor, large 3.0" LCD screen and 720p HD (30fps) movie capture.
				</p>

				<h5>Electric powered Fujinon 18x zoom lens</h5>
				<p>
				The S2950 sports an impressive 28mm – 504mm* high precision Fujinon optical zoom lens. Simple to operate with an electric powered zoom lever, the huge zoom range means that you can capture all the detail, even when you're at a considerable distance away. You can even operate the zoom during video shooting. Unlike a bulky D-SLR, bridge cameras allow you great versatility of zoom, without the hassle of carrying a bag of lenses.
				</p>
				<h5>Impressive panoramas</h5>
				<p>
				With its easy to use Panoramic shooting mode you can get creative on the S2950, however basic your skills, and rest assured that you will not risk shooting uneven landscapes or shaky horizons. The camera enables you to take three successive shots with a helpful tool which automatically releases the shutter once the images are fully aligned to seamlessly stitch the shots together in-camera. It's so easy and the results are impressive.
				</p>

				<h5>Sharp, clear shots</h5>
				<p>
				Even at the longest zoom settings or in the most challenging of lighting conditions, the S2950 is able to produce crisp, clean results. With its mechanically stabilised 1/2 3", 14 megapixel CCD sensor, and high ISO sensitivity settings, Fujifilm's Dual Image Stabilisation technology combines to reduce the blurring effects of both hand-shake and subject movement to provide superb pictures.
				</p>
				
				<a href="ReviewList.book"><input type="button" value="리뷰리스트 + 작성"></a><br>
<!-- 			<a href="ReviewWriteForm.book"><input type="button" value="리뷰작성"></a> -->
		
				<br>
		
				<a href="QList.book"><input type="button" value="문의 리스트 + 작성"></a>
				
				
              </div>
		<div class="tab-pane fade" id="profile">
		<div id="myTab" class="pull-right">
		 <a href="#listView" data-toggle="tab"><span class="btn btn-large"><i class="icon-list"></i></span></a>
		 <a href="#blockView" data-toggle="tab"><span class="btn btn-large btn-primary"><i class="icon-th-large"></i></span></a>
		</div>
		<br class="clr"/>
		<hr class="soft"/>
		<div class="tab-content">
			<div class="tab-pane" id="listView">
				<div class="row">	  
					<div class="span2">
						<img src="themes/images/products/4.jpg" alt=""/>
					</div>
					<div class="span4">
						<h3>New | Available</h3>				
						<hr class="soft"/>
						<h5>Product Name </h5>
						<p>
						Nowadays the lingerie industry is one of the most successful business spheres.We always stay in touch with the latest fashion tendencies - 
						that is why our goods are so popular..
						</p>
						<a class="btn btn-small pull-right" href="product_details.html">View Details</a>
						<br class="clr"/>
					</div>
					<div class="span3 alignR">
					<form class="form-horizontal qtyFrm">
					<h3> $222.00</h3>
					<label class="checkbox">
						<input type="checkbox">  Adds product to compair
					</label><br/>
					<div class="btn-group">
					  <a href="product_details.html" class="btn btn-large btn-primary"> Add to <i class=" icon-shopping-cart"></i></a>
					  <a href="product_details.html" class="btn btn-large"><i class="icon-zoom-in"></i></a>
					 </div>
						</form>
					</div>
			</div>
			<hr class="soft"/>
			<div class="row">	  
					<div class="span2">
						<img src="themes/images/products/5.jpg" alt=""/>
					</div>
					<div class="span4">
						<h3>New | Available</h3>				
						<hr class="soft"/>
						<h5>Product Name </h5>
						<p>
						Nowadays the lingerie industry is one of the most successful business spheres.We always stay in touch with the latest fashion tendencies - 
						that is why our goods are so popular..
						</p>
						<a class="btn btn-small pull-right" href="product_details.html">View Details</a>
						<br class="clr"/>
					</div>
					<div class="span3 alignR">
					<form class="form-horizontal qtyFrm">
						<h3> $222.00</h3>
						<label class="checkbox">
						<input type="checkbox">  Adds product to compair
						</label><br/>
						<div class="btn-group">
						<a href="product_details.html" class="btn btn-large btn-primary"> Add to <i class=" icon-shopping-cart"></i></a>
						<a href="product_details.html" class="btn btn-large"><i class="icon-zoom-in"></i></a>
						</div>
					</form>
					</div>
			</div>
			<hr class="soft"/>
			<div class="row">	  
					<div class="span2">
					<img src="themes/images/products/6.jpg" alt=""/>
					</div>
					<div class="span4">
						<h3>New | Available</h3>				
						<hr class="soft"/>
						<h5>Product Name </h5>
						<p>
						Nowadays the lingerie industry is one of the most successful business spheres.We always stay in touch with the latest fashion tendencies - 
						that is why our goods are so popular..
						</p>
						<a class="btn btn-small pull-right" href="product_details.html">View Details</a>
						<br class="clr"/>
					</div>
					<div class="span3 alignR">
					<form class="form-horizontal qtyFrm">
					<h3> $222.00</h3>
					<label class="checkbox">
						<input type="checkbox">  Adds product to compair
					</label><br/>
				<div class="btn-group">
				  <a href="product_details.html" class="btn btn-large btn-primary"> Add to <i class=" icon-shopping-cart"></i></a>
				  <a href="product_details.html" class="btn btn-large"><i class="icon-zoom-in"></i></a>
				 </div>
						</form>
					</div>
			</div>
			<hr class="soft"/>
			<div class="row">	  
					<div class="span2">
					<img src="themes/images/products/7.jpg" alt=""/>
					</div>
					<div class="span4">
						<h3>New | Available</h3>				
						<hr class="soft"/>
						<h5>Product Name </h5>
						<p>
						Nowadays the lingerie industry is one of the most successful business spheres.We always stay in touch with the latest fashion tendencies - 
						that is why our goods are so popular..
						</p>
						<a class="btn btn-small pull-right" href="product_details.html">View Details</a>
						<br class="clr"/>
					</div>
					<div class="span3 alignR">
						<form class="form-horizontal qtyFrm">
						<h3> $222.00</h3>
						<label class="checkbox">
						<input type="checkbox">  Adds product to compair
						</label><br/>
						<div class="btn-group">
						<a href="product_details.html" class="btn btn-large btn-primary"> Add to <i class=" icon-shopping-cart"></i></a>
						<a href="product_details.html" class="btn btn-large"><i class="icon-zoom-in"></i></a>
						</div>
						</form>
					</div>
			</div>
			
			<hr class="soft"/>
			<div class="row">	  
					<div class="span2">
					<img src="themes/images/products/8.jpg" alt=""/>
					</div>
					<div class="span4">
						<h3>New | Available</h3>				
						<hr class="soft"/>
						<h5>Product Name </h5>
						<p>
						Nowadays the lingerie industry is one of the most successful business spheres.We always stay in touch with the latest fashion tendencies - 
						that is why our goods are so popular..
						</p>
						<a class="btn btn-small pull-right" href="product_details.html">View Details</a>
						<br class="clr"/>
					</div>
					<div class="span3 alignR">
						<form class="form-horizontal qtyFrm">
						<h3> $222.00</h3>
						<label class="checkbox">
						<input type="checkbox">  Adds product to compair
						</label><br/>
						<div class="btn-group">
						<a href="product_details.html" class="btn btn-large btn-primary"> Add to <i class=" icon-shopping-cart"></i></a>
						<a href="product_details.html" class="btn btn-large"><i class="icon-zoom-in"></i></a>
						</div>
						</form>
					</div>
			</div>
			<hr class="soft"/>
				<div class="row">	  
					<div class="span2">
					<img src="themes/images/products/9.jpg" alt=""/>
					</div>
					<div class="span4">
						<h3>New | Available</h3>				
						<hr class="soft"/>
						<h5>Product Name </h5>
						<p>
						Nowadays the lingerie industry is one of the most successful business spheres.We always stay in touch with the latest fashion tendencies - 
						that is why our goods are so popular..
						</p>
						<a class="btn btn-small pull-right" href="product_details.html">View Details</a>
						<br class="clr"/>
					</div>
					<div class="span3 alignR">
						<form class="form-horizontal qtyFrm">
						<h3> $222.00</h3>
						<label class="checkbox">
						<input type="checkbox">  Adds product to compair
						</label><br/>
						<div class="btn-group">
						<a href="product_details.html" class="btn btn-large btn-primary"> Add to <i class=" icon-shopping-cart"></i></a>
						<a href="product_details.html" class="btn btn-large"><i class="icon-zoom-in"></i></a>
						</div>
						</form>
					</div>
			</div>
			<hr class="soft"/>
		</div>
			<div class="tab-pane active" id="blockView">
				<ul class="thumbnails">
					<li class="span3">
					  <div class="thumbnail">
						<a href="product_details.html"><img src="themes/images/products/10.jpg" alt=""/></a>
						<div class="caption">
						  <h5>Manicure &amp; Pedicure</h5>
						  <p> 
							Lorem Ipsum is simply dummy text. 
						  </p>
						  <h4 style="text-align:center"><a class="btn" href="product_details.html"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">&euro;222.00</a></h4>
						</div>
					  </div>
					</li>
					<li class="span3">
					  <div class="thumbnail">
						<a href="product_details.html"><img src="themes/images/products/11.jpg" alt=""/></a>
						<div class="caption">
						  <h5>Manicure &amp; Pedicure</h5>
						  <p> 
							Lorem Ipsum is simply dummy text. 
						  </p>
						  <h4 style="text-align:center"><a class="btn" href="product_details.html"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">&euro;222.00</a></h4>
						</div>
					  </div>
					</li>
					<li class="span3">
					  <div class="thumbnail">
						<a href="product_details.html"><img src="themes/images/products/12.jpg" alt=""/></a>
						<div class="caption">
						  <h5>Manicure &amp; Pedicure</h5>
						  <p> 
							Lorem Ipsum is simply dummy text. 
						  </p>
						   <h4 style="text-align:center"><a class="btn" href="product_details.html"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">&euro;222.00</a></h4>
						</div>
					  </div>
					</li>
					<li class="span3">
					  <div class="thumbnail">
						<a href="product_details.html"><img src="themes/images/products/13.jpg" alt=""/></a>
						<div class="caption">
						  <h5>Manicure &amp; Pedicure</h5>
						  <p> 
							Lorem Ipsum is simply dummy text. 
						  </p>
						   <h4 style="text-align:center"><a class="btn" href="product_details.html"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">&euro;222.00</a></h4>
						</div>
					  </div>
					</li>
					<li class="span3">
					  <div class="thumbnail">
						<a href="product_details.html"><img src="themes/images/products/1.jpg" alt=""/></a>
						<div class="caption">
						  <h5>Manicure &amp; Pedicure</h5>
						  <p> 
							Lorem Ipsum is simply dummy text. 
						  </p>
						   <h4 style="text-align:center"><a class="btn" href="product_details.html"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">&euro;222.00</a></h4>
						</div>
					  </div>
					</li>
					<li class="span3">
					  <div class="thumbnail">
						<a href="product_details.html"><img src="themes/images/products/2.jpg" alt=""/></a>
						<div class="caption">
						  <h5>Manicure &amp; Pedicure</h5>
						  <p> 
							Lorem Ipsum is simply dummy text. 
						  </p>
						   <h4 style="text-align:center"><a class="btn" href="product_details.html"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">&euro;222.00</a></h4>
						</div>
					  </div>
					</li>
				  </ul>
			<hr class="soft"/>
			</div>
		</div>
				<br class="clr">
					 </div>
					 <div class="tab-pane fade" id="review">
									 <div id="vip-tab_comment" class="vip-tabcontent vip-tabcontent_lt on" style="display: block;">
												<div id="review-wrapper"><h3 class="tit_detailarea">프리미엄 상품평<span class="num">0</span></h3>
							
							<div id="premium-wrapper" class="board_comment">
								<div class="board_selectboxwrap">
									<div class="board_selectbox uxeselectbox" style="width:140px">
										<button class="uxeselect_btn">
											<span class="txt">인기순</span>
											<span class="arr blind">열기</span>
										</button>
										<ul class="select-commont-list uxeselect_dropdown" id="premium-sort-list">
											<li><a href="#" data-montelena-acode="200000564" data-sort="0">인기순</a></li>
											<li><a href="#" data-montelena-acode="200000564" data-sort="1">신규 등록순</a></li>
											<li><a href="#" data-montelena-acode="200000564" data-sort="2">포토 상품평만</a></li>
										</ul>
									</div>
								</div>
							
							<table class="tb_comment tb_premium">
								<caption>상품평이미지, 상품평, 작성자, 등록일, 조회수에 관한 테이블</caption>
							<colgroup>
							<col style="width:120px">
							<col>
							<col style="width:140px">
							</colgroup>
								<tbody>
										<tr class="board_empty">
											<td colspan="3">등록된 상품평이 없습니다.</td>
										</tr>
								</tbody>
							</table>
							
								<div class="board_pagenationwrap" id="premium-pagenation-wrap" data-goodscode="1689173523" data-page-no="1" data-total-page="0" data-sort="0">
								</div>
							</div>
							
							<div class="board_comment">
								<h3 class="tit_detailarea">일반 상품평<span class="num">0</span></h3>
								<div class="txt_info">
									상품평은 구매완료 후 <a target="_blank" href="http://myg.gmarket.co.kr/ContractList/ContractList">수취확인</a>에서 작성하실 수 있습니다.
								</div>
								<div id="text-wrapper">
							<table class="tb_comment tb_comment_common">
								<caption>상품평 등급, 상품평내용 , 작성자, 등록일, 조회수에 관한 테이블</caption>
							<colgroup>
							<col style="width:120px">
							<col>
							<col style="width:140px">
							</colgroup>
								<tbody>
											<tr class="board_empty">
												<td colspan="3">등록된 상품평이 없습니다.</td>
											</tr>
								</tbody>
							</table>
							
								<div class="board_pagenationwrap" id="text-pagenation-wrap" data-goodscode="1689173523" data-page-no="1" data-total-page="0">
								</div>
							
							
								</div>
							</div>
							
							</div>
											</div>
					 </div>
					 <div class="tab-pane fade" id="bookqna">
					 <div id="vip-tab_qna" class="vip-tabcontent vip-tabcontent_lt on" style="display: block;">
	<h3 class="tit_detailarea">상품 문의하기<span id="txtQnaCount" class="num">0</span></h3>
	<div class="board_selectbox pos uxeselectbox" style="width:100px">
		<button class="uxeselect_btn"><span class="txt">제목</span><span class="arr blind">열기</span></button>
		<ul class="select-commont-list uxeselect_dropdown" style="display: none;" id="searchKindUl">
			<li><a href="javascript:;" data-search-kind="S">제목</a></li>
			<li><a href="javascript:;" data-search-kind="C">제목+내용</a></li>
		</ul>
	</div>
	<form id="inputSearchForm" action="">
		<fieldset>
			<legend>상품 문의하기 검색 폼</legend>
			<div class="board_schbox">
				<input type="text" class="ip_board-sch" id="inputSearch" title="검색어 입력">
				<input type="hidden" id="inputSearchKind" value="S">
				<button type="submit" class="btn_sch"><span class="blind">검색</span></button>
				<span class="txt_result">총 검색 결과 <strong id="txtSearchCount">0건</strong></span>
			</div>
		</fieldset>
	</form>

	<div class="board_qna">
		<div class="board_btnswrap">
			<ul>
				<li class="bt_question">
					<a href="javascript:;" onclick="javascript:pdsClickLog('200000573', 'utility', {});openQnaWrite();" data-montelena-acode="200000573">문의하기</a>
				</li>
				<li class="tab_rt"><a href="javascript:pdsClickLog('200000575', 'utility', {});searchQna('my');" data-montelena-acode="200000575" class="my">내 문의보기</a></li>
				<li class="tab_rt"><a href="javascript:pdsClickLog('200000576', 'utility', {});searchQna('all');" data-montelena-acode="200000576" class="tl">전체 문의보기</a></li>
			</ul>
		</div>
		<div id="qnaList-wrapper">




<table class="tb_board tb_qna">
	<caption>번호, 문의종류, 답변상태, 제목, 문의자, 등록일 에 관한 테이블</caption>
	<colgroup>
		<col style="width:59px">
		<col style="width:92px">
		<col style="width:92px">
		<col>
		<col style="width:122px">
		<col style="width:104px">
	</colgroup>
	<thead>
		<tr>
			<th class="hnum"><a href="javascript:;">번호</a></th>
			<th class="htype">
				<a href="#board_qt_type" class="dropctrl uxeDropdown">
					문의종류<span class="blind arr">열기</span>
				</a>
				<ul id="board_qt_type" class="board_dropbox">
					<li><a href="javascript:;" data-search-qna="">전체</a></li>
					<li><a href="javascript:;" data-search-qna="K2">상품</a></li>
					<li><a href="javascript:;" data-search-qna="K4">배송</a></li>
					<li><a href="javascript:;" data-search-qna="K18">취소</a></li>
					<li><a href="javascript:;" data-search-qna="K17">반품/취소</a></li>
					<li><a href="javascript:;" data-search-qna="K19">교환</a></li>
					<li><a href="javascript:;" data-search-qna="K7">기타</a></li>
				</ul>
			</th>
			<th class="htit">
				<a href="#board_as_status" class="dropctrl uxeDropdown">
					답변상태<span class="blind arr">열기</span>
				</a>
				<ul id="board_as_status" class="board_dropbox">
					<li><a href="javascript:;" data-ans-kind="">전체</a></li>
					<li><a href="javascript:;" data-ans-kind="NA">검토중</a></li>
					<li><a href="javascript:;" data-ans-kind="CA">답변완료</a></li>
				</ul>
			</th>
			<th>제목</th>
			<th>문의자</th>
			<th>등록일</th>
		</tr>
	</thead>
	<tbody>
		<tr class="board_empty">
			<td colspan="6">작성된 문의가 없습니다.</td>
		</tr>
	</tbody>
</table>



</div>
	</div><!--//board_qa-->
</div>
					 	<table class="table table-striped">
					       <thead>
					         <tr>
					           <th style="width:30px">번호</th>
					           <th style="width:50px">답변상태</th>
					           <th style="text-align: center">제목</th>
					           <th style="width:60px">문의자</th>
					           <th style="width:60px">등록일</th>
					         </tr>
					       </thead>
					       <tbody>
					         <tr>
					           <td>1</td>
					           <td>Otto</td>
					           <td>@mdo</td>
					           <td>Otto</td>
					           <td>@mdo</td>
					         </tr>
					          <tr>
					          	<td colspan="2"></td>
								<td colspan="2">답변</td>					          
					          </tr>
					         <tr>
					           <td>2</td>
					           <td>Thornton</td>
					           <td>@fat</td>
					           <td>Thornton</td>
					           <td>@fat</td>
					         </tr>
					         <tr>
					          	<td colspan="2"></td>
								<td colspan="2">답변</td>					          
					          </tr>
					         <tr>
					           <td>3</td>
					           <td>the Bird</td>
					           <td>@twitter</td>
					           <td>Thornton</td>
					           <td>@fat</td>
					         </tr>
					         <tr>
					          	<td colspan="2"></td>
								<td colspan="2">답변</td>					          
					          </tr>
					       </tbody>
					     </table>
					 </div>
		</div>
          </div>

	</div>
</div>
</div> </div>
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