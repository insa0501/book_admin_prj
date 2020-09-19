package kr.co.sist.admin.qna.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.qna.vo.SelectQnaListVO;

@Controller
public class AdminQnaController {
	
	/**
	 * �������� ����Ʈ ������
	 * @param currentPage
	 * @param sdVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/select_qna_list.do", method=GET)
	public String selectQnaList(SelectQnaListVO sqlVO, Model model) {
		return "";
	}//selectQnaList
	
	/**
	 * ���ǻ����� ������
	 * @param qna_no
	 * @param model
	 * @return
	 */
	@RequestMapping(value="select_qna_detail.do", method=GET)
	public String selectQnaDetail(int qna_no, Model model) {
		return "";
	}//selectQnaDetail
	
	/**
	 * ���� �亯 �ޱ�
	 * @param qna_no
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update_qna_answer.do", method=GET)
	public String updateQnaAnswer(int qna_no, Model model) {
		return "";
	}//updateQnaAnswer
	
	/**
	 * ���� ����
	 * @param qna_no
	 * @param model
	 * @return
	 */
	@RequestMapping(value="delete_qna.do", method=GET)
	public String deleteQna(int qna_no, Model model) {
		return "";
	}//updateQnaDelete
	
}//class
