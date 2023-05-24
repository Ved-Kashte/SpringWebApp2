package org.nlt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CityController extends ParentController {
public CityController() {
	System.out.println("City Controller OBject Created");
}

@RequestMapping(value="/city")
public ModelAndView showCity()
{
	Map m=new HashMap();
	System.out.println("City method");
	m.put("Title", "NLT Infotech Pvt Ltd, Nagpur");
	return new ModelAndView("index",m);
}
}
