package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaDAO<E> {
	
	protected EntityManager entityManager;

	public JpaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
     public E create(E entity) {
    	 
    	 entityManager.getTransaction().begin();
    	 entityManager.persist(entity);
    	
    	 entityManager.flush();
    	 entityManager.refresh(entity);
    	 
    	 
    	 entityManager.getTransaction().commit();
    	 
    	 return entity;
    	 
     }
     
     
     public E update(E entity) {
    	 entityManager.getTransaction().begin();
    	 entity = entityManager.merge(entity);
    	 
    	 entityManager.getTransaction().commit();
    	 return entity;
     }
     
     
     public E find(Class<E> type,Object id) {
    	 
    	 entityManager.getTransaction().begin();
    	E entity = entityManager.find(type, id);
    	if(entity != null) {
    		entityManager.refresh(entity);
    	}
    	
    	 
    	 return entity;
    	 
     }
     
     public void delete(Class<E> type,Object id) {
    	 
    	
    	 entityManager.getTransaction().begin();
    	  Object reference = entityManager.getReference(type, id);
    	  entityManager.remove(reference);
    	  
    	  entityManager.getTransaction().commit();
    	
    	
    	 
     }
     
    public List<E> findAllWithNamedQuery(String nameQuery){
    	Query queryString = entityManager.createNamedQuery(nameQuery);
    	return queryString.getResultList();
    }
    
    public List<E> findAllWithNamedQuery(String nameQuery,String paramName,Object paramValue){
    	Query query = entityManager.createNamedQuery(nameQuery);
    	query.setParameter(paramName, paramValue);
    	return query.getResultList();
    }
    
    public Long countAllWithNamedQuery(String namedQuery) {
    	Query queryString = entityManager.createNamedQuery(namedQuery);
    	return (Long) queryString.getSingleResult();
    }
	
	
	

}
