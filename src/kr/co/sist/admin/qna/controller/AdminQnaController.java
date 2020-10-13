package kr.co.sist.admin.qna.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.qna.domain.QnaDetailDomain;
import kr.co.sist.admin.qna.domain.QnaListDomain;
import kr.co.sist.admin.qna.service.QnaDetailService;
import kr.co.sist.admin.qna.service.QnaListService;
import kr.co.sist.admin.qna.vo.PageNationVO;
import kr.co.sist.admin.qna.vo.SelectQnaListVO;
import kr.co.sist.admin.qna.vo.UpdateQnaAnswerVO;

@Controller
public class AdminQnaController {
	
	/**
	 * �������� ����Ʈ ������
	 * @param currentPage
	 * @param sdVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qna_list.do", method= { GET,POST })
	public String selectQnaList(SelectQnaListVO sqlVO, Model model/* , HttpSession session */) {
		QnaListService qls = new QnaListService();
		
		int totalCount = qls.totalCount(sqlVO); // ��ȸ�� �ֹ������� ����
		int pageScale = qls.pageScale(); // ���������� ������ ������ ���� 
		int totalPage = qls.totalPage(totalCount, pageScale); // �� ������ ��
		if (sqlVO.getCurrentPage() == 0) { // ������������ ���ٸ�
			sqlVO.setCurrentPage(1); // 1�� ����
		} // end if
		int currentPage = sqlVO.getCurrentPage(); // ����������
		int startNum = qls.startNum(currentPage, pageScale);
		int endNum = qls.endNum(startNum, pageScale);
		String selectType = sqlVO.getSelectType();
		String selectData = sqlVO.getSelectData();
		
		/*
		 * System.out.println("totalCount : " + totalCount);
		 * System.out.println("pageScale : " + pageScale);
		 * System.out.println("totalPage : " + totalPage);
		 * System.out.println("selectType : " + selectType);
		 * System.out.println("selectData : " + selectData);
		 */
		
		sqlVO.setStartNum(startNum); // �������� �ֹ����� ���۹�ȣ
		sqlVO.setEndNum(endNum); // ����ȣ
		
		PageNationVO pnVO = new PageNationVO("", selectType, selectData, currentPage, totalPage); // ����¡�� ���� VO�� �� ����
		
		String indexList = qls.pageNation(pnVO); // ����¡ �� ���� ����
		model.addAttribute("indexList", indexList);
		
		List<QnaListDomain> list = qls.searchQnaList(sqlVO); // DB������ ��ȸ�Ͽ� ����Ʈ�� ����
		model.addAttribute("qna_list", list);
		//session.setAttribute("qna_currentPage", currentPage);
		
		return "qna/admin_mgr_qna";
	}//selectQnaList
	
	/**
	 * ���ǻ����� ������
	 * @param qna_no
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qna_detail.do", method=GET)
	public String selectQnaDetail(int qna_no, Model model) {
		
		QnaListService qls = new QnaListService();
		QnaDetailDomain qdd = qls.searchQnaDetail(qna_no);
		
		model.addAttribute("qna_info", qdd);
		
		return "qna/admin_mgr_qna_detail";
	}//selectQnaDetail
	
	/**
	 * ���� �亯 �ޱ�
	 * @param qna_no
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qna_answer.do", method=POST)
	public String updateQnaAnswer(UpdateQnaAnswerVO uqaVO, Model model, HttpSession session) {
		
		String msg = "fail";
		QnaDetailService qds = new QnaDetailService();
		
		uqaVO.setAdmin_id((String)session.getAttribute("admin_id"));
		
		if (qds.inputQnaAnswer(uqaVO)) {
			msg = "success";
		} // end if
		
		model.addAttribute("update_msg", msg);
		
		return "redirect:qna_list.do";
	}//updateQnaAnswer
	
	/**
	 * ���� ����
	 * @param qna_no
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/delete_qna.do", method= {GET, POST})
	public String deleteQna(int qna_no, Model model) {
		
		QnaDetailService qds = new QnaDetailService();
		qds.removeQna(qna_no);
		
		return "redirect:qna_list.do";
	}//updateQnaDelete
	
}//class
