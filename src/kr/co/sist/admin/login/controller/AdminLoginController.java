package kr.co.sist.admin.login.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.sist.admin.login.service.AdminLoginService;
import kr.co.sist.admin.login.vo.AdminLoginVO;
import kr.co.sist.admin.login.vo.UpdateAdminPassVO;

@Controller
public class AdminLoginController {

	/**
	 * ������ �α��� (������ ����)
	 * @return ������ �α��� ó��
	 */
	@RequestMapping(value="/admin_index.do", method={GET,POST})
	public String adminLoginForm(HttpSession session) {
		
		String adminLoginUrl = "login/admin_login";
		System.out.println("adminLoginForm : " + (String)session.getAttribute("admin_id"));
		
		if ( session.getAttribute("admin_id") != null ) {
			adminLoginUrl = "redirect:book_list.do";
		} // end if
		
		return adminLoginUrl;
	} // adminLoginForm()
	
	/**
	 * ������ �α��� ó��
	 * @param session ������ ���̵� ����
	 * @param alVO ������ �α��� VO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin_login_process.do", method= {GET,POST} )
	public String adminLogin(HttpSession session, AdminLoginVO alVO, Model model) {
		
		String url = "forward:admin_index.do";
		
		String ssCheck = (String) session.getAttribute("admin_id");
		System.out.println("ssCheck " + ssCheck);
		
		AdminLoginService als = new AdminLoginService();
		String admin_id = als.adminLogin(alVO);
		
		model.addAttribute("login_flag", "fail");
		
		if (admin_id != null) {
			session.setAttribute("admin_id", admin_id);
			model.addAttribute("admin_id", admin_id);
			model.addAttribute("login_flag", "success");
		} // end if
		
		/*
		 * if (admin_id != null) {
		 * 
		 * session.setAttribute("admin_id", admin_id); model.addAttribute("admin_id",
		 * admin_id);
		 * 
		 * url = "redirect:book_list.do"; } // end if
		 */		
		if (ssCheck != null) {	
			//url = "redirect:book_list.do";				
			url = "redirect:order_list.do";				
		} // end if
		
		System.out.println(url);
		return url;
	} // adminLogin()
	
	@RequestMapping(value="/admin_book.do", method=POST)
	public String skipLogin() {
		return "book/admin_mgr_book";
	} //skipLogin
	
	/**
	 * ������ �α׾ƿ�
	 * @param SessionStatus
	 * @return ������ ����
	 */
	@RequestMapping(value="/admin_logout.do", method=GET)
	public String adminLogout(SessionStatus ss, HttpSession hs) {
		hs.removeAttribute("admin_id");
		
		//ss.setComplete(); // ������ �ȵȴ�
		//return "forward:admin_index.do";
		
		return "redirect:admin_index.do";
	} // adminLogout()
	
	/**
	 * ������ ��й�ȣ Ȯ��
	 * @return ������ ��й�ȣ ����
	 */
	@RequestMapping(value="/admin_pass_check_form.do", method=GET)
	public String adminPassCheck(HttpSession session,Model model) {
		String admin_id = (String)session.getAttribute("admin_id");
		
		if( admin_id != null && !"".equals(admin_id) ) {
			//�α����ϰ� ��й�ȣ ������ �� ��� 
			model.addAttribute("admin_id",admin_id);
			return "login/admin_change_pw";
		}
		//�α����� ���� �ʰ� ��й�ȣ ������ �������� �˻��Ͽ� �� ��� �α����������� �̵�
		return "redirect:admin_logout.do";
		
	} // adminPassCheck
	
	/**
	 * ������ ��й�ȣ ����
	 * @param uapVO
	 * @return ������ ����
	 */
	@RequestMapping(value="/change_admin_pass.do", method= POST)
	@ResponseBody
	public String changeAdminPass(UpdateAdminPassVO uapVO) {
		//���������� ������ Ŭ���� ��üȭ
		AdminLoginService als = new AdminLoginService();
		//�ش� ���̵� ��й�ȣ�� �ٲٱ� ���� id�� pw�� �޴´�.
		int result = als.changeAdminPass(uapVO);
		return String.valueOf(result);
	} // changeAdminPass
} // class
