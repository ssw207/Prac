<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 


<html>
<head>
<title>1일차 과제</title>
</head>
<%
    request.setCharacterEncoding("UTF-8");
%>

<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script type="text/javascript" >
function test(){//
	setInterval(function() {//시작버튼 클릭시 작동
		$.ajax({//아작스통신 시작
			type : "GET",//주소만 보내므로 get통신
 			//data: "",//입력값없음로 사용하지 않음
			url : "./watch.do",//컨트롤러의 리퀘스트맵핑과 일치하는 명령어
			success : function(result) {//아작스통신으로 컨트롤러에서 결과값을 result로 받아옴
				$('#time').html(result.result);//돔탐색을하여 id가 time인 위치를 찾고 바닥에 아작스통신으로 받아온 결과값을찍음
			}
		})
	}, 1000);//1초간격으로 반복

}
</script>
<body>
	<h1>1일차 과제</h1>
	<div id="time"></div>
	<input type="button" value="시작" onclick="test()">
</body>
</html>
