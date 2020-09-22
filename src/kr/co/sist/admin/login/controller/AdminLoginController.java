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
	 * ������ �α��� (������ ����)
	 * @return ������ �α��� ó��
	 */
	@RequestMapping(value="/admin_index.do", method=POST)
	public String adminLoginForm() {
		
		return "";
	} // adminLoginForm()
	
	/**
	 * ������ �α��� ó��
	 * @param session ������ ���̵� ����
	 * @param alVO ������ �α��� VO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin_login_process.do", method=POST)
	public String adminLogin(HttpSession session, AdminLoginVO alVO, Model model) {
		
		return "";
	} // adminLogin()
	
	/**
	 * ������ �α׾ƿ�
	 * @param SessionStatus
	 * @return ������ ����
	 */
	@RequestMapping(value="/admin_logout.do", method=POST)
	public String adminLogout(SessionStatus ss) {
		return "login_form";
	} // adminLogout()
	
	/**
	 * ������ ��й�ȣ Ȯ��
	 * @return ������ ��й�ȣ ����
	 */
	@RequestMapping(value="/admin_pass_check_form.do", method=GET)
	public String adminPassCheck() {
		return "";
	} // adminPassCheck
	
	/**
	 * ������ ��й�ȣ ����
	 * @param uapVO
	 * @return ������ ����
	 */
	@RequestMapping(value="/change_admin_pass.do", method=POST)
	public String changeAdminPass(UpdateAdminPassVO uapVO) {
		return "";
	} // changeAdminPass
} // class