package kr.co.sist.admin.order.vo;

public class UpdateOrderVO {
	private String order_status;
	private int order_no;
	
	public UpdateOrderVO() {
	}
	
	public UpdateOrderVO(String order_status, int order_no) {
		this.order_status = order_status;
		this.order_no = order_no;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	
	
	
}
