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
		//���� ����Ʈ�� ��ȸ ���������� ������ Ŭ����
		BookListService bls = new BookListService();
		//��ü �Խù� ��
		int totalCount = bls.totalCount(sblVO);
		//�� ȭ�鿡 ������ �Խù��� ��
		int pageScale = bls.pageScale();
		//�� �������� ��
		int totalPage = bls.totalPage(totalCount, pageScale);
		//���� ������ ��ȣ - �Ķ���� �ʿ� (����������)
		int currentPage = sblVO.getCurrentPage();
		
		//�������� ���� ��ȣ
		int startNum = bls.startNum(currentPage, pageScale);
		//�������� �� ��ȣ
		int endNum = bls.endNum(startNum, pageScale);
		
		//������ �ϴ��� ������ �̵�
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
