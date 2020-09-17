package kr.co.sist.admin.book.vo;

public class BookModifyVO {
	String book_isbn, book_name, book_country, book_type_no, book_writer, book_company, book_date, book_info,
			book_best, book_activity, book_img;
	int book_price, book_stock;
	public BookModifyVO() {
	}
	public BookModifyVO(String book_isbn, String book_name, String book_country, String book_type_no,
			String book_writer, String book_company, String book_date, String book_info, String book_best,
			String book_activity, String book_img, int book_price, int book_stock) {
		this.book_isbn = book_isbn;
		this.book_name = book_name;
		this.book_country = book_country;
		this.book_type_no = book_type_no;
		this.book_writer = book_writer;
		this.book_company = book_company;
		this.book_date = book_date;
		this.book_info = book_info;
		this.book_best = book_best;
		this.book_activity = book_activity;
		this.book_img = book_img;
		this.book_price = book_price;
		this.book_stock = book_stock;
	}
	public String getBook_isbn() {
		return book_isbn;
	}
	public void setBook_isbn(String book_isbn) {
		this.book_isbn = book_isbn;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_country() {
		return book_country;
	}
	public void setBook_country(String book_country) {
		this.book_country = book_country;
	}
	public String getBook_type_no() {
		return book_type_no;
	}
	public void setBook_type_no(String book_type_no) {
		this.book_type_no = book_type_no;
	}
	public String getBook_writer() {
		return book_writer;
	}
	public void setBook_writer(String book_writer) {
		this.book_writer = book_writer;
	}
	public String getBook_company() {
		return book_company;
	}
	public void setBook_company(String book_company) {
		this.book_company = book_company;
	}
	public String getBook_date() {
		return book_date;
	}
	public void setBook_date(String book_date) {
		this.book_date = book_date;
	}
	public String getBook_info() {
		return book_info;
	}
	public void setBook_info(String book_info) {
		this.book_info = book_info;
	}
	public String getBook_best() {
		return book_best;
	}
	public void setBook_best(String book_best) {
		this.book_best = book_best;
	}
	public String getBook_activity() {
		return book_activity;
	}
	public void setBook_activity(String book_activity) {
		this.book_activity = book_activity;
	}
	public String getBook_img() {
		return book_img;
	}
	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public int getBook_stock() {
		return book_stock;
	}
	public void setBook_stock(int book_stock) {
		this.book_stock = book_stock;
	}
	
	
}
