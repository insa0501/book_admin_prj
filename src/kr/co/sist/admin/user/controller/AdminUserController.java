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
	 * ȸ������ ����Ʈ ������
	 * @param currentPage
	 * @param sdVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/user_list.do", method=GET)
	public String selectUserList(SelectUserListVO sulVO, Model model) {
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
		PageNationVO pnVO = new PageNationVO("", currentPage, totalPage);
		String pageNation = uls.pageNation(pnVO);
		model.addAttribute("page_nation",pageNation);
		
		List<UserListDomain> list = uls.searchUserList(sulVO);
		model.addAttribute("user_list",list);
		
		
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
		return "user/detail";
	}//selectUserDetail
	
	/**
	 * ȸ������ ���� ���μ���
	 * @param uuVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update_user.do", method=GET)
	public String updateUser(UpdateUserVO uuVO, Model model) {
		return "";
	}//updateUser
	
	/**
	 * ȸ�� Ż�� ���μ���
	 * @param uurVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="user_resign.do", method=GET)
	public String updateUserResign(UpdateUserResignVO uurVO, Model model) {
		return "user/res_detail";
	}//updateUserResign
	
}//class
