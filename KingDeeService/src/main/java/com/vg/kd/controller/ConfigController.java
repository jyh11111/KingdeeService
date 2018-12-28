package com.vg.kd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
 
public class ConfigController {
	
	@GetMapping("/config")
	public ModelAndView config() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("config");
		return mv;
		
	}
	

}
