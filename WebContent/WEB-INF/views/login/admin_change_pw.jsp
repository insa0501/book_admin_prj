<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 비번 변경</title>

    <!-- bootstrap etc -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <!-- css -->
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/reset.css">
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/common_header_footer.css">
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/admin_change_pw.css">
    <link rel = "stylesheet" type="text/css" href="http://localhost/book_admin_prj/common/css/admin_link.css">
	<style type="text/css">
	 #pwBtn:hover{cursor: pointer;}
	</style>
    <!-- JS -->
    <script src="http://localhost/book_admin_prj/common/js/scroll.js"></script>
    
    <script type="text/javascript">
    $(function(){
    	$("#pwBtn").click(function(){
    		var pass1 = $("#pass1").val();
    		var pass2 = $("#pass2").val();
    		/* if(pass1.length<5){
    			alert("비밀번호는 5글자 이상입니다.");
    			return;
    		} */
    		if(pass1.search(/\s/) != -1){
    			alert("비밀번호는 공백 없이 입력해주세요.");
    			return;
    		}
    		
    		if(pass1 != pass2){
    			alert("비밀번호가 일치하지 않습니다.");
    			return;
    		}
    		if(!confirm("정말로 비밀번호를 변경하시겠습니까?")){
    			return;
    		}
    		$.ajax({
    			url:"http://localhost/book_admin_prj/change_admin_pass.do",
    			type:"POST",
    			dataType:"TEXT",
    			data:{admin_id : $("#admin_id").val(), admin_pass : $("#pass1").val() },
    			error : function( xhr ){
    				alert("에러");
    				console.log(xhr.status+" / "+xhr.statusText);
    			},
    			success : function( text ){
    				alert("비밀번호가 변경되었습니다.");
    				alert("재로그인이 필요합니다.");
    				location.replace("http://localhost/book_admin_prj/admin_logout.do");
    			}//success
    		});//ajax
    		
    	});//click
    });//ready
    
    window.onload=function(){
    	$(".nav_user_icons").html('<span><a href="http://localhost/book_admin_prj/admin_logout.do"><i class="fas fa-sign-in-alt"></i></a></span>');
    }
    </script>
</head>

<body>

	<!-- header -->
	<jsp:include page="../../../common/jsp/menu.jsp"/>
  	<!-- header end -->


    <!-- main section -->
    <section class="section_main">
        <div class="login_wrap">
            <div class="login_title">관리자 비밀번호 변경</div>
            <div class="login_input">
                <form action="http://localhost/book_admin_prj/change_admin_pass.do" method="POST" name="frm" id="frm" >
                    <input type="password" id="pass1" name="admin_pass" class="input_new_pw" placeholder="새 비밀번호">
                    <input type="button" id="pwBtn" class="find_btn" value="비밀번호 변경">
                    <input type="password" id="pass2" class="input_new_pw2" placeholder="다시 입력해주세요">
                    <input type="hidden" name="admin_id" id="admin_id" value="${requestScope.admin_id }"/>
                </form>
            </div>
        </div>
    </section> <!-- main end -->

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