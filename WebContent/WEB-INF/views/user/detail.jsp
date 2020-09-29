<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원상세정보</title>
    <link rel="icon" type="image/png" href="../images/icons/favicon.ico" />
    <!-- 다음 api 우편번호 검색 -->
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
    	var checkFlag = false;
    	
    	$("#accept").click(function(){
    		location.href="http://localhost/book_admin_prj/user_list.do";
    	});//click
    	$("#res_fin").click(function(){
    		if(confirm("정말로 탈퇴하시겠습니까?")){
    			if($("#res_data").val() == "" ){
    				alert("탈퇴사유를 입력해주세요.");
    				return;
    			}
    			$("#delete_frm").submit();
    		}//end if
    	});//click
    	$("#edit").click(function(){
    		if( !confirm("정말로 변경하시겠습니까?")){
    			return;
    		}//end if
    		checkNull();
    		if( !checkFlag ){
    			return;
    		}
   			$("#update_frm").submit();
    		
    	});//click
    	
    	$("#searchZip").click(function(){
        	searchZipcode();
        });//click
    	
    function checkNull(){
    	if($("#user_name").val() == "" ){
    		alert("이름을 입력해주세요.");
    		return;
    	}
    	/* 
    	var regExp =/(01[016789])([1-9]{1}[0-9]{2,3})([0-9]{4})$/;
    	var regexMdn = /^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/;
    	var regex= /^\d{2,3}-\d{3,4}-\d{4}$/; 
    	if( !regex.test($("#user_phone").val()) ){
    		alert("전화번호를 확인해주세요.<br/>입력방식은 010-xxxx-xxxx");
    		return;
    	}
    	*/
    	phone = $("#user_phone").val()
    	if( phone.replace(/[0-9]/g,"") != ""){
    		alert("휴대폰은 숫자만 입력할 수 있습니다.");
    		return;
    	}
    	if( phone.length != 11){
    		alert("휴대폰 번호를 확인해주세요.");
    		return;
    	}
    	if($("#zipcode").val() == "" ){
    		alert("우편번호를 입력해주세요.");
    		return;
    	}
    	if($("#addr1").val() == "" ){
    		alert("주소를 입력해주세요.");
    		return;
    	}
    	checkFlag = true;
    	return;
    	
    }
    	
    
    
    });//ready
    
    function searchZipcode(){//다음 API를 사용한 우편번호 찾기
    	
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('zipcode').value = data.zonecode;
                document.getElementById("addr1").value = roadAddr;
              //  document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
            }
        }).open();
    }
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
      <div class="main_content">
      <form name="update_frm" id="update_frm" action="http://localhost/book_admin_prj/update_user.do" method="POST">
        <table>
          <tr>
            <td class="column">아이디</td>
            <td class="content"><c:out value="${user_detail.user_id }"/><input type="hidden" name="user_id" value="${user_detail.user_id }"/>
            </td>
            <td class="column">상태</td>
            <td class="content"><c:out value="${user_detail.user_status eq 'Y' ? '회원' : '탈퇴'  }"/></td>
          </tr>
          <tr>
            <td class="column">이름</td>
            <td class="content"><input type="text" class="name" name="user_name" id="user_name" value="${user_detail.user_name }" /></td>
            <td class="column">전화번호</td>
            <td class="content"><input type="text" class="phone" maxlength="11" name="user_phone" id="user_phone" value="${user_detail.user_phone }" /></td>
          </tr>
          <tr>
            <td class="column">ip</td>
            <td class="content" colspan="3"><c:out value="${user_detail.user_ip }"/></td>
          </tr>
          <tr>
            <td class="column">주소</td>
            <td class="content" colspan="3">
              <input type="text" class="addr" id="zipcode" readonly="readonly" name="user_zipcode" value="${user_detail.user_zipcode }" />
              <input type="button" value="우편번호검색" id="searchZip" /><br />
              <input type="text" class="addr" id="addr1" readonly="readonly" name="user_addr1" value="${user_detail.user_addr1 }" />
              <input type="text" class="addr" id="addr2" name="user_addr2" value="${user_detail.user_addr2 }" />
            </td>
          </tr>
        </table>
		<div class="btn_group" id="btn_group">
          <button type="button" class="btn btn-dark" id="edit">수정</button>
          <button type="button" class="btn btn-dark" id="res_str">탈퇴</button>
          <button type="button" class="btn btn-dark" id="accept">확인</button>
        </div>
		</form>
		
		<form name="delete_frm" id="delete_frm" action="http://localhost/book_admin_prj/delete_user.do" method="POST">
        <div class="res_content" id="res_content">
          <div class="res_title">탈퇴사유</div>
          <textarea class="res_data" name="user_resdata" id="res_data"></textarea>
          <input type="hidden" name="resign_id" value="${user_detail.user_id }" />
          <div class="res_btn_group">
            <button type="button" class="btn btn-dark" id="res_fin">
              탈퇴
            </button>
            <button type="button" class="btn btn-dark" id="cancel">취소</button>
          </div>
        </div>
        </form>
        
        
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
