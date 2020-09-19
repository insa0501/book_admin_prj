<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script type="text/javascript">

	$(function() {
		
	});//ready

</script>
</head>
<body>

<label>주문관리</label><br/>
<select>
	<option value="none">전체보기</option>
	<option>주문번호</option>
	<option>주문자id</option>
	<option>책 제목</option>
	<option>배달현황</option>
</select>
<input type="text" placeholder="검색어를 입력하세요"/>
<input type="button" value="검색"/>
<table>
	<tr>
		<th style="text-align: center">주문번호</th>
        <th style="text-align: center">주문id</th>
        <th style="text-align: center">책제목</th>
        <th style="text-align: center">가격</th>
        <th style="text-align: center">배달현황</th>
        <th style="text-align: center">주문일자</th>
    </tr>
</table>

</body>
</html>