<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원관리</title>
    <link rel="icon" type="image/png" href="http://localhost/book_admin_prj/common/images/icons/favicon.ico" />
    <!--Bootstrap-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous" ></script>
    <!--CSS-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/reset.css" />
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/admin_mgr.css" />
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/main.css" />
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/common_header_footer.css" />
    <!-- JS -->
    <style type="text/css">
    	td{ text-align: center; border-bottom: 1px solid #d9d9d9;}
    </style>
  </head>
  <body>
    <!-- header -->
    <section class="section_header">
      <div class="header_nav nav-up" id="header_nav">
        <div class="nav_logo">BOOKS</div>
        <ul class="nav_menu">
          <li class="nav_">도서관리</li>
          <li class="nav_">주문관리</li>
          <li class="nav_">회원관리</li>
          <li class="nav_">문의관리</li>
        </ul>
        <div class="nav_user_icons">
          <span><i class="fas fa-sign-in-alt"></i></span>
          <!-- <span><i class="far fa-user"></i></span> -->
        </div>
      </div>
    </section>
    <!-- header end -->
    <!--main section-->
    <section class="section_main">
      <div class="content_wrap">
        <div class="content_title">회원 관리</div>
        <div class="search">
          <div class="select_type">
            <select class="custom-select">
              <option value="1">아이디</option>
              <option value="2">이름</option>
              <option value="3">전화번호</option>
            </select>
          </div>

          <div class="keyword">
            <input class="form-control form-control-lg" type="text" />
          </div>
          <div class="search_btn">
            <button type="button" class="btn btn-dark">검색</button>
          </div>
        </div>
        <div class="search_result">
          <table class="table">
            <thead class="thead-light">
              <tr>
                <th scope="col">아이디</th>
                <th scope="col">이름</th>
                <th scope="col">전화번호</th>
                <th scope="col">주소</th>
                <th scope="col">상태</th>
              </tr>
            </thead>
            <tbody>
            <c:if test="${empty user_list or user_list eq null }">
            	<strong>유저 정보가 존재하지 않습니다.</strong>
            </c:if>
            <c:forEach var="ul" items="${user_list }">
            	<tr>
            		<td><c:out value="${ul.user_id }"/></td>
            		<td><c:out value="${ul.user_name }"/></td>
            		<td><c:out value="${ul.user_phone }"/></td>
            		<td><c:out value="${ul.user_addr1 }"/></td>
            		<td><c:out value="${ul.user_status }"/></td>
            	</tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
     <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-end">
     		<c:out value="${page_nation }" escapeXml="false"/>
     	</ul>
     </nav>
    </section>
    <!--main end-->
    <!-- footer -->
    <section class="footer">
      <div class="footer_text">
        @copyright 2조 <br />
        Lorem ipsum dolor sit amet consectetur adipisicing elit.<br />
        Necessitatibus tenetur temporibus, enim nostrum soluta deleniti? <br />
        Veritatis maiores consequuntur magni
      </div>
    </section>
  </body>
</html>
