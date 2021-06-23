<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="bd" tagdir="/WEB-INF/tags/board"%>


<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
</head>
<body>
<bd:navbar />
<div class="container">
	<h1>글보기</h1>

		<div class="row">
			<div class="col-12">
				<form >
					<div class="form-group">
					<label for="input1">제목</label>
					 <input readonly id="input1" class="form-control" name="title" value="${board.title }"> 
					</div>
					<div class="form-group">
					<label for="textarea1">내용</label>
					<textarea readonly id="textarea1" class="form-control" name="content" >
					<c:out value="${board.content }"></c:out>
					</textarea> 				
					</div>
					<div class="form-group">
					<label for="input2">작성자</label>
					 <input readonly id="input2" class="form-control" name="writer" value="${board.writer }"> <br>
					</div>

					
					<a class="btn btn-secondary" href="${appRoot }/board/modify?bno=${board.bno}">수정/삭제</a>
				</form>

			</div>
		</div>
		
</div>
</body>
</html>