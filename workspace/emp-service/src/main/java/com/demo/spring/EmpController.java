package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.entity.Emp;

@Controller
public class EmpController {

	@Autowired
	EmpRepository repo;

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String getFirstPage(Model model) {
		Emp e = new Emp();
		model.addAttribute("emp", e);
		return "emp";
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ModelAndView processForm(@ModelAttribute("emp") Emp e) {
		ModelAndView mv = new ModelAndView();
		if (repo.existsById(e.getEmpId())) {
			mv.setViewName("error");
		} else {
			repo.save(e);
			mv.setViewName("response");
			mv.addObject("name", e.getName());
		}
		return mv;
	}
}
