package kr.co.sist.admin.qna.vo;

public class PageNationVO {
	String url, selectType, selectData;
	int currentPage, totalPage;
	
	public PageNationVO() {
	}
	
	public PageNationVO(String url, String selectType, String selectData, int currentPage, int totalPage) {
		super();
		this.url = url;
		this.selectType = selectType;
		this.selectData = selectData;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
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
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
