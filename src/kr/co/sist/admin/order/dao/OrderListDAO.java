package kr.co.sist.admin.order.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.admin.order.domain.OrderDetailDomain;
import kr.co.sist.admin.order.domain.OrderListDomain;
import kr.co.sist.admin.order.vo.OrderBookVO;
import kr.co.sist.admin.order.vo.OrderSearchVO;
import kr.co.sist.admin.order.vo.RangeVO;
import kr.co.sist.admin.order.vo.SelectOrderListVO;

public class OrderListDAO {
	
	private static OrderListDAO olDAO;
	private static SqlSessionFactory ssf;
	
	private OrderListDAO() {
	}//OrderListDAO
	
	public static OrderListDAO getInstance() {
		if(olDAO ==null) {
			olDAO = new OrderListDAO();
		}//end if
		return olDAO;
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
	 * 주문정보 총 개수 구하기
	 * @param sdVO
	 * @return
	 */
	// SelectOrderListVO solVO
	public int selectOrderListCount(SelectOrderListVO solVO) {
		int cnt = 0;
		
		SqlSession ss = getSqlSession();
		cnt = ss.selectList("kr.co.sist.admin.order.orderList", solVO).size();
		
		return cnt;
	}//selectOrderCount
	
	/**
	 * 주문정보 리스트
	 * @param sdVO
	 * @param olrVO
	 * @return
	 */
	//SelectOrderListVO solVO
	public List<OrderListDomain> selectOrderList(SelectOrderListVO solVO) {
		List<OrderListDomain> list = new ArrayList<OrderListDomain>();
		
		SqlSession ss = getSqlSession();
		list = ss.selectList("kr.co.sist.admin.order.orderList", solVO);
		
		return list;
	}//selectOrderList
	
	/**
	 * 주문상세정보
	 * @param order_no
	 * @return
	 */
	public OrderDetailDomain selectOrderDetail(int order_no) {
		OrderDetailDomain odd = null;
		
		SqlSession ss = getSqlSession();
		odd = ss.selectOne("orderDetail", order_no);
		
		odd.setOrderBookList(ss.selectList("orderDetail_bookList", order_no));
		
		ss.close();
		
		return odd;
	}//selectOrderDetail
	
	public static void main(String[] args) {
//		SelectOrderListVO solVO = new SelectOrderListVO();
//		solVO.setSelectType("2");
//		solVO.setSelectData("반짝");
//		System.out.println(new OrderListDAO().selectOrderListCount(solVO));
		OrderListDAO ol = new OrderListDAO();
		OrderDetailDomain odd = ol.selectOrderDetail(2);
		
		for (OrderBookVO ob : odd.getOrderBookList()) {
			System.out.println(ob.getBook_name());
		} // end for
		
	}
}//class
