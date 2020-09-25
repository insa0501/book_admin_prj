package kr.co.sist.admin.book.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartRequest;

import kr.co.sist.admin.book.domain.BookListDomain;
import kr.co.sist.admin.book.service.BookListService;
import kr.co.sist.admin.book.vo.BookModifyVO;
import kr.co.sist.admin.book.vo.PageNationVO;
import kr.co.sist.admin.book.vo.SelectBookListVO;

@Controller
public class AdminBookController {
	@RequestMapping(value="/book_list.do", method=GET)
	public String selectBookList(SelectBookListVO sblVO , Model model) {
		//도서 리스트를 조회 업무로직을 구현한 클래스
		BookListService bls = new BookListService();
		//전체 게시물 수
		int totalCount = bls.totalCount(sblVO);
		//한 화면에 보여줄 게시물의 수
		int pageScale = bls.pageScale();
		//총 페이지의 수
		int totalPage = bls.totalPage(totalCount, pageScale);
		//시작 페이지 번호 - 파라메터 필요 (현재페이지)
		int currentPage = sblVO.getCurrentPage();
		
		//페이지별 시작 번호
		int startNum = bls.startNum(currentPage, pageScale);
		//페이지별 끝 번호
		int endNum = bls.endNum(startNum, pageScale);
		
		//페이지 하단의 페이지 이동
		PageNationVO pnv = new PageNationVO("", currentPage, totalPage);
		String pageNation = bls.pageNation(pnv);
		model.addAttribute("pageNation",pageNation);
		
		List<BookListDomain> list = bls.selectBookList(sblVO);
		model.addAttribute("bookList",list);
		
		return "book/main";
	}
	@RequestMapping(value="/add_book.do", method=GET)
	public String addBook(String currentPage, Model model) {
		return "";
	}
	@RequestMapping(value="/insert_book.do", method=GET)
	public String insertBook(MultipartRequest request, BookModifyVO bmVO) {
		return "";
	}
	@RequestMapping(value="change_book.do", method=GET)
	public String changeBook(MultipartRequest request, BookModifyVO bmVO) {
		return "";
	}
	@RequestMapping(value="select_book_detail.do", method=GET)
	public String selectBookDetail(String book_isbn, Model model) {
		return "";
	}
}
