<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
${user_changeFlag eq 1 ? 'alert("유저 정보가 변경되었습니다.");window.location.replace("user_list.do");' : '' }
${user_deleteFlag eq 1 ? 'alert("탈퇴가 완료되었습니다.");window.location.replace("user_list.do");' : '' }

${book_insertFlag eq 1 ? 'alert("도서가 추가되었습니다.");window.location.replace("book_list.do");' : '' }
${book_updateFlag eq 1 ? 'alert("도서가 변경되었습니다.");window.location.replace("book_list.do");' : '' }
${book_updateFlag eq 1 ? 'alert("도서가 변경되었습니다.");window.location.replace("book_list.do");' : '' }

</script>


