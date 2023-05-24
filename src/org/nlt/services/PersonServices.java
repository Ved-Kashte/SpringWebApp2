package org.nlt.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.nlt.model.Persons;
import org.springframework.stereotype.Service;

@Service
public class PersonServices implements ParentServices {

	public PersonServices() {
		System.out.println("Person Services Object Created");
	}
	
	public boolean addPerson(Persons person)
	{
		ses.beginTransaction();
		ses.save(person);
		ses.getTransaction().commit();
		return true;
	}
	
	public List<Persons> getPersons()
	{
		ses.beginTransaction();
		Query query = ses.createQuery("from Persons where status=1");
		List<Persons> personList=query.list();
		ses.getTransaction().commit();
		return personList;
	}
	
	public Persons getPerson(int id)
	{
		ses.beginTransaction();
	    Query query = ses.createQuery("from Persons where status=1 and id="+id);
	    List<Persons> personList = query.list();
		ses.getTransaction().commit();
		return !personList.isEmpty()?personList.get(0):null;
	}
	
	public boolean updatePerson(Persons person)
	{
		ses.beginTransaction();
		ses.update(person);
		ses.getTransaction().commit();
		return true;
	}
	
	public boolean deletePerson(Persons person)
	{
		ses.beginTransaction();
		ses.update(person);
		ses.getTransaction().commit();
		return true;
	}
}
