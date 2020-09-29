<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>도서관리</title>
    <link rel="icon" type="image/png" href="http://localhost/book_admin_prj/images/icons/favicon.ico" />
    <!--Bootstrap-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous" ></script>
    <!--CSS-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/reset.css" />
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/admin_mgr.css" />
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/main.css" />
    <link rel = "stylesheet" href="http://localhost/book_admin_prj/common/css/common_header_footer.css">
    <!-- JS -->
    <script type="text/javascript">
    
    $(function(){
    	$("#search").click(function(){
    		$("#search_frm").submit();
    	});//click
    });//ready
    </script>
    ${insertFlag eq 1 ? '<script>alert("도서가 추가되었습니다.");</script>' : '' }
    ${updateFlag eq 1 ? '<script>alert("도서가 변경되었습니다.");</script>' : '' }
  </head>
  <body>
  
 
    <!-- header -->
    <section class="section_header">
      <div class="header_nav nav-up" id="header_nav">
        <div class="nav_logo">BOOKS</div>
        <ul class="nav_menu">
          <li class="nav_"><a href="http://localhost/book_admin_prj/book_list.do">도서관리</a></li>
          <li class="nav_">주문관리</li>
          <li class="nav_"><a href="http://localhost/book_admin_prj/user_list.do">회원관리</a></li>
          <li class="nav_">문의관리</li>
        </ul>
        <div class="nav_user_icons">
        	<span><a href="http://localhost/book_admin_prj/admin_pass_check_form.do">비밀번호변경</a></span>
          <span><a href="http://localhost/book_admin_prj/admin_logout.do"><i class="fas fa-sign-in-alt"></i></a></span>
          <!-- <span><i class="far fa-user"></i></span> -->
        </div>
      </div>
    </section>
    <!-- header end -->
    <!--main section-->
    <section class="section_main">
      <div class="content_wrap">
        <div class="content_title">도서관리</div>
        
        <form action="http://localhost/book_admin_prj/book_list.do" method="GET" name="search_frm" id="search_frm" >
        <div class="search">
          <div class="select_type">
            <select class="custom-select" name="selectType">
              <option value="book_isbn" ${param.selectType eq 'book_isbn'? "selected='selected'" : ''  }>ISBN</option>
              <option value="book_name" ${param.selectType eq 'book_name'? "selected='selected'" : ''  }>도서명</option>
              <option value="book_price" ${param.selectType eq 'book_price'? "selected='selected'" : ''  }>가격</option>
              <option value="book_writer" ${param.selectType eq 'book_writer'? "selected='selected'" : ''  }>저자</option>
              <option value="book_company" ${param.selectType eq 'book_company'? "selected='selected'" : ''  }>출판사</option>
              <option value="book_date" ${param.selectType eq 'book_date'? "selected='selected'" : ''  }>출간일</option>
              <option value="book_stock" ${param.selectType eq 'book_stock'? "selected='selected'" : ''  }>재고</option>
              <option value="book_activity" ${param.selectType eq 'book_activity'? "selected='selected'" : ''  }>상태</option>
            </select>
          </div>

          <div class="keyword">
            <input class="form-control form-control-lg" type="text" name="selectData" value="${param.selectData }" />
          </div>
          <div class="search_btn">
            <button type="button" class="btn btn-dark" id="search">검색</button>
          </div>
        </div>
        </form>
        
        <div class="search_result">
          <table class="table">
            <thead class="thead-light">
              <tr>
                <th scope="col">ISBN</th>
                <th scope="col">도서명</th>
                <th scope="col">가격</th>
                <th scope="col">저자</th>
                <th scope="col">출판사</th>
                <th scope="col">출간일</th>
                <th scope="col">재고</th>
                <th scope="col">상태</th>
              </tr>
            </thead>
            <tbody>
            <c:if test="${book_list eq null or empty book_list  }">
              <tr>
                <th scope="row" colspan="8">해당 도서가 없습니다.</th>
              </tr>
             </c:if>
             <c:forEach var="book" items="${book_list }">
              <tr>
                <th scope="row"><c:out value="${book.book_isbn }"/></th>
                <td>
                	<a href="select_book_detail.do?book_isbn=${book.book_isbn }">
                		<c:out value="${book.book_name }"/>
                	</a>
                </td>
                <td><c:out value="${book.book_price }"/></td>
                <td><c:out value="${book.book_writer }"/></td>
                <td><c:out value="${book.book_company }"/></td>
                <td><c:out value="${book.book_date }"/></td>
                <td><c:out value="${book.book_stock }"/></td>
                <td><c:out value="${book.book_activity }"/></td>
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
     
     <div class="">
     	<input type="button" value="도서추가" onclick="javascript:location.href='add_book.do';"/>
     </div>
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
