package com.ecom.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public static EntityManagerFactory getEntityManagerFactory() {
		
		EntityManagerFactory factory = null;
		
		try {
			factory = Persistence.createEntityManagerFactory("JPA-PU");				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return factory;
	}
}
