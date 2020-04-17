<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Bootstrap 101 Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--     Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet"/>
	<link href="themes/css/font-awesome.css" rel="stylesheet" type="text/css">
<!-- Google-code-prettify -->	
	<link href="themes/js/google-code-prettify/prettify.css" rel="stylesheet"/>
<!-- fav and touch icons -->
    <link rel="shortcut icon" href="themes/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="themes/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="themes/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="themes/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="themes/images/ico/apple-touch-icon-57-precomposed.png">
	<style type="text/css" id="enject"></style>
<!--     플러그인 참조 -->
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.js"></script>
    <script src="http://cdn.ckeditor.com/4.4.7/standard/ckeditor.js"></script>
    
    
    <script type="text/javascript">
	
	function checkCode3() {
		  var v1 = form2.code_check2.value;
		  var v2 = form2.code3.value;
		  if(v1!=v2){
			   document.getElementById('checkCode2').style.color = "red";
			   document.getElementById('checkCode2').innerHTML = "잘못된인증번호";
               makeNull();
		  }else{
			   document.getElementById('checkCode2').style.color = "blue";
			   document.getElementById('checkCode2').innerHTML = "인증되었습니다."; 
			   makeReal();
		  }
		 }
	function makeReal(){
		var hi = document.getElementById("hi");
		hi.type="submit";
	}
    function makeNull(){
		var hi = document.getElementById("hi");
		hi.type="hidden";
	}

    
  
   
</script>
    
  </head>
  <body>
  <%
 System.out.println("여기까지 왔지롱");
  %>
    <!-- 상단 고정메뉴 (검정) -->
    <form id = "form2" action="history.back();" name="form2" class="form2">
		<table>
			<tr>
				<td><span class="control-label">인증번호</span></td>
				<td><div class="control-label"><input type="text" name="code3" id="code3" onkeyup="checkCode3()" placeholder="인증번호를 입력하세요." /></div>
					<div id="checkCode2"></div></td>
				<td><input type="hidden" readonly="readonly" name="code_check2"
					id="code_check2" value="<%=session.getAttribute("code")%>" /></td>
			</tr>
		</table>
		<input id = "hi" type="hidden" value='인증하기'/>
		</form>
		
    <!--// 내용영역 끝 -->
  </body>
</html>