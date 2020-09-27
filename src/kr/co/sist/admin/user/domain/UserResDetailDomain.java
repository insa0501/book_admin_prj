package kr.co.sist.admin.user.domain;

public class UserResDetailDomain {
	private String user_id, user_ip,user_status, user_resign_date;

	public UserResDetailDomain() {
	}

	public UserResDetailDomain(String user_id, String user_ip, String user_status, String user_resign_date) {
		this.user_id = user_id;
		this.user_ip = user_ip;
		this.user_status = user_status;
		this.user_resign_date = user_resign_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_ip() {
		return user_ip;
	}

	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

	public String getUser_resign_date() {
		return user_resign_date;
	}

	public void setUser_resign_date(String user_resign_date) {
		this.user_resign_date = user_resign_date;
	}


	
	

}
