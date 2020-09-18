package kr.co.sist.admin.qna.vo;

public class SelectDataVO {
	private String selectType, selectData;

	public SelectDataVO() {
	}

	public SelectDataVO(String selectType, String selectData) {
		this.selectType = selectType;
		this.selectData = selectData;
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
	
	
}
