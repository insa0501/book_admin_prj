package kr.co.sist.admin.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.user.vo.SelectUserDetailVO;
import kr.co.sist.admin.user.vo.SelectUserListVO;
import kr.co.sist.admin.user.vo.UpdateUserResignVO;
import kr.co.sist.admin.user.vo.UpdateUserVO;

@Controller
public class AdminUserController {
	
	/**
	 * 회원정보 리스트 페이지
	 * @param currentPage
	 * @param sdVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/select_user_list.do", method=GET)
	public String selectUserList(SelectUserListVO sulVO, Model model) {
		return "";
	}//selectUserList
	
	/**
	 * 회원상세정보 페이지
	 * @param sudVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="select_user_detail.do", method=GET)
	public String selectUserDetail(SelectUserDetailVO sudVO, Model model) {
		return "";
	}//selectUserDetail
	
	/**
	 * 회원정보 변경 프로세스
	 * @param uuVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update_user.do", method=GET)
	public String updateUser(UpdateUserVO uuVO, Model model) {
		return "";
	}//updateUser
	
	/**
	 * 회원 탈퇴 프로세스
	 * @param uurVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="update_user_resign.do", method=GET)
	public String updateUserResign(UpdateUserResignVO uurVO, Model model) {
		return "";
	}//updateUserResign
	
}//class
