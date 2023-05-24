package org.nlt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nlt.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends ParentController {
	
	@RequestMapping(value="/loginUser" , method=RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest req, HttpServletResponse resp) {
		Map m = new HashMap();
		HttpSession httpSession=req.getSession();
		String username=req.getParameter("email");
		String password=req.getParameter("password");
		Users user=userServices.getUser(username,password);
		
		if(user!=null) {
			httpSession.setAttribute("LoginUser", user.getName());
			m.put("Title", "NLT Infotech Pvt Ltd");
			m.put("Action", "./addPerson");
			m.put("ButtonValue", "SUBMIT");
			m.put("PersonList", personService.getPersons());    
			return new ModelAndView("index",m);
		}else {
			m.put("ErrorMessage", "Invalid Login! Please Try Again.........");
			return new ModelAndView("login",m);
		}
	}
}
