package org.nlt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StateController {

	public StateController() {
		System.out.println("State Controller Object Created");
	}
	
	@RequestMapping(value="/state")
	public ModelAndView showState() {
		
		System.out.println("State Method");
		
		Map m = new HashMap();
		m.put("Title", "NLT Infotech Pvt Ltd, Nagpur, Maharashtra");
		return new ModelAndView("index",m);
	}
}
