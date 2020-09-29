package kr.co.sist.admin.order.service;

import kr.co.sist.admin.order.dao.OrderDetailDAO;
import kr.co.sist.admin.order.vo.UpdateOrderVO;

public class OrderDetailService {

	/**
	 * �ֹ����� ����
	 * @param uoVO
	 * @return
	 */
	public boolean changeOrderData(UpdateOrderVO uoVO) {
		boolean flag = false;
		
		OrderDetailDAO odDAO = OrderDetailDAO.getInstance();
		
		if (odDAO.updateOrder(uoVO) == 1) {
			flag = !flag;
		} // end if
		
		return flag;
	}//changeOrder
	
	/**
	 * �ֹ����� ����
	 * @param order_no
	 * @return
	 */
	public boolean removeOrder(int order_no) {
		boolean flag = false;
		
		OrderDetailDAO odDAO = OrderDetailDAO.getInstance();
		
		if(odDAO.deleteOrder(order_no) == 1) {
			flag = !flag;
		} // end if
		
		return flag;
	}//removeOrder
	
}//class
