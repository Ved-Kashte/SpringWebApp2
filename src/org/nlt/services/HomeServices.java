package org.nlt.services;

import org.springframework.stereotype.Service;

@Service
public class HomeServices implements ParentServices {

	public HomeServices() {
		System.out.println(ses);
		System.out.println(sf);
		System.out.println("Home Services Object Created");
	}
}
