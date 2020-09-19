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
	 * �������� ����Ʈ
	 * @param sdVO
	 * @param olrVO
	 * @return
	 */
	public List<QnaListDomain> searchQnaList(SelectDataVO sdVO, QnaListRangeVO olrVO) {
		List<QnaListDomain> list = new ArrayList<QnaListDomain>();
		
		return list;
	}//searchQnaList
	
	/**
	 * ���ǻ�����
	 * @param qna_no
	 * @return
	 */
	public QnaDetailDomain searchQnaDetail(int qna_no) {
		QnaDetailDomain odDomain = null;
		
		return odDomain;
	}//searchQnaDetail
	
	/**
	 * ��ü ������ �� : DB���
	 * @return
	 */
	public int totalCount() {
		int totalCnt=0; 
		
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

		pageNumber = 10; //������ �̵��� ���� ���� �ѹ��� 10���� ��ȣ�� ǥ��.

		startPage = ((pnVO.getCurrentPage() - 1) / pageNumber) * pageNumber + 1;
		endPage = (((startPage - 1) + pageNumber) / pageNumber) * pageNumber;

		if (pnVO.getTotalPage() <= endPage){	//���������� ������ �̵��� ���� ���� ǥ�õ� ������ ��ȣ���� �۴ٸ�
			endPage = pnVO.getTotalPage();	//������ ��ȣ�� �������� ��ȣ�� ����
		}//end if

		if ( pnVO.getCurrentPage() > pageNumber) {	//������������ ���� ǥ�õ� ��ȣ���� ũ�ٸ�
			curPage = startPage - 1; 		//[<<]������ �� �̵��� ������ ��ȣ�� ������ ���
			indexList = indexList + "<a href='"+pnVO.getUrl()+"?pnVO.getCurrentPage()="+curPage+"'>[<<]</a>";		//[<<]�� a�±׿� ��Ƽ� �������̵� ���� ǥ���� ������ ����
		}else{	//������������ ���� ǥ�õ� ��ȣ���� ũ�� �ʴٸ�
			indexList = indexList + "[<<]";		//[<<]�� ��Ƽ� �������̵� ���� ǥ���� ������ ����
		}//end else 
		indexList = indexList + " ... ";	//�� ���¸� ���� ������ ' ... '�� �߰�

		curPage = startPage;	//���� ���۹�ȣ�� ������ �̵��� �ӽ� ������ ����
		while (curPage <= endPage){		//������ �̵��� �ӽ� ������ ���� ������ ��ȣ���� �۰ų� ���ٸ�
			if (curPage == pnVO.getCurrentPage()) {	//������ �̵��� �ӽ� ������ ���� �������� ���� ���
				indexList = indexList + "["+pnVO.getCurrentPage()+"]";	//�� ���¸� ���� ������ [�����ȣ]�� �߰�
			} else {	//������ �̵��� �ӽ� ������ ���� �������� �ٸ� ���
				indexList = indexList +"<a href='"+pnVO.getUrl()+"?pnVO.getCurrentPage()="+curPage+"'>["+curPage+"]</a>";		//[��ȣ]�� a�±׿� ��Ƽ� �� ���¸� ���� ������ �߰�
			}//end else 
				
			curPage++;	//������ �̵��� �ӽ� ������ �������Ѽ� �������̵� ���� ��ȣ�� for��ó�� ��������� �Ѵ�.
		}//end while
			
		indexList = indexList + " ... ";	//'[<<]...[��ȣ][][][]'�� ����� ������ ' ... '�� �߰�

		if ( pnVO.getTotalPage() > endPage) {	//���� ������ ��ȣ�� ������������  �۴ٸ�
			curPage = endPage + 1;		//[>>]������ �� �̵��� ������ ��ȣ�� ������ ���
			indexList = indexList + "<a href='"+pnVO.getUrl()+"?pnVO.getCurrentPage()="+curPage+"'>[>>]</a>";		//[>>]�� a�±׿� ��Ƽ� �� ���¸� ���� ������ �߰�
		}else{	//���� ������ ��ȣ�� ������������  ���� �ʴٸ�
			indexList = indexList + "[>>]";		//[>>]�� ��Ƽ� �������̵� ���� ǥ���� ������ ����
		}//end else 
			
		return indexList;	//������ �̵����� ���� ������ ��ȯ
	}//pageNation
	
}//class
