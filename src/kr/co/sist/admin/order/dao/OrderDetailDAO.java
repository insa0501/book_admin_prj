package kr.co.sist.admin.order.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.admin.order.vo.UpdateOrderVO;

public class OrderDetailDAO {

	private static OrderDetailDAO odDAO;
	private static SqlSessionFactory ssf;
	
	private OrderDetailDAO() {
	}//OrderListDAO
	
	public static OrderDetailDAO getInstance() {
		if(odDAO ==null) {
			odDAO = new OrderDetailDAO();
		}//end if
		return odDAO;
	}//getInstance
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		if(ssf==null) {
			//1. xml�� ����
			String xmlConfig = "kr/co/sist/admin/mybatis_config.xml";	///////////////////////////////////////////    �����ʿ�!!!!
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
	 * �ֹ����� ����
	 * @param uoVO
	 * @return
	 */
	public int updateOrder(UpdateOrderVO uoVO) {
		int cnt = 0;
		
		SqlSession ss = getSqlSession();
		cnt = ss.update("orderDetail_update", uoVO);
		
		if (cnt == 1) {
			ss.commit();
		} // end if
		
		ss.close();
		
		return cnt;
	}//updateOrder
	
	/**
	 * �ֹ����� ����
	 * @param order_no
	 * @return
	 */
	public int deleteOrder(int order_no) {
		int cnt = 0;
		
		SqlSession ss = getSqlSession();
		cnt = ss.delete("order_delete", order_no);
		
		if (cnt == 1) {
			ss.commit();
		} // end if
		
		ss.close();
		
		return cnt;
	}//deleteOrder
	
	public static void main(String[] args) {
//		UpdateOrderVO uoVO = new UpdateOrderVO();
//		uoVO.setOrder_no(3);
//		uoVO.setOrder_status("1");
//		
		System.out.println(new OrderDetailDAO().getInstance().deleteOrder(4));
		
		
	} // main
}//class
