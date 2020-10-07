package kr.co.sist.admin.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.user.domain.UserDetailDomain;
import kr.co.sist.admin.user.domain.UserListDomain;
import kr.co.sist.admin.user.domain.UserResDetailDomain;
import kr.co.sist.admin.user.service.UserDetailService;
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
	@RequestMapping(value="/user_list.do", method= {GET,POST})
	public String selectUserList(SelectUserListVO sulVO, String changeFlag, String deleteFlag, Model model) {
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
		//검색데이터, 검색타입, 현재페이지, 전체페이지
		StringBuilder searchData = new StringBuilder();
		if( sulVO.getSelectData() != null && !"".equals(sulVO.getSelectData()) ) {
			searchData
			.append("selectType=")
			.append(sulVO.getSelectType())
			.append("&selectData=")
			.append(sulVO.getSelectData());
		}
		PageNationVO pnVO = new PageNationVO(searchData.toString(), currentPage, totalPage);
		String pageNation = uls.pageNation(pnVO);
		model.addAttribute("page_nation",pageNation);
		
		List<UserListDomain> list = uls.searchUserList(sulVO);
		model.addAttribute("user_list",list);
		
		model.addAttribute("changeFlag", changeFlag);
		model.addAttribute("deleteFlag", deleteFlag);
		
		
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
		//업무로직을 구현한 클래스 객체
		UserListService uls = new UserListService();
		if("N".equals(sudVO.getUser_status())) {
			UserResDetailDomain urdd = uls.searchUserResDetail(sudVO.getUser_id());
			List<String> list = uls.searchUserResData(sudVO.getUser_id());
			model.addAttribute("user_detail",urdd);
			model.addAttribute("res_list",list);
			return "user/res_detail";
		}
		
		UserDetailDomain udd = uls.searchUserDetail(sudVO.getUser_id());
		model.addAttribute("user_detail",udd);
		return "user/detail";
	}//selectUserDetail
	
	/**
	 * 회원정보 변경 프로세스
	 * @param uuVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update_user.do", method=POST)
	public String updateUser(UpdateUserVO uuVO, Model model) {
		//유저 상세정보 업무로직을 구현한 클래스 객체
		UserDetailService uds = new UserDetailService();
		int flag = uds.changeUserData(uuVO);
		model.addAttribute("user_changeFlag",flag);
		
		//return "redirect:user_list.do";
		return "redirect:process_result.do";
	}//updateUser
	
	/**
	 * 회원 탈퇴 프로세스
	 * @param uurVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="delete_user.do", method=POST)
	public String updateUserResign(UpdateUserResignVO uurVO, Model model) {
		//유저 상세정보 업무로직을 구현한 클래스 객체
		UserDetailService uds = new UserDetailService();
		int flag = uds.resignUser(uurVO);
		model.addAttribute("user_deleteFlag", flag);
		
		return "redirect:process_result.do";
	}//updateUserResign
		
}//class
