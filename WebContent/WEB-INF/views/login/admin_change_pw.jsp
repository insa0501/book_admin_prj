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
    <link rel="stylesheet" href="http://localhost/common/css/reset.css">
    <link rel="stylesheet" href="http://localhost/common/css/common_header_footer.css">
    <link rel="stylesheet" href="http://localhost/common/css/admin_change_pw.css">

    <!-- JS -->
    <script src="http://localhost/common/js/scroll.js"></script>
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
            <div class="login_title">관리자 비밀번호 변경</div>
            <div class="login_input">
                <form action="#void">
                    <input type="text" class="input_new_pw" placeholder="새 비밀번호">
                    <input type="button" class="find_btn" value="비밀번호 변경">
                    <input type="text" class="input_new_pw2" placeholder="다시 입력해주세요">
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