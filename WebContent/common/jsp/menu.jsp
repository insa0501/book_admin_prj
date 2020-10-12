<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="상단 메뉴 공통디자인"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <section class="section_header">
	<script type="text/javascript">
		<c:if test="${ sessionScope.admin_id == null }">
			location.replace("admin_index.do");
	   	</c:if>
	</script>
      <div class="header_nav nav-up" id="header_nav">
        <div class="nav_logo">BOOKS</div>
        <ul class="nav_menu">
          <li class="nav_"><a href="http://localhost/book_admin_prj/book_list.do">도서관리</a></li>
          <li class="nav_"><a href="http://localhost/book_admin_prj/order_list.do">주문관리</a></li>
          <li class="nav_"><a href="http://localhost/book_admin_prj/user_list.do">회원관리</a></li>
          <li class="nav_"><a href="http://localhost/book_admin_prj/qna_list.do">문의관리</a></li>
        </ul>
        <div class="nav_user_icons">
        	<span><a href="http://localhost/book_admin_prj/admin_pass_check_form.do">비밀번호변경</a></span>
          <span><a href="http://localhost/book_admin_prj/admin_logout.do"><i class="fas fa-sign-in-alt"></i></a></span>
          <!-- <span><i class="far fa-user"></i></span> -->
        </div>
      </div>
    </section>