<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Sidebar ================================================== -->
    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="AdminMain.adm">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">BookShop</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Tables -->
      <li class="nav-item">
<!--         <a class="nav-link" href="tables.html"> -->
        <a class="nav-link" href="MemberList.adm">
          <i class="fas fa-fw fa-table"></i>
          <span>회원관리</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        주문 / 매출 조회
      </div>
      
      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>주문/매출조회</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="OrderList.adm">주문관리</a>
            <a class="collapse-item" href="Sales.adm">매출관리</a>
          
            <h6 class="collapse-header">Custom Components 참고:</h6>
            <a class="collapse-item" href="admin/buttons.html">Buttons</a>
            <a class="collapse-item" href="admin/cards.html">Cards</a>
            <a class="collapse-item" href="admin/buttons.html">Buttons</a>
            <a class="collapse-item" href="admin/cards.html">Cards</a>
          </div>
        </div>
      </li>

 <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        제품관리
      </div>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-wrench"></i>
          <span>제품관리</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="List.abook">제품목록(수정/삭제/검색)</a>
            <a class="collapse-item" href="WriteForm.abook">제품등록</a>
            <a class="collapse-item" href="ReviewList.abook">상품후기(답변/수정/삭제)</a>
            <a class="collapse-item" href="QList.abook">상품문의(답변작성/수정/삭제)</a>
            <a class="collapse-item" href="RefundList.abook">상품반품(엑셀)</a>
            <a class="collapse-item" href="BuyList.abook">물량추가(엑셀)</a>
          
            <h6 class="collapse-header">Custom Utilities-참고:</h6>
            <a class="collapse-item" href=".admin/utilities-color.html">Colors</a>
            <a class="collapse-item" href="admin/utilities-border.html">Borders</a>
            <a class="collapse-item" href="admin/utilities-animation.html">Animations</a>
            <a class="collapse-item" href="admin/utilities-other.html">Other</a>
          </div>
        </div>
      </li>
       <!-- Divider -->
      
       <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        	게시판관리
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>게시판 관리</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="QList.bo">1:1답변목록(답변/수정/삭제)</a>
            <a class="collapse-item" href="FAQ_List.bo">FAQ목록(답변/수정/삭제)</a>
            <a class="collapse-item" href="Notice_List.bo">배너 - 공지사항/이벤트목록(작성/수정/삭제)</a>
          
            <h6 class="collapse-header">Login Screen-참고:</h6>
            <a class="collapse-item" href="login.html">Login</a>
            <a class="collapse-item" href="register.html">Register</a>
            <a class="collapse-item" href="forgot-password.html">Forgot Password</a>
            <div class="collapse-divider"></div>
            <h6 class="collapse-header">Other Pages-참고:</h6>
            <a class="collapse-item" href="admin/404.html">404 Page</a>
            <a class="collapse-item" href="admin/blank.html">Blank Page</a>
          </div>
        </div>
      </li>
 <!-- Divider -->

 	 <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        참고
      </div>
      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="admin/charts.html">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Charts</span></a>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="admin/tables.html">
          <i class="fas fa-fw fa-table"></i>
          <span>table</span></a>
      </li>
      
      
      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

<!-- Sidebar end=============================================== -->