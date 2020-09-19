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
import kr.co.sist.admin.user.vo.UserListRangeVO;
import kr.co.sist.admin.user.vo.SelectDataVO;

public class UserListDAO {
	
	private static UserListDAO ulDAO;
	private static SqlSessionFactory ssf;
	
	private UserListDAO() {
	}//UserListDAO
	
	private static UserListDAO getInstance() {
		if(ulDAO ==null) {
			ulDAO = new UserListDAO();
		}//end if
		return ulDAO;
	}//getInstance
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		if(ssf==null) {
			//1. xml�� ����
			String xmlConfig = "kr/co/sist/dao/mybatis_config.xml";	///////////////////////////////////////////    �����ʿ�!!!!
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
	 * ȸ������ �� ���� ���ϱ�
	 * @param sdVO
	 * @return
	 */
	public int selectUserCount(SelectDataVO sdVO) {
		int cnt = 0;
		
		return cnt;
	}//selectUserCount
	
	/**
	 * ȸ������ ����Ʈ
	 * @param sdVO
	 * @param olrVO
	 * @return
	 */
	public List<UserListDomain> selectUserList(SelectDataVO sdVO, UserListRangeVO olrVO) {
		List<UserListDomain> list = new ArrayList<UserListDomain>();
		
		return list;
	}//selectUserList
	
	/**
	 * ȸ��������
	 * @param user_id
	 * @return
	 */
	public UserDetailDomain selectUserDetail(String user_id) {
		UserDetailDomain udDomain = null;
		
		return udDomain;
	}//selectUserDetail
	
}//class
