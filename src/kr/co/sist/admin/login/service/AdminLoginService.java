package kr.co.sist.admin.login.service;

import kr.co.sist.admin.login.dao.AdminLoginDAO;
import kr.co.sist.admin.login.vo.AdminLoginVO;
import kr.co.sist.admin.login.vo.UpdateAdminPassVO;

public class AdminLoginService {
	/**
	 * ������ �α���
	 * @param alVO
	 * @return
	 */
	public String adminLogin(AdminLoginVO alVO) {
		String admin_id = "";
		
		admin_id = AdminLoginDAO.getInstance().selectAdminId(alVO);
		
		return admin_id;
	} // adminLogin()
	
	/**
	 * Method : ������ ��й�ȣ ����
	 * �ۼ��� : ��ȿ��
	 * �����̷� : 2020-10-08
	 * @param uapVO
	 * @return
	 */
	public int changeAdminPass(UpdateAdminPassVO uapVO) {
		int cnt = 0;
		
		cnt = AdminLoginDAO.getInstance().updateAdminPass(uapVO);
		
		return cnt;
	} // changeAdminPass
} // class