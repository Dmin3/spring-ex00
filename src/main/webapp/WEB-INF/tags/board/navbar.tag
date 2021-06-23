<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="${appRoot }/board/list">스프링게시판</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${appRoot }/board/list"><i class="fas fa-list-ul"></i>목록보기 </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="${appRoot }/board/register"><i class="fas fa-pencil-alt"></i>글쓰기</a>
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