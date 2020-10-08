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
    <link rel = "stylesheet" type="text/css" href="http://localhost/book_admin_prj/common/css/admin_link.css">
    <style type="text/css">
    .addBook{ width:100px; height:30px; display: block; border-radius: 6px; color:#007BFF;
    			border:1px solid #dee2e6; background-color: #FFFFFF;}
    </style>
    
    <!-- JS -->
    <script type="text/javascript">
    
    $(function(){
    	$("#search").click(function(){
    		$("#search_frm").submit();
    	});//click
    });//ready
    </script>
  </head>
  <body>
  
 
    <!-- header -->
	<%-- <jsp:include page="http://localhost/book_admin_prj/common/jsp/menu.jsp"/> --%>
	<%-- <jsp:include page="../../../common/jsp/menu.jsp"/> --%>
	<c:import url="http://localhost/book_admin_prj/common/jsp/menu.jsp"/>
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
     
     <div style="margin-top:5px;">
     	<input type="button" class="addBook" value="도서추가" onclick="javascript:location.href='add_book.do';"/>
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
