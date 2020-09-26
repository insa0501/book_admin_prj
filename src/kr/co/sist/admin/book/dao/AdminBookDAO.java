package kr.co.sist.admin.book.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.admin.book.domain.BookDetailDomain;
import kr.co.sist.admin.book.domain.BookListDomain;
import kr.co.sist.admin.book.vo.BookModifyVO;
import kr.co.sist.admin.book.vo.SelectBookListVO;

public class AdminBookDAO {
	private static AdminBookDAO abDAO;
	private static SqlSessionFactory ssf;
	private AdminBookDAO() {
	}
	
	/**
	 * 싱글턴을 객체를 위한 method
	 * @return
	 */
	public static AdminBookDAO getInstance() {
		if( abDAO == null) {
			abDAO = new AdminBookDAO();
		}//end if
		return abDAO;
	}
	
	/**
	 * SqlSession 설정
	 * @return
	 */
	public static SqlSession getSqlSession() {
		SqlSession ss = null;
		if( ssf == null ) {
			try {
			//1. xml과 연결
			String xmlConfig="kr/co/sist/admin/mybatis_config.xml";
			Reader reader = Resources.getResourceAsReader(xmlConfig);
			//2. MyBatis Framework 생성
			ssf = new SqlSessionFactoryBuilder().build(reader);
			reader.close();//xml을 읽어들인 스트림을 끊는다.
			} catch(IOException ie) {
				ie.printStackTrace();
			}//end catch
		}//end if
		ss = ssf.openSession();
		
		return ss;
	}
	
	
	/**
	 * 검색데이터와 현재페이지, 범위를 받아 보여줄 도서의 갯수를 받아오는 일
	 * @param sdVO
	 * @return
	 */
	public int selectBookCnt(SelectBookListVO sblVO) {
		int cnt = 0;
		SqlSession ss = getSqlSession();
		
		cnt = ss.selectOne("kr.co.sist.admin.book.bookCnt", sblVO);
		ss.close();
		return cnt;
	}

	/**
	 * 검색데이터와 현재페이지, 범위를 받아 보여주는 도서를 받아오는 일
	 * @param brVO
	 * @param sdVO
	 * @return
	 */
	public List<BookListDomain> selectBookList(SelectBookListVO sblVO){
		List<BookListDomain> list = new ArrayList<BookListDomain>();
		SqlSession ss = getSqlSession();
		list = ss.selectList("kr.co.sist.admin.book.bookList",sblVO);
		ss.close();
		return list;
	}
	
	/**
	 * 도서를 추가하는 일
	 * @param bmVO
	 */
	public int insertBook(BookModifyVO bmVO) {
		int cnt=0;
		SqlSession ss = getSqlSession();
		cnt=ss.insert("kr.co.sist.admin.book.bookInsert",bmVO);
		ss.commit();
		ss.close();
		return cnt;
	}//insertBook
	
	/**
	 * 도서 정보를 변경하는 일
	 * @param bmVO
	 * @return
	 */
	public int updateBook(BookModifyVO bmVO) {
		int cnt = 0;
		SqlSession ss = getSqlSession();
		cnt = ss.update("kr.co.sist.admin.book.bookUpdate", bmVO);
		
		ss.commit();
		ss.close();
		return cnt;
	}
	
	/**
	 * 도서의 isbn을 받아 해당 도서의 상세정보를 보여주는 일
	 * @param book_isbn
	 * @return
	 */
	public BookDetailDomain selectBookDetail(String book_isbn) {
		BookDetailDomain bdd = null;
		SqlSession ss = getSqlSession();
		
		bdd = ss.selectOne("kr.co.sist.admin.book.bookDetail", book_isbn);
		
		ss.close();
		return bdd;
	}//selectBookDetail
	
	public static void main(String[] args) {
		String book_isbn = "9788-9745-6529-9";
		BookDetailDomain book = AdminBookDAO.getInstance().selectBookDetail(book_isbn);
		System.out.println(book.getBook_name());
	}//main
	
}
