package kr.co.sist.admin.user.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.sist.admin.user.dao.UserListDAO;
import kr.co.sist.admin.user.domain.UserDetailDomain;
import kr.co.sist.admin.user.domain.UserListDomain;
import kr.co.sist.admin.user.domain.UserResDetailDomain;
import kr.co.sist.admin.user.vo.PageNationVO;
import kr.co.sist.admin.user.vo.SelectUserListVO;

public class UserListService {

	/**
	 * Method : 회원정보 리스트
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * @param sdVO
	 * @param ulrVO
	 * @return
	 */
	public List<UserListDomain> searchUserList(SelectUserListVO sulVO) {
		List<UserListDomain> list = new ArrayList<UserListDomain>();
		UserListDAO ulDAO = UserListDAO.getInstance();
		list = ulDAO.selectUserList(sulVO);
		return list;
	}//searchUserList
	
	/**
	 * Method : 회원상세정보
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * @param user_id
	 * @return
	 */
	public UserDetailDomain searchUserDetail(String user_id) {
		UserDetailDomain udDomain = null;
		UserListDAO ulDAO = UserListDAO.getInstance();
		udDomain = ulDAO.selectUserDetail(user_id);
		return udDomain;
	}//searchUserDetail
	/**
	 * Method : 탈퇴한 회원 상세 정보
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * @param user_id
	 * @return
	 */
	public UserResDetailDomain searchUserResDetail(String user_id) {
		UserResDetailDomain urdd = null;
		UserListDAO ulDAO = UserListDAO.getInstance();
		urdd = ulDAO.selectResDetail(user_id);
		urdd.setUser_status("탈퇴");
		return urdd;
	}//searchUserResDetail
	public List<String> searchUserResData(String user_id) {
		List<String> resData = null;
		UserListDAO ulDAO = UserListDAO.getInstance();
		resData = ulDAO.selectResData(user_id);
		return resData;
	}//searchUserResData
	
	/**
	 * Method : 전체 원글의 수 : DB사용 
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * 변경이력 : 2020-10-12
	 * 변경내용 : 브라우저에서 selectType을 임의로 수정했을때의 처리
	 * @return
	 */
	public int totalCount(SelectUserListVO sulVO) {
		int totalCnt=0; 
		
		if(sulVO.getSelectData() != null && !"".equals(sulVO.getSelectData()) && sulVO.getSelectType() == null ) {
			sulVO.setSelectType("user_id");
		}
		
		if(sulVO.getSelectType() != null && !"".equals(sulVO.getSelectType())) {
			boolean flag = false;
			String[] arr = {"user_id","user_name","user_phone","user_addr1","user_status"};
			for(int i=0; i<arr.length; i++) {
				if(sulVO.getSelectType().equals(arr[i])){
					flag = true;
				}//end if
			}//end for
			if(!flag) {
				sulVO.setSelectType("user_id");
			}
		}//end if
		
		
		UserListDAO ulDAO = UserListDAO.getInstance();
		totalCnt = ulDAO.selectUserCount(sulVO);
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
	 * Method : 총 페이지수
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * @param totalCount
	 * @param pageScale
	 * @return
	 */
	public int totalPage(int totalCount, int pageScale) {
		int totalPage=(int)Math.ceil((double)totalCount/pageScale);
		
		return totalPage;
	}//totalPage
	
	/**
	 * Method : 시작번호.
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * @return
	 */
	public int startNum( int currentPage,int pageScale) {
		int startNum= currentPage*pageScale-pageScale+1;
		
		return startNum;
	}//startNum
	
	/**
	 * Method : 끝번호.
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * @return
	 */
	public int endNum(int startNum, int pageScale) {
		int endNum = startNum+pageScale-1;
		
		return endNum;
	}//totalCount
	
	/**
	 * Method : 글이 여러개 있을 때 이동하기 위한 인덱스리스트.
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * @param pnVO
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
	
}//class
