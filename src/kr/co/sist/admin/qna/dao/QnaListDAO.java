package kr.co.sist.admin.qna.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.admin.qna.domain.QnaDetailDomain;
import kr.co.sist.admin.qna.domain.QnaListDomain;
import kr.co.sist.admin.qna.vo.SelectQnaListVO;

public class QnaListDAO {
	
	private static QnaListDAO qlDAO;
	private static SqlSessionFactory ssf;
	
	private QnaListDAO() {
	}//QnaListDAO
	
	private static QnaListDAO getInstance() {
		if(qlDAO ==null) {
			qlDAO = new QnaListDAO();
		}//end if
		return qlDAO;
	}//getInstance
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		if(ssf==null) {
			//1. xml�� ����
			String xmlConfig = "kr/co/sist/dao/mybatis_config.xml";///////////////////////////////////////////    �����ʿ�!!!!
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
	 * ���� �� ���� ���ϱ�
	 * @param sdVO
	 * @return
	 */
	public int selectQnaCount(SelectQnaListVO sqlVO) {
		int cnt = 0;
		
		return cnt;
	}//selectQnaCount
	
	/**
	 * �������� ����Ʈ
	 * @param sdVO
	 * @param qlrVO
	 * @return
	 */
	public List<QnaListDomain> selectQnaList(SelectQnaListVO sqlVO) {
		List<QnaListDomain> list = new ArrayList<QnaListDomain>();
		
		return list;
	}//selectQnaList
	
	/**
	 * ���ǻ�����
	 * @param qna_no
	 * @return
	 */
	public QnaDetailDomain selectQnaDetail(int qna_no) {
		QnaDetailDomain qdDomain = null;
		
		return qdDomain;
	}//selectQnaDetail
	
}//class