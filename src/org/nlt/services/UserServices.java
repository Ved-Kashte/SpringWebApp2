package org.nlt.services;

import java.util.List;

import org.hibernate.Query;
import org.nlt.model.Users;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements ParentServices {

	public Users getUser(String username, String password) {
		ses.beginTransaction();
		Query query = ses.createQuery("from Users where email='" + username + "' and password='" + password + "' and status=1");
		List<Users> list = query.list();
		ses.getTransaction().commit();
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
}
