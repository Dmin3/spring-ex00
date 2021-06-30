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
	<script>
	$(function(){
		$("#btn1").click(function(){
			var data = { // 자바스크립트 객체
					bno: 1,
					reply: "새로운 댓글",
					replyer: "user12"
					};
			$.post({
				url: "${appRoot}/replies/new",
				data: JSON.stringify(data), // 자바스크립트 객체를 JSON(텍스트)로 바꿔주는형식
		// JSON.parse(data) 는 반대로 JSON(String 객체)를 자바스크립트 객체로 바꿔주는 형식
				contentType: "application/json",
				success: function(data) {
					console.log(data);
				},
				error:function(){
					console.log("등록실패")
				}
			});
		});
		$("#btn2").click(function(){
			// 등록실패도 잘 뜨는지 확인
			var data = { 
					bno: 77,
					reply: "새로운 댓글",
					replyer: "user12"
					};
			$.post({
				url: "${appRoot}/replies/new",
				data: JSON.stringify(data), 
				contentType: "application/json",
				success: function(data) {
					console.log(data);
				},
				error:function(){
					console.log("등록실패")
				}
			});
		})
	})
	</script>
	
	<h5>입력테스트</h5>
	<button id="btn1">TEST CREATE - success</button>
	<button id="btn2">TEST CREATE - fail</button>
	
	<hr>
	<script>
	$(function(){
		$("#btn3").click(function(){
			var bno = 1;
			$.get({
				url: "${appRoot}/replies/pages/" + bno,
				success: function(data){
					console.log(data);
				}
			})
		})
	})
	</script>
	<h5>목록 테스트</h5>
	<button id="btn3">TEST LIST</button>
	
	<hr>
	<script type="text/javascript">
		$(function(){
			$("#btn4").click(function(){
				var rno = 11;
				$.get({
					url:"${appRoot}/replies/" + rno,
					success: function(data){
							console.log(data);
					}
				});
			})
		})
	</script>
	<h5>댓글 하나 얻어오기</h5>
	<button id="btn4">TEST GET</button>
	
	<hr>
	
	<h5>댓글 삭제</h5>
	<script>
	$(function(){
		$("#btn5").click(function(){
			var rno = 8;
			$.ajax({
				type: "delete",
				url:"${appRoot}/replies/" + rno,
				success: function(){
					console.log("delete success");
				},
				error:function(){
					console.log("delete fail");
				}
			})
		})
	})
	</script>
	<button id="btn5">TEST DELETE</button>
	
	<hr>
	
	<script>
	$(function(){
		$("#btn6").click(function(){
			var rno = 7;
			var data = {
					rno : rno,
					bno : 1,
					reply:"안녕하세요",
					replyer:"user00000"
			}
			$.ajax({
				type:"put",
				url:"${appRoot}/replies/" + rno,
				data:JSON.stringify(data), // json으로 형식 바꾸어주기
				contentType: "application/json", // 요청 형식 json 으로 바꾸어주기
				success: function(){
					console.log("수정 성공!!");
				},
				error: function(){
					console.log("수정 실패 ㅠ");
				}
			})
		})
	})
	</script>
	<h5>댓글 수정</h5>
	<button id="btn6">TEST UPDATE</button>
	
	<hr>
	<script>
	$(function(){
		$("#btn7").click(function() {
			var rno = $("#input1").val();
			var bno = $("#input2").val();
			var reply = $("#input3").val();
			var replyer = $("#input4").val();
			
			var data = {
					rno : rno,
					bno : bno,
					reply : reply,
					replyer : replyer 
					};
			$.ajax({
				type:"put",
				url: "${appRoot}/replies/" + rno,
				data: JSON.stringify(data), // json으로 형식 바꾸어주기
				contentType: "application/json", // 요청 형식 json 으로 바꾸어주기
				success: function(){
					console.log("수정 성공!!");
				},
				error: function(){
					console.log("수정 실패 ㅠ");
				}
			})
		});
	})
	</script>
	
	<h5>댓글 수정 form</h5>

	<input id="input1" name="rno" value="7" readonly> <br>
	<input id="input2" name="bno" value="1" readonly> <br>
	<input id="input3" name="reply" placeholder="댓글입력"> <br>
	<input id="input4" name="replyer" placeholder="작성자 입력"> <br>
	
	<button id="btn7" >TEST UPDATE form</button>
		
</div>
</body>
</html>