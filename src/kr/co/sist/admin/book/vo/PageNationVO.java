package kr.co.sist.admin.book.vo;

public class PageNationVO {
	String url;
	int currentPage, totalPage;
	public PageNationVO() {
	}
	public PageNationVO(String url, int currentPage, int totalPage) {
		this.url = url;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
