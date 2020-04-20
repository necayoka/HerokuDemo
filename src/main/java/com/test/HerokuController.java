package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HerokuController {

	@RequestMapping("go")
	public String go() {
		return "home.jsp";
	}
	
	@RequestMapping("add")
	public String add(@RequestParam("ime") String ime) {
		Grad grad = new Grad();
		grad.setIme(ime);
		Dao.addGrad(grad);
		return "home.jsp";
	}
	
	@RequestMapping("show")
	public ModelAndView show(int id) {
		ModelAndView mv = new ModelAndView();
		Grad grad = Dao.showGrad(id);
		mv.addObject("grad", grad);
		mv.setViewName("show.jsp");
		return mv;
	}
	
}
