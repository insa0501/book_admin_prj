package kr.co.sist.admin.book.service;

import kr.co.sist.admin.book.dao.AdminBookDAO;
import kr.co.sist.admin.book.domain.BookDetailDomain;
import kr.co.sist.admin.book.vo.BookModifyVO;

public class BookDetailService {
	/**
	 * Method : 도서를 추가하는 일
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * @param bmVO
	 */
	public int  addBook(BookModifyVO bmVO) {
		AdminBookDAO abDAO = AdminBookDAO.getInstance();
		return abDAO.insertBook(bmVO);
	}
	
	/**
	 * Method : 도서 정보를 변경하는 일
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
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
	 * Method : 해당 도서의 상세정보를 얻는 일
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
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
