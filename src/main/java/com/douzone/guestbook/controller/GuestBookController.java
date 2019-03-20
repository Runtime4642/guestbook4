package com.douzone.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook.dao.GuestBookDao;
import com.douzone.guestbook.vo.GuestBookVo;

@Controller
public class GuestBookController {

	@Autowired
	private GuestBookDao guestBookDao;
	
	@RequestMapping("")
	public String list(Model model) {
		
		model.addAttribute("list",guestBookDao.getList());
		return "index";
	}
	

//	@RequestMapping(value="/write",method=RequestMethod.POST)
//	public String write(@RequestParam(value="name") String name,
//		@RequestParam(value="password") String password,
//		@RequestParam(value="message")String message) {
//		//System.out.println(name);
//		//System.out.println(password);
//		//System.out.println(message);
//
//		guestBookDao.insert(vo)
//		
//		return "/list";
//	}
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(GuestBookVo vo) {
		guestBookDao.insert(vo);
		return "redirect:/";
	}
	@RequestMapping(value="/deleteform")
	public String deleteform(@RequestParam("no") Long no,Model model) {
		model.addAttribute("no",no);
		return "deleteform";
	}
	@RequestMapping(value="/delete")
	public String delete(@RequestParam("no") String no,@RequestParam("password") String password) {
		guestBookDao.delete(no, password);
		 return "redirect:/";
	}
	
}
