package kr.co.sist.admin.user.vo;

public class SelectUserDetailVO {
	private String user_id, user_status;

	public SelectUserDetailVO() {
	}

	public SelectUserDetailVO(String user_id, String user_status) {
		this.user_id = user_id;
		this.user_status = user_status;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	
	
}
