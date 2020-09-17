package kr.co.sist.admin.book.vo;

public class BookRangeVO {
	String startNum, endNum;

	public BookRangeVO() {
	}

	public BookRangeVO(String startNum, String endNum) {
		this.startNum = startNum;
		this.endNum = endNum;
	}

	public String getStartNum() {
		return startNum;
	}

	public void setStartNum(String startNum) {
		this.startNum = startNum;
	}

	public String getEndNum() {
		return endNum;
	}

	public void setEndNum(String endNum) {
		this.endNum = endNum;
	}
	
}
