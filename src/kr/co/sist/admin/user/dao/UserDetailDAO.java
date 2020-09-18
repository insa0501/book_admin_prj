package kr.co.sist.admin.user.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.admin.user.vo.UpdateUserResignVO;
import kr.co.sist.admin.user.vo.UpdateUserVO;

public class UserDetailDAO {

	private static UserDetailDAO udDAO;
	private static SqlSessionFactory ssf;
	
	private UserDetailDAO() {
	}//UserListDAO
	
	private static UserDetailDAO getInstance() {
		if(udDAO ==null) {
			udDAO = new UserDetailDAO();
		}//end if
		return udDAO;
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
	
	public int updateUser(UpdateUserVO uoVO) {
		int cnt = 0;
		
		return cnt;
	}//updateUser
	
	public int updateUserResign(UpdateUserResignVO uurVO) {
		int cnt = 0;
		
		return cnt;
	}//updateUserResign
	
}//class
