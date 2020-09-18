package kr.co.sist.admin.user.vo;

public class UpdateUserResignVO {
	private String user_id, user_resdata;

	public UpdateUserResignVO() {
	}

	public UpdateUserResignVO(String user_id, String user_resdata) {
		this.user_id = user_id;
		this.user_resdata = user_resdata;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_resdata() {
		return user_resdata;
	}

	public void setUser_resdata(String user_resdata) {
		this.user_resdata = user_resdata;
	}
	
}
