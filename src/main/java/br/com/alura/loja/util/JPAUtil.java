package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence
			.createEntityManagerFactory("loja");

	public static EntityManager getEntityManager() { 
		return FACTORY.createEntityManager();
	}
	
	private static final EntityManagerFactory MYFACTORY = Persistence
			.createEntityManagerFactory("mysql");
	
	public static EntityManager getMyEntityManager() {
		return MYFACTORY.createEntityManager();
	}
	
}
