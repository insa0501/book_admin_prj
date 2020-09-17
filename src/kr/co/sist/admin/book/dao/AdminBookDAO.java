package kr.co.sist.admin.book.dao;

public class AdminBookDAO {
	private static AdminBookDAO abDAO;
	private AdminBookDAO() {
	}
	
	public static AdminBookDAO getInstance() {
		if( abDAO == null) {
			abDAO = new AdminBookDAO();
		}//end if
		return abDAO;
	}
	
}
