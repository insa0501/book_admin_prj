package kr.co.sist.admin.qna.vo;

public class UpdateQnaAnswerVO {
	private String qna_answer, admin_id;
	private int qna_no;
	
	public UpdateQnaAnswerVO() {
	}

	public UpdateQnaAnswerVO(String qna_answer, String admin_id, int qna_no) {
		this.qna_answer = qna_answer;
		this.admin_id = admin_id;
		this.qna_no = qna_no;
	}

	public String getQna_answer() {
		return qna_answer;
	}

	public void setQna_answer(String qna_answer) {
		this.qna_answer = qna_answer;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	
	
	
}
