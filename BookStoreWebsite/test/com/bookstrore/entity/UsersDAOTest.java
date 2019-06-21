package com.bookstrore.entity;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.dao.UsersDAO;
import com.bookstore.entity.Users;

public class UsersDAOTest {
	private static  EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UsersDAO userDAO;
	
	@BeforeClass
	public static void setUpClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		 entityManager =entityManagerFactory.createEntityManager();
		
		 userDAO = new UsersDAO(entityManager);
	}

	@Test
	public void testCreateUsers() {
		Users users1 = new Users();
		users1.setEmail("vk1@gmail.com");
		users1.setFullName("vinod1 kumar new");
		users1.setPassword("45s6");
		
		// create Entity Manager factory
		 
		 userDAO.create(users1);
		
		assertTrue(users1.getUserId() > 0);
		 
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		Users users1 =new Users();
		// create Entity Manager factory
		 entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		 entityManager =entityManagerFactory.createEntityManager();
		
		 userDAO = new UsersDAO(entityManager);
		 userDAO.create(users1);
		
		assertTrue(users1.getUserId() > 0);
		
	}
	
	@Test
	public void testUpdateUser() {
		Users userUpdate = new Users();
		userUpdate.setUserId(1);
		userUpdate.setEmail("vvk@gmail.com");
		userUpdate.setFullName("kumarvinod");
		userUpdate.setPassword("password");
		
		userDAO = new UsersDAO(entityManager);
		userDAO.update(userUpdate);
		String expected = "password";
		String actual = userUpdate.getPassword();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetUsersFound() {
		Integer userId = 1;
		Users getUser = userDAO.get(userId);
		
		if(getUser != null) {
			System.out.println(getUser.getEmail());
		}
	     assertNotNull(getUser);
		
		
	}
	
	@Test
	public void testGetUsersNotFound() {
		Integer userId = 67;
		Users getUser = userDAO.get(userId);
		assertNull(getUser);
	}
	
	
	
	@Test
	public void testDeleteUser() {
		Integer userId = 7;
		userDAO.delete(userId);
		
		Users user = userDAO.get(userId);
		assertNull(user);
		
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteUserNotFound() {
		Integer userid = 66;
		userDAO.delete(userid);
	}
	
	
 @Test
 public void testListAll() {
	 List<Users> userList  = userDAO.listAll();
	 for (Users users : userList) {
		 System.out.println(users.getEmail());
		
	}
	 assertTrue(userList.size() > 0);
	 
 }
 
 
   @Test
   public void testFindByEmail() {
	   String email = "vk@gmail.com";
	   Users user = userDAO.findByEmail(email);
	   assertNotNull(user);
   }
 
  	@Test
  	public void testCountAll() {
  		Long countUsers = userDAO.count();
  		System.out.println(countUsers);
  		Long expected = (long) 8;
  		
  		assertEquals(expected, countUsers);
  	}
	
	@AfterClass
	public static void tearDownClass() {
		
		 entityManager.close();
		 entityManagerFactory.close();
		
	}

}
