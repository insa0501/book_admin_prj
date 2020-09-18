package kr.co.sist.admin.qna.domain;

public class QnaListDomain {
	private String user_id, qna_subject, qna_type, admin_id, qna_reply_date, qna_input_date;
	int qna_no;
	
	public QnaListDomain() {
	}

	public QnaListDomain(String user_id, String qna_subject, String qna_type, String admin_id, String qna_reply_date,
			String qna_input_date, int qna_no) {
		this.user_id = user_id;
		this.qna_subject = qna_subject;
		this.qna_type = qna_type;
		this.admin_id = admin_id;
		this.qna_reply_date = qna_reply_date;
		this.qna_input_date = qna_input_date;
		this.qna_no = qna_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getQna_subject() {
		return qna_subject;
	}

	public void setQna_subject(String qna_subject) {
		this.qna_subject = qna_subject;
	}

	public String getQna_type() {
		return qna_type;
	}

	public void setQna_type(String qna_type) {
		this.qna_type = qna_type;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getQna_reply_date() {
		return qna_reply_date;
	}

	public void setQna_reply_date(String qna_reply_date) {
		this.qna_reply_date = qna_reply_date;
	}

	public String getQna_input_date() {
		return qna_input_date;
	}

	public void setQna_input_date(String qna_input_date) {
		this.qna_input_date = qna_input_date;
	}

	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	
	
	
}
