<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:url value="/board/list" var="listUrl" >
<c:if test="${not empty cri.pageNum }"> 
	<c:param name="pageNum" value="${cri.pageNum }"></c:param>
</c:if>
<c:if test="${not empty cri.amount }"> 
	<c:param name="amount" value="${cri.amount }"></c:param>
</c:if>
	<c:param name="keyword" value="${cri.keyword }"></c:param>
	<c:param name="type" value="${cri.type }"></c:param>
	
</c:url>

<c:url value="/board/register" var="registerUrl" >
	<c:if test="${not empty cri.pageNum }">
	<c:param name="pageNum" value="${cri.pageNum }"></c:param>
	</c:if>
	<c:if test="${not empty cri.amount }">
	<c:param name="amount" value="${cri.amount }"></c:param>
	</c:if>
	<c:param name="keyword" value="${cri.keyword }"></c:param>
	<c:param name="type" value="${cri.type }"></c:param>
	
</c:url>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="${appRoot }/board/list">스프링게시판</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${listUrl }"><i class="fas fa-list-ul"></i>목록보기 </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="${registerUrl }"><i class="fas fa-pencil-alt"></i>글쓰기</a>
      </li>
     <li class="nav-item active">
        <a class="nav-link" href="${appRoot }/secure/all">모두</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="${appRoot }/secure/member">멤버만</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="${appRoot }/secure/admin">어드민만</a>
      </li>
    </ul>
  </div>
  
  <form action="${appRoot }/logout" method="post">
  	<input type="submit" class="btn btn-outline-secondary" value="로그아웃">
  </form>
  
  
   <form action="${listUrl }" method="get" class="form-inline">
   		
   	<select name="type" class="form-control mr-sm-2">
   		<option value=""> </option>
   		<option value="T" ${cri.type == "T" ? 'selected': '' }>제목 </option>
   		<option value="C" ${cri.type == "C" ? 'selected': '' }>내용 </option>
   		<option value="W" ${cri.type == "W" ? 'selected': '' } >작성자 </option>
   		<option value="TC" ${cri.type == "TC" ? 'selected': '' }>제목 or 내용 </option>
   		<option value="TW" ${cri.type == "TW" ? 'selected': '' }>제목 or 작성자 </option>
   		<option value="TWC" ${cri.type == "TWC" ? 'selected': '' }>제목 or 작성자 or 내용 </option>
   	</select>	
   	
      <input name="keyword" value="${cri.keyword }" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <input type="hidden" name="pageNum" value="1">
      <input type="hidden" name="amount" value="${cri.amount }">
      
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
    </form>
</nav>

















