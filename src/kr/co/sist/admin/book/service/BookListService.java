package kr.co.sist.admin.book.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.sist.admin.book.domain.BookListDomain;
import kr.co.sist.admin.book.vo.PageNationVO;
import kr.co.sist.admin.book.vo.SelectBookListVO;

public class BookListService {
	/**
	 * 도서 리스트를 얻는 일 
	 * @param brVO
	 * @param sdVO
	 * @return
	 */
	public List<BookListDomain> selectBookList(SelectBookListVO sblVO) {
		List<BookListDomain> list = new ArrayList<BookListDomain>();
		return list;
	}//selectBookList
	
	/**
	 * 하단의 페이지를 나누는 일
	 * @param pnd
	 * @return
	 */
	public String pageNation(PageNationVO pnv) {
		String pageNation = "";
		return pageNation;
	}//pageNation
	
	/**
	 * 도서의 전체 갯수
	 * @return
	 */
	public int totalCount() {
		int totalCount = 0;
		
		return totalCount;
	}//totalCount
	
	/**
	 * 보여줄 도서의 갯수
	 * @return
	 */
	public int pageScale() {
		int pageScale = 10;
		return pageScale;
	}
	
	/**
	 * 보여줄 갯수
	 * @param totalCount
	 * @param pageScale
	 * @return
	 */
	public int totalPage(int totalCount, int pageScale) {
		int totalPage=(int)Math.ceil((double)totalCount/pageScale);
		
		return totalPage;
	}
	
	/**
	 * 한페이지에 보여줄 시작 번호
	 * @param currentPage
	 * @param pageScale
	 * @return
	 */
	public int startNum(int currentPage, int pageScale) {
		int startNum= currentPage*pageScale-pageScale+1;
		return startNum;
	}
	
	/**
	 * 한페이지에 보여줄 마지막 번호
	 * @param startNum
	 * @param pageScale
	 * @return
	 */
	public int endNum(int startNum, int pageScale) {
		int endNum = startNum+pageScale-1;
		return endNum;
	}
}
