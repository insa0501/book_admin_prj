package kr.co.sist.admin.user.vo;

public class UpdateUserResignVO {
	private String resign_id, user_resdata;

	public UpdateUserResignVO() {
	}

	public UpdateUserResignVO(String resign_id, String user_resdata) {
		this.resign_id = resign_id;
		this.user_resdata = user_resdata;
	}

	public String getResign_id() {
		return resign_id;
	}

	public void setResign_id(String resign_id) {
		this.resign_id = resign_id;
	}

	public String getUser_resdata() {
		return user_resdata;
	}

	public void setUser_resdata(String user_resdata) {
		this.user_resdata = user_resdata;
	}

	
}
