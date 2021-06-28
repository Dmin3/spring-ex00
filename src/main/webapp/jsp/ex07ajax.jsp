<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>


</head>
<body>
<div class="container">
	<script type="text/javascript">
	$(function(){
		$("#btn1").click(function(){
			$.ajax({ // type 초기값은 get방식이다
				url : "${appRoot}/rest07/sub01",
				data : {
					name : "korea",
					age : 33
				},
				success : function(data){
					console.log(data);
				}
			})
		})
	})
	</script>

	<button id="btn1">btn1</button>
	
	
	<script >
	$(function(){
		
		$("#btn2").click(function(){
			$.ajax({
				url : "${appRoot}/rest07/sub02",
				type : "post",
				data : {
					id:"jeju",
					age:22
				},
				success: function(data){
					console.log(data)
				}
			})
		})
	})
	</script>
	<button id="btn2">btn2</button>
	
	
	<script type="text/javascript">
	$(function(){
		$("#btn3").click(function(){
			$.ajax({
				url : "${appRoot}/rest07/sub03",
				type: "post",
				data : JSON.stringify({
					id: "jeju",
					age : 77
				}),
				contentType : "application/json",
				success:function(data){
					console.log(data);
				}
			})
		})
	})
	</script>
	<button id="btn3">btn3</button>
	
	<script>
	$(function(){
		$("#btn4").click(function(){
			$.ajax({
				url : "${appRoot}/rest07/sub04",
				success: function(data){
					// User객체를 자동으로 변환해줌
					console.log(data);
					
					console.log(data.id);
					console.log(data.age);
					
				}
				
			})
		})
	})
	</script>
	<button id="btn4">btn4</button>
		
</div>
</body>
</html>