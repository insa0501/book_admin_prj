package kr.co.sist.admin.book.vo;

public class SelectBookListVO {
	private String selectType, selectData;
	private int currentPage, startNum, endNum;
	
	
	public SelectBookListVO() {
	}
	
	public SelectBookListVO(String selectType, String selectData, int currentPage, int startNum, int endNum) {
		super();
		this.selectType = selectType;
		this.selectData = selectData;
		this.currentPage = currentPage;
		this.startNum = startNum;
		this.endNum = endNum;
	}

	public String getSelectType() {
		return selectType;
	}
	public void setSelectType(String selectType) {
		this.selectType = selectType;
	}
	public String getSelectData() {
		return selectData;
	}
	public void setSelectData(String selectData) {
		this.selectData = selectData;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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
