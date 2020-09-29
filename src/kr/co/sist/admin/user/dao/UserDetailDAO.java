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
	
	public static UserDetailDAO getInstance() {
		if(udDAO ==null) {
			udDAO = new UserDetailDAO();
		}//end if
		return udDAO;
	}//getInstance
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		if(ssf==null) {
			//1. xml과 연결
			String xmlConfig="kr/co/sist/admin/mybatis_config.xml";
			Reader reader = Resources.getResourceAsReader(xmlConfig);
			//2. MyBatis Framework 생성
			ssf = new SqlSessionFactoryBuilder().build(reader);
			reader.close();//xml을 읽어들인 스트림을 끊는다.
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
	 * 회원정보 변경
	 * @param uoVO
	 * @return
	 */
	public int updateUser(UpdateUserVO uuVO) {
		int cnt = 0;
		SqlSession ss = getSqlSession();
		cnt = ss.update("kr.co.sist.admin.user.userUpdate", uuVO );
		//트랜잭션 처리
		ss.commit();
		//SqlSession 끊기
		ss.close();
		return cnt;
	}//updateUser
	
	/**
	 * 회원 탈퇴
	 * @param uurVO
	 * @return
	 */
	public int updateUserResign(UpdateUserResignVO uurVO) {
		int cnt = 0;
		SqlSession ss = getSqlSession();
		cnt = ss.update("kr.co.sist.admin.user.userResignUpdate", uurVO.getResign_id() );
		ss.insert("kr.co.sist.admin.user.userResignInsert",uurVO);
		//트랜잭션 처리
		ss.commit();
		//SqlSession 끊기
		ss.close();
		return cnt;
	}//updateUserResign
	
}//class
