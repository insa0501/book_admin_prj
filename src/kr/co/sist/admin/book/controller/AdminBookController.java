package kr.co.sist.admin.book.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartRequest;

import kr.co.sist.admin.book.vo.BookModifyVO;
import kr.co.sist.admin.book.vo.SelectBookListVO;

@Controller
public class AdminBookController {
	@RequestMapping(value="/book_list.do", method=GET)
	public String selectBookList(SelectBookListVO sblVO , Model model) {
		return "";
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
