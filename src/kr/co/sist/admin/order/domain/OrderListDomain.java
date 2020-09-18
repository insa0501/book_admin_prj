package kr.co.sist.admin.order.domain;

public class OrderListDomain {
	private String book_name, user_id, order_status, order_date;
	private int order_no, order_price;
	
	public OrderListDomain() {
	}
	
	public OrderListDomain(String book_name, String user_id, String order_status, String order_date,
			int order_no, int order_price) {
		this.book_name = book_name;
		this.user_id = user_id;
		this.order_status = order_status;
		this.order_date = order_date;
		this.order_no = order_no;
		this.order_price = order_price;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public int getOrder_price() {
		return order_price;
	}

	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	
	
	
}
