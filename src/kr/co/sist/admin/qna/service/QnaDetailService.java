package kr.co.sist.admin.qna.service;

import kr.co.sist.admin.qna.dao.QnaDetailDAO;
import kr.co.sist.admin.qna.vo.UpdateQnaAnswerVO;

public class QnaDetailService {

	/**
	 * ���� �亯 �ޱ�
	 * @param uqaVO
	 * @return
	 */
	public boolean inputQnaAnswer(UpdateQnaAnswerVO uqaVO) {
		boolean flag = false;
		
		QnaDetailDAO qdDAO = QnaDetailDAO.getInstance();
		if (qdDAO.updateQnaAnswer(uqaVO) == 1) {
			flag = !flag;
		} // end if
		
		return flag;
	}//inputQnaAnswer
	
	/**
	 * ���� ����
	 * @param qna_no
	 * @return
	 */
	public boolean removeQna(int qna_no) {
		boolean flag = false;
		
		QnaDetailDAO qdDAO = QnaDetailDAO.getInstance();
		if (qdDAO.deleteQna(qna_no) == 1) {
			flag = !flag;
		} // end if
		
		return flag;
	}//removeQna
	
}//class
