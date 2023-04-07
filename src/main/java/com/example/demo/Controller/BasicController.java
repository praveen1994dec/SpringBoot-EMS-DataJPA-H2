package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BasicController {
	
	ModelAndView mv;
	
	@GetMapping("/basic")
	public ModelAndView welcome() {
		mv = new ModelAndView();
		mv.setViewName("index.html");
		
		return mv;
	}

}
