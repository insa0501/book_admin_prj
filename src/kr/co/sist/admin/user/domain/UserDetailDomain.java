package kr.co.sist.admin.user.domain;

public class UserDetailDomain {
	private String user_name, user_phone, user_ip, user_zipcode, user_addr1, user_addr2,
		user_hiredate, user_resdata, user_resign_date;

	public UserDetailDomain() {
	}

	public UserDetailDomain(String user_name, String user_phone, String user_ip, String user_zipcode, String user_addr1,
			String user_addr2, String user_hiredate, String user_resdata, String user_resign_date) {
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_ip = user_ip;
		this.user_zipcode = user_zipcode;
		this.user_addr1 = user_addr1;
		this.user_addr2 = user_addr2;
		this.user_hiredate = user_hiredate;
		this.user_resdata = user_resdata;
		this.user_resign_date = user_resign_date;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_ip() {
		return user_ip;
	}

	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}

	public String getUser_zipcode() {
		return user_zipcode;
	}

	public void setUser_zipcode(String user_zipcode) {
		this.user_zipcode = user_zipcode;
	}

	public String getUser_addr1() {
		return user_addr1;
	}

	public void setUser_addr1(String user_addr1) {
		this.user_addr1 = user_addr1;
	}

	public String getUser_addr2() {
		return user_addr2;
	}

	public void setUser_addr2(String user_addr2) {
		this.user_addr2 = user_addr2;
	}

	public String getUser_hiredate() {
		return user_hiredate;
	}

	public void setUser_hiredate(String user_hiredate) {
		this.user_hiredate = user_hiredate;
	}

	public String getUser_resdata() {
		return user_resdata;
	}

	public void setUser_resdata(String user_resdata) {
		this.user_resdata = user_resdata;
	}

	public String getUser_resign_date() {
		return user_resign_date;
	}

	public void setUser_resign_date(String user_resign_date) {
		this.user_resign_date = user_resign_date;
	}
	
	
}
