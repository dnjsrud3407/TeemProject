<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
if(session.getAttribute("uID") == null){
	response.sendRedirect("index.jsp");
}
 %>
<html lang="en">
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Dashboard</title>

  <!-- Custom fonts for this template-->
  <link href="admin/vendor/fontawesome-free/css/all.min.css?ver=1" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i?ver=1" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="admin/css/sb-admin-2.css?ver=1" rel="stylesheet">
  <link href="admin/css/sb-admin-2.min.css?ver=1" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
	<jsp:include page="adminInc/adminMenu.jsp" />
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <jsp:include page="./adminInc/topbar.jsp"></jsp:include>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Content Row -->
          <div class="">
          <div class="row" >

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-4 col-md-6 mb-4">
              <div class="card border-left-info shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="font-weight-bold text-xl text-info text-uppercase mb-1">주문현황</div>
                    </div>
                    <div class="col-xl-6">
                      <div class="col mr-2">
                        <div class="font-weight text-dark mb-1 iconText">신규주문</div><div class="iconText2">0건</div><div class="clear"></div>
                        <div class="font-weight text-dark mb-1 iconText">배송중</div><div class="iconText2">0건</div><div class="clear"></div>
                        <div class="font-weight text-dark mb-1 iconText">배송완료</div><div class="iconText2">0건</div><div class="clear"></div>
                      </div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-clipboard-list fa-2x_custom text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            
            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-4 col-md-6 mb-4">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="font-weight-bold text-xl text-success text-uppercase mb-1">이번달 매출현황</div>
                    </div>
                    <div class="col mr-2">
                      <div class="font-weight text-dark mb-1 iconText">결제완료</div><div class="iconText2">0원</div><div class="clear"></div>
                      <div class="font-weight text-dark mb-1 iconText">취소/반품</div><div class="iconText2">0원</div><div class="clear"></div>
                      <div class="font-weight text-dark mb-1 iconText">총매출</div><div class="iconText2">0원</div><div class="clear"></div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-dollar-sign fa-2x_custom text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            
            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-4 col-md-6 mb-4">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="font-weight-bold text-xl text-primary text-uppercase mb-1">상품</div>
                    </div>
                    <div class="col mr-2">
                      <div class="font-weight text-dark mb-1 iconText">판매중 상품</div><div class="iconText2">0건</div><div class="clear"></div>
                      <div class="font-weight text-dark mb-1 iconText">수정중 상품</div><div class="iconText2">0건</div><div class="clear"></div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-dollar-sign fa-2x_custom text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>
          </div>
          <!-- Content Row -->

          <div class="row">

            <!-- Area Chart -->
            <div class="col-xl-12 col-lg-7">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary text-xl">매출 통계</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  <div class="chart-area">
                    <canvas id="myAreaChart"></canvas>
<!--                     <input type="hidden" id="iii" value="11111"> -->
                  </div>
                </div>
              </div>
            </div>

            
          </div>
          
          <div class="">
          <div class="row">
            <div class="col-xl-4 col-lg-5">
              <div class="card shadow mb-4 EventHeight">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body text-center text-dark">
                	<table class="boardTr">
                		<c:forEach begin="1" end="5" varStatus="status">
	                		<tr style="border: 1px solid;">
	                			<td colspan="2">게시글 최신꺼부터 가져오기</td>
	                			<td>2020.04.21</td>
	                		</tr>                		
                		</c:forEach>
                	</table>
                </div>
              </div>
            </div>
            
            <div class="col-xl-4 col-lg-5">
              <div class="card shadow mb-4 EventHeight">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">이벤트</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body text-center text-dark">
                	<table class="boardTr">
                		<c:forEach begin="1" end="5" varStatus="status">
	                		<tr>
	                			<td colspan="2">게시글 최신꺼부터 가져오기</td>
	                			<td>2020.04.21</td>
	                		</tr>                		
                		</c:forEach>
                	</table>
                </div>
              </div>
            </div>
            
            <!-- 미답변 게시글 -->
            <div class="col-xl-4 col-lg-5">
              <div class="card shadow mb-4 EventHeight">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">미답변 게시글</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body text-center text-dark" style="padding-top: 0px;">
                	<table class="boardTr">
                		<tr>
                			<td class="boardTitle">상품문의</td>
                			<td class="boardTitle">상품후기</td>
                			<td class="boardTitle">1:1문의</td>
                		</tr>
                		<tr></tr>
                		<c:forEach begin="1" end="4" varStatus="status">
	                		<tr style="border: 1px solid;">
	                			<td colspan="2">게시글 최신꺼부터 가져오기</td>
	                			<td>2020.04.21</td>
	                		</tr>                		
                		</c:forEach>
                	</table>
                </div>
              </div>
            </div>
            
          </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2019</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="LogoutPro.me">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="admin/vendor/jquery/jquery.min.js?ver=1"></script>
  <script src="admin/vendor/bootstrap/js/bootstrap.bundle.min.js?ver=1"></script>

  <!-- Core plugin JavaScript-->
  <script src="admin/vendor/jquery-easing/jquery.easing.min.js?ver=1"></script>

  <!-- Custom scripts for all pages-->
  <script src="admin/js/sb-admin-2.min.js?ver=1"></script>

  <!-- Page level plugins -->
  <script src="admin/vendor/chart.js/Chart.min.js?ver=1"></script>

  <!-- Page level custom scripts -->
  <script src="admin/js/demo/chart-area-demo.js?ver=1"></script>
  <script src="admin/js/demo/chart-pie-demo.js?ver=1"></script>
</body>

</html>
