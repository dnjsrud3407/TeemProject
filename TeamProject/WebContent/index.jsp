<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

</head>

<body>

	<ul>
		<li><a href="AdminMain.adm">관리자</a></li>
	
		<li><a href="JoinForm.me">회원가입</a></li>

		<li><a href="Login.me">로그인</a></li>
		
		<li><a href="member.jsp">마이페이지</a></li>

		<li><a href="helpCenter.jsp">고객센터</a></li>

	</ul>
<!-- 상품검색란 include -->
	<ul>

		<li><a href="">로드맵</a>
		
		</li>

		<li><a href="BookList.book">교재구매</a>

			<ul>

				<li><a href="BookList.book">새로나온책</a></li>

				<li><a href="BookList.book">베스트셀러</a></li>

				<li>단계별

					<ul>

						<li><a href="BookList.book?stage=1">1단계</a>

						<li><a href="BookList.book?stage=2">2단계</a></li>

						<li><a href="BookList.book?stage=3">3단계</a></li>

						<li><a href="BookList.book?stage=4">4단계</a></li>

					</ul>

				</li>

				<li>분야별

					<ul>

						<li><a href="BookList.book?stage=1">JAVA</a></li>

						<li><a href="BookList.book?stage=1">JSP</a></li>

						<li><a href="BookList.book?stage=1">HTML/CSS</a></li>

						<li><a href="BookList.book?stage=1">DATABASE</a></li>

					</ul>

				</li>

			</ul>

		</li>

		<li><a href="">이벤트</a></li>

	</ul>

</body>

</html>