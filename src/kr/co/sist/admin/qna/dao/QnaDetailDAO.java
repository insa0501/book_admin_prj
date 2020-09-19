package kr.co.sist.admin.qna.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.admin.qna.vo.UpdateQnaAnswerVO;

public class QnaDetailDAO {

	private static QnaDetailDAO qdDAO;
	private static SqlSessionFactory ssf;
	
	private QnaDetailDAO() {
	}//qnaListDAO
	
	private static QnaDetailDAO getInstance() {
		if(qdDAO ==null) {
			qdDAO = new QnaDetailDAO();
		}//end if
		return qdDAO;
	}//getInstance
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		if(ssf==null) {
			//1. xml과 연결
			String xmlConfig = "kr/co/sist/dao/mybatis_config.xml";	///////////////////////////////////////////    수정필요!!!!
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
	 * 문의 답변 달기
	 * @param uqaVO
	 * @return
	 */
	public int updateQnaAnswer(UpdateQnaAnswerVO uqaVO) {
		int cnt = 0;
		
		return cnt;
	}//updateQnaAnswer
	
	/**
	 * 문의 삭제
	 * @param qna_no
	 * @return
	 */
	public int deleteQna(int qna_no) {
		int cnt = 0;
		
		return cnt;
	}//updateQnaDelete
	
}//class
