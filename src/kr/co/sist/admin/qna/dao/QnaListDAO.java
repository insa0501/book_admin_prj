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
	
	public static QnaListDAO getInstance() {
		if(qlDAO ==null) {
			qlDAO = new QnaListDAO();
		}//end if
		return qlDAO;
	}//getInstance
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		if(ssf==null) {
			//1. xml과 연결
			String xmlConfig = "kr/co/sist/admin/mybatis_config.xml";
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
	 * 문의 총 개수 구하기
	 * @param sdVO
	 * @return
	 */
	public int selectQnaCount(SelectQnaListVO sqlVO) {
		int cnt = 0;
		
		SqlSession ss = getSqlSession();
		cnt = ss.selectOne("kr.co.sist.admin.qna.qnaListCnt", sqlVO);
		
		return cnt;
	}//selectQnaCount
	
	/**
	 * 문의정보 리스트
	 * @param sdVO
	 * @param qlrVO
	 * @return
	 */
	public List<QnaListDomain> selectQnaList(SelectQnaListVO sqlVO) {
		List<QnaListDomain> list = new ArrayList<QnaListDomain>();
		
		SqlSession ss = getSqlSession();
		list = ss.selectList("kr.co.sist.admin.qna.qnaList", sqlVO);
		
		return list;
	}//selectQnaList
	
	/**
	 * 문의상세정보
	 * @param qna_no
	 * @return
	 */
	public QnaDetailDomain selectQnaDetail(int qna_no) {
		QnaDetailDomain qdd = null;
		
		SqlSession ss = getSqlSession();
		qdd = ss.selectOne("kr.co.sist.admin.qna.qnaDetail", qna_no);
		
		return qdd;
	}//selectQnaDetail
	
}//class
