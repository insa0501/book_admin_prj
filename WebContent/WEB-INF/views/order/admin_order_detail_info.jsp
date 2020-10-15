<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href="http://localhost/book_admin_prj/common/css/reset.css" />
<link rel = "stylesheet" type="text/css" href="http://localhost/book_admin_prj/common/css/admin_order_detail_info.css">
<link rel = "stylesheet" href="http://localhost/book_admin_prj/common/css/main.css" />
<link rel = "stylesheet" type="text/css" href="http://localhost/book_admin_prj/common/css/common_header_footer.css">
<link rel = "stylesheet" type="text/css" href="http://localhost/book_admin_prj/common/css/admin_link.css">
<title>Insert title here</title>
<!-- <style type="text/css">
    	a { color:#333; }
    	a:hover { color:#333; font-weight:bold; }
</style> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

 <script src="header.js"></script>
 
<script type="text/javascript">

 $(function () {
	 
	$("#closeBtn").click(function() {
		location.href="order_list.do";
	}) // click	
	
	$("#updateBtn").click(function(){
		
		if (confirm("수정하시겠습니까?")) {
		
			$.ajax({
				url:"update_order.do",
				type:"POST",
				data:"order_no=" + $("#order_no").val() + "&order_status=" + $("#order_status").val(),
				dataType:"text",
				error:function( xhr ){
					console.log(xhr.status + " / " + xhr.statusText);				
				}, //error
				success:function( ){
					alert("수정되었습니다.");
					location.href="order_list.do";
				} //success
			}); // ajax
		
		} // end if 
		
	}) // updateBtn click
	
	$("#deleteBtn").click(function(){

		if (confirm("삭제하시겠습니까?")) {

			$.ajax({
				url:"delete_order.do",
				type:"GET",
				data:"order_no=" + $("#order_no").val(),
				dataType:"text",
				error:function( xhr ){
					console.log(xhr.status + " / " + xhr.statusText);				
				}, //error
				success:function( text_data ){
					location.href="order_list.do";
					alert("삭제되었습니다.");
				} //success
			}); // ajax
			
		} // end if 
		
	}) // deleteBtn click
	
 });//ready

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
     
     <div id="orderDetailInfo">
     
      <form method="post" id="orderDetailFrm" name="orderDetailFrm"> <!-- enctype="multipart/form-data" 업로드가 없어서 일단 주석처리 -->
       <div><h2>주문상세정보</h2></div> 
       
         <div class="orderData">
         <!-- 여기서 수정은 배송 현황만 가능 -->
           <table class="orderDataTab">
           <div class="orderDataLabel"><h3>&nbsp;주문 정보</h3></div>
              <tr >
                 <th class="colTh"> 주문번호 </th><td><input type="text" name="order_no" id="order_no" readonly="readonly" value="${ order_info.order_no }"/></td>
                 <th class="colTh"> 주문 일자</th><td><input type="text" name="order_date" id="order_date" value="${ order_info.order_date }"/></td>
              </tr>
              <tr>
                 <th class="colTh"> 주문자 ID </th><td><input type="text" name="user_id" id="user_id" value="${ order_info.user_id }"/></td>
                 <th class="colTh"> 연락처 </th><td><input type="text" name="order_phone" id="order_phone" value="${ order_info.order_phone }"/></td>
              </tr>
              
              
              <tr>
                 <th class="colTh">배송현황</th>
                      <td><select name="order_status" id="order_status">
                           <option value="0" ${ order_info.order_status eq 0 ? "selected='selected'":"" }>주문완료</option>
                           <option value="1" ${ order_info.order_status eq 1 ? "selected='selected'":"" }>배송중</option>
                           <option value="2" ${ order_info.order_status eq 2 ? "selected='selected'":"" }>배송완료</option>
                          </select> 
                      </td>
                 <th class="colTh">결제</th><td><c:out value="${ order_info.card_info }"/></td><!-- 코딩시 카드사(카드번호 조회) -->
                           
              </tr>
              <tr>
                 <th class="colTh">우편번호</th><td><input type="text" name="order_zipcode" id="order_zipcode" value="${ order_info.order_zipcode }"/></td>
                 <th class="colTh">주문자 ip</th><td><input type="text" name="user_ip" id="user_ip" value="${ order_info.user_ip }"/></td>
                 
              </tr>
              <tr>
                 <th class="colTh">주소</th><td colspan="3"><input type="text" name="order_addr1" id="order_addr1" value="${ order_info.order_addr1 }"/></td>
              </tr>
              <tr>
                 <th class="colTh">상세주소</th><td colspan="3"><input type="text" name="order_addr2" id="order_addr2" value="${ order_info.order_addr2 }"/></td>
                 
              </tr>
           </table>
           </div> 
       
           
           <div id="paymentInfo">
             <table class="paymentInfoTab">
             <div class="paymentInfoLabel"><h3>결제 정보</h3></div>
              <tr>
                 <th class="colTh"> 주문금액 </th><td><input type="text" name="order_price" id="order_price"  value="${ order_info.order_price }원"/></td>
                 <th class="colTh"> 배송비 </th><td><input type="text" name="delivery_charge" id="delivery_charge"  value="0원"/></td>
              </tr>
             </table>
           </div>
              
           <div id="bookInfo">
              <div class="bookInfoLabel"><h3>도서 정보</h3></div>
             <table class="bookInfoTab"> 
              <tr>
                 <th class="colTh1"> isbn </th><th class="colTh1"> 도서명 </th><th class="colTh1"> 수량 </th><th class="colTh1"> 판매가 </th>
              </tr>
              <c:forEach var="odd" items="${ order_info.orderBookList }">
	              <tr>
	                 <td><input type="text" name="book_isbn" id="book_isbn" value="${ odd.book_isbn }"/> </td>
	                 <td><input type="text" name="book_name" id="book_name" value="${ odd.book_name }"/> </td>
	                 <td><input type="text" name="order_book_cnt" id="order_book_cnt" value="${ odd.order_book_cnt }"/> </td>
	                 <td><input type="text" name="book_price" id="book_price" value="${ odd.book_price }"/> </td>
	              </tr>
              </c:forEach>
             </table>
          </div>
            
              <div id="buttonGrop">
			    <input type="button" value="확인" id="closeBtn" name="closeBtn"/>
                <input type="button" value="수정" id="updateBtn" name="updateBtn"/>
			    <input type="button" value="삭제" id="deleteBtn" name="deleteBtn"/>
              </div>
            
       </form><!-- orderDetailFrm -->      
     
    </div>

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