package kr.co.sist.admin.book.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.sist.admin.book.domain.BookDetailDomain;
import kr.co.sist.admin.book.domain.BookListDomain;
import kr.co.sist.admin.book.vo.BookModifyVO;
import kr.co.sist.admin.book.vo.BookRangeVO;
import kr.co.sist.admin.book.vo.SelectDataVO;

public class AdminBookDAO {
	private static AdminBookDAO abDAO;
	private AdminBookDAO() {
	}
	
	/**
	 * 싱글턴을 위한 Method
	 * @return
	 */
	public static AdminBookDAO getInstance() {
		if( abDAO == null) {
			abDAO = new AdminBookDAO();
		}//end if
		return abDAO;
	}
	
	/**
	 * 도서의 전체 갯수를 반환하는 일
	 * @param sdVO
	 * @return
	 */
	public int selectBookCnt(SelectDataVO sdVO) {
		int cnt = 0;
		
		return cnt;
	}
	
	/**
	 * 조회된 도서 리스트 정보를 반환하는 일
	 * @param brVO
	 * @param sdVO
	 * @return
	 */
	public List<BookListDomain> selectBookList(BookRangeVO brVO, SelectDataVO sdVO){
		List<BookListDomain> list = new ArrayList<BookListDomain>();
		
		return list;
	}
	
	/**
	 * 도서를 추가하는 일
	 * @param bmVO
	 */
	public void insertBook(BookModifyVO bmVO) {
		
	}
	
	/**
	 * 도서 정보를 변경하는 일
	 * @param bmVO
	 * @return
	 */
	public int updateBook(BookModifyVO bmVO) {
		int cnt = 0;
		
		return cnt;
	}
	
	/**
	 * 도서의 isbn을 받아 해당 도서의 상세정보를 얻는 일
	 * @param book_isbn
	 * @return
	 */
	public BookDetailDomain selectBookDetail(String book_isbn) {
		BookDetailDomain bdd = null;
		
		return bdd;
	}
	
}
