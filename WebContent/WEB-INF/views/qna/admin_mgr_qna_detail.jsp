<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>문의상세</title>
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
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/admin_mgr_qna_detail.css" />
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/main.css" />
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/common_header_footer.css" />
    <link rel = "stylesheet" type="text/css" href="http://localhost/book_admin_prj/common/css/admin_link.css">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script type="text/javascript">
    	$(function() {
    		
    		$("#acceptBtn").click(function() {
    			location.href="order_list.do";
    		}) // click
    		
   			$("#addReplyBtn").click(function() {
				if (confirm("답변을 등록하시겠습니까?")) {
					$.ajax({
						url:"qna_answer.do",
						type:"POST",
						data:"qna_no="+$("#qna_no").val()+"&qna_answer="+$("#qna_answer").val(),
						dataType:"text",
						error:function( xhr ) {
							console.log( xhr.status + " / " + xhr.statusText );
							alert("답변등록에 실패하였습니다.");
						}, //error
						success:function( ) {
							alert("답변이 등록되었습니다.");
							location.href = "qna_list.do";
						} // success
		    		}); // ajax	
		    		
				} // end if
				
   			}) // addReplyBtn click
   			
   			
   			$("#delReplyBtn").click(function() {
				if (confirm("문의를 삭제하시겠습니까?")) {
					$.ajax({
						url:"delete_qna.do",
						type:"POST",
						data:"qna_no="+$("#qna_no").val(),
						error:function( xhr ) {
							console.log( xhr.status + " / " + xhr.statusText );
							alert("삭제에 실패하였습니다.");
						}, //error
						success:function( ) {
							alert("삭제되었습니다.");
							location.href="qna_list.do";
						} // success
		    		}); // ajax	
		    		
				} // end if
				
   			}) // addReplyBtn click
   			
    	}) // ready
    </script>
  </head>
  <body>
        <!-- header -->
        <!-- <section class="section_header">
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
              <span><i class="far fa-user"></i></span>
            </div>
          </div>
        </section> -->
        <%-- <c:import url="http://localhost/book_admin_prj/common/jsp/menu.jsp"/> --%>
        <jsp:include page="../../../common/jsp/menu.jsp"/>
        <!-- header end -->
  	<div id="container">
    <section class="main_section">
    	<div class="content_wrap">
	      <div class="main_title">문의상세 및 답변</div>
	      <div class="main_content">
	        <table>
	          <tr>
	            <td class="column">문의번호</td>
	            <td class="content">
	            	<c:out value="${ qna_info.qna_no }"/>
	            	<input type="hidden" id="qna_no" value="${ qna_info.qna_no }"/>
	            </td>
	            <td class="column">등록시간</td>
	            <td class="content"><c:out value="${ qna_info.qna_input_date}"/></td>
	          </tr>
	          <tr>
	            <td class="column">아이디</td>
	            <td class="content"><c:out value="${ qna_info.user_id }"/></td>
	            <td class="column">ip</td>
	            <td class="content"><c:out value="${ qna_info.qna_ip }"/></td>
	          </tr>
	          <tr>
	            <td class="column">분류</td>
	            <td class="content"><c:out value="${ qna_info.qna_type }"/></td>
	            <td class="column">답변일자</td>
	            <td class="content"><c:out value="${ qna_info.qna_reply_date ne null ? qna_info.qna_reply_date : '' }"/></td>
	          </tr> 
	          <tr>
	            <td class="column">제목</td>
	            <td class="que_content" colspan="3">
	                <input type="text" class="q_title_input" readonly="readonly" value="<c:out value='${ qna_info.qna_subject }'/>"/>
	            </td>
			  </tr>	            
			  <tr>
	            <td class="column">내용</td>
	            <td class="que_content" colspan="3">
	                <textarea type="text" class="q_content_input" readonly="readonly"><c:out value='${ qna_info.qna_content }'/></textarea>
	            </td>
	          </tr>
	        </table>
			</div>
	    <div class="answer_content">
            <div class="a_title">답변</div>
            <input type="text" class="a_content" id="qna_answer" value="${ qna_info.qna_answer ne null ? qna_info.qna_answer : '' }"/>
        </div>
        <div class="btn_group" id="btn_group">
          <button type="button" class="btn btn-dark" id="addReplyBtn">수정/답변</button>
          <button type="button" class="btn btn-dark" id="delReplyBtn">삭제</button>
          <button type="button" class="btn btn-dark" id="acceptBtn">확인</button>
        </div>
	</div>
    </section>
    </div>
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
