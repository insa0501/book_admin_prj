package kr.co.sist.admin.book.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.sist.admin.book.domain.BookDetailDomain;
import kr.co.sist.admin.book.domain.BookListDomain;
import kr.co.sist.admin.book.vo.BookModifyVO;
import kr.co.sist.admin.book.vo.SelectBookListVO;

public class AdminBookDAO {
	private static AdminBookDAO abDAO;
	private AdminBookDAO() {
	}
	
	/**
	 * 싱글턴을 객체를 위한 method
	 * @return
	 */
	public static AdminBookDAO getInstance() {
		if( abDAO == null) {
			abDAO = new AdminBookDAO();
		}//end if
		return abDAO;
	}
	
	/**
	 * 검색데이터와 현재페이지, 범위를 받아 보여줄 도서의 갯수를 받아오는 일
	 * @param sdVO
	 * @return
	 */
	public int selectBookCnt(SelectBookListVO sblVO) {
		int cnt = 0;
		
		return cnt;
	}
	
	/**
	 * 검색데이터와 현재페이지, 범위를 받아 보여주는 도서를 받아오는 일
	 * @param brVO
	 * @param sdVO
	 * @return
	 */
	public List<BookListDomain> selectBookList(SelectBookListVO sblVO){
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
	 * 도서의 isbn을 받아 해당 도서의 상세정보를 보여주는 일
	 * @param book_isbn
	 * @return
	 */
	public BookDetailDomain selectBookDetail(String book_isbn) {
		BookDetailDomain bdd = null;
		
		return bdd;
	}
	
}
