package kr.co.sist.admin.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.user.domain.UserListDomain;
import kr.co.sist.admin.user.service.UserListService;
import kr.co.sist.admin.user.vo.PageNationVO;
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
	@RequestMapping(value="/user_list.do", method=GET)
	public String selectUserList(SelectUserListVO sulVO, Model model) {
		//도서 리스트를 조회 업무로직을 구현한 클래스
		UserListService uls = new UserListService();
		//전체 게시물 수
		int totalCount = uls.totalCount(sulVO);
		//한 화면에 보여줄 게시물의 수
		int pageScale = uls.pageScale();
		//총 페이지의 수
		int totalPage = uls.totalPage(totalCount, pageScale);
		//현제페이지가 파라메터가 없을 경우 1로 지정
		if( sulVO.getCurrentPage() == 0 ) {
			sulVO.setCurrentPage(1);
		}
		//시작 페이지 번호 - 파라메터 필요 (현재페이지)
		int currentPage = sulVO.getCurrentPage();
		
		//페이지별 시작 번호
		int startNum = uls.startNum(currentPage, pageScale);
		//페이지별 끝 번호 
		int endNum = uls.endNum(startNum, pageScale);
		//업무로직에 필요한 endNum과 startNum을 설정
		sulVO.setEndNum(endNum);
		sulVO.setStartNum(startNum);
		
		//페이지 하단의 페이지 이동
		PageNationVO pnVO = new PageNationVO("", currentPage, totalPage);
		String pageNation = uls.pageNation(pnVO);
		model.addAttribute("page_nation",pageNation);
		
		List<UserListDomain> list = uls.searchUserList(sulVO);
		model.addAttribute("user_list",list);
		
		
		return "user/main";
	}//selectUserList
	
	/**
	 * 회원상세정보 페이지
	 * @param sudVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="user_detail.do", method=GET)
	public String selectUserDetail(SelectUserDetailVO sudVO, Model model) {
		return "user/detail";
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
	@RequestMapping(value="user_resign.do", method=GET)
	public String updateUserResign(UpdateUserResignVO uurVO, Model model) {
		return "user/res_detail";
	}//updateUserResign
	
}//class
