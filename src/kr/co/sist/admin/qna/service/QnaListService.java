package kr.co.sist.admin.qna.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.sist.admin.qna.domain.QnaDetailDomain;
import kr.co.sist.admin.qna.domain.QnaListDomain;
import kr.co.sist.admin.qna.vo.PageNationVO;
import kr.co.sist.admin.qna.vo.QnaListRangeVO;
import kr.co.sist.admin.qna.vo.SelectDataVO;

public class QnaListService {

	/**
	 * 문의정보 리스트
	 * @param sdVO
	 * @param olrVO
	 * @return
	 */
	public List<QnaListDomain> searchQnaList(SelectDataVO sdVO, QnaListRangeVO olrVO) {
		List<QnaListDomain> list = new ArrayList<QnaListDomain>();
		
		return list;
	}//searchQnaList
	
	/**
	 * 문의상세정보
	 * @param qna_no
	 * @return
	 */
	public QnaDetailDomain searchQnaDetail(int qna_no) {
		QnaDetailDomain odDomain = null;
		
		return odDomain;
	}//searchQnaDetail
	
	/**
	 * 전체 원글의 수 : DB사용
	 * @return
	 */
	public int totalCount() {
		int totalCnt=0; 
		
		return totalCnt;
	}//totalCount
	
	/**
	 * 한 화면에 보여줄 게시물의 수. 10건
	 * @return
	 */
	public int pageScale() {
		int pageScale=10;
		
		return pageScale;
	}//pageScale
	
	/**
	 * 총 페이지수
	 * @param totalCount
	 * @param pageScale
	 * @return
	 */
	public int totalPage(int totalCount, int pageScale) {
		int totalPage=(int)Math.ceil((double)totalCount/pageScale);
		
		return totalPage;
	}//totalPage
	
	/**
	 * 시작번호.
	 * @return
	 */
	public int startNum(int currentPage, int pageScale) {
		int startNum= currentPage*pageScale-pageScale+1;
		
		return startNum;
	}//startNum
	
	/**
	 * 끝번호.
	 * @return
	 */
	public int endNum(int startNum, int pageScale) {
		int endNum = startNum+pageScale-1;
		
		return endNum;
	}//totalCount
	
	/**
	 * 글이 여러개 있을 때 이동하기 위한 인덱스리스트.
	 * @param pnVO
	 * @return
	 */
	public String pageNation(PageNationVO pnVO) {
		String indexList=""; //페이지 이동을 위한 폼의 형태를 저장할 변수 ex. [<<]...[1][2]...[>]와 같은 형태 띄우기

		int pageNumber=0; //페이지 이동을 위한 폼에 한번에 표시될 번호의 개수
		int startPage=0; //페이지 이동을 위한 폼의 표시될 시작 번호
		int endPage=0; //페이지 이동을 위한 폼의 표시될 마지막 번호 
		int curPage=0; //페이지 폼의 링크를 눌렀을 때의 이동과 폼에 표시될 페이지번호를 저장할 변수

		pageNumber = 10; //페이지 이동을 위한 폼에 한번에 10개의 번호를 표시.

		startPage = ((pnVO.getCurrentPage() - 1) / pageNumber) * pageNumber + 1;
		endPage = (((startPage - 1) + pageNumber) / pageNumber) * pageNumber;

		if (pnVO.getTotalPage() <= endPage){	//총페이지가 페이지 이동을 위한 폼의 표시될 마지막 번호보다 작다면
			endPage = pnVO.getTotalPage();	//마지막 번호는 총페이지 번호로 변경
		}//end if

		if ( pnVO.getCurrentPage() > pageNumber) {	//현재페이지가 폼에 표시된 번호보다 크다면
			curPage = startPage - 1; 		//[<<]눌렀을 때 이동할 페이지 번호를 변수에 담고
			indexList = indexList + "<a href='"+pnVO.getUrl()+"?pnVO.getCurrentPage()="+curPage+"'>[<<]</a>";		//[<<]를 a태그에 담아서 페이지이동 폼을 표현할 변수에 저장
		}else{	//현재페이지가 폼에 표시된 번호보다 크지 않다면
			indexList = indexList + "[<<]";		//[<<]만 담아서 페이지이동 폼을 표현할 변수에 저장
		}//end else 
		indexList = indexList + " ... ";	//폼 형태를 담은 변수에 ' ... '을 추가

		curPage = startPage;	//폼의 시작번호를 페이지 이동용 임시 변수에 저장
		while (curPage <= endPage){		//페이지 이동용 임시 변수가 폼의 마지막 번호보다 작거나 같다면
			if (curPage == pnVO.getCurrentPage()) {	//페이지 이동용 임시 변수가 현재 페이지와 같은 경우
				indexList = indexList + "["+pnVO.getCurrentPage()+"]";	//폼 형태를 담은 변수에 [현재번호]를 추가
			} else {	//페이지 이동용 임시 변수가 현재 페이지와 다른 경우
				indexList = indexList +"<a href='"+pnVO.getUrl()+"?pnVO.getCurrentPage()="+curPage+"'>["+curPage+"]</a>";		//[번호]를 a태그에 담아서 폼 형태를 담은 변수에 추가
			}//end else 
				
			curPage++;	//페이지 이동용 임시 변수를 증가시켜서 페이지이동 폼의 번호가 for문처럼 만들어지게 한다.
		}//end while
			
		indexList = indexList + " ... ";	//'[<<]...[번호][][][]'이 저장된 변수에 ' ... '을 추가

		if ( pnVO.getTotalPage() > endPage) {	//폼의 마지막 번호가 총페이지보다  작다면
			curPage = endPage + 1;		//[>>]눌렀을 때 이동할 페이지 번호를 변수에 담고
			indexList = indexList + "<a href='"+pnVO.getUrl()+"?pnVO.getCurrentPage()="+curPage+"'>[>>]</a>";		//[>>]를 a태그에 담아서 폼 형태를 담은 변수에 추가
		}else{	//폼의 마지막 번호가 총페이지보다  작지 않다면
			indexList = indexList + "[>>]";		//[>>]만 담아서 페이지이동 폼을 표현할 변수에 저장
		}//end else 
			
		return indexList;	//페이지 이동폼을 담은 변수를 반환
	}//pageNation
	
}//class
