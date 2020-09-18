package kr.co.sist.admin.qna.vo;

public class QnaListRangeVO {
	private int startNum, endNum;

	public QnaListRangeVO() {
	}

	public QnaListRangeVO(int startNum, int endNum) {
		this.startNum = startNum;
		this.endNum = endNum;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	
	
}
