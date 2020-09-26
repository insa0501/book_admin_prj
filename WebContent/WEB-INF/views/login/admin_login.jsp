<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<c:if test="${ sessionScope.admin_id ne null}">
    	<script type="text/javascript">
    		//location.replace("book_list.do");
    		location.replace("select_order_list.do");
    	</script>
    </c:if>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 로그인👍</title>

    <!-- bootstrap etc -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous">
    </script>
    <!-- css -->
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/reset.css">
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/common_header_footer.css">
    <link rel="stylesheet" href="http://localhost/book_admin_prj/common/css/admin_login.css">

    <!-- JS -->
    <script src="http://localhost/book_admin_prj/common/js/scroll.js"></script>
    <script type="text/javascript">
    	function loginCheck() { 
			if ($("#admin_id").val() == "") {
				alert("아이디를 입력해주세요");
				return;
			} // end if
			
			if ($("#admin_pass").val() == "") {
				alert("비밀번호를 입력해주세요");
				return;
			} // end if
				
				loginFrm.submit(); 
		}//loginCheck
		
    	$(function() {
    		$("#admin_pass").keydown(function() {
    			if (window.event.which == 13) {
    				loginCheck();
    			} // end if
    		}); // keydown
    		
    		$("#login_btn").click(function() {
    			loginCheck();
    		}); // click
    	});// ready
    	
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
  
    <!-- main section -->
    <section class="section_main">
        <div class="login_wrap">
            <div class="login_title">관리자 로그인</div>
            <div class="login_input">
                <form action="admin_login_process.do" method="post" name="loginFrm">
                    <input type="text" class="input_id" name="admin_id" id="admin_id" tabindex="1"/>
                    <input type="button" class="login_btn" name="login_btn" id="login_btn" value="관리자 로그인" style="cursor:pointer">
                    <input type="password" class="input_pass" name="admin_pass" id="admin_pass" tabindex="2" />
                    <span>
                        <input type="checkbox" id="remember_chk" class="remember_chk" value="remember">
                        <label for="remember_chk">아이디 기억</label>
                    </span>
                </form><%-- 로그인 실패 메시지 --%>
                <c:if test="${ login_flag eq 'fail'}">
	                <div style="margin-top:10px; color:red; text-align:center;">
	                   	아이디와 비밀번호를 확인해주세요.
	                </div>
              	</c:if>
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