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
	<link href="css/nav.css?ver=1" rel="stylesheet" type="text/css">
	<style type="text/css" id="enject"></style>
	
  </head>
<body>
<jsp:include page="../inc/top.jsp"></jsp:include>
<!-- Header End====================================================================== -->
<div id="mainBody">
	<div class="container">
	<div class="row" style="margin-left: 10%;">
<!-- Sidebar ================================================== -->
<%--     <jsp:include page="../inc/menu.jsp"></jsp:include> --%>
<!-- Sidebar end=============================================== -->
	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="./index.jsp">전체교제</a> <span class="divider">/</span></li>
		<li class="active">전체교제</li>
    </ul>
	<hr class="soft"/>
	<form class="form-horizontal span6">
		<div class="control-group">
		  <label class="control-label alignL">Sort By </label>
			<select>
              <option>Priduct name A - Z</option>
              <option>Priduct name Z - A</option>
              <option>Priduct Stoke</option>
              <option>Price Lowest first</option>
            </select>
		</div>
	  </form>
	  
<div id="myTab" class="pull-right">
 <a href="#listView" data-toggle="tab"><span class="btn btn-large"><i class="icon-list"></i></span></a>
 <a href="#blockView" data-toggle="tab"><span class="btn btn-large btn-primary"><i class="icon-th-large"></i></span></a>
</div>
<br class="clr"/>
<div class="tab-content">
	<div class="tab-pane" id="listView">
	  <c:forEach var="book" items="${bookAllList}" varStatus="status">
	  
		<div class="row">	  
			<div class="span2">
				<img src="upload/${book.bookImage }" alt="책이미지"/>
			</div>
			<div class="span4">
				<h3>New | Available</h3>				
				<hr class="soft"/>
				<h5>${book.bookTitle } </h5>
				<p>
				${book.bookIntroduce }
				</p>
				<a class="btn btn-small pull-right" href="product_details.html">View Details</a>
				<br class="clr"/>
			</div>
			<div class="span3 alignR">
			<form class="form-horizontal qtyFrm">
			<h3> ${book.bookPrice }</h3>
			<label class="checkbox">
				<input type="checkbox">  Adds product to compair
			</label><br/>
			
			  <a href="CartAdd.book?bookID=${book.bookID }" class="btn btn-large btn-primary"> Add to <i class=" icon-shopping-cart"></i></a>
			  <a href="Book.book?bookID=${book.bookID }" class="btn btn-large"><i class="icon-zoom-in"></i></a>
			
				</form>
			</div>
		</div>
	</c:forEach>
		<hr class="soft"/>
	</div>

	<div class="tab-pane active" id="blockView">
		<ul class="thumbnails">
		  <c:forEach var="book" items="${bookAllList }" varStatus="status">
				<li class="span3">
				  <div class="thumbnail">
					<a href="Book.book?bookID=${book.bookID }">
						<img src="boardFile/${book.bookImage}" alt="책 이미지" style="min-width:100px; max-width: 250px; min-height: 100px; max-height: 250px;"/>
					</a>
					<div class="caption">
					  <h5>${book.bookTitle }</h5>
					  <p style="height: 50px;text-overflow: ellipsis;white-space: nowrap; overflow: hidden;"> 
						${book.bookIntroduce }
					  </p>
					    <h4 style="text-align:center"><a class="btn" href="Book.book?bookID=${book.bookID }"> <i class="icon-zoom-in"></i></a> <a class="btn" href="CartAdd.book?bookID=${book.bookID }">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">${book.bookPrice }원</a></h4>
					</div>
				  </div>
				</li>
				  <%-- <c:if test="${((status.index+1) mod 3)==0}">		
			  </ul>
			  <ul class="thumbnails">
			  	</c:if> --%>
			</c:forEach>
		</ul>
		<hr class="soft"/>
	</div>
</div>
	
	<div class="pagination">
			<ul>
			<li><c:if test="${pageInfo.startPage > pageInfo.pageBlock }">
			<a href="BookListALL.book?&page=${pageInfo.startPage-pageInfo.pageBlock}">&lsaquo;</a></c:if></li>
			<li>
			<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
			<a href="BookListALL.book?&page=${i}">${i}</a>
			</c:forEach></li>
			<%-- <li><a href="BookList.book?bk2=${param.bk2 }&page=2">2</a></li> --%>
			
			<li><a href="#">...</a></li>
			<li><c:if test="${pageInfo.endPage < pageInfo.maxPage }">
			<a href='<c:url value="/BookListALL.book?&page=${pageInfo.startPage + pageInfo.pageBlock}"/>'>&rsaquo;</a></c:if></li>
			</ul>
			</div>
			<br class="clr"/>
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