package kr.co.sist.admin.qna.domain;

public class QnaDetailDomain {
	private String user_id, qna_subject, qna_content, qna_type, qna_answer, qna_input_date, qna_reply_date, qna_ip;
	private int qna_no;
	
	public QnaDetailDomain() {
	}

	public QnaDetailDomain(String user_id, String qna_subject, String qna_content, String qna_type, String qna_answer,
			String qna_input_date, String qna_reply_date, String qna_ip, int qna_no) {
		this.user_id = user_id;
		this.qna_subject = qna_subject;
		this.qna_content = qna_content;
		this.qna_type = qna_type;
		this.qna_answer = qna_answer;
		this.qna_input_date = qna_input_date;
		this.qna_reply_date = qna_reply_date;
		this.qna_ip = qna_ip;
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

	public String getQna_content() {
		return qna_content;
	}

	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}

	public String getQna_type() {
		return qna_type;
	}

	public void setQna_type(String qna_type) {
		this.qna_type = qna_type;
	}

	public String getQna_answer() {
		return qna_answer;
	}

	public void setQna_answer(String qna_answer) {
		this.qna_answer = qna_answer;
	}

	public String getQna_input_date() {
		return qna_input_date;
	}

	public void setQna_input_date(String qna_input_date) {
		this.qna_input_date = qna_input_date;
	}

	public String getQna_reply_date() {
		return qna_reply_date;
	}

	public void setQna_reply_date(String qna_reply_date) {
		this.qna_reply_date = qna_reply_date;
	}

	public String getQna_ip() {
		return qna_ip;
	}

	public void setQna_ip(String qna_ip) {
		this.qna_ip = qna_ip;
	}

	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	
	
	
}
