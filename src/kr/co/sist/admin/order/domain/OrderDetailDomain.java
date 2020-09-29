package kr.co.sist.admin.order.domain;

import java.util.List;

import kr.co.sist.admin.order.vo.OrderBookVO;

public class OrderDetailDomain {
	private String order_date, order_status, user_id, order_phone, 
					order_zipcode, order_addr1, order_addr2, user_ip, card_info;
	private int order_no, order_price;
	private List<OrderBookVO> orderBookList;
	
	public String getCard_info() {
		return card_info;
	}

	public void setCard_info(String card_info) {
		this.card_info = card_info;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getOrder_phone() {
		return order_phone;
	}

	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}

	public String getOrder_zipcode() {
		return order_zipcode;
	}

	public void setOrder_zipcode(String order_zipcode) {
		this.order_zipcode = order_zipcode;
	}

	public String getOrder_addr1() {
		return order_addr1;
	}

	public void setOrder_addr1(String order_addr1) {
		this.order_addr1 = order_addr1;
	}

	public String getOrder_addr2() {
		return order_addr2;
	}

	public void setOrder_addr2(String order_addr2) {
		this.order_addr2 = order_addr2;
	}

	public String getUser_ip() {
		return user_ip;
	}

	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}

	public int getOrder_price() {
		return order_price;
	}

	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}

	public List<OrderBookVO> getOrderBookList() {
		return orderBookList;
	}

	public void setOrderBookList(List<OrderBookVO> orderBookList) {
		this.orderBookList = orderBookList;
	}
	
} // class
