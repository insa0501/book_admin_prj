package kr.co.sist.admin.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.user.vo.SelectDataVO;
import kr.co.sist.admin.user.vo.SelectUserDetailVO;
import kr.co.sist.admin.user.vo.UpdateUserResignVO;
import kr.co.sist.admin.user.vo.UpdateUserVO;

@Controller
public class AdminUserController {
	
	@RequestMapping(value="/select_user_list.do", method=GET)
	public String selectUserList(String currentPage, SelectDataVO sdVO , Model model) {
		return "";
	}//selectUserList
	
	@RequestMapping(value="select_user_detail.do", method=GET)
	public String selectUserDetail(SelectUserDetailVO sudVO, Model model) {
		return "";
	}//selectUserDetail
	
	@RequestMapping(value="/update_user.do", method=GET)
	public String updateUser(UpdateUserVO uuVO, Model model) {
		return "";
	}//updateUser
	
	@RequestMapping(value="update_user_resign.do", method=GET)
	public String updateUserResign(UpdateUserResignVO uurVO, Model model) {
		return "";
	}//updateUserResign
	
}//class
