<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="css/bookqna2.css" rel="stylesheet">
<link href="css/bookqna3.css" rel="stylesheet">

<style type="text/css">

.hover:hover {
background-color: #5af; 
}

.hover2:hover {
background-color: #b4b9c9; 
}











</style>


</head>
<body>
	<header>
<%-- 		<%if(sid == null) {%> --%>
<!-- 			<a href="LoginForm.me">Login</a> | <a href="JoinForm.me">Join</a> -->
<%-- 		<%} else { %> --%>
<%-- 			Welcome <%=sid %> :D | <a href="Logout.me">Logout</a> --%>
<%-- 		<%} %> --%>
	</header>
	<!-- 게시판 글 등록 -->
<!-- 	<section id="writeForm"> -->
	 <div class="vip_popup_wrap">
		<h1 class="tit_vippop">판매자에게 문의하기</h1>
		<p class="subinfo"> 상품 문의를 남겨주시면 판매자가 직접 답변을 드립니다.
		</p>
		<form action="QWritePro.book" method="post" enctype="multipart/form-data" name="boardform">
		   <fieldset>
		   		<legend>판매자에게 문의하기 폼</legend>
					<table class="tb_questionform">
					 <colgroup>
					 	<col style="width:92px">
					 </colgroup>
						<tbody>
						<tr>
							<th>상품명</th>
							<td class="pdtit"></td>
						</tr>
						<tr>
							<th>아이디</th>
							<td>강경준</td>
						</tr>
						<tr>
							<th>제목</th>
							<td>
							  <input type="text" title="제목" class="ip_viptext" id="qa_title" 
							  style="width:496px;padding: 7px 18px 5px 12px;height: 18px;" name="boardTitle">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td>
								<textarea title="내용" class="ip_viptxtarea" id="ta_content" name="boardContent">
								
								</textarea>
							</td>
						</tr>
					  </tbody>
					</table>
		  	</fieldset>
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<td class="td_left"><label for="board_name">Username</label></td> -->
<!-- 					<td class="td_right"><input type="text" name="board_name" id="board_name" required="required" /></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td class="td_left"><label for="board_pass">Password</label></td> -->
<!-- 					<td class="td_right"><input type="password" name="board_pass" id="board_pass" required="required" /></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td class="td_left"><label for="board_subject">Subject</label></td> -->
<!-- 					<td class="td_right"><input type="text" name="board_subject" id="board_subject" required="required" /></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td class="td_left"><label for="board_content">Content</label></td> -->
<!-- 					<td class="td_right"><textarea name="board_content" id="board_content" cols="40" rows="15" required="required" ></textarea></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td class="td_left"><label for="board_file">Attached File</label></td> -->
<!-- 					<td class="td_right"><input type="file" name="board_file" id="board_file" required="required" /></td> -->
<!-- 				</tr> -->
<!-- 			</table> -->
			<section id="commandCell">
				<input type="submit" value="confirm" />&nbsp;&nbsp;
<!-- 				<input type="reset" value="Cencel" /> -->
			</section>
		</form>
		<p class="bottom_btns">
		<!-- "javascript:;insertQna('1766321978')" -->
			<a href= ./QWritePro.book
				class="bt_confirm bt_vipround100 hover"><span>확인</span></a> <a
				href="javascript:window.close();" class="bt_cancel bt_vipround100 hover2"><span>취소</span></a>
		</p>
		<p class="bar_close">
			<a href="#" class="bt_close" onclick="window.close();"> 닫기 <span
				class="ic">X</span>
			</a>
		</p>
	</div>
	 
<!-- 	</section> -->
</body>
</html>