<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.4.1.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	// ================== 대분류 카테고리 지정
	$.getJSON('jsonBK1.jsp', function (d) {
		$.each(d, function (index, item) {
			$("select[name='BK1Category']").append("<option value='" + item.BK1 + "'>" + item.BK1 + "</option>");
		});
	});
	
	// ================== 대분류 카테고리 바꼈을 때 소분류 변경함수
	$("#BK1Category").on("change", function () {
		// 대분류 값 가져오기
		var BK1 = $("#BK1Category option:selected").val();
		// 소분류 데이터 가져오기
		$.ajax({
			type:"POST",
			url:"jsonBK2_1.jsp",
			data:"BK1="+BK1,
			success: function(msg){	// 소분류 innerHTML
				$("select[name='BK2Category']").html(msg);
			}
		});
// 		alert($("#BK2Category option:selected").val());
		// 레벨 셀렉트 박스 지우기
		$("select[name='BKLevCategory']").html("<option value='선택하세요'>선택하세요</option>");
	});
	
	
	// ================== 소분류 카테고리 바꼈을 때 레벨 변경함수
	$("#BK2Category").on("change", function () {
// 		// 대분류, 소분류 값 가져오기
		var BK1 = $("#BK1Category option:selected").val();
		var BK2 = $("#BK2Category option:selected").val();
// 		// 소분류 데이터 가져오기
		$.ajax({
			type:"POST",
			url:"jsonBKLev_2.jsp",
			data:"BK1="+BK1+"&BK2="+BK2,
			success: function (msg2) {	// 레벨 innerHTML
				$("select[name='BKLevCategory']").html(msg2);
			}
		});
	});
});
</script>
</head>
<body>
대분류 : <select name="BK1Category" id="BK1Category" style="width:200px">
     		<option value="선택하세요">선택하세요</option>
  		</select>
소분류 : <select name="BK2Category" id="BK2Category" style="width:200px">
      		<option value="선택하세요">선택하세요</option>
  	   </select>
레벨 : <select name="BKLevCategory" style="width:200px">
     		<option value="선택하세요">선택하세요</option>
  	  </select>
</body>
</html>