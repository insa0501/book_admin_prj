package kr.co.sist.admin.book.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.sist.admin.book.dao.AdminBookDAO;
import kr.co.sist.admin.book.domain.BookListDomain;
import kr.co.sist.admin.book.vo.PageNationVO;
import kr.co.sist.admin.book.vo.SelectBookListVO;

public class BookListService {
	/**
	 * Method : 도서 리스트를 얻는 일
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08 
	 * @param brVO
	 * @param sdVO
	 * @return
	 */
	public List<BookListDomain> selectBookList(SelectBookListVO sblVO) {
		List<BookListDomain> list = new ArrayList<BookListDomain>();
		list = AdminBookDAO.getInstance().selectBookList(sblVO);
		return list;
	}//selectBookList
	
	/**
	 * 하단의 페이지를 나누는 일
	 * @param pnd
	 * @return
	 */
	public String pageNation(PageNationVO pnVO) {
		String pageNation=""; //페이지 이동을 위한 폼의 형태를 저장할 변수 ex. [<<]...[1][2]...[>]와 같은 형태 띄우기

		int pageNumber=0; //페이지 이동을 위한 폼에 한번에 표시될 번호의 개수
		int startPage=0; //페이지 이동을 위한 폼의 표시될 시작 번호
		int endPage=0; //페이지 이동을 위한 폼의 표시될 마지막 번호 
		int curPage=0; //페이지 폼의 링크를 눌렀을 때의 이동과 폼에 표시될 페이지번호를 저장할 변수

		pageNumber = 5; //페이지 이동을 위한 폼에 한번에 10개의 번호를 표시.

		startPage = ((pnVO.getCurrentPage() - 1) / pageNumber) * pageNumber + 1;
		endPage = (((startPage - 1) + pageNumber) / pageNumber) * pageNumber;

		if (pnVO.getTotalPage() <= endPage){	//총페이지가 페이지 이동을 위한 폼의 표시될 마지막 번호보다 작다면
			endPage = pnVO.getTotalPage();	//마지막 번호는 총페이지 번호로 변경
		}//end if

		if ( pnVO.getCurrentPage() > pageNumber) {	//현재페이지가 폼에 표시된 번호보다 크다면
			curPage = startPage - 1; 		//[<<]눌렀을 때 이동할 페이지 번호를 변수에 담고
			pageNation = pageNation +"<li class='page-item'>"
					+ "<a href='?"+pnVO.getUrl()+"&currentPage="+curPage+"' class='page-link' href='#' tabindex='-1'>Previous</a>"
					+"</li>";		//[<<]를 a태그에 담아서 페이지이동 폼을 표현할 변수에 저장
		}else{	//현재페이지가 폼에 표시된 번호보다 크지 않다면
			pageNation = pageNation + "<li class='page-item disabled'><a class='page-link' href='#' tabindex='-1'>Previous</a></li>";		//[<<]만 담아서 페이지이동 폼을 표현할 변수에 저장
		}//end else 

		curPage = startPage;	//폼의 시작번호를 페이지 이동용 임시 변수에 저장
		while (curPage <= endPage){		//페이지 이동용 임시 변수가 폼의 마지막 번호보다 작거나 같다면
			if (curPage == pnVO.getCurrentPage()) {	//페이지 이동용 임시 변수가 현재 페이지와 같은 경우
				pageNation = pageNation + "<li class='page-item'><a class='page-link disabled' style='color:#6c757d; font-weight:bold;'>"+pnVO.getCurrentPage()+"</a></li>";	//폼 형태를 담은 변수에 [현재번호]를 추가
			} else {	//페이지 이동용 임시 변수가 현재 페이지와 다른 경우
				pageNation = pageNation +"<li class='page-item'><a  class='page-link' href='?"+pnVO.getUrl()+"&currentPage="+curPage+"'>"+curPage+"</a></li>";		//[번호]를 a태그에 담아서 폼 형태를 담은 변수에 추가
			}//end else 
				
			curPage++;	//페이지 이동용 임시 변수를 증가시켜서 페이지이동 폼의 번호가 for문처럼 만들어지게 한다.
		}//end while
			

		if ( pnVO.getTotalPage() > endPage) {	//폼의 마지막 번호가 총페이지보다  작다면
			curPage = endPage + 1;		//[>>]눌렀을 때 이동할 페이지 번호를 변수에 담고
			pageNation = pageNation + "<li class='page-item'>"
					+"<a href='?"+pnVO.getUrl()+"&currentPage="+curPage+"' class='page-link' href='#' tabindex='-1'>Next</a></li>";		//[>>]를 a태그에 담아서 폼 형태를 담은 변수에 추가
		}else{	//폼의 마지막 번호가 총페이지보다  작지 않다면
			pageNation = pageNation + "<li class='page-item disabled'><a class='page-link' href='#' tabindex='-1'>Next</a></li>";		//[>>]만 담아서 페이지이동 폼을 표현할 변수에 저장
		}//end else 
			
		return pageNation;	//페이지 이동폼을 담은 변수를 반환
	}//pageNation
	
	/**
	 * Method : 도서의 전체 갯수
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * @return
	 */
	public int totalCount(SelectBookListVO sblVO) {
		int totalCount = 0;
		AdminBookDAO abDAO = AdminBookDAO.getInstance();
		totalCount = abDAO.selectBookCnt(sblVO);
		return totalCount;
	}//totalCount
	
	/**
	 * Method : 보여줄 도서의 갯수
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * @return
	 */
	public int pageScale() {
		int pageScale = 10;
		return pageScale;
	}
	
	/**
	 * Method : 보여줄 갯수
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * @param totalCount
	 * @param pageScale
	 * @return
	 */
	public int totalPage(int totalCount, int pageScale) {
		int totalPage=(int)Math.ceil((double)totalCount/pageScale);
		
		return totalPage;
	}
	
	/**
	 * Method : 한페이지에 보여줄 시작 번호
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * @param currentPage
	 * @param pageScale
	 * @return
	 */
	public int startNum(int currentPage, int pageScale) {
		int startNum= currentPage*pageScale-pageScale+1;
		return startNum;
	}
	
	/**
	 * Method : 한페이지에 보여줄 마지막 번호
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * @param startNum
	 * @param pageScale
	 * @return
	 */
	public int endNum(int startNum, int pageScale) {
		int endNum = startNum+pageScale-1;
		return endNum;
	}
}
