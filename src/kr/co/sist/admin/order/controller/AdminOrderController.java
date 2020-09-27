package kr.co.sist.admin.order.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.order.domain.OrderListDomain;
import kr.co.sist.admin.order.service.OrderListService;
import kr.co.sist.admin.order.vo.OrderSearchVO;
import kr.co.sist.admin.order.vo.PageNationVO;
import kr.co.sist.admin.order.vo.RangeVO;
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
	public String selectOrderList(SelectOrderListVO solVO, Model model) {
		OrderListService ols = new OrderListService();
		
		int totalCount = ols.totalCount(solVO); // 조회된 주문내역의 갯수
		int pageScale = ols.pageScale(); // 페이지마다 보여줄 내역의 갯수 
		int totalPage = ols.totalPage(totalCount, pageScale); // 총 페이지 수
		if (solVO.getCurrentPage() == 0) { // 현재페이지가 없다면
			solVO.setCurrentPage(1); // 1로 설정
		} // end if
		int currentPage = solVO.getCurrentPage(); // 현재페이지
		int startNum = ols.startNum(currentPage, pageScale);
		
		solVO.setStartNum(startNum); // 페이지의 주문내역 시작번호
		solVO.setEndNum(ols.endNum(startNum, pageScale)); // 끝번호
		
		PageNationVO pnVO = new PageNationVO("", currentPage, totalPage); // 페이징을 위한 VO에 값 설정
		
		String indexList = ols.pageNation(pnVO); // 페이징 된 값을 저장
		
		List<OrderListDomain> list = ols.searchOrderList(solVO); // DB내역을 조회하여 리스트에 저장
				
		model.addAttribute("order_list", list);
		model.addAttribute("indexList", indexList);
		
		return "order/admin_mgr_order";
	}//selectOrderListwww
	
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
