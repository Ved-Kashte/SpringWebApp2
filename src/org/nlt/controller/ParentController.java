package org.nlt.controller;

import org.nlt.services.CityServices;
import org.nlt.services.HomeServices;
import org.nlt.services.PersonServices;
import org.nlt.services.StateServices;
import org.nlt.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;

public class ParentController {

	@Autowired
	protected CityServices cityService;
	
	@Autowired
	protected UserServices userServices;

	@Autowired
	protected StateServices stateService;

	@Autowired
	protected HomeServices homeService;

	@Autowired
	protected PersonServices personService;
}
