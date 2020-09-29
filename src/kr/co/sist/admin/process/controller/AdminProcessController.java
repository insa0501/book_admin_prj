package kr.co.sist.admin.process.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminProcessController {
	@RequestMapping(value="process_result.do",method= {POST,GET})
	public String processResult(String user_deleteFlag, String user_changeFlag, String book_updateFlag,String book_insertFlag,Model model ){
		model.addAttribute("user_deleteFlag",user_deleteFlag);
		model.addAttribute("user_changeFlag",user_changeFlag);
		model.addAttribute("book_updateFlag",book_updateFlag);
		model.addAttribute("book_insertFlag",book_insertFlag);
		return "process/process_result";
	}
}
