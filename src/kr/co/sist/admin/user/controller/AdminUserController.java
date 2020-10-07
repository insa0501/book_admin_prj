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
	 * ȸ������ ����Ʈ ������
	 * @param currentPage
	 * @param sdVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/user_list.do", method= {GET,POST})
	public String selectUserList(SelectUserListVO sulVO, String changeFlag, String deleteFlag, Model model) {
		//���� ����Ʈ�� ��ȸ ���������� ������ Ŭ����
		UserListService uls = new UserListService();
		//��ü �Խù� ��
		int totalCount = uls.totalCount(sulVO);
		//�� ȭ�鿡 ������ �Խù��� ��
		int pageScale = uls.pageScale();
		//�� �������� ��
		int totalPage = uls.totalPage(totalCount, pageScale);
		//������������ �Ķ���Ͱ� ���� ��� 1�� ����
		if( sulVO.getCurrentPage() == 0 ) {
			sulVO.setCurrentPage(1);
		}
		//���� ������ ��ȣ - �Ķ���� �ʿ� (����������)
		int currentPage = sulVO.getCurrentPage();
		
		//�������� ���� ��ȣ
		int startNum = uls.startNum(currentPage, pageScale);
		//�������� �� ��ȣ 
		int endNum = uls.endNum(startNum, pageScale);
		//���������� �ʿ��� endNum�� startNum�� ����
		sulVO.setEndNum(endNum);
		sulVO.setStartNum(startNum);
		
		//������ �ϴ��� ������ �̵�
		//�˻�������, �˻�Ÿ��, ����������, ��ü������
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
	 * ȸ�������� ������
	 * @param sudVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="user_detail.do", method=GET)
	public String selectUserDetail(SelectUserDetailVO sudVO, Model model) {
		//���������� ������ Ŭ���� ��ü
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
	 * ȸ������ ���� ���μ���
	 * @param uuVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update_user.do", method=POST)
	public String updateUser(UpdateUserVO uuVO, Model model) {
		//���� ������ ���������� ������ Ŭ���� ��ü
		UserDetailService uds = new UserDetailService();
		int flag = uds.changeUserData(uuVO);
		model.addAttribute("user_changeFlag",flag);
		
		//return "redirect:user_list.do";
		return "redirect:process_result.do";
	}//updateUser
	
	/**
	 * ȸ�� Ż�� ���μ���
	 * @param uurVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="delete_user.do", method=POST)
	public String updateUserResign(UpdateUserResignVO uurVO, Model model) {
		//���� ������ ���������� ������ Ŭ���� ��ü
		UserDetailService uds = new UserDetailService();
		int flag = uds.resignUser(uurVO);
		model.addAttribute("user_deleteFlag", flag);
		
		return "redirect:process_result.do";
	}//updateUserResign
		
}//class
