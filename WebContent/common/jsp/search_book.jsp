<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://211.238.142.34/jsp_prj/common/css/main.css">
<title>Insert title here</title>
<style type="text/css">
	/*검색*/
.wrap_search{position:absolute;left:272px;top:71px}
.top_search{width:454px;height:44px;background:#4a57a8; }
.inner_search{float:left;width:404px;background:#fff;margin:5px 0 0 5px}
.in_keyword{background:transparent;width:386px;height:34px;padding:0 9px;border:none;outline:none;color:#333;font-size:14px;font-weight:bold}
.bnt_search{float:left;width:45px;height:44px;background-position:0 0; border: none;}
.sp_main{background-image:url(https://nstatic.dcinside.com/dc/w/images/sp/sp_main.png);background-repeat:no-repeat}
button{cursor:pointer}
.page_nation{display: block; font-size: 0px; text-align: center;}
.page_num{display: inline-block; width:20px; height: 25px;font-size: 16px;
		 background-color: #d9d9d9; font-weight: bold; color:#333; border:1px solid #333; }
.page_num:hover{cursor: pointer;}
#tbody tr:hover{ cursor:pointer; font-weight: bold; font-size: 18px;}

</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>


<script type="text/javascript">
$(function(){
	$("#book_name").keydown(function(key){
		if(key.which == 13 ){
			page_num = 1;
			searchBook();
			return;
		}//end if
	});//keydown
	
});//ready
	var page_num = 1;
	function chkSearch(){
		page_num = 1;
		searchBook();
	}//chkSearch
	
	//검색된 결과의 값들을 저장할 변수들
	var book_authors = new Array();//저자
	var book_contents = new Array();//내용
	var book_isbn = new Array();//isbn
	var book_price = new Array();//가격
	var book_publisher = new Array();//출판사
	var book_title = new Array();//제목
	var book_datetime = new Array();//출판일
	var book_thumbnail = new Array();//이미지링크
	
	function searchBook(){
		$.ajax({
			url: "https://dapi.kakao.com/v3/search/book",
			headers: {'Authorization': 'KakaoAK '+ '92628fe8d4f123715e82c662089eadf4'},
			type : "get",
			data:{ 
				query: $("#book_name").val(),
				size: 5,
				page: page_num
			},
			error : function(xhr){
				alert("검색중 오류가 발생하였습니다.\n잠시후 다시시도 해주세요.");
			},
			success:function(book_json){
				if( book_json.documents.length ==0){
					var result = "<tr><td scope='row' colspan='4'>해당 도서가 존재하지 않습니다.</td></tr>";
					$("#tbody").html(result);
					return;
				}
				
				
				console.log(book_json);
				
				
				var result = "";
				$.each(book_json.documents, function(idx, book){
					//검색된 도서를 innerHTML으로 출력하기 위한 설정
					result += "<tr onclick='moveValue("+idx+")'><td><img src='"+book.thumbnail+"' style='width:100px; height:120px;'/></td>"
					result += "<td>"+book.authors+"</td>";
					result += "<td>"+book.title+"</td>";
					result += "<td>"+book.publisher+"</td><tr/>";
					//선택시 부모페이지에 넘겨줄 값
					book_authors[idx] = book.authors;//저자
					book_contents[idx] = book.contents;//내용
					book_isbn[idx] = book.isbn;//isbn
					book_price[idx] = book.price;//가격
					book_publisher[idx] = book.publisher;//출판사
					book_title[idx] = book.title;//제목
					book_datetime[idx] = book.datetime;//출판일
					book_thumbnail[idx] = book.thumbnail;//이미지 링크
				});//each
				//검색된 내용을 화면에 출력
				$("#tbody").html(result);
				
				//검색결과 페이지
				var total_page = Math.ceil(book_json.meta.pageable_count/5);
				
				//첫 페이지일 경우 3번쨰 페이지까지 보여진다.
				if( page_num == 1 ){
					result = '<li class="page_num" id="page_num1" onclick="pageLocation('+1+')">1</li>';
					if(total_page > 1){
							result+='<li class="page_num" id="page_num2" onclick="pageLocation('+2+')">2</li>';
					}
					$(".page_nation").html(result);
				}
				if( page_num > 1 && page_num < total_page && total_page > 1){//2페이지부터는 이전페이지,현재페이지,다음페이지가 보여진다.
					result = '<li class="page_num" id="page_num1" onclick="pageLocation('+(page_num-1)+')">'+(page_num-1)+'</li>'
						+'<li class="page_num" id="page_num2" onclick="pageLocation('+page_num+')">'+page_num+'</li>'
						+'<li class="page_num" id="page_num3" onclick="pageLocation('+(page_num+1)+')">'+(page_num+1)+'</li>';
				$(".page_nation").html(result);
				}
				if( page_num > 1 && page_num==total_page && total_page>1){//마지막 페이지
					result = '<li class="page_num" id="page_num1" onclick="pageLocation('+(page_num-1)+')">'+(page_num-1)+'</li>'
					+'<li class="page_num" id="page_num2" onclick="pageLocation('+page_num+')">'+page_num+'</li>';
					$(".page_nation").html(result);
				}
				
				$('html').animate({scrollTop : $("#top").offset().top},100);
				window.resizeTo(487, 520);
				
			}
		});//ajax
	}//click
	
	function pageLocation(clicked_page){
		page_num = clicked_page;
		searchBook();
	}//pageLocation
	
	function moveValue(idx){
		$("#book_name", opener.document).val(book_title[idx]);//책이름
		$("#book_writer", opener.document).val(book_authors[idx]);//저자
		$("#book_price", opener.document).val(book_price[idx]);//가격
		$("#book_company", opener.document).val(book_publisher[idx]);//출판사
		var isbn = "";
		if(book_isbn[idx].length >20){
			isbn = book_isbn[idx].substring(11);
			isbn = isbn.slice(0,4)+'-'+isbn.slice(4,8)+'-'+isbn.slice(8,12)+'-'+isbn.slice(12);
		}
		$("#book_date", opener.document).val(book_datetime[idx].substring(0,10));//출판일
		$("#book_isbn", opener.document).val(isbn);//isbn
		$("#img_link", opener.document).val(book_thumbnail[idx]);//책 이미지
		$("#book_info", opener.document).val(book_contents[idx]);//책 내용
		opener.location.href="javascript:searchBookImg()";
		self.close();
	}

</script>
</head>
<body>
<div  class="top_search clear" id="top" style="position:relative;">
  <div class="inner_search">
    <input class="in_keyword" type="text" name="search" id="book_name" title="검색어 입력" value="" placeholder="도서검색" accesskey="f" type="search" autocomplete="off">
  </div>
  <button class="sp_main bnt_search" id="search_book" onclick="chkSearch()" style="position:absolute; "></button>
</div>
<table class="table table-hover" style="width:454px;">
  <thead class="thead-dark">
    <tr style="width:454px;">
      <th scope="col" style="width:124px;">#</th>
      <th scope="col" style="width:77px;">저자</th>
      <th scope="col" style="width:166px;">도서명</th>
      <th scope="col" style="width:87px;">출판사</th>
    </tr>
  </thead>
  <tbody id="tbody">
    <tr>
    	<th scope="col" colspan="4">도서명을 검색해주세요.</th>
    </tr>
  </tbody>
</table>
<div>
<ul class="page_nation">
	
</ul>
</div>

</body>
</html>