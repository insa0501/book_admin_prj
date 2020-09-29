package kr.co.sist.admin.user.service;

import kr.co.sist.admin.user.dao.UserDetailDAO;
import kr.co.sist.admin.user.vo.UpdateUserResignVO;
import kr.co.sist.admin.user.vo.UpdateUserVO;

public class UserDetailService {

	/**
	 * È¸¿øÁ¤º¸ º¯°æ
	 * @param uuVO
	 * @return
	 */
	public int changeUserData(UpdateUserVO uuVO) {
		int cnt = 0;
		UserDetailDAO udd = UserDetailDAO.getInstance();
		cnt = udd.updateUser(uuVO);
		
		return cnt;
	}//changeUser
	
	/**
	 * È¸¿ø Å»Åð
	 * @param uurVO
	 * @return
	 */
	public int resignUser(UpdateUserResignVO uurVO) {
		int flag = 0;
		UserDetailDAO udd = UserDetailDAO.getInstance();
		flag = udd.updateUserResign(uurVO);
		return flag;
	}//resignUser
	
}//class
