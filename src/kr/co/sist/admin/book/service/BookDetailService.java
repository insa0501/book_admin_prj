package kr.co.sist.admin.book.service;

import kr.co.sist.admin.book.dao.AdminBookDAO;
import kr.co.sist.admin.book.domain.BookDetailDomain;
import kr.co.sist.admin.book.vo.BookModifyVO;

public class BookDetailService {
	/**
	 * 도서를 추가하는 일
	 * @param bmVO
	 */
	public int  addBook(BookModifyVO bmVO) {
		AdminBookDAO abDAO = AdminBookDAO.getInstance();
		return abDAO.insertBook(bmVO);
	}
	
	/**
	 * 도서 정보를 변경하는 일
	 * @param bmVO
	 * @return
	 */
	public int changeBook(BookModifyVO bmVO) {
		int result = 0;
		AdminBookDAO abDAO = AdminBookDAO.getInstance();
		result = abDAO.updateBook(bmVO);
		return result;
	}
	
	/**
	 * 해당 도서의 상세정보를 얻는 일
	 * @param book_isbn
	 * @return
	 */
	public BookDetailDomain selectBookDetail(String book_isbn) {
		BookDetailDomain bdd = null;
		AdminBookDAO abDAO = AdminBookDAO.getInstance();
		bdd = abDAO.selectBookDetail(book_isbn);
		return bdd;
	}
}
