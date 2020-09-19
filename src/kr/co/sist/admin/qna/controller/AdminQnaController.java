package kr.co.sist.admin.qna.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.qna.vo.SelectDataVO;

@Controller
public class AdminQnaController {
	
	/**
	 * 문의정보 리스트 페이지
	 * @param currentPage
	 * @param sdVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/select_qna_list.do", method=GET)
	public String selectQnaList(String currentPage, SelectDataVO sdVO , Model model) {
		return "";
	}//selectQnaList
	
	/**
	 * 문의상세정보 페이지
	 * @param qna_no
	 * @param model
	 * @return
	 */
	@RequestMapping(value="select_qna_detail.do", method=GET)
	public String selectQnaDetail(int qna_no, Model model) {
		return "";
	}//selectQnaDetail
	
	/**
	 * 문의 답변 달기
	 * @param qna_no
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update_qna_answer.do", method=GET)
	public String updateQnaAnswer(int qna_no, Model model) {
		return "";
	}//updateQnaAnswer
	
	/**
	 * 문의 삭제 (삭제시 문의를 다 삭제하는게 아니라 "삭제된 문의입니다"와 같이 보여주는게 좋지 않을까해서 업데이트로 해놨는데,
	 * 그냥 다 삭제해도 문제는 없을거 같습니다.)
	 * @param qna_no
	 * @param model
	 * @return
	 */
	@RequestMapping(value="update_qna_delete.do", method=GET)
	public String updateQnaDelete(int qna_no, Model model) {
		return "";
	}//updateQnaDelete
	
}//class
