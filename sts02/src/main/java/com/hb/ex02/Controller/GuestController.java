package com.hb.ex02.Controller;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hb.ex02.model.GuestDao;
import com.hb.ex02.model.GuestDao2;
import com.hb.ex02.model.GuestDaoImf;
import com.hb.ex02.model.GuestVo;

@Controller
public class GuestController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private GuestDao dao;
	
	@RequestMapping("/")
	public String selectAll(Model model){
		try {
			model.addAttribute("alist", dao.listAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	@RequestMapping("/add")
	public String addView(){
		
		return "addform";
	}
	
	@RequestMapping("/insert")
	public String insertOne(GuestVo bean, Model model){
		log.debug(bean);
			dao.insertOne(bean);
		return "redirect:/";
	}
	
	@RequestMapping("/detail")
	public String detailOne(@RequestParam("idx") int sabun, Model model){
		log.debug(sabun);
		try{
			GuestVo bean = dao.selectOne(sabun);
			model.addAttribute("bean", bean);
		}catch(Exception e){
			
		}
		return "detail";
	}
	
	@RequestMapping("/edit")
	public String editView(Model model, @RequestParam("idx") int sabun){
		model.addAttribute("bean",dao.selectOne(sabun));
		return "editform";
	}
	
	@RequestMapping("/update")
	public String updateOne(GuestVo bean){
		dao.updateOne(bean);
		return "redirect:/";
	}
	
}
