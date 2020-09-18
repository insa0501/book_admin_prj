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
import kr.co.sist.admin.qna.vo.QnaListRangeVO;
import kr.co.sist.admin.qna.vo.SelectDataVO;

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
			//1. xml과 연결
			String xmlConfig = "kr/co/sist/dao/mybatis_config.xml";///////////////////////////////////////////    수정필요!!!!
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
	
	public int selectQnaCount(SelectDataVO sdVO) {
		int cnt = 0;
		
		return cnt;
	}//selectQnaCount
	
	public List<QnaListDomain> selectQnaList(SelectDataVO sdVO, QnaListRangeVO qlrVO) {
		List<QnaListDomain> list = new ArrayList<QnaListDomain>();
		
		return list;
	}//selectQnaList
	
	public QnaDetailDomain selectQnaDetail(int qna_no) {
		QnaDetailDomain qdDomain = null;
		
		return qdDomain;
	}//selectQnaDetail
	
}//class
