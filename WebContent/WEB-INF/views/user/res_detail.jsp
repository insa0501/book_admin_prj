<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>탈퇴회원상세정보</title>
    <link rel="icon" type="image/png" href="../images/icons/favicon.ico" />
    <!--Bootstrap-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous" ></script>
    <!--CSS-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link rel="stylesheet" href="common/css/reset.css" />
    <link rel="stylesheet" href="common/css/admin_mgr_user_detail.css" />
    <link rel="stylesheet" href="common/css/common_header_footer.css" />
    <!--JS-->
    <script src="common/js/res.js"></script>
    
    <script type="text/javascript">
    $(function(){
    	$("#accept").click(function(){
    		location.href="http://localhost/book_admin_prj/user_list.do";
    	});
    });
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
    <!-- '회원'상태의 회원상세 페이지에서 탈퇴가 눌릴 경우 btn_group의 class 에 hidden이 추가 되어야함 -->
    <!-- 탈퇴처리 JavaScript는 res.js에서 -->
    <section class="main_section">
      <div class="main_title">회원상세정보</div>

      <div class="res_user_content">
        <table>
          <tr>
            <td class="column">아이디</td>
            <td class="content"><c:out value="${user_detail.user_id }"/></td>
            <td class="column">상태</td>
            <td class="content"><c:out value="${user_detail.user_status }"/></td>
          </tr>
          <tr> 
            <td class="column">탈퇴일</td>
            <td class="content"><c:out value="${user_detail.user_resign_date }"/></td>
            <td class="column">탈퇴ip</td>
            <td class="content"><c:out value="${user_detail.user_ip }"/></td>
          </tr>
          <tr>
            <td class="column">탈퇴사유</td>
            <td class="content" colspan="3">
            <c:set var="res_num" value="●"/>
            <c:forEach var="rs" items="${res_list }">
            	<c:out value="${res_num }"/><c:out value="${rs }"/>
            </c:forEach>
            </td>
          </tr>
        </table>
        <div class="btn_group">
          <!-- 탈퇴한 회원정보는 수정할 수 없음 -->
          <!-- <button type="button" class="btn btn-dark" id="edit">수정</button> -->
          <button type="button" class="btn btn-dark" id="accept">확인</button>
        </div>
      </div>
    </section>
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
