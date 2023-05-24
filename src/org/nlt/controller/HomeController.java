package org.nlt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends ParentController {

	public HomeController() {
		System.out.println("Home Controller Object Created");
	}
	
	@RequestMapping(value="/")
	public ModelAndView home(HttpServletRequest req,HttpServletResponse res)
	{
		
		HttpSession httpSession=req.getSession();
		System.out.println(cityService);
		System.out.println(homeService);
		System.out.println(personService);
		System.out.println(stateService);
		
		Map m=new HashMap();
		if(httpSession.getAttribute("LoginUser")!=null) {
			
		m.put("Title", "NLT Infotech Pvt Ltd");
		m.put("Action", "./addPerson");
		m.put("ButtonValue", "SUBMIT");
		m.put("PersonList", personService.getPersons());         
		return new ModelAndView("index",m);
		} else {
			return new ModelAndView("login",m);
		}
	}
}
