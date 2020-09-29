package kr.co.sist.admin.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.sist.admin.login.service.AdminLoginService;
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
	@RequestMapping(value="/admin_index.do", method={GET,POST})
	public String adminLoginForm(HttpSession session) {
		
		System.out.println("adminLoginForm " + (String)session.getAttribute("admin_id"));
		return "login/admin_login";
	} // adminLoginForm()
	
	/**
	 * 관리자 로그인 처리
	 * @param session 관리자 아이디 저장
	 * @param alVO 관리자 로그인 VO
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
		return "login/admin_change_pw";
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
