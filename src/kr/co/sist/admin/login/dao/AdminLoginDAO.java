package kr.co.sist.admin.login.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.admin.login.vo.AdminLoginVO;
import kr.co.sist.admin.login.vo.UpdateAdminPassVO;

public class AdminLoginDAO {
	private static AdminLoginDAO a_loginDAO;
	private static SqlSessionFactory ssf;
	
	private AdminLoginDAO() {
	}
	
	public static AdminLoginDAO getInstance() {
		if (a_loginDAO == null) {
			a_loginDAO = new AdminLoginDAO();
		}
		return a_loginDAO; 
	} // getInstance()
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException{
		
		if (ssf == null) {
			// xml과 연결
			String xmlConfig="kr/co/sist/admin/mybatis_config.xml";
			Reader reader = Resources.getResourceAsReader(xmlConfig);
			
			// Mybatis Framework 생성
			ssf = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} // end if
		return ssf;
	} // getSqlSessionFactory()
	
	public SqlSession getSqlSession() {
		SqlSession ss = null;
		
		try {
			ss = getSqlSessionFactory().openSession();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch
		
		return ss;
	} // getSqlSession()
	
	/**
	 * 관리자 로그인
	 * @param alVO
	 * @return admin_id
	 * @throws SQLException
	 */
	public String selectAdminId(AdminLoginVO alVO) {
		String admin_id = "";
		
		admin_id = getSqlSession().selectOne("kr.co.sist.admin.login.adminLogin", alVO);
		
		return admin_id;
	} // selectAdminId
	
	/**
	 * Method : 관리자 비밀번호 변경
	 * 작성자 : 김효준
	 * 변경이력 : 2020-10-08
	 * @param uapVO
	 * @return 
	 * @throws SQLException
	 */
	public int updateAdminPass(UpdateAdminPassVO uapVO) {
		int cnt = 0;
		SqlSession ss = getSqlSession();
		cnt = ss.update("kr.co.sist.admin.login.updateAdminPass", uapVO);
		ss.commit();
		ss.close();
		return cnt;
	} //updateAdminPass
} // class