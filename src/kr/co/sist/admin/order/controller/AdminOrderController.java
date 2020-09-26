package kr.co.sist.admin.order.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.order.vo.SelectOrderListVO;
import kr.co.sist.admin.order.vo.UpdateOrderVO;

@Controller
public class AdminOrderController {
	
	/**
	 * 주문관리 페이지
	 * @param currentPage
	 * @param sdVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/select_order_list.do", method=GET)
	public String selectOrderList(SelectOrderListVO solVO , Model model) {
		return "order/admin_mgr_order";
	}//selectOrderList
	
	/**
	 * 주문상세정보 페이지
	 * @param order_no
	 * @param model
	 * @return
	 */
	@RequestMapping(value="select_order_detail.do", method=GET)
	public String selectOrderDetail(int order_no, Model model) {
		return "";
	}//selectOrderDetail
	
	/**
	 * 주문정보 변경 프로세스
	 * @param uoVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update_order.do", method=GET)
	public String updateOrder(UpdateOrderVO uoVO, Model model) {
		return "";
	}//updateOrder
	
	/**
	 * 주문 삭제 프로세스
	 * @param order_no
	 * @param model
	 * @return
	 */
	@RequestMapping(value="delete_order.do", method=GET)
	public String deleteOrder(int order_no, Model model) {
		return "";
	}//deleteOrder
	
}
