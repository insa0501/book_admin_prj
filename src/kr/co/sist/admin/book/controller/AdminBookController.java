package kr.co.sist.admin.book.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.sist.admin.book.domain.BookDetailDomain;
import kr.co.sist.admin.book.domain.BookListDomain;
import kr.co.sist.admin.book.service.BookDetailService;
import kr.co.sist.admin.book.service.BookListService;
import kr.co.sist.admin.book.vo.BookModifyVO;
import kr.co.sist.admin.book.vo.PageNationVO;
import kr.co.sist.admin.book.vo.SelectBookListVO;

@Controller
public class AdminBookController {
	@RequestMapping(value="/book_list.do", method= {GET,POST})
	public String selectBookList(SelectBookListVO sblVO, String updateFlag, String insertFlag , Model model) {
		//도서 리스트를 조회 업무로직을 구현한 클래스
		BookListService bls = new BookListService();
		//전체 게시물 수
		int totalCount = bls.totalCount(sblVO);
		//한 화면에 보여줄 게시물의 수
		int pageScale = bls.pageScale();
		//총 페이지의 수
		int totalPage = bls.totalPage(totalCount, pageScale);
		//현제페이지가 파라메터가 없을 경우 1로 지정
		if( sblVO.getCurrentPage() == 0 ) {
			sblVO.setCurrentPage(1);
		}
		//시작 페이지 번호 - 파라메터 필요 (현재페이지)
		int currentPage = sblVO.getCurrentPage();
		
		//페이지별 시작 번호
		int startNum = bls.startNum(currentPage, pageScale);
		//페이지별 끝 번호
		int endNum = bls.endNum(startNum, pageScale);
		//업무로직에 필요한 endNum과 startNum을 설정
		sblVO.setEndNum(endNum);
		sblVO.setStartNum(startNum);
		
		//페이지 하단의 페이지 이동
		//검색데이터, 검색타입, 현재페이지, 전체페이지
		StringBuilder searchData = new StringBuilder();
		if( sblVO.getSelectData() != null && !"".equals(sblVO.getSelectData()) ) {
			searchData
			.append("selectType=")
			.append(sblVO.getSelectType())
			.append("&selectData=")
			.append(sblVO.getSelectData());
		}
		PageNationVO pnv = new PageNationVO(searchData.toString(), currentPage, totalPage);
		String pageNation = bls.pageNation(pnv);
		model.addAttribute("page_nation",pageNation);
		
		List<BookListDomain> list = bls.selectBookList(sblVO);
		model.addAttribute("book_list",list);
		
		model.addAttribute("insertFlag",insertFlag);
		model.addAttribute("updateFlag",updateFlag);
		
		return "book/main";
	}
	@RequestMapping(value="/add_book.do", method=GET)
	public String addBook(String currentPage, Model model) {
		return "book/add_book";
	}
	@RequestMapping(value="/insert_book.do", method=POST)
	public String insertBook(HttpServletRequest request,Model model )  throws IOException  {
		//업로드 파일이 저장될 폴더의 경로
		String path = "C:/Users/sist34/git/book_admin_prj/WebContent/common/images/book";
		//업로드 파일의 크기(byte)
		int maxSize = 1024 * 1024 * 10;
		//업로드를 수행할 MultipartRequest 생성
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		//VO에 넣어주기 위한 파라메터 정리
		String book_isbn = mr.getParameter("book_isbn");
		String book_name = mr.getParameter("book_name");
		String book_country = mr.getParameter("book_country");
		String book_type_no = mr.getParameter("book_type_no");
		String book_writer = mr.getParameter("book_writer");
		String book_company = mr.getParameter("book_company");
		String book_date = mr.getParameter("book_date");
		String book_info = mr.getParameter("book_info"); 
		//체크되면 on 체크가안되면 null이 들어온다.
		String book_best = "N";
		if(mr.getParameter("book_best") != null ) {
			book_best = "Y";
		}
		String book_activity = "N";
		if( mr.getParameter("book_activity") != null ) {
			book_activity = "Y";
		}
		//img는 업로드된 파일명을 받는다.
		String book_img = mr.getFilesystemName("book_img");
		int book_price = Integer.parseInt(mr.getParameter("book_price"));
		int book_stock = Integer.parseInt(mr.getParameter("book_stock"));
		//데이터베이스에 처리하기 위해 VO에 파라메터 값을 넣는다.
		BookModifyVO bmVO = new BookModifyVO(book_isbn, book_name, book_country, book_type_no, 
				book_writer, book_company, book_date, book_info, book_best, book_activity, 
				book_img, book_price, book_stock);
		
		//도서를 추가하는 일을 하는 객체 생성
		BookDetailService bds = new BookDetailService();
		//도서를 추가하는 일
		if( book_isbn != null && !"".equals(book_isbn)) {
			int cnt=bds.addBook(bmVO);
			model.addAttribute("book_insertFlag", cnt);
		}
		
		
		
		return "redirect:process_result.do";
	}
	@RequestMapping(value="change_book.do", method=POST)
	public String changeBook(HttpServletRequest request,Model model) throws IOException {
		//업로드 파일이 저장될 폴더의 경로
		String path = "C:/Users/sist34/git/book_admin_prj/WebContent/common/images/book";
		//업로드 파일의 크기(byte)
		int maxSize = 1024 * 1024 * 10;
		//업로드를 수행할 MultipartRequest 생성
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		//VO에 넣어주기 위한 파라메터 정리
		String book_isbn = mr.getParameter("book_isbn");
		String book_name = mr.getParameter("book_name");
		String book_country = mr.getParameter("book_country");
		String book_type_no = mr.getParameter("book_type_no");
		String book_writer = mr.getParameter("book_writer");
		String book_company = mr.getParameter("book_company");
		String book_date = mr.getParameter("book_date");
		String book_info = mr.getParameter("book_info");
		//체크되면 on 체크가안되면 null이 들어온다.
		String book_best = "N";
		if(mr.getParameter("book_best") != null ) {
			book_best = "Y";
		}
		String book_activity = "N";
		if( mr.getParameter("book_activity") != null ) {
			book_activity = "Y";
		}
		//img는 업로드된 파일명을 받는다 카톡을 열어주세여ㅛ
		String book_img = mr.getParameter("book_img");
		if( mr.getFilesystemName("upfile") != null && !"".equals(mr.getFilesystemName("upfile")) ) {
			book_img = mr.getFilesystemName("upfile");
		}
		System.out.println(book_img);
		int book_price = Integer.parseInt(mr.getParameter("book_price"));
		int book_stock = Integer.parseInt(mr.getParameter("book_stock"));
		//데이터베이스에 처리하기 위해 VO에 파라메터 값을 넣는다.
		BookModifyVO bmVO = new BookModifyVO(book_isbn, book_name, book_country, book_type_no, 
				book_writer, book_company, book_date, book_info, book_best, book_activity, 
				book_img, book_price, book_stock);
		
		//도서를 추가하는 일을 하는 객체 생성
		BookDetailService bds = new BookDetailService();
		//도서를 추가하는 일
		if( book_isbn != null && !"".equals(book_isbn)) {
			int cnt=bds.changeBook(bmVO);
			model.addAttribute("book_updateFlag", cnt);
		}
				
		return "redirect:process_result.do";
	}
	@RequestMapping(value="select_book_detail.do", method=GET)
	public String selectBookDetail(String book_isbn, Model model) {
		//해당도서의 상세정보를 얻는 업무로직을 구현한 클래스
		BookDetailService bds = new BookDetailService();
		//도서의 상세정보 얻기
		BookDetailDomain bdd = bds.selectBookDetail(book_isbn);
		
		model.addAttribute("book_detail", bdd);
		return "book/detail";
	}
	
	
	
}
