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
<!-- 파일전송할땐 항상 post 방식으로 전송!!!! -->
<div class="container">
	<form action="${appRoot }/upload/sub01" method="post" enctype="multipart/form-data">
		fname : <input name="fname" value="trump" /> <br>
		file : <input type="file" name="ufile" accept="image/*"> <br>
		<input type="submit">
	</form>
	
	<form action="${appRoot }/upload/sub02" method="post" enctype="multipart/form-data">
		name : <input name="name" value="donald"> <br>
		file : <input name="file" type="file" accept="image/*"> <br>
		<input type="submit">
	</form>
		
</div>
</body>
</html>