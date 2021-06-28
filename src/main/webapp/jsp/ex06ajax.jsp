<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>
<script type="text/javascript">
	$(function (){
		$("#btn1").click(function() {
			console.log("click btn1");
			$.ajax("${appRoot}/rest06/sub01");
		});
		
		$("#btn11").click(function(){
			$.ajax({
				url : "${appRoot}/rest06/sub01"
					 // btn1과 같은 일을 하고있음
					 
			});
		});
	});

</script>

<title>Insert title here</title>
</head>
<body>
<!-- ajax는 페이지 전체를 로딩하지 않음 -->
<h3><%= Math.random() %></h3>

<div class="container">
	<button id="btn1">버튼</button>
	<button id="btn11">버튼1-1</button>
	
	
	
	
	<script type="text/javascript">
	$(function(){
		$("#btn2").click(function(){
			var jqXHR = $.ajax("${appRoot}/rest06/sub02");	
			jqXHR.done(function(data){
				console.log("btn2 done... ")
				console.log(data)
			});
		});
	});
	</script>
	
	<button id="btn2">버튼2</button>
	<!-- btn2 == btn3 같음. 변수로 바꿔주냐 차이일뿐 -->
	<script type="text/javascript">
	$(function(){
		$("#btn3").click(function(){
			$.ajax("${appRoot}/rest06/sub02").done(function(data){
				console.log("btn done");
				console.log(data);
			});	
		});
		$("#btn31").click(function(){
			$.ajax({
				url : "${appRoot}/rest06/sub02",
				success : function(res){
					console.log("btn3-1 successn function");
					console.log(res);
				}
			})
		})
	});
	
	</script>
	<button id="btn3">BTN3</button>
	<button id="btn31">BTN31</button>
	
	<script>
	$(function(){
		$("#btn4").click(function(){
		
		$.ajax("${appRoot}/rest06/sub04")  // url
		.done(function(){
			console.log("성공!!");	
		})
		.fail(function(){
			console.log("실패!!")
		});
			
		});
		$("#btn41").click(function(){
			$.ajax({
				url : "${appRoot}/rest06/sub04",
				error : function(){
					console.log("실패!!! from btn4-1 error option")
				}
			})
		})
	});
	</script>
		
	<button id="btn4">버튼4</button>
	<button id="btn41">버튼4-1</button>
	
	<script>
		$(function(){
			$("#btn5").click(function(){
				$.ajax({
					url : "${appRoot}/rest06/sub05",
				//	type : "POST"  method로 교체가능
					method : "put"
				});
			});
		});
	</script>
	<button id="btn5">버튼5</button>
	
	
</div>
</body>
</html>