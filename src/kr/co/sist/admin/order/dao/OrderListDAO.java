package kr.co.sist.admin.order.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.admin.order.domain.OrderDetailDomain;
import kr.co.sist.admin.order.domain.OrderListDomain;
import kr.co.sist.admin.order.vo.OrderListRangeVO;
import kr.co.sist.admin.order.vo.SelectDataVO;

public class OrderListDAO {
	
	private static OrderListDAO olDAO;
	private static SqlSessionFactory ssf;
	
	private OrderListDAO() {
	}//OrderListDAO
	
	private static OrderListDAO getInstance() {
		if(olDAO ==null) {
			olDAO = new OrderListDAO();
		}//end if
		return olDAO;
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
	
	public int selectOrderCount(SelectDataVO sdVO) {
		int cnt = 0;
		
		return cnt;
	}//selectOrderCount
	
	public List<OrderListDomain> selectOrderList(SelectDataVO sdVO, OrderListRangeVO olrVO) {
		List<OrderListDomain> list = new ArrayList<OrderListDomain>();
		
		return list;
	}//selectOrderList
	
	public OrderDetailDomain selectOrderDetail(int order_no) {
		OrderDetailDomain odDomain = null;
		
		return odDomain;
	}//selectOrderDetail
	
}//class
