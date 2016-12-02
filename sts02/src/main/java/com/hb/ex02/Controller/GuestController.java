package com.hb.ex02.Controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hb.ex02.model.GuestDao;
import com.hb.ex02.model.GuestDao2;
import com.hb.ex02.model.GuestDaoImf;
import com.hb.ex02.model.GuestVo;

@Controller
public class GuestController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private GuestDao guestDao;
	
	@RequestMapping("/")
	public String selectAll(Model model, HttpSession session){
		try {
			model.addAttribute("alist", guestDao.listAll());
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
		guestDao.insertOne(bean);
		return "redirect:/";
	}
	
	@RequestMapping("/detail")
	public String detailOne(@RequestParam("idx") int sabun, Model model){
		log.debug(sabun);
		try{
			GuestVo bean = guestDao.selectOne(sabun);
			model.addAttribute("bean", bean);
		}catch(Exception e){
			
		}
		return "detail";
	}
	
	@RequestMapping("/edit")
	public String editView(Model model, @RequestParam("idx") int sabun){
		model.addAttribute("bean",guestDao.selectOne(sabun));
		return "editform";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateOne(HttpServletRequest req, GuestVo bean){
		guestDao.updateOne(bean);
		return "redirect:/";
	}
	
	@RequestMapping("/delete")
	public String deleteOne(@RequestParam("idx") int sabun){
		guestDao.deleteOne(sabun);
		return "redirect:/";
	}
	
}
