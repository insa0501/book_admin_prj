<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>문의관리</title>
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
    <link rel = "stylesheet" type="text/css" href="http://localhost/book_admin_prj/common/css/admin_link.css">
    <!-- JS -->
    <script type="text/javascript">
    	$(function(){
    		
    		function nullChk() {
    			if($("#selectData").val() == "") {
    				alert("값이 입력되지 않았습니다.");
    				return;
    			} // end if
    			//alert($("#selectType").val() + " / " + $("#selectData").val());
    			qnaFrm.submit();
    		} // nullChk()
    		
    		$("#searchBtn").click(function(){
    			nullChk();	
    		}) // click
    		
    		$("#selectData").keydown(function() {
    			if (window.event.which == 13) {
    				nullChk();
    			} // end if
    		}) //keydown
    		
    		$("#selectType").change(function(){
   				var output = "<input class='form-control form-control-lg' type='text' id='selectData' name='selectData'/>";
   				var keywordDiv = document.getElementById("keywordDiv");
   				
    			if($("#selectType").val() == 3) {
    				
    				output = "<select id='selectData' name='selectData' class='custom-select'>"
    							+"<option value='N'>미완료</option>"
    							+"<option value='Y'>완료</option>"
    						+"</select>";
    			} // end if
   				keywordDiv.innerHTML = output;
    		}) // change
    		
    	}) // ready
    </script>
  </head>
  <body>
    <!-- header -->
    <!-- <link rel="import" href="common/html/mgr_header.html" /> -->
    <!-- <section class="section_header">
      <div class="header_nav nav-up" id="header_nav">
        <div class="nav_logo">BOOKS</div>
        <ul class="nav_menu">
          <li class="nav_">도서관리</li>
          <li class="nav_"><a href="order_list.do">주문관리</a></li>
          <li class="nav_">회원관리</li>
          <li class="nav_"><a href="qna_list.do">문의관리</a></li>
        </ul>
        <div class="nav_user_icons">
          <span><i class="fas fa-sign-in-alt"></i></span>
          <span><i class="far fa-user"></i></span>
        </div>
      </div>
    </section> -->
    <%-- <c:import url="http://localhost/book_admin_prj/common/jsp/menu.jsp"/> --%>
    <jsp:include page="../../../common/jsp/menu.jsp"/>
    <!-- header end -->
    <!--main section-->
    <section class="section_main">
      <div class="content_wrap">
        <div class="content_title">문의관리</div>
        <form action="qna_list.do" name="qnaFrm" method="get">
	        <div class="search">
	          <div class="select_type">
	            <select id="selectType" name="selectType" class="custom-select">
	              <option value="1" ${ param.selectType eq '1' ? "selected='selected'":"" }>회원아이디</option>
	              <option value="2" ${ param.selectType eq '2' ? "selected='selected'":"" }>문의내용</option>
	              <option value="3" ${ param.selectType eq '3' ? "selected='selected'":"" }>답변유무</option>
	            </select>
	          </div>
	
	          <div class="keyword" id="keywordDiv">
	            <c:if test="${ param.selectType ne '3' }">
	            	<input type="text" class="form-control form-control-lg search_text" id="selectData" name="selectData" value="${ param.selectData }"/>
	            </c:if>
	          	<c:if test="${ param.selectType eq '3' }">
	          		<select id="selectData" name="selectData" class="custom-select">
    					<option value='N' ${ param.selectData eq 'N' ? "selected='selected'" : "" }>미완료</option>
    					<option value='Y' ${ param.selectData eq 'Y' ? "selected='selected'" : "" }>완료</option>
    				</select>
	          	</c:if>
	          </div>
	          <div class="search_btn">
	            <button type="button" id="searchBtn" class="btn btn-dark">검색</button>
	          </div>
	        </div>
        </form>
        <div class="search_result">
          <table class="table">
            <thead class="thead-light">
              <tr>
                <th scope="col">문의번호</th>
                <th scope="col">제목</th>
                <th scope="col">아이디</th>
                <th scope="col">분류</th>
                <th scope="col">등록일</th>
                <th scope="col">답변유무</th>
              </tr>
            </thead>
            <tbody>
	            <c:if test="${ empty qna_list }">
	            	<tr><td colspan="6" style="text-align:center;">조회된 항목이 없습니다</td></tr>
	            </c:if>
          	    <c:forEach var="ql" items="${ qna_list }">
	              <tr>
	                <th scope="row"><c:out value="${ ql.qna_no }"/></th>
	                <td><a href="qna_detail.do?qna_no=${ ql.qna_no }"><c:out value="${ ql.qna_subject }"/></a></td>
	                <td><c:out value="${ ql.user_id }"/></td>
	                <td><c:out value="${ ql.qna_type }"/></td>
	                <td><c:out value="${ ql.qna_input_date}"/></td>
	                <td><c:out value="${ ql.qna_status }"/></td>
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
