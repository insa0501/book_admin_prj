package kr.co.sist.admin.book.domain;

public class BookListDomain {
	String book_isbn, book_name, book_writer, book_company, book_date, book_activity;
	int book_price, book_stock;
	public BookListDomain() {
	}
	public BookListDomain(String book_isbn, String book_name, String book_writer, String book_company,
			String book_date, String book_activity, int book_price, int book_stock) {
		this.book_isbn = book_isbn;
		this.book_name = book_name;
		this.book_writer = book_writer;
		this.book_company = book_company;
		this.book_date = book_date;
		this.book_activity = book_activity;
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
	public String getBook_activity() {
		return book_activity;
	}
	public void setBook_activity(String book_activity) {
		this.book_activity = book_activity;
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
