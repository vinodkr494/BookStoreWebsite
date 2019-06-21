package com.bookstrore.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;

public class UsersTest {

	public static void main(String[] args) {
		
		// create user object
		Users users1 = new Users();
		users1.setEmail("kumar.kr494@gmail.com");
		users1.setFullName("kumar");
		users1.setPassword("123456");
		
		// create entity manager factory
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager  entityManager = entityManagerFactory.createEntityManager();
		
		//begin transaction
		
		entityManager.getTransaction().begin();
	
		// persist the object
		
		entityManager.persist(users1);
		
		// commit the transaction
		entityManager.getTransaction().commit();
		// close the entity manager
		entityManager.close();
		// close the entity manager factory
		entityManagerFactory.close();
		
		// print the output
		System.out.println("user object persist");
		
		
		
		

	}

}
