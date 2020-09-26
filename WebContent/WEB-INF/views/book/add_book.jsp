<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel = "stylesheet" type="text/css" href="http://localhost/book_admin_prj/common/css/add_detail_book.css"> -->
<link rel = "stylesheet" type="text/css" href="http://localhost/book_admin_prj/common/css/common_header_footer.css">
<link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/admin_add_detail_book.css">


<title>Insert title here</title>
<style type="text/css">

 
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

 <script src="header.js"></script>
 
<script type="text/javascript">

 $(function () {
	$("#addBookBtn").click(function(){
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
		
		$("#add_frm").submit();
	});
	 $("#closeBtn").click(function(){
		 location.href="http://localhost/book_admin_prj/book_list.do"
	 });//click
	 $("#book_img").change(function(select_file){
		var check_img = $("#book_img").val();
		 var start_num = check_img.lastIndexOf('.')+1;
		 var end_num = check_img.length;
		 check_img = check_img.substring(start_num,end_num).toLowerCase();
		 if( !(check_img == 'jpg' || check_img == 'png' || check_img == 'jpeg' || check_img == 'gif') ){
			 alert("이미지형식의 파일만 업로드가능합니다.");
			 $("#book_img").val("");
			 return;
		 }
		 
		 var file = select_file.target.files[0];
		 var reader = new FileReader();
		 reader.readAsDataURL(file);
		 reader.onload = function(){
			 $("#preview").prop('src', reader.result);
		 }
	 });//change
	 
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
     
      <form action="http://localhost/book_admin_prj/insert_book.do" method="POST" id="add_frm" name="add_frm"  enctype="multipart/form-data">
       <div><h2>도서 추가</h2></div><br/><br/>
       
          <div><h3>&nbsp;도서 정보</h3></div>
          <div class="checkBoxGrop">
            <input type="checkbox" name="book_best" id="book_best">베스트셀러
            <input type="checkbox" name="book_activity" id="book_activity">활성화 여부
           </div>
           
        
          <div class="bookImgDiv">
              <div class="bookImg">
                   <img src="../common/images/ex_book.png" id="preview"><br/>
              </div>
              <div>
                <input type="file" id="book_img" name="book_img" value = "이미지 선택">
              </div>
         </div>
         
         <div class="bookData">
           <table class="bookDataTab">
              <tr>
                 <th class="colTh">isbn</th><td><input type="text" name="book_isbn" id="book_isbn"></td>
                 <th class="colTh">도서명</th><td><input type="text" name="book_name" id="book_name"></td>
              </tr>
              <tr>
                 <th class="colTh">도서분류</th>
                      <td><select name="book_country" id="book_country">
                           <option value="국내도서">국내도서</option>
                           <option value="외국도서">외국도서</option>
                          </select> 
                      </td>
                 <th class="colTh">세부분류</th>
                          <td><select name="book_type_no" id="book_type_no">
                          <option value="0">과학</option>
                          <option value="1">아동</option>
                          <option value="2">소설</option>
                          <option value="3">여행</option>
                          <option value="4">요리</option>
                          <option value="5">심리</option>
                        </select>
                      </td>
              </tr>
              <tr>
                 <th class="colTh">저자명</th><td><input type="text" name="book_writer" id="book_writer"></td>
                 <th class="colTh">출판사</th><td><input type="text" name="book_company" id="book_company"></td>
                 
              </tr>
              <tr>
                 <th class="colTh">판매가</th><td><input type="text" name="book_price" id="book_price"></td>
                 <th class="colTh">출판일</th><td><input type="text" name="book_date" id="book_date"></td>
              </tr>
              <tr>
                 <th class="colTh">재고량</th><td><input type="text" name="book_stock" id="book_stock"></td>
                 
              </tr>
           </table>
           </div> 
       
           
           <div class="bookInfoDiv">
            <div id="bookIntroDiv"><h3>도서소개</h3></div>
                
                 <textarea  name="book_info" id="book_info" ></textarea> 
              <div id="buttonGrop" >
                <input type="submit" value="추가"   id="addBookBtn" name="addBookBtn"/>
			    <input type="button" value="취소"   id="closeBtn" name="closeBtn"/>
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