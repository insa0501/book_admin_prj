package kr.co.sist.admin.book.service;

import kr.co.sist.admin.book.domain.BookDetailDomain;
import kr.co.sist.admin.book.vo.BookModifyVO;

public class BookDetailService {
	/**
	 * 도서를 추가하는 일
	 * @param bmVO
	 */
	public void addBook(BookModifyVO bmVO) {
		
	}
	
	/**
	 * 도서정보를 변경하는 일
	 * @param bmVO
	 * @return
	 */
	public int changeBook(BookModifyVO bmVO) {
		int result = 0;
		return result;
	}
	
	/**
	 * 도서의 isbn을 받고 해당 도서의 상세정보를 보여주는 일
	 * @param book_isbn
	 * @return
	 */
	public BookDetailDomain selectBookDetail(String book_isbn) {
		BookDetailDomain bdd = null;
		
		return bdd;
	}
}
