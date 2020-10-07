package kr.co.sist.admin.qna.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.sist.admin.qna.dao.QnaListDAO;
import kr.co.sist.admin.qna.domain.QnaDetailDomain;
import kr.co.sist.admin.qna.domain.QnaListDomain;
import kr.co.sist.admin.qna.vo.PageNationVO;
import kr.co.sist.admin.qna.vo.SelectQnaListVO;

public class QnaListService {

	/**
	 * �������� ����Ʈ
	 * @param sdVO
	 * @param olrVO
	 * @return
	 */
	public List<QnaListDomain> searchQnaList(SelectQnaListVO sqlVO) {
		List<QnaListDomain> list = new ArrayList<QnaListDomain>();
		
		QnaListDAO qlDAO = QnaListDAO.getInstance();
		list = qlDAO.selectQnaList(sqlVO);
						
		return list;
	}//searchQnaList
	
	/**
	 * ���ǻ�����
	 * @param qna_no
	 * @return
	 */
	public QnaDetailDomain searchQnaDetail(int qna_no) {
		QnaDetailDomain qdd = null;
		
		QnaListDAO qlDAO = QnaListDAO.getInstance();
		qdd = qlDAO.selectQnaDetail(qna_no);
		
		return qdd;
	}//searchQnaDetail
	
	/**
	 * ��ü ������ �� : DB���
	 * @return
	 */
	public int totalCount(SelectQnaListVO sqlVO) {
		int totalCnt=0; 
		
		QnaListDAO qlDAO = QnaListDAO.getInstance();
		totalCnt = qlDAO.selectQnaCount(sqlVO);
		
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
	 * �� ��������
	 * @param totalCount
	 * @param pageScale
	 * @return
	 */
	public int totalPage(int totalCount, int pageScale) {
		int totalPage=(int)Math.ceil((double)totalCount/pageScale);
		
		return totalPage;
	}//totalPage
	
	/**
	 * ���۹�ȣ.
	 * @return
	 */
	public int startNum(int currentPage, int pageScale) {
		int startNum= currentPage*pageScale-pageScale+1;
		
		return startNum;
	}//startNum
	
	/**
	 * ����ȣ.
	 * @return
	 */
	public int endNum(int startNum, int pageScale) {
		int endNum = startNum+pageScale-1;
		
		return endNum;
	}//totalCount
	
	/**
	 * ���� ������ ���� �� �̵��ϱ� ���� �ε�������Ʈ.
	 * @param pnVO
	 * @return
	 */
	public String pageNation(PageNationVO pnVO) {
		String indexList=""; //������ �̵��� ���� ���� ���¸� ������ ���� ex. [<<]...[1][2]...[>]�� ���� ���� ����

		int pageNumber=0; //������ �̵��� ���� ���� �ѹ��� ǥ�õ� ��ȣ�� ����
		int startPage=0; //������ �̵��� ���� ���� ǥ�õ� ���� ��ȣ
		int endPage=0; //������ �̵��� ���� ���� ǥ�õ� ������ ��ȣ 
		int curPage=0; //������ ���� ��ũ�� ������ ���� �̵��� ���� ǥ�õ� ��������ȣ�� ������ ����
		int currentPage = pnVO.getCurrentPage();
		int totalPage = pnVO.getTotalPage();
		String selectType = pnVO.getSelectType();
		String selectData = pnVO.getSelectData();
		
		pageNumber = 5; //������ �̵��� ���� ����ȣ ǥ��.

		startPage = ((currentPage - 1) / pageNumber) * pageNumber + 1;
		endPage = (((startPage - 1) + pageNumber) / pageNumber) * pageNumber;

		if (totalPage <= endPage){	//���������� ������ �̵��� ���� ���� ǥ�õ� ������ ��ȣ���� �۴ٸ�
			endPage = pnVO.getTotalPage();	//������ ��ȣ�� �������� ��ȣ�� ����
		}//end if

		if ( currentPage > pageNumber) {	//������������ ���� ǥ�õ� ��ȣ���� ũ�ٸ�
			curPage = startPage - 1; 		//[<<]������ �� �̵��� ������ ��ȣ�� ������ ���
			indexList = indexList + "<li class='page-item'><a href='?currentPage="+curPage+(selectData!=null?"&selectType="+selectType+"&selectData="+selectData:"")+"' class='page-link' tabindex='-1'>Previous</a></li>";		//[<<]�� a�±׿� ��Ƽ� �������̵� ���� ǥ���� ������ ����
		}else{	//������������ ���� ǥ�õ� ��ȣ���� ũ�� �ʴٸ�
			indexList = indexList + "<li class='page-item disabled'><a class='page-link' href='#' tabindex='-1'>Previous</a></li>";		//[<<]�� ��Ƽ� �������̵� ���� ǥ���� ������ ����
		}//end else 

		curPage = startPage;	//���� ���۹�ȣ�� ������ �̵��� �ӽ� ������ ����
		while (curPage <= endPage){		//������ �̵��� �ӽ� ������ ���� ������ ��ȣ���� �۰ų� ���ٸ�
			if (curPage == currentPage) {	//������ �̵��� �ӽ� ������ ���� �������� ���� ���
				indexList = indexList + "<li class='page-item disabled'><a class='page-link' href='#' tabindex='-1'>"+currentPage+"</a></li>";	//�� ���¸� ���� ������ [�����ȣ]�� �߰�
			} else {	//������ �̵��� �ӽ� ������ ���� �������� �ٸ� ���
				indexList = indexList +"<li class='page-item'><a href='?currentPage="+curPage+(selectData!=null?"&selectType="+selectType+"&selectData="+selectData:"")+"' class='page-link'>"+curPage+"</a></li>";		//[��ȣ]�� a�±׿� ��Ƽ� �� ���¸� ���� ������ �߰�
			}//end else 
				
			curPage++;	//������ �̵��� �ӽ� ������ �������Ѽ� �������̵� ���� ��ȣ�� for��ó�� ��������� �Ѵ�.
		}//end while
			

		if ( pnVO.getTotalPage() > endPage) {	//���� ������ ��ȣ�� ������������  �۴ٸ�
			curPage = endPage + 1;		//[>>]������ �� �̵��� ������ ��ȣ�� ������ ���
			indexList = indexList + "<li class='page-item'><a class='page-link' href='?current_page='"+curPage+(selectData!=null?"&selectType="+selectType+"&selectData="+selectData:"")+"' tabindex='-1'>Next</a></li>";		//[>>]�� a�±׿� ��Ƽ� �� ���¸� ���� ������ �߰�
		}else{	//���� ������ ��ȣ�� ������������  ���� �ʴٸ�
			indexList = indexList + "<li class='page-item disabled'><a class='page-link' href='#' tabindex='-1'>Next</a></li>";		//[>>]�� ��Ƽ� �������̵� ���� ǥ���� ������ ����
		}//end else 
			
		return indexList;	//������ �̵����� ���� ������ ��ȯ
	}//pageNation
	
}//class
