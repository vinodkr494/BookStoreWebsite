package com.bookstrore.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Category;

public class CategoryTest {

	public static void main(String[] args) {
		
		//creating category object
		Category category = new Category();
		category.setName("NTSE");
		
		//
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		// persist object
		entityManager.persist(category);
		
		// commit the transection
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		entityManagerFactory.close();
		
		//output 
		System.out.println("category object persist");
		
		
		
		
		
	}

}
