package kr.co.sist.admin.order.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.order.domain.OrderDetailDomain;
import kr.co.sist.admin.order.domain.OrderListDomain;
import kr.co.sist.admin.order.service.OrderDetailService;
import kr.co.sist.admin.order.service.OrderListService;
import kr.co.sist.admin.order.vo.OrderSearchVO;
import kr.co.sist.admin.order.vo.PageNationVO;
import kr.co.sist.admin.order.vo.RangeVO;
import kr.co.sist.admin.order.vo.SelectOrderListVO;
import kr.co.sist.admin.order.vo.UpdateOrderVO;

@Controller
public class AdminOrderController {
	
	/**
	 * �ֹ����� ������
	 * @param currentPage
	 * @param sdVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/order_list.do", method=GET)
	public String selectOrderList(SelectOrderListVO solVO, Model model) {
		OrderListService ols = new OrderListService();
		
		int totalCount = ols.totalCount(solVO); // ��ȸ�� �ֹ������� ����
		int pageScale = ols.pageScale(); // ���������� ������ ������ ���� 
		int totalPage = ols.totalPage(totalCount, pageScale); // �� ������ ��
		if (solVO.getCurrentPage() == 0) { // ������������ ���ٸ�
			solVO.setCurrentPage(1); // 1�� ����
		} // end if
		int currentPage = solVO.getCurrentPage(); // ����������
		int startNum = ols.startNum(currentPage, pageScale);
		int endNum = ols.endNum(startNum, pageScale);
		
		
		solVO.setStartNum(startNum); // �������� �ֹ����� ���۹�ȣ
		solVO.setEndNum(endNum); // ����ȣ
		
		PageNationVO pnVO = new PageNationVO("", currentPage, totalPage); // ����¡�� ���� VO�� �� ����
		
		String indexList = ols.pageNation(pnVO); // ����¡ �� ���� ����
		model.addAttribute("indexList", indexList);
		
		List<OrderListDomain> list = ols.searchOrderList(solVO); // DB������ ��ȸ�Ͽ� ����Ʈ�� ����
		model.addAttribute("order_list", list);
		
		
		return "order/admin_mgr_order";
	}//selectOrderListwww
	
	/**
	 * �ֹ������� ������
	 * @param order_no
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/order_detail.do", method= {GET, POST})
	public String selectOrderDetail(int order_no, Model model) {
		
		OrderListService ols = new OrderListService();
		OrderDetailDomain odd = ols.searchOrderDetail(order_no);
		
		model.addAttribute("order_info", odd);
		
		return "order/admin_order_detail_info";
	}//selectOrderDetail
	
	/**
	 * �ֹ����� ���� ���μ���
	 * @param uoVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update_order.do", method=POST)
	public String updateOrder(UpdateOrderVO uoVO, Model model) {
		
		String msg = "fail";
		
		OrderDetailService ods = new OrderDetailService();
		
		if (ods.changeOrderData(uoVO)) {
			msg = "success";
		} // end if
		
		model.addAttribute("update_msg", msg);
		
		return "forward:order_detail.do";
	}//updateOrder
	
	/**
	 * �ֹ� ���� ���μ���
	 * @param order_no
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/delete_order.do", method=GET)
	public String deleteOrder(int order_no, Model model) {
		String msg = "fail";
		
		OrderDetailService ods = new OrderDetailService();
		
		if (ods.removeOrder(order_no)) {
			msg = "success";
		} // end if
		
		model.addAttribute("update_msg", msg);
		
		return ""; // �ֹ����� ����Ʈ�� �̵��ϰ� alert ��� ���� �ڵ� �����
	}//deleteOrder
	
}
