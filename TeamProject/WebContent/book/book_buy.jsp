<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	String sid = null;
// // 로그인이 되지 않은 상태일 경우 로그인 페이지로 강제 이동 처리
// 	if(session.getAttribute("sid") == null) {
// 		out.println("<script>");
// 		out.println("alert('This service requires a login')");
// 		out.println("location.href='LoginForm.me'");
// 		out.println("</script>");
// 	} else {// 로그인 된 상태일 경우 세션 ID 가져오기
// 		sid = (String)session.getAttribute("sid");
// 	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Board</title>
<style type="text/css">
	#registForm {
		width: 500px;
		height: 610px;
		border: 1px solid red;
		margin: auto;
	}
	
/* 	h2 { */
/* 		text-align: center; */
/* 	} */
	
	table {
		margin: auto;
		width: 450px;
		border: 1px solid darkgray;
	}
	
	.td_left {
		width: 150px;
		background: orange;
	}
	
	.td_right {
		width: 300px;
		background: skyblue;
	}
	
	#commandCell {
		text-align: center;
	}
	header {
	text-align: right;
}
</style>
</head>
<body>
	<header>
		<!-- 세션ID(sId) 가 없을 경우 로그인(LoginForm.me), 회원가입(JoinForm.me) 링크 표시 -->
		<!-- 세션ID(sId) 가 있을 경우 회원ID, 로그아웃(Logout.me)링크 표시 -->
<%-- 		<%if(sid == null) {%> --%>
<!-- 			<a href="LoginForm.me">Login</a> | <a href="JoinForm.me">Join</a> -->
<%-- 		<%} else { %> --%>
<%-- 			Welcome <%=sid %> :D | <a href="Logout.me">Logout</a> --%>
<%-- 		<%} %> --%>
	</header>
	<!-- 게시판 글 등록 -->
	<section id="writeForm">
		<h2>book.jsp</h2>
				<a href="#"> 결제페이지입니다</a>
		
<!-- 		<form action="BookBuyPro.bo" method="post" enctype="multipart/form-data" name="boardform"> -->
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					label 태그를 사용하여 해당 레이블 클릭 시 for 속성에 지정된 이름과 같은 id 속성을 갖는 텍스트필드로 커서 요청 -->
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
<!-- 			<section id="commandCell"> -->
<!-- 				<input type="submit" value="confirm" />&nbsp;&nbsp; -->
<!-- 				<input type="reset" value="Cencel" /> -->
<!-- 			</section> -->
		</form>	
	</section>
</body>
</html>