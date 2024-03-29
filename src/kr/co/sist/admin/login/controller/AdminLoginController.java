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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sist.admin.login.service.AdminLoginService;
import kr.co.sist.admin.login.vo.AdminLoginVO;
import kr.co.sist.admin.login.vo.UpdateAdminPassVO;

@Controller
public class AdminLoginController {

	/**
	 * 관리자 로그인 (관리자 메인)
	 * @return 관리자 로그인 처리
	 */
	@RequestMapping(value="/admin_index.do", method= { GET, POST} )
	public String adminLoginForm(HttpSession session) {
		
		String adminLoginUrl = "login/admin_login";
		
		return adminLoginUrl;
	} // adminLoginForm()
	
	/**
	 * 관리자 로그인 처리
	 * @param session 관리자 아이디 저장
	 * @param alVO 관리자 로그인 VO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin_login_process.do", method= {GET, POST} )
	public String adminLogin(HttpSession session, AdminLoginVO alVO, Model model) {
		
		String url = "login/admin_login";
		String sessionChk = (String) session.getAttribute("admin_id");
		
		if (sessionChk != null) {	
			url = "redirect:book_list.do";				
		} else {
			AdminLoginService als = new AdminLoginService();
			String admin_id = als.adminLogin(alVO);
			
			model.addAttribute("login_flag", "fail");
			
			if (admin_id != null) {
				session.setAttribute("admin_id", admin_id);
				model.addAttribute("login_flag", "success");
				
				url = "forward:book_list.do";
			} // end if
			
		} // end else
		
		return url;
	} // adminLogin()
	
	/**
	 * 관리자 로그아웃
	 * @param SessionStatus
	 * @return 관리자 메인
	 */
	@RequestMapping(value="/admin_logout.do", method= { GET, POST} )
	public String adminLogout(SessionStatus ss, HttpSession hs) {
		hs.removeAttribute("admin_id");
		
		//ss.setComplete(); // 적용이 안된다
		//return "forward:admin_index.do";
		
		return "redirect:admin_index.do";
		//return "login/admin_login";
	} // adminLogout()
	
	/**
	 * 관리자 비밀번호 확인
	 * @return 관리자 비밀번호 변경
	 * 변경일자 : 2020.10.15
	 * 변경내용 : POST방식으로 변경화면으로 이동되서 GET 추가.
	 */
	@RequestMapping(value="/admin_pass_check_form.do", method= {POST,GET})
	public String adminPassCheck(HttpSession session,Model model) {
		String admin_id = (String)session.getAttribute("admin_id");
		
		if( admin_id != null && !"".equals(admin_id) ) {
			//로그인하고 비밀번호 변경을 온 경우 
			model.addAttribute("admin_id",admin_id);
			return "login/admin_change_pw";
		}
		//로그인을 하지 않고 비밀번호 변경을 브라우저에 검색하여 온 경우 로그인페이지로 이동
		return "redirect:admin_logout.do";
		
	} // adminPassCheck
	
	/**
	 * 관리자 비밀번호 변경
	 * @param uapVO
	 * @return 관리자 메인
	 */
	@RequestMapping(value="/change_admin_pass.do", method= POST)
	@ResponseBody
	public String changeAdminPass(UpdateAdminPassVO uapVO) {
		//업무로직을 구현한 클래스 객체화
		AdminLoginService als = new AdminLoginService();
		//해당 아이디에 비밀번호를 바꾸기 위해 id와 pw를 받는다.
		int result = als.changeAdminPass(uapVO);
		return String.valueOf(result);
	} // changeAdminPass
} // class
