package kr.co.sist.admin.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.admin.user.domain.UserDetailDomain;
import kr.co.sist.admin.user.domain.UserListDomain;
import kr.co.sist.admin.user.domain.UserResDetailDomain;
import kr.co.sist.admin.user.vo.SelectUserListVO;

public class UserListDAO {
	
	private static UserListDAO ulDAO;
	private static SqlSessionFactory ssf;
	
	private UserListDAO() {
	}//UserListDAO
	
	public static UserListDAO getInstance() {
		if(ulDAO ==null) {
			ulDAO = new UserListDAO();
		}//end if
		return ulDAO;
	}//getInstance
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		if(ssf==null) {
			//1. xml�� ����
			String xmlConfig="kr/co/sist/admin/mybatis_config.xml";
			Reader reader = Resources.getResourceAsReader(xmlConfig);
			//2. MyBatis Framework ����
			ssf = new SqlSessionFactoryBuilder().build(reader);
			reader.close();//xml�� �о���� ��Ʈ���� ���´�.
		}//end if
		return ssf;
	}//getSqlSessionFactory
	
	public SqlSession getSqlSession() {
		SqlSession ss = null;
		
		try {
			ss = getSqlSessionFactory().openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ss;
	}//getSqlSession
	
	/**
	 * Method : ȸ������ �� ���� ���ϱ�
	 * �ۼ��� : ��ȿ��
	 * �����̷� : 2020-10-08
	 * @param sdVO
	 * @return
	 */
	public int selectUserCount(SelectUserListVO sulVO) {
		int cnt = 0;
		SqlSession ss = getSqlSession();
		if("user_status".equals(sulVO.getSelectType())) {
			String setData = "ȸ��".equals(sulVO.getSelectData()) ? "Y" : "N";
			sulVO.setSelectData(setData);
		}
		cnt = ss.selectOne("kr.co.sist.admin.user.userCnt", sulVO);
		
		ss.close();
		return cnt;
	}//selectUserCount
	
	/**
	 * Method : ȸ������ ����Ʈ
	 * �ۼ��� : ��ȿ��
	 * �����̷� : 2020-10-08
	 * @param sdVO
	 * @param olrVO
	 * @return
	 */
	public List<UserListDomain> selectUserList(SelectUserListVO sulVO) {
		List<UserListDomain> list = new ArrayList<UserListDomain>();
		SqlSession ss = getSqlSession();
		
		list = ss.selectList("kr.co.sist.admin.user.userList", sulVO);
		
		ss.close();
		return list;
	}//selectUserList
	
	/**
	 * Method : ȸ�� �� ����
	 * �ۼ��� : ��ȿ��
	 * �����̷� : 2020-10-08
	 * @param user_id
	 * @return
	 */
	public UserDetailDomain selectUserDetail(String user_id) {
		UserDetailDomain udDomain = null;
		SqlSession ss = getSqlSession();
		
		udDomain = ss.selectOne("kr.co.sist.admin.user.userDetail",user_id);
		
		ss.close();
		return udDomain;
	}//selectUserDetail
	
	/**
	 * Method : Ż���� ȸ�� �� ����
	 * �ۼ��� : ��ȿ��
	 * �����̷� : 2020-10-08
	 * @param user_id
	 * @return
	 */
	public UserResDetailDomain selectResDetail(String user_id) {
		UserResDetailDomain list = null;
		SqlSession ss = getSqlSession();
		list = ss.selectOne("kr.co.sist.admin.user.userResDetail",user_id);
		ss.close();
		return list;
	}
	public List<String> selectResData(String user_id) {
		List<String> list = null;
		SqlSession ss = getSqlSession();
		list = ss.selectList("kr.co.sist.admin.user.userResData",user_id);
		ss.close();
		return list;
	}
	
	
}//class
