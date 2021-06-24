<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:url value="/board/list" var="listUrl" >
	
	<c:param name="pageNum" value="${pageMaker.cri.pageNum }"></c:param>
	<c:param name="amount" value="${pageMaker.cri.amount }"></c:param>
	
	
	<c:param name="pageNum" value="${cri.pageNum }"></c:param>
	<c:param name="amount" value="${cri.amount }"></c:param>
	
</c:url>

<c:url value="/board/register" var="registerUrl" >
	
	<c:param name="pageNum" value="${pageMaker.cri.pageNum }"></c:param>
	<c:param name="amount" value="${pageMaker.cri.amount }"></c:param>
	
	
	<c:param name="pageNum" value="${cri.pageNum }"></c:param>
	<c:param name="amount" value="${cri.amount }"></c:param>
	
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
        <a class="nav-link" href="#">Pricing</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#" >Disabled</a>
      </li>
    </ul>
  </div>
</nav>