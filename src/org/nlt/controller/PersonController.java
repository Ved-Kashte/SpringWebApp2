package org.nlt.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nlt.model.Persons;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController extends ParentController {

	public PersonController() {
		System.out.println("Person Controller Object Created");
	}

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public ModelAndView addPerson(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("AddPerson Method");

		Map m = new HashMap();

		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String phone = req.getParameter("phone");
		String gender = "Male";

		m.put("NameValue", name);
		m.put("AgeValue", age);
		m.put("PhoneValue", phone);

		if (name.isEmpty()) {
			m.put("NameError", "*Name Required");
		} else if (age.isEmpty()) {
			m.put("AgeError", "*Age Required");
		} else if (phone.isEmpty()) {
			m.put("PhoneError", "*Phone Required");
		} else {
			Persons person = new Persons();
			person.setName(name);
			person.setAge(Integer.parseInt(age));
			person.setGender(gender);
			person.setPhone(Long.parseLong(phone));
			person.setStatus(1);
			person.setCreated(new Date());
			person.setModified(new Date());
			if (personService.addPerson(person)) {
				m.put("SuccessMessage", "Record Submitted Successfully");
				m.put("NameValue", "");
				m.put("AgeValue", "");
				m.put("PhoneValue", "");
			} else {
				m.put("ErrorMessage", "Couldn't Submit Record!");
			}
		}

		m.put("Action", "./addPerson");
		m.put("ButtonValue", "SUBMIT");
		m.put("Title", "NLT Infotech Pvt Ltd");
		m.put("PersonList", personService.getPersons());
		return new ModelAndView("index", m);
	}

	@RequestMapping(value = "/getPersonEdit", method = RequestMethod.GET)
	public ModelAndView getPersonEdit(HttpServletRequest req, HttpServletResponse resp) {

		Map m = new HashMap();

		String id = req.getParameter("id");
		Persons person = personService.getPerson(Integer.parseInt(id));

		if (person != null) {
			m.put("IdValue", person.getId());
			m.put("NameValue", person.getName());
			m.put("PhoneValue", person.getPhone());
			m.put("AgeValue", person.getAge());
		}

		m.put("Action", "./addPerson");
		m.put("ButtonValue", "SUBMIT");
		m.put("Title", "NLT Infotech Pvt Ltd");
		m.put("PersonList", personService.getPersons());
		return new ModelAndView("index", m);
	}

	@RequestMapping(value = "/deletePerson", method = RequestMethod.GET)
	public ModelAndView getPersonDelete(HttpServletRequest req, HttpServletResponse resp) {

		Map m = new HashMap();

		String id = req.getParameter("id");
		Persons person = personService.getPerson(Integer.parseInt(id));//will fetch existing object

		if (person != null) {
			person.setStatus(0);//overwrite
			person.setModified(new Date());//overwrite
			
			boolean result = personService.updatePerson(person);
			if(result)
			{
				m.put("SuccessMessage", "Record Submitted Successfully");
				m.put("NameValue", "");
				m.put("AgeValue", "");
				m.put("PhoneValue", "");
			}
			else
			{
				m.put("ErrorMessage", "Couldn't Delete Record!");
			}
		}

		m.put("Action", "./deletePerson");
		m.put("ButtonValue", "DELETE");
		m.put("Title", "NLT Infotech Pvt Ltd");
		m.put("PersonList", personService.getPersons());
		return new ModelAndView("index", m);
	}

	@RequestMapping(value = "/updatePerson", method = RequestMethod.POST)
	public ModelAndView updatePerson(HttpServletRequest req, HttpServletResponse resp) 
	{
		Map m = new HashMap();

		String id = req.getParameter("id");
		Persons person = personService.getPerson(Integer.parseInt(id));

		if (person != null) 
		{
			String name = req.getParameter("name");// new name
			String age = req.getParameter("age"); // new age
			String phone = req.getParameter("phone");// new phone

			person.setName(name); // overwrite
			person.setAge(Integer.parseInt(age));// overwrite
			person.setPhone(Long.parseLong(phone));// overwrite
			person.setModified(new Date());// overwrite

			boolean result = personService.updatePerson(person);
			if (result) 
			{
				m.put("SuccessMessage", "Record Submitted Successfully");
				m.put("NameValue", "");
				m.put("AgeValue", "");
				m.put("PhoneValue", "");
			} 
			else 
			{
				m.put("ErrorMessage", "Couldn't update records");
			}
		}
			m.put("Action", "./updatePerson");
			m.put("ButtonValue", "UPDATE");
			m.put("Title", "NLT Infotech Pvt Ltd");
			m.put("PersonList", personService.getPersons());
			return new ModelAndView("index", m);
		
	}
}