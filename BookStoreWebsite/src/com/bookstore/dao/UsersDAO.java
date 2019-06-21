package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Users;

public class UsersDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UsersDAO(EntityManager entityManager) {
		super(entityManager);
		
	}
	
	public Users create(Users user) {
		
		return super.create(user);
	}

	@Override
	public Users update(Users user) {
		
		return super.update(user);
	}

	@Override
	public Users get(Object id) {
		
		return super.find(Users.class, id);
	}

	@Override
	public void delete(Object id) {
		
		super.delete(Users.class, id);
		
	}

	@Override
	public List<Users> listAll() {
		
		
		return super.findAllWithNamedQuery("Users.findAll");
	}

	@Override
	public Long count() {
		
		return super.countAllWithNamedQuery("Users.countAll");
	}
	
	public Users findByEmail(String email) {
		
		List<Users> listUser = super.findAllWithNamedQuery("Users.findByEmail", "email", email);
		
		if(listUser != null && listUser.size() > 0) {
			return listUser.get(0);
		}
		
		return null;
		
	}

}
