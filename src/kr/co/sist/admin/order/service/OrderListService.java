package kr.co.sist.admin.order.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.sist.admin.order.dao.OrderListDAO;
import kr.co.sist.admin.order.domain.OrderDetailDomain;
import kr.co.sist.admin.order.domain.OrderListDomain;
import kr.co.sist.admin.order.vo.PageNationVO;
import kr.co.sist.admin.order.vo.SelectOrderListVO;

public class OrderListService {

	/**
	 * 주문정보 리스트
	 * @param sdVO
	 * @param olrVO
	 * @return
	 */
	//SelectOrderListVO solVO
	public List<OrderListDomain> searchOrderList(SelectOrderListVO solVO) {
		List<OrderListDomain> list = new ArrayList<OrderListDomain>();
				
		OrderListDAO olDAO = OrderListDAO.getInstance();
		list = olDAO.selectOrderList(solVO);
		
		return list;
	}//searchOrderList
	
	/**
	 * 주문상세정보
	 * @param order_no
	 * @return
	 */
	public OrderDetailDomain searchOrderDetail(int order_no) {
		OrderDetailDomain odd = null;
		
		OrderListDAO olDAO = OrderListDAO.getInstance();
		odd = olDAO.selectOrderDetail(order_no);
		
		return odd;
	}//searchOrderDetail
	
	/**
	 * 전체 원글의 수 : DB사용
	 * @return
	 */
	//SelectOrderListVO solVO
	public int totalCount(SelectOrderListVO solVO) {
		int totalCnt=0; 
		
		OrderListDAO olDAO = OrderListDAO.getInstance();
		totalCnt = olDAO.selectOrderListCount(solVO);
		
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
		int currentPage = pnVO.getCurrentPage();
		int totalPage = pnVO.getTotalPage();
		String selectType = pnVO.getSelectType();
		String selectData = pnVO.getSelectData();
		
		pageNumber = 5; //페이지 이동을 위한 폼번호 표시.

		startPage = ((currentPage - 1) / pageNumber) * pageNumber + 1;
		endPage = (((startPage - 1) + pageNumber) / pageNumber) * pageNumber;

		if (totalPage <= endPage){	//총페이지가 페이지 이동을 위한 폼의 표시될 마지막 번호보다 작다면
			endPage = pnVO.getTotalPage();	//마지막 번호는 총페이지 번호로 변경
		}//end if

		if ( currentPage > pageNumber) {	//현재페이지가 폼에 표시된 번호보다 크다면
			curPage = startPage - 1; 		//[<<]눌렀을 때 이동할 페이지 번호를 변수에 담고
			indexList = indexList + "<li class='page-item'><a href='?currentPage="+curPage+(selectData!=null?"&selectType="+selectType+"&selectData="+selectData:"")+"' class='page-link' tabindex='-1'>Previous</a></li>";		//[<<]를 a태그에 담아서 페이지이동 폼을 표현할 변수에 저장
		}else{	//현재페이지가 폼에 표시된 번호보다 크지 않다면
			indexList = indexList + "<li class='page-item disabled'><a class='page-link' href='#' tabindex='-1'>Previous</a></li>";		//[<<]만 담아서 페이지이동 폼을 표현할 변수에 저장
		}//end else 

		curPage = startPage;	//폼의 시작번호를 페이지 이동용 임시 변수에 저장
		while (curPage <= endPage){		//페이지 이동용 임시 변수가 폼의 마지막 번호보다 작거나 같다면
			if (curPage == currentPage) {	//페이지 이동용 임시 변수가 현재 페이지와 같은 경우
				indexList = indexList + "<li class='page-item disabled'><a class='page-link' href='#' tabindex='-1'>"+currentPage+"</a></li>";	//폼 형태를 담은 변수에 [현재번호]를 추가
			} else {	//페이지 이동용 임시 변수가 현재 페이지와 다른 경우
				indexList = indexList +"<li class='page-item'><a href='?currentPage="+curPage+(selectData!=null?"&selectType="+selectType+"&selectData="+selectData:"")+"' class='page-link'>"+curPage+"</a></li>";		//[번호]를 a태그에 담아서 폼 형태를 담은 변수에 추가
			}//end else 
				
			curPage++;	//페이지 이동용 임시 변수를 증가시켜서 페이지이동 폼의 번호가 for문처럼 만들어지게 한다.
		}//end while
			

		if ( pnVO.getTotalPage() > endPage) {	//폼의 마지막 번호가 총페이지보다  작다면
			curPage = endPage + 1;		//[>>]눌렀을 때 이동할 페이지 번호를 변수에 담고
			indexList = indexList + "<li class='page-item'><a class='page-link' href='?current_page='"+curPage+(selectData!=null?"&selectType="+selectType+"&selectData="+selectData:"")+"' tabindex='-1'>Next</a></li>";		//[>>]를 a태그에 담아서 폼 형태를 담은 변수에 추가
		}else{	//폼의 마지막 번호가 총페이지보다  작지 않다면
			indexList = indexList + "<li class='page-item disabled'><a class='page-link' href='#' tabindex='-1'>Next</a></li>";		//[>>]만 담아서 페이지이동 폼을 표현할 변수에 저장
		}//end else 
			
		return indexList;	//페이지 이동폼을 담은 변수를 반환
	}//pageNation
	
}//class
