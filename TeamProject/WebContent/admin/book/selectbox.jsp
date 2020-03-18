<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function() {

	//****************이부분은 DB로 셋팅하세요.
    //Main 카테고리 셋팅 (DB에서 값을 가져와 셋팅 하세요.)

    $.getJSON('jsonBK1.jsp', function (d) {
		$.each(d, function (index, item) {
			$("select[name='BK1Category']").append("<option value='" + item.BK1 + "'>" + item.BK1 + "</option>");
		});
	});
    
	//*********** 1depth카테고리 선택 후 2depth 생성 START ***********
    $(document).on("change","select[name='BK1Category']",function(){
        
        //두번째 셀렉트 박스를 삭제 시킨다.
        var BK2CategorySelectBox = $("select[name='BK2Category']");
        BK2CategorySelectBox.children().remove(); //기존 리스트 삭제
        //세번째 셀렉트 박스를 삭제 시킨다.
        var BKLevCategorySelectBox = $("select[name='BKLevCategory']");
        BKLevCategorySelectBox.children().remove(); //기존 리스트 삭제
        BKLevCategorySelectBox.append("<option value=''>전체</option>");
        
        //선택한 첫번째 박스의 값을 가져와 일치하는 값을 두번째 셀렉트 박스에 넣는다.
        $("option:selected", this).each(function(){
            var selectValue = $(this).val(); //main category 에서 선택한 값
            BK2CategorySelectBox.append("<option value=''>전체</option>");
            $.getJSON('jsonBK2.jsp', function (d) {
        		$.each(d, function (index, item) {
        			if(item.BK1 == selectValue){
        				$("select[name='BK2Category']").append("<option value='" + item.BK2 + "'>" + item.BK2 + "</option>");
        			}
        		});
        	});
        });
        
    });
	
  //*********** 2depth카테고리 선택 후 3depth 생성 START ***********
    $(document).on("change","select[name='BK2Category']",function(){
        
        //세번째 셀렉트 박스를 삭제 시킨다.
        var BKLevCategorySelectBox = $("select[name='BKLevCategory']");
        BKLevCategorySelectBox.children().remove(); //기존 리스트 삭제
        
        //선택한 두번째 박스의 값을 가져와 일치하는 값을 두번째 셀렉트 박스에 넣는다.
        $("option:selected", this).each(function(){
            var selectValue = $(this).val(); //main category 에서 선택한 값
            BKLevCategorySelectBox.append("<option value=''>전체</option>");
            $.getJSON('jsonBKLev.jsp', function (d) {
        		$.each(d, function (index, item) {
        			if(item.BK2 == selectValue){
        				$("select[name='BKLevCategory']").append("<option value='" + item.BKLev + "'>" + item.BKLev + "</option>");
        			}
        		});
        	});
        });
        
    });
});
</script>

</head>
<body>
	대분류 : <select name="BK1Category" style="width:200px">
        <option value="">전체</option>
    </select>
        소분류 : <select name="BK2Category" style="width:200px">
        <option value="">전체</option>
    </select>
        레벨 : <select name="BKLevCategory" style="width:200px">
        <option value="">전체</option>
    </select>
</body>
</html>