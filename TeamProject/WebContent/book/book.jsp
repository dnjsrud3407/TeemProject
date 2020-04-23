<%@page import="vo.BoardBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%

String nowPage = request.getParameter("page");


boolean isLogin = false; 
	if(session.getAttribute("uID") == null) {
		isLogin = false;
     	String uID	= (String)session.getAttribute("uID");
     	
	} else { 
		isLogin = true;
		String uID	= (String)session.getAttribute("uID");
     
		
	}

%> 
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
  	<link rel="css/bookqna.css" rel="stylesheet">
  	<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
  	
    $(document).ready(function(){
    	
    	$(".qna_tr_s").hide();
    	
    	$('.qna_tr_p').click(function(){
    		
    	$(this).next().slideToggle();	
    	});
    })
    
    $(document).on("click",".open-AddReview", function (){
    	var Title = $(".rv_img").data('id');
    	$(".rv_main ")
    	var reviewImg = $(".rv_img").attr("src");
    	console.log(reviewImg);
//     	var review_t = $('#rv_title').text();
//     	var review_c = $('#rv_content').text();
//     	var review_time = $('#rv_regtime').text();
//     	var readcount = $('#rv_count').text();
   
    	
//     	$('#rv_readcount').html(readcount + '<br>');
//     	$('#review_regtime').html(review_time+'<br>');
//     	$('#detail_title').html(review_t);
//     	$('#detail_content').html(review_c);
    	
    })
   
   
	var isLogin = <%=isLogin%>;
	var pop_title = document.bookQnaForm;
	
	function loginChk() {
		var loginUrl = "http://localhost:8080/TeamProject" + "/Login.me?url=" + location.href;
		if(!isLogin){
			window.location.href = loginUrl;
			return false;
		}
		return true;
	}
	
	function openQna(p, number) {
		alert(isLogin);
		
		
		var qnaUrl = "";
		
		if(p === 'w'){
			qnaUrl = "./QWriteForm.book";
			
		} else if(p === 'm'){
			qnaUrl = "./QModifyForm.book";
			
		} else if(p === 'd'){
			if(loginChk()){
				if(confirm('삭제하시겠습니까?')){
					location.href = "./QDeletePro.book?bookID=" + ${book.bookID} + "&boardNum=" + number;
					return;
				
				}
			}
		}else {
			alert('알 수 없는 오류입니다');
		}
		
	
		
	
		if(loginChk()){
			//alert('true');
 			window.open('',"bookQnaForm",'toolbar=no,scrollbars=no,resizable=no,top=100,left=0,width=700,height=600');
 			bookQnaForm.action = qnaUrl;
 			bookQnaForm.method="post"
 			bookQnaForm.target="bookQnaForm";
 			bookQnaForm.bookID="${book.bookID}";
 			bookQnaForm.bookTitle="${book.bookTitle}";
 			bookQnaForm.uID="${sessionScope.uID}";
 			if(p === 'm'){
 				 document.bookQnaForm.boardNum.value=number;
 				 
 				 
 			}
 			bookQnaForm.submit();
		}
	}
	
	function openReview(p, number) {
		alert(isLogin);
		console.log(p);
		console.log(number);
		
		var reviewUrl = "";
		
		if(p === 'm'){
			reviewUrl = "./ReviewModifyForm.book?boardNum=" + number + "&bookID=" + ${book.bookID};
			
		} else if(p === 'd'){
			if(loginChk()){
				if(confirm('삭제하시겠습니까?')){
					location.href = "./ReviewDeletePro.book?boardNum=" + number + "&bookID=" + ${book.bookID};
					return;	
				}
			}
		}else {
			alert('알 수 없는 오류입니다');
		}
		
	
		
	
		if(loginChk()){
			//alert('true');
 			window.open(reviewUrl,"reviewForm",'toolbar=no,scrollbars=no,resizable=no,top=100,left=0,width=700,height=700');

		}
	}
    
	function kindSubmit(index, qty){
		if(loginChk()){
			if(index == 1) {
				document.kindFrm.action='CartAdd2.book';
			} else if(index == 2) { 
				alert(qty);
				document.kindFrm.action='CartAdd.book';
			} else if (index == 3) {
				document.kindFrm.action='BookLike.book';
			}
			document.kindFrm.submit();
		}
		return false;
		
	}
	

	
</script>
	<style type="text/css" id="enject">
	.qBtn {
    display: inline-block;
    float: right;
}

.td_rgt {/* border: 1px solid #00f; */
/*  vertical-align:bottom !important; */}

/* 
.btn_rgt {/* border: 1px solid red; */
 float: right;
  
 }	 */
.rv_wrap .rv_main{
padding: 20px;
} 

.rv_content .info_area{
	position: relative;
	margin-bottom: 15px;
	border-bottom: 1px solid; color: #777;
}

.rv_content .info_area .rv_comment{
position: absolute;
top: 0;
left: 0;
vertical-align: middle;
}

.rv_content .info_area .rv_comment .title {
color: #444;
font-size: 14px;
font-weight: 14px;
font-weight: 700;
line-height: 20px;
text-align: left;
}
.rv_content .info_area {
padding: 5px 0;
text-align: right;
display: block;
line-height: 18px;
}

.rv_content{
vertical-align: top;
padding: 15px;}

.info_area{
vertical-align: top;
display: block;
}

.info_text .info_text span{
display: block;
line-height: 18px;
}


.scroll_area{
overflow-y: auto;
overflow-x: hidden;
}
/*Review modal */
/*  .modal { */
/*  	text-align: center; */
/*  } */
 
/*  @@media screen and (min-width: 768px){ */
/*  	.modal:before { */
/*  		display: inline-block; */
/*  		vertical-align: middle; */
/*  		content: " "; */
/*  		height: 100%; */
/*  	} */
/*  } */
/*  .modal-dialog { */
/*  		display: inline-block; */
/*  		text-align: left; */
/*  		vertical-align: middle; */
/*  	} */
	</style>
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
	        <a href="CartList.book"><span class="btn btn-mini btn-primary"><i class="icon-shopping-cart icon-white"></i> [ num ] 장바구니 </span> </a> 
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
    <a class="brand" href="Main.me"><img src="themes/images/logo.png?ver=1" alt="Bootsshop"/></a>
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
	<div class="span9">
    <ul class="breadcrumb">
    <li><a href="Main.me">Home</a> <span class="divider">/</span></li>
    <li><a href="products.jsp">Products</a> <span class="divider">/</span></li>
    <li class="active">product Details</li>
    </ul>
    <c:set var="book" value="${requestScope.book}"/>
	<div class="row">	  
			<div id="gallery" class="span3">
            <a href="upload/${book.bookImage }" title="${book.bookTitle }">
				<img src="upload/${book.bookImage }" style="width:100%" alt="상품 이미지"/>
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
				<h3>${book.bookTitle } </h3>
				<small>- (14MP, 18x Optical Zoom) 3-inch LCD</small>
				<hr class="soft"/>
				<form class="form-horizontal qtyFrm" method="post" name="kindFrm">
				  <div class="control-group">
					<label class="control-label"><span>${book.bookPrice }</span></label>
					<div class="controls">
					<input type="number" class="span1" placeholder="Qty." name="qty" value="1"/>
					<input type="hidden" name="bookID" value="${book.bookID }"/>
				  	  <button type="button" class="btn btn-large btn-primary pull-right" onclick='kindSubmit(1)'> 구매하기</button>
					  <button type="button" class="btn btn-large btn-primary pull-right" onclick='kindSubmit(2,qty.value)'> 장바구니 <i class=" icon-shopping-cart"></i></button>
					  <button type="button" class="btn btn-large btn-primary pull-right" onclick='kindSubmit(3)'> ♡ </button>	
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
					${book.bookIntroduce }
				</p>
				<a class="btn btn-small pull-right" href="#detail">More Details</a>
				<br class="clr"/>
			<a href="#" name="detail"></a>
			<hr class="soft"/>
			</div>
			
			<div class="span9">
            <ul id="productDetail" class="nav nav-tabs">
              <li ><a href="#bookqna" data-toggle="tab">상품문의</a></li>
              <li><a href="#review" data-toggle="tab">상품후기</a></li>
              <li class="active"><a href="#home" data-toggle="tab">상세설명</a></li>
<!--               <li><a href="#profile" data-toggle="tab">Related Products</a></li> -->
            </ul>
            <div id="myTabContent" class="tab-content">
              <div class="tab-pane active" id="home">
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
				
				<c:set var="bk2" value="${book.BK2 }"/>
				 <a href="BookList.book?bk2=${fn:substring(bk2,0,1)}" class="btn btn-large pull-right">Compair Product</a>
				 
				
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
					 <c:if test="${empty articleReviewList }">
						<h3>상품후기</h3>
						<hr class="soft">
						<table>
						<tr style="height: 200px;">
							<td style="width: 870px;">
							   	<h4 style="text-align: center;">등록된 상품평이 없습니다.</h4>
							</td>
						</tr>
						
						</table>
							
								<hr class="soft">
					 </c:if>
					 
					 <c:forEach var="review" items="${articleReviewList }" varStatus="status">
					 	<c:forEach var="file" items="${review.fileList }" varStatus="status"> 
						<div class="row">	  
							<div class="span2">
								<img id="rv_img${status.index }" class="rv_img" src="boardfile/${file.originFilename}" alt="상품후기이미지">
							</div>
							<div class="span4">
								
								<a href="#viewDetail" role="button" data-toggle="modal" class="open-AddReview" onclick="readcountUp('<c:out value="${review.boardNum}"/>')"><h3>New | Available</h3>				
									
									<h5 id="rv_title" class="rv_title">${review.boardTitle } </h5>
									<p id="rv_content" class="rv_content">
										${review.boardContent }
									</p>
								</a>
								
								<br class="clr">
							</div>
							<div class="span3" style="">
							
							<div>
							<h4>작성자 : ${review.boardWriter}</h4>
							<h4 id="rv_regtime">작성일 : <fmt:formatDate value="${review.boardRegTime }" pattern="yyyy-MM-dd" /></h4>
							<h4 id="rv_count">조회수 : ${review.boardReadcount }</h4>
							<h4 style="margin-bottom: 100px;">평점 :
							<c:forEach  var="i" begin="1" end="${review.score}">
								<img src="./img/rateStar.png" style="width: 20px; height: 20px;">
							</c:forEach>
							<c:if test="${review.score <5 }">
								<c:forEach  var="i" begin="1" end="${5 - review.score}">
									<img src="./img/writingStar.png" style="width: 20px; height: 20px;">
								</c:forEach>
								
							</c:if>	 </h4>
							
							
							<br>
							</div>
								<div>
								 <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" onclick="openReview('m','<c:out value="${review.boardNum}"/>')">글 수정하기 <span class=""></span></button>
							     <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" onclick="openReview('d','<c:out value="${review.boardNum}"/>')">글 삭제하기 <span class=""></span></button>
								</div>
							</div>
						</div>
								<hr class="soft">
							</c:forEach>
						</c:forEach>
								<div style="text-align: right;"> 상품평은 구매완료 후 <a href="OrderList.mo">수취확인</a>에서 작성하실 수 있습니다.</div>
						<c:if test="${!empty articleReviewList}">
						<div class="pagination">
							<ul>
							<li><c:if test="${pageInfoReview.startPage > pageBlock }">
							<a href='<c:url value="/Book.book?bookID=${book.bookID }&page=${pageInfoReview.startPage-pageInfoReview.pageBlock }"/>'>&lsaquo;</a></c:if></li>
							<li>
							<c:forEach var="i" begin="${pageInfoReview.startPage }" end="${pageInfoReview.endPage }" step="1">
							<a href='<c:url value="/Book.book?bookID=${book.bookID}&page=${i}"/>'>${i}</a>
							</c:forEach></li>
<!-- 							<li><a href="#bookqna&page=2">2</a></li> -->
<!-- 							<li><a href="#bookqna#&page=3">3</a></li> -->
<!-- 							<li><a href="#bookqna#&page=4">4</a></li> -->
							<li><a href="#">...</a></li>
							<li><c:if test="${pageInfoReview.endPage < pageInfoReview.maxPage }">
							<a href='<c:url value="/Book.book?bookID=${book.bookID }&page=${pageInfoReview.startPage + pageInfoReview.pageBlock}"/>'>&rsaquo;</a></c:if></li>
							</ul>
							</div>
							<br class="clr"/>
						</c:if>
					 </div>
					 <div class="tab-pane fade" id="bookqna">
					 	<div>
					 		
						    <h3><a href='<c:url value ="/Book.book?bookID=${book.bookID}"/>'>상품 문의하기</a></h3>    
						    <form class="well form-search">
						        <select id="select11" style="width:100px">
						                <option>제목</option>
						                <option>답변상태</option>
						                <option>문의자</option>
						              </select>
								<input type="text" class="input-medium search-query" style="">
								  <button type="submit" class="btn">Search</button>
						        <div class="qBtn">
									<button class="btn btn-inverse dropdown-toggle" data-toggle="dropdown" onclick="openQna('w','0')">문의하기 </button>
								</div>
							</form>
								<form name="bookQnaForm">
									<input type="hidden" name="bookID" value="${book.bookID }"/>
									<input type="hidden" name="bookTitle" value="${book.bookTitle }"/>
									<input type="hidden" name="uID" value="${sessionScope.uID }"/>
									<input type="hidden" name="boardNum" value=""/>
								</form>
						 </div>
					 	
					 	
					  
					 	<table id="qna_tb" class="table table-striped" style="width:870px"> 
					       <thead>
					         <tr>
					           <th style="width:100px">번호</th>
					           <th style="width:100px">답변상태</th>
					           <th style="text-align: center">제목</th>
					           <th style="width:100px">문의자</th>
					           <th style="width:100px">등록일</th>  
					         </tr>
					       </thead>
					       <tbody>
							<c:forEach var="qna" items="${articleQnaList}" varStatus="status">
					       		<tr class="qna_tr_p">
									<!-- 전체 레코드 수 - ( (현재 페이지 번호 - 1) * 한 페이지당 보여지는 레코드 수 + 현재 게시물 출력 순서 ) -->
									<td>${pageInfoQna.listCount -((pageInfoQna.page-1)* pageInfoQna.pageBlock + status.index)}</td>
									<td><c:if test="${0 < qna.boardReSeq}"> 
	           		 					답변완료 </c:if> 답변전</td>
					           		<td>${qna.boardTitle }</td>
									<td>${qna.boardWriter }</td>
									<td>${qna.boardRegTime }</td>
								</tr>
								<tr class="qna_tr_s" style="display: table-row;">
								   <td></td>
								   <td></td>
									<td><!--  class="td_rgt" -->
	<%-- 								<div style="text-align:center;">
									<div class="qna_qt" style="text-align: center; ">
										<span class="icon_qt">Q</span>
										${qna.boardContent}
									</div>
									<div class="qna_as" style="text-align: center;">
										<span class="icon_as">A</span>
										판매자의 답변
									</div>
							
									<p class="info" style="border: 1px solid pink;display: inline-block;">
									  <span class="">판매자의 답변</span>
									  <span class="date">
									  	등록일 :
									  	<em>2020-04-09</em>
									  </span>
									</p> 
									</div>
								 <div class="btn-group btn_rgt" style="border: 1px solid red; float:right ; ">
								 
									
							         <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" onclick="openQna('m','<c:out value="${qna.boardNum}"/>')">글 수정하기 <span class=""></span></button>
							         <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" onclick="openQna('d','<c:out value="${qna.boardNum}"/>')">글 삭제하기 <span class="caret"></span></button>
<!-- 							         <ul class="dropdown-menu"> -->
<!-- 							           <li><a href="#">Action</a></li> -->
<!-- 							           <li><a href="#">Another action</a></li> -->
<!-- 							           <li><a href="#">Something else here</a></li> -->
<!-- 							           <li class="divider"></li> -->
<!-- 							           <li><a href="#">Separated link</a></li> -->
<!-- 							         </ul> -->
							       </div> --%>
							       
							         
							           Q ${qna.boardContent}<br>
                                      A 판매자의 답변   jfdklgjldjgfkjglfjljgjfjgkldjkljigsourttt jfdklgjldjgfkjglfjljgjfjgkldjkljigsourttt<br>
                                                                                         판매자의 답변 등록일 : 2020-04-09
							       
							    	
									</td>
									<td colspan="2" style="vertical-align: bottom;">
									 
							    	 <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" onclick="openQna('m','<c:out value="${qna.boardNum}"/>')">글 수정하기 <span class=""></span></button>
							         <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" onclick="openQna('d','<c:out value="${qna.boardNum}"/>')">글 삭제하기 <span class=""></span></button>
							    	
									</td>
								</tr>				
  							</c:forEach>
							</tbody>
					    </table>
					   <%--  <a href="BookList.book?bk2=${book.BK2 }" class="btn btn-large pull-right">Compair Product</a> --%>
					    <c:if test="${!empty articleQnaList }">
						<div class="pagination">
							<ul>
							<li><c:if test="${pageInfoQna.startPage > pageBlock }">
							<a href='<c:url value="/Book.book?bookID=${book.bookID }&page=${pageInfoQna.startPage-pageInfoQna.pageBlock }"/>'>&lsaquo;</a></c:if></li>
							<li>
							<c:forEach var="i" begin="${pageInfoQna.startPage }" end="${pageInfoQna.endPage }" step="1">
							<a href='<c:url value="/Book.book?bookID=${book.bookID}&page=${i}"/>'>${i}</a>
							</c:forEach></li>
<!-- 							<li><a href="#bookqna&page=2">2</a></li> -->
<!-- 							<li><a href="#bookqna#&page=3">3</a></li> -->
<!-- 							<li><a href="#bookqna#&page=4">4</a></li> -->
							<li><a href="#">...</a></li>
							<li><c:if test="${pageInfoQna.endPage < pageInfoQna.maxPage }">
							<a href='<c:url value="/Book.book?bookID=${book.bookID }&page=${pageInfoQna.startPage + pageInfoQna.pageBlock}"/>'>&rsaquo;</a></c:if></li>
							</ul>
							</div>
							<br class="clr"/>
						</c:if>	
					 </div>
<!-- 					 <a href="compair.html" class="btn btn-large pull-right">Compair Product</a> -->
<!-- 						<div class="pagination"> -->
<!-- 							<ul> -->
<%-- 							<li><c:if test="${pageInfo.startPage > pageBlock }"> --%>
<%-- 							<a href='<c:url value="/Book.book?bookID=${book.bookID }&page=${pageInfo.startPage-pageInfo.pageBlock }"/>'>&lsaquo;</a></c:if></li> --%>
<!-- 							<li> -->
<%-- 							<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1"> --%>
<%-- 							<a href='<c:url value="/Book.book?bookID=${book.bookID}&page=${i}"/>'>${i}</a> --%>
<%-- 							</c:forEach></li> --%>
<!-- <!-- 							<li><a href="#bookqna&page=2">2</a></li> --> 
<!-- <!-- 							<li><a href="#bookqna#&page=3">3</a></li> --> 
<!-- <!-- 							<li><a href="#bookqna#&page=4">4</a></li> --> 
<!-- 							<li><a href="#">...</a></li> -->
<%-- 							<li><c:if test="${pageInfo.endPage < pageInfo.maxPage }"> --%>
<%-- 							<a href='<c:url value="/Book.book?bookID=${book.bookID }&page=${pageInfo.startPage + pageInfo.pageBlock}"/>'>&rsaquo;</a></c:if></li> --%>
<!-- 							</ul> -->
<!-- 							</div> -->
<!-- 							<br class="clr"/> -->
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
    <!-- <div class="modal"></div> -->
   <!--  <div class="modal-backdrop fade in"></div> -->
   
    <div id="viewDetail" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false"
    style="width: 820px; height: 620px; left:42%; top:45%; border: 1px solid #fff;">
		<div class="rv_wrap" style="color: #777; letter-spacing: -1px; text-align: left;">
			<div class="rv_top" style="padding: 20px 20px 20px; border-bottom: 1px solid #c6c6c6; height: 10px; line-height: 18px;" >
				<strong class="rev_title" style="width: 122px; font-size: 20px; height: 19px;">상품평</strong>
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">close</button>
			</div>
		  <div class="rv_main">
			<div class="rv_content">
				<div class="info_area">
					<div class="rv_comment">
						<p class="title" id="detail_title">
							
						</p>
					</div>
					<div class="info_text" style="text-align: right; width: 774px; height: 46px; padding: 5px;">
						<div style="display: inline-block; margin-right: 40px;">
						<span id="rv_readcount"></span>
						<span id="review_regtime"></span>
						</div>
					</div>
				</div>
				<div class="scroll_area" style="max-height: 415px;">
					<div class="cont_box">
					<p class="cont_p" style="text-align: center;"><img alt="상품후기이미지" id="cont_img" class="modal_img"></p>
					<p class="cont_text" style="margin: 10px;" id="detail_content"></p>
					<hr>
					</div>
				</div>
				<div class="cont_bottom">
					<div class="">
						
					</div>
				</div>
				 <div></div>	
			
			</div>
		  </div>
		  
		</div>  
	</div>
<!-- Placed at the end of the document so the pages load faster ============================================= -->
    <script src="themes/js/jquery.js" type="text/javascript"></script>
    <script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="themes/js/google-code-prettify/prettify.js"></script>
    <script src="themes/js/bootshop.js"></script>
    <script src="themes/js/jquery.lightbox-0.5.js"></script>
    

</body>
</html>