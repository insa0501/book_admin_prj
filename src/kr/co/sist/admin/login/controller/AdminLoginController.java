package kr.co.sist.admin.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.sist.admin.login.vo.AdminLoginVO;
import kr.co.sist.admin.login.vo.UpdateAdminPassVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

@Controller
public class AdminLoginController {

	/**
	 * 관리자 로그인 (관리자 메인)
	 * @return 관리자 로그인 처리
	 */
	@RequestMapping(value="/admin_index.do", method=POST)
	public String adminLoginForm() {
		
		return "";
	} // adminLoginForm()
	
	/**
	 * 관리자 로그인 처리
	 * @param session 관리자 아이디 저장
	 * @param alVO 관리자 로그인 VO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin_login_process.do", method=POST)
	public String adminLogin(HttpSession session, AdminLoginVO alVO, Model model) {
		
		return "";
	} // adminLogin()
	
	/**
	 * 관리자 로그아웃
	 * @param SessionStatus
	 * @return 관리자 메인
	 */
	@RequestMapping(value="/admin_logout.do", method=POST)
	public String adminLogout(SessionStatus ss) {
		return "login_form";
	} // adminLogout()
	
	/**
	 * 관리자 비밀번호 확인
	 * @return 관리자 비밀번호 변경
	 */
	@RequestMapping(value="/admin_pass_check_form.do", method=GET)
	public String adminPassCheck() {
		return "";
	} // adminPassCheck
	
	/**
	 * 관리자 비밀번호 변경
	 * @param uapVO
	 * @return 관리자 메인
	 */
	@RequestMapping(value="/change_admin_pass.do", method=POST)
	public String changeAdminPass(UpdateAdminPassVO uapVO) {
		return "";
	} // changeAdminPass
} // class
