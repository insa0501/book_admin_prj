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
	 * Method : ȸ������ ����Ʈ
	 * �ۼ��� : ��ȿ��
	 * �����̷� : 2020-10-08
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
	 * Method : ȸ��������
	 * �ۼ��� : ��ȿ��
	 * �����̷� : 2020-10-08
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
	 * Method : Ż���� ȸ�� �� ����
	 * �ۼ��� : ��ȿ��
	 * �����̷� : 2020-10-08
	 * @param user_id
	 * @return
	 */
	public UserResDetailDomain searchUserResDetail(String user_id) {
		UserResDetailDomain urdd = null;
		UserListDAO ulDAO = UserListDAO.getInstance();
		urdd = ulDAO.selectResDetail(user_id);
		urdd.setUser_status("Ż��");
		return urdd;
	}//searchUserResDetail
	public List<String> searchUserResData(String user_id) {
		List<String> resData = null;
		UserListDAO ulDAO = UserListDAO.getInstance();
		resData = ulDAO.selectResData(user_id);
		return resData;
	}//searchUserResData
	
	/**
	 * Method : ��ü ������ �� : DB��� 
	 * �ۼ��� : ��ȿ��
	 * �����̷� : 2020-10-08
	 * �����̷� : 2020-10-12
	 * ���泻�� : ���������� selectType�� ���Ƿ� ������������ ó��
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
	 * �� ȭ�鿡 ������ �Խù��� ��. 10��
	 * @return
	 */
	public int pageScale() {
		int pageScale=10;
		
		return pageScale;
	}//pageScale
	
	/**
	 * Method : �� ��������
	 * �ۼ��� : ��ȿ��
	 * �����̷� : 2020-10-08
	 * @param totalCount
	 * @param pageScale
	 * @return
	 */
	public int totalPage(int totalCount, int pageScale) {
		int totalPage=(int)Math.ceil((double)totalCount/pageScale);
		
		return totalPage;
	}//totalPage
	
	/**
	 * Method : ���۹�ȣ.
	 * �ۼ��� : ��ȿ��
	 * �����̷� : 2020-10-08
	 * @return
	 */
	public int startNum( int currentPage,int pageScale) {
		int startNum= currentPage*pageScale-pageScale+1;
		
		return startNum;
	}//startNum
	
	/**
	 * Method : ����ȣ.
	 * �ۼ��� : ��ȿ��
	 * �����̷� : 2020-10-08
	 * @return
	 */
	public int endNum(int startNum, int pageScale) {
		int endNum = startNum+pageScale-1;
		
		return endNum;
	}//totalCount
	
	/**
	 * Method : ���� ������ ���� �� �̵��ϱ� ���� �ε�������Ʈ.
	 * �ۼ��� : ��ȿ��
	 * �����̷� : 2020-10-08
	 * @param pnVO
	 * @return
	 */
	public String pageNation(PageNationVO pnVO) {
		String pageNation=""; //������ �̵��� ���� ���� ���¸� ������ ���� ex. [<<]...[1][2]...[>]�� ���� ���� ����

		int pageNumber=0; //������ �̵��� ���� ���� �ѹ��� ǥ�õ� ��ȣ�� ����
		int startPage=0; //������ �̵��� ���� ���� ǥ�õ� ���� ��ȣ
		int endPage=0; //������ �̵��� ���� ���� ǥ�õ� ������ ��ȣ 
		int curPage=0; //������ ���� ��ũ�� ������ ���� �̵��� ���� ǥ�õ� ��������ȣ�� ������ ����

		pageNumber = 5; //������ �̵��� ���� ���� �ѹ��� 10���� ��ȣ�� ǥ��.

		startPage = ((pnVO.getCurrentPage() - 1) / pageNumber) * pageNumber + 1;
		endPage = (((startPage - 1) + pageNumber) / pageNumber) * pageNumber;

		if (pnVO.getTotalPage() <= endPage){	//���������� ������ �̵��� ���� ���� ǥ�õ� ������ ��ȣ���� �۴ٸ�
			endPage = pnVO.getTotalPage();	//������ ��ȣ�� �������� ��ȣ�� ����
		}//end if

		if ( pnVO.getCurrentPage() > pageNumber) {	//������������ ���� ǥ�õ� ��ȣ���� ũ�ٸ�
			curPage = startPage - 1; 		//[<<]������ �� �̵��� ������ ��ȣ�� ������ ���
			pageNation = pageNation +"<li class='page-item'>"
					+ "<a href='?"+pnVO.getUrl()+"&currentPage="+curPage+"' class='page-link' href='#' tabindex='-1'>Previous</a>"
					+"</li>";		//[<<]�� a�±׿� ��Ƽ� �������̵� ���� ǥ���� ������ ����
		}else{	//������������ ���� ǥ�õ� ��ȣ���� ũ�� �ʴٸ�
			pageNation = pageNation + "<li class='page-item disabled'><a class='page-link' href='#' tabindex='-1'>Previous</a></li>";		//[<<]�� ��Ƽ� �������̵� ���� ǥ���� ������ ����
		}//end else 

		curPage = startPage;	//���� ���۹�ȣ�� ������ �̵��� �ӽ� ������ ����
		while (curPage <= endPage){		//������ �̵��� �ӽ� ������ ���� ������ ��ȣ���� �۰ų� ���ٸ�
			if (curPage == pnVO.getCurrentPage()) {	//������ �̵��� �ӽ� ������ ���� �������� ���� ���
				pageNation = pageNation + "<li class='page-item'><a class='page-link disabled' style='color:#6c757d; font-weight:bold;'>"+pnVO.getCurrentPage()+"</a></li>";	//�� ���¸� ���� ������ [�����ȣ]�� �߰�
			} else {	//������ �̵��� �ӽ� ������ ���� �������� �ٸ� ���
				pageNation = pageNation +"<li class='page-item'><a  class='page-link' href='?"+pnVO.getUrl()+"&currentPage="+curPage+"'>"+curPage+"</a></li>";		//[��ȣ]�� a�±׿� ��Ƽ� �� ���¸� ���� ������ �߰�
			}//end else 
				
			curPage++;	//������ �̵��� �ӽ� ������ �������Ѽ� �������̵� ���� ��ȣ�� for��ó�� ��������� �Ѵ�.
		}//end while
			

		if ( pnVO.getTotalPage() > endPage) {	//���� ������ ��ȣ�� ������������  �۴ٸ�
			curPage = endPage + 1;		//[>>]������ �� �̵��� ������ ��ȣ�� ������ ���
			pageNation = pageNation + "<li class='page-item'>"
					+"<a href='?"+pnVO.getUrl()+"&currentPage="+curPage+"' class='page-link' href='#' tabindex='-1'>Next</a></li>";		//[>>]�� a�±׿� ��Ƽ� �� ���¸� ���� ������ �߰�
		}else{	//���� ������ ��ȣ�� ������������  ���� �ʴٸ�
			pageNation = pageNation + "<li class='page-item disabled'><a class='page-link' href='#' tabindex='-1'>Next</a></li>";		//[>>]�� ��Ƽ� �������̵� ���� ǥ���� ������ ����
		}//end else 
			
		return pageNation;	//������ �̵����� ���� ������ ��ȯ
	}//pageNation
	
}//class
