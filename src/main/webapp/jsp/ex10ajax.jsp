<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$("#submit1").click(function(e){
			e.preventDefault();
			$(this).attr("disabled", "disabled") // 버튼 얼리기(여러번 클릭방지)
			var id = $("#input1").val();
			var age = $("#input2").val();
			var data = {id : id, age : age};
			
			$.post({  
				url:"${appRoot}/rest10/add", // post 방식으로 URL로 요청을 보냄
				data : data,
				success: function(data){
					console.log(data);
					alert(data.id + "가 등록되었습니다"); // 팝업창 메세지
					$("#submit1").removeAttr("disabled"); // 버튼 풀어주기
				}
			})
		})
		
		$("#button2").click(function(){
			$.get({
				url : "${appRoot}/rest10/list",
				success : function(list){
					console.log(list);
						var table1body = $("#table1 tbody");
							table1body.empty();
							
							
					for(var i= 0; i < list.length; i++){
						var tr = $("<tr><td>"+ list[i].id + "</td><td>"	+ list[i].age + "</td></tr>");
						table1body.append(tr);
					}
				}
			});
		});
		$("#like-button1").click(function(){
			var operation = $(this).attr("data-operation");			
			var url = "${appRoot}/rest10/" + operation;	
			
			
			$.post({
				url: url,
				success: function(data){
					$("#like-cnt1").text(data);
					
					if(operation === "like"){
						$("#like-button1").attr("data-operation", "unlike");
						$("#like-icon1").removeClass("far").addClass("fas");
					} else{
						$("#like-button1").attr("data-operation", "like");
						$("#like-icon1").removeClass("fas").addClass("far");
					}	
				}
			})
		})
		
	})

</script>
</head>
<body>
<div class="container">
	<%=Math.random() %> <!-- 전체페이지가 로딩 안되는지 확인용 --> 
	<hr>
	
	<button id="like-button1" data-operation="like">
	<i id="like-icon1" class="far fa-heart"></i>
	<span id="like-cnt1">10</span>
	</button>
	
	
	
	<hr>
	
		<input id="input1" name="id" placeholder="id">
		<input id="input2" name="age" placeholder="age">
		<button id="submit1" type="submit" value="전송">전송</button> 
		
		<hr>
		
		<button id="button2">목록보기</button>
		
		<table class="table" id="table1">
			<thead>
			<tr>
			<th>ID </th>
			<th>AGE </th>
			</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	
	
	
		
</div>
</body>
</html>