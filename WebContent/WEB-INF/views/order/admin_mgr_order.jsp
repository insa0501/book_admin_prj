<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>주문관리</title>
    <link rel="icon" type="image/png" href="http://localhost/book_admin_prj/images/icons/favicon.ico" />
    <!--Bootstrap-->
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
      integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
      crossorigin="anonymous"
    />
    <script
      src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
      integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
      crossorigin="anonymous"
    ></script>
    <!--CSS-->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
    />
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/reset.css" />
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/admin_mgr.css" />
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/main.css" />
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/common_header_footer.css" />
    <!-- JS -->
    <script type="text/javascript">
    	$(function() {
    		$("#searchBtn").click(function(){
    			if($("#selectData").val() == "") {
    				alert("값이 입력되지 않았습니다.");
    			} // end if
    			orderFrm.submit();
    		}) // click
    	}) //ready
    </script>
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
        <div class="content_title">주문관리</div>
        <form action="select_order_list.do" method="get" name="orderFrm">
        <div class="search">
          <div class="select_type">
            <select name="selectType" class="custom-select">
              <option value="1">ISBN</option>
              <option value="2">도서명</option>
              <option value="3">저자</option>
            </select>
          </div>

          <div class="keyword">
            <input class="form-control form-control-lg" id="selectData" name="selectData" type="text" />
          </div>
          <div class="search_btn">
            <button type="button" class="btn btn-dark" id="searchBtn" name="searchBtn">검색</button>
          </div>
        </div>
        </form>
        <div class="search_result">
          <table class="table">
            <thead class="thead-light">
              <tr>
                <th scope="col">#</th>
                <th scope="col">책 제목</th>
                <th scope="col">주문아이디</th>
                <th scope="col">주문가격</th>
                <th scope="col">배송현황</th>
                <th scope="col">주문일자</th>
              </tr>
            </thead>
            <tbody>
	            <c:forEach var="ol" items="${ order_list }">
	            <c:if test="${ empty order_list }">
	            	<tr><td>조회된 항목이 없습니다</td></tr>
	            </c:if>
	              <tr>
	                <th scope="row"><c:out value="${ ol.order_no }"/></th>
	                <td><c:out value="${ ol.book_name }"/></td>
	                <td><c:out value="${ ol.user_id }"/></td>
	                <td><c:out value="${ ol.order_price }"/></td>
	                <td><c:out value="${ ol.order_status }"/></td>
	                <td><c:out value="${ ol.order_date }"/></td>
	              </tr>
	            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
      <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-end">
        	<c:out value="${ indexList }" escapeXml="false"/>
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
