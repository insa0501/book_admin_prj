package kr.co.sist.admin.book.service;

import kr.co.sist.admin.book.domain.BookDetailDomain;
import kr.co.sist.admin.book.vo.BookModifyVO;

public class BookDetailService {
	/**
	 * ������ �߰��ϴ� ��
	 * @param bmVO
	 */
	public void addBook(BookModifyVO bmVO) {
		
	}
	
	/**
	 * ���� ������ �����ϴ� ��
	 * @param bmVO
	 * @return
	 */
	public int changeBook(BookModifyVO bmVO) {
		int result = 0;
		return result;
	}
	
	/**
	 * �ش� ������ �������� ��� ��
	 * @param book_isbn
	 * @return
	 */
	public BookDetailDomain selectBookDetail(String book_isbn) {
		BookDetailDomain bdd = null;
		
		return bdd;
	}
}
