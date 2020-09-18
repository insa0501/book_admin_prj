package kr.co.sist.admin.qna.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.qna.vo.SelectDataVO;

@Controller
public class AdminQnaController {
	
	@RequestMapping(value="/select_qna_list.do", method=GET)
	public String selectQnaList(String currentPage, SelectDataVO sdVO , Model model) {
		return "";
	}//selectQnaList
	
	@RequestMapping(value="select_qna_detail.do", method=GET)
	public String selectQnaDetail(int qna_no, Model model) {
		return "";
	}//selectQnaDetail
	
	@RequestMapping(value="/update_qna_answer.do", method=GET)
	public String updateQnaAnswer(int qna_no, Model model) {
		return "";
	}//updateQnaAnswer
	
	@RequestMapping(value="update_qna_delete.do", method=GET)
	public String updateQnaDelete(int qna_no, Model model) {
		return "";
	}//updateQnaDelete
	
}//class
