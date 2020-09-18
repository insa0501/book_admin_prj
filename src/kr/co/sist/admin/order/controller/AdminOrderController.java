package kr.co.sist.admin.order.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.order.vo.SelectDataVO;
import kr.co.sist.admin.order.vo.UpdateOrderVO;

@Controller
public class AdminOrderController {
	
	@RequestMapping(value="/select_order_list.do", method=GET)
	public String selectOrderList(String currentPage, SelectDataVO sdVO , Model model) {
		return "";
	}//selectOrderList
	
	@RequestMapping(value="select_order_detail.do", method=GET)
	public String selectOrderDetail(int order_no, Model model) {
		return "";
	}//selectOrderDetail
	
	@RequestMapping(value="/update_order.do", method=GET)
	public String updateOrder(UpdateOrderVO uoVO, Model model) {
		return "";
	}//updateOrder
	
	@RequestMapping(value="delete_order.do", method=GET)
	public String deleteOrder(int order_no, Model model) {
		return "";
	}//deleteOrder
	
}
