<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel = "stylesheet" type="text/css" href="http://localhost/book_admin_prj/common/css/add_detail_book.css"> -->
<link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/admin_add_detail_book.css">
<link rel = "stylesheet" type="text/css" href="http://localhost/book_admin_prj/common/css/common_header_footer.css">
 
<title>Insert title here</title>
<style type="text/css">

 
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

 <script src="header.js"></script>
 
<script type="text/javascript">

 $(function () {
	 $("#updateBtn").click(function(){
			if( $("#book_img").val() == ""){
				alert("도서 이미지를 설정해주세요.");
				return;
			}
			if( $("#book_isbn").val() == ""){
				alert("도서번호를 설정해주세요.");
				return;
			}
			if( $("#book_name").val() == ""){
				alert("도서명을 설정해주세요.");
				return;
			}
			if( $("#book_writer").val() == ""){
				alert("저자를 설정해주세요.");
				return;
			}
			if( $("#book_company").val() == ""){
				alert("출판사를 설정해주세요.");
				return;
			}
			if( $("#book_price").val() == ""){
				alert("도서의 가격을 설정해주세요.");
				return;
			}
			if( $("#book_date").val() == ""){
				alert("도서의 출판일을 설정해주세요.");
				return;
			}
			if( $("#book_stock").val() == ""){
				alert("도서의 재고를 설정해주세요.");
				return;
			}
			if( $("#book_info").val() == ""){
				alert("도서 정보를 설정해주세요.");
				return;
			}
			
			$("#updateBook").submit();
		});//click
	 
	 $("#closeBtn").click(function(){
		 location.href='http://localhost/book_admin_prj/book_list.do';
	 });//click
	 
	 $("#upfile").change(function(select_file){
		 var check_img = $("#upfile").val();
		 
		 var start_num = check_img.lastIndexOf('.')+1;
		 var end_num = check_img.length;
		 check_img = check_img.substring(start_num,end_num).toLowerCase();
		 if( !(check_img == 'jpg' || check_img == 'png' || check_img == 'jpeg' || check_img == 'gif') ){
			 alert("이미지형식의 파일만 업로드가능합니다.");
			 $("#upfile").val("");
			 return;
		 }
		 
		 $("#book_img").val( $("#upfile").val() );
		 var file = select_file.target.files[0];
		 var reader = new FileReader();
		 reader.readAsDataURL(file);
		 reader.onload = function(){
			 $("#preview").prop('src', reader.result);
		 }
	 });//change
	 
	 function fileUpload(input){
		 
	 }
	 
 });//ready



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
 
  <div id="container">
     <div id = "bookaddBody">
     
      <form action="http://localhost/book_admin_prj/change_book.do" method="post" id="updateBook" name="updateBook"  enctype="multipart/form-data">
       <div><h2>도서 상세 정보</h2></div><br/><br/>
       
          <div><h3>&nbsp;도서 정보</h3></div>
          <div class="checkBoxGrop">
            <input type="checkbox" name="book_best" id="book_best" ${book_detail.book_best eq 'Y' ? 'checked="checked"' : '' }>베스트셀러
            <input type="checkbox" name="book_best" id="book_activity" ${book_detail.book_activity eq 'Y' ? 'checked="checked"' : '' }>활성화 여부
           </div>
           
        
          <div class="bookImgDiv">
              <div class="bookImg">
                   <img src="http://localhost/book_admin_prj/common/images/book/${book_detail.book_img }" id="preview"><br/>
              </div>
              <div>
                <input type="file" id="upfile" name="upfile" value = "이미지 선택">
                <input type="hidden" id="book_img" name="book_img" value="${book_detail.book_img }"/>
              </div>
         </div>
         
         <div class="bookData">
           <table class="bookDataTab">
              <tr>
                 <th class="colTh">isbn</th>
                 <td><input type="text" name="book_isbn" id="book_isbn" value="${book_detail.book_isbn }"></td>
                 <th class="colTh">도서명</th>
                 <td><input type="text" name="book_name" id="book_name" value="${book_detail.book_name }"></td>
              </tr>
              <tr>
                 <th class="colTh">도서분류</th>
                      <td><select name="book_country" id="book_country">
                           <option value="국내도서" >국내도서</option>
                           <option value="외국도서" ${book_detail.book_country ne '국내' ? 'selected="selected"' : ''  }>외국도서</option>
                          </select> 
                      </td>
                 <th class="colTh">세부분류</th>
                          <td>
                          <select name="book_type_no" id="book_type_no"> 
                          <option value="0" ${book_detail.book_type_no eq '0' ? 'selected="selected"':'' }>과학</option>
                          <option value="1" ${book_detail.book_type_no eq '1' ? 'selected="selected"':'' }>아동</option>
                          <option value="2" ${book_detail.book_type_no eq '2' ? 'selected="selected"':'' }>소설</option>
                          <option value="3" ${book_detail.book_type_no eq '3' ? 'selected="selected"':'' }>여행</option>
                          <option value="4" ${book_detail.book_type_no eq '4' ? 'selected="selected"':'' }>요리</option>
                          <option value="5" ${book_detail.book_type_no eq '5' ? 'selected="selected"':'' }>심리</option>
                        </select>
                      </td>
              </tr>
              <tr>
                 <th class="colTh">저자명</th>
                 <td><input type="text" name="book_writer" id="book_writer" value="${book_detail.book_writer }" ></td>
                 <th class="colTh">출판사</th>
                 <td><input type="text" name="book_company" id="book_company" value="${book_detail.book_company }" ></td>
                 
              </tr>
              <tr>
                 <th class="colTh">판매가</th>
                 <td><input type="text" name="book_price" id="book_price" value="${book_detail.book_price }" ></td>
                 <th class="colTh">출판일</th>
                 <td><input type="text" name="book_date" id="book_date" value="${book_detail.book_date }" ></td>
              </tr>
              <tr>
                 <th class="colTh">재고량</th>
                 <td><input type="text" name="book_stock" id="book_stock" value="${book_detail.book_stock }" ></td>
                 <th class="colTh">도서 등록일</th>
                 <td><input type="text" name="book_input_date" id="book_input_date" value="${book_detail.book_input_date }" ></td>
                 
              </tr>
           </table>
           </div> 
       
           
           <div class="bookInfoDiv">
            <div id="bookIntroDiv"><h3>도서소개</h3></div>
                
              <textarea  name="book_info" id="book_info" ><c:out value="${book_detail.book_info }"/></textarea> 
              <div id="buttonGrop" >
                <input type="button" value="확인"   id="closeBtn" name="closeBtn" /><!-- 확인버튼 클릭시 도서관리페이지로 이동 -->
			    <input type="button" value="수정"   id="updateBtn" name="updateBtn"/><!-- 수정버튼 클릭 시 수정됨 -->
              </div>
           </div>
            
       </form>      
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