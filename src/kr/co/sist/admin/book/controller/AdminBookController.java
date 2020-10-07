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
		//���� ����Ʈ�� ��ȸ ���������� ������ Ŭ����
		BookListService bls = new BookListService();
		//��ü �Խù� ��
		int totalCount = bls.totalCount(sblVO);
		//�� ȭ�鿡 ������ �Խù��� ��
		int pageScale = bls.pageScale();
		//�� �������� ��
		int totalPage = bls.totalPage(totalCount, pageScale);
		//������������ �Ķ���Ͱ� ���� ��� 1�� ����
		if( sblVO.getCurrentPage() == 0 ) {
			sblVO.setCurrentPage(1);
		}
		//���� ������ ��ȣ - �Ķ���� �ʿ� (����������)
		int currentPage = sblVO.getCurrentPage();
		
		//�������� ���� ��ȣ
		int startNum = bls.startNum(currentPage, pageScale);
		//�������� �� ��ȣ
		int endNum = bls.endNum(startNum, pageScale);
		//���������� �ʿ��� endNum�� startNum�� ����
		sblVO.setEndNum(endNum);
		sblVO.setStartNum(startNum);
		
		//������ �ϴ��� ������ �̵�
		//�˻�������, �˻�Ÿ��, ����������, ��ü������
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
		//���ε� ������ ����� ������ ���
		String path = "C:/Users/sist34/git/book_admin_prj/WebContent/common/images/book";
		//���ε� ������ ũ��(byte)
		int maxSize = 1024 * 1024 * 10;
		//���ε带 ������ MultipartRequest ����
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		//VO�� �־��ֱ� ���� �Ķ���� ����
		String book_isbn = mr.getParameter("book_isbn");
		String book_name = mr.getParameter("book_name");
		String book_country = mr.getParameter("book_country");
		String book_type_no = mr.getParameter("book_type_no");
		String book_writer = mr.getParameter("book_writer");
		String book_company = mr.getParameter("book_company");
		String book_date = mr.getParameter("book_date");
		String book_info = mr.getParameter("book_info"); 
		//üũ�Ǹ� on üũ���ȵǸ� null�� ���´�.
		String book_best = "N";
		if(mr.getParameter("book_best") != null ) {
			book_best = "Y";
		}
		String book_activity = "N";
		if( mr.getParameter("book_activity") != null ) {
			book_activity = "Y";
		}
		//img�� ���ε�� ���ϸ��� �޴´�.
		String book_img = mr.getFilesystemName("book_img");
		int book_price = Integer.parseInt(mr.getParameter("book_price"));
		int book_stock = Integer.parseInt(mr.getParameter("book_stock"));
		//�����ͺ��̽��� ó���ϱ� ���� VO�� �Ķ���� ���� �ִ´�.
		BookModifyVO bmVO = new BookModifyVO(book_isbn, book_name, book_country, book_type_no, 
				book_writer, book_company, book_date, book_info, book_best, book_activity, 
				book_img, book_price, book_stock);
		
		//������ �߰��ϴ� ���� �ϴ� ��ü ����
		BookDetailService bds = new BookDetailService();
		//������ �߰��ϴ� ��
		if( book_isbn != null && !"".equals(book_isbn)) {
			int cnt=bds.addBook(bmVO);
			model.addAttribute("book_insertFlag", cnt);
		}
		
		
		
		return "redirect:process_result.do";
	}
	@RequestMapping(value="change_book.do", method=POST)
	public String changeBook(HttpServletRequest request,Model model) throws IOException {
		//���ε� ������ ����� ������ ���
		String path = "C:/Users/sist34/git/book_admin_prj/WebContent/common/images/book";
		//���ε� ������ ũ��(byte)
		int maxSize = 1024 * 1024 * 10;
		//���ε带 ������ MultipartRequest ����
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		//VO�� �־��ֱ� ���� �Ķ���� ����
		String book_isbn = mr.getParameter("book_isbn");
		String book_name = mr.getParameter("book_name");
		String book_country = mr.getParameter("book_country");
		String book_type_no = mr.getParameter("book_type_no");
		String book_writer = mr.getParameter("book_writer");
		String book_company = mr.getParameter("book_company");
		String book_date = mr.getParameter("book_date");
		String book_info = mr.getParameter("book_info");
		//üũ�Ǹ� on üũ���ȵǸ� null�� ���´�.
		String book_best = "N";
		if(mr.getParameter("book_best") != null ) {
			book_best = "Y";
		}
		String book_activity = "N";
		if( mr.getParameter("book_activity") != null ) {
			book_activity = "Y";
		}
		//img�� ���ε�� ���ϸ��� �޴´� ī���� �����ּ�����
		String book_img = mr.getParameter("book_img");
		if( mr.getFilesystemName("upfile") != null && !"".equals(mr.getFilesystemName("upfile")) ) {
			book_img = mr.getFilesystemName("upfile");
		}
		System.out.println(book_img);
		int book_price = Integer.parseInt(mr.getParameter("book_price"));
		int book_stock = Integer.parseInt(mr.getParameter("book_stock"));
		//�����ͺ��̽��� ó���ϱ� ���� VO�� �Ķ���� ���� �ִ´�.
		BookModifyVO bmVO = new BookModifyVO(book_isbn, book_name, book_country, book_type_no, 
				book_writer, book_company, book_date, book_info, book_best, book_activity, 
				book_img, book_price, book_stock);
		
		//������ �߰��ϴ� ���� �ϴ� ��ü ����
		BookDetailService bds = new BookDetailService();
		//������ �߰��ϴ� ��
		if( book_isbn != null && !"".equals(book_isbn)) {
			int cnt=bds.changeBook(bmVO);
			model.addAttribute("book_updateFlag", cnt);
		}
				
		return "redirect:process_result.do";
	}
	@RequestMapping(value="select_book_detail.do", method=GET)
	public String selectBookDetail(String book_isbn, Model model) {
		//�ش絵���� �������� ��� ���������� ������ Ŭ����
		BookDetailService bds = new BookDetailService();
		//������ ������ ���
		BookDetailDomain bdd = bds.selectBookDetail(book_isbn);
		
		model.addAttribute("book_detail", bdd);
		return "book/detail";
	}
	
	
	
}
