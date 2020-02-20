<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<section id="writeForm">
		<h2>review_write.jsp</h2>
		<form action="ReviewWritePro.book" method="post" enctype="multipart/form-data" name="boardform">
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
	</section>
</body>
</html>