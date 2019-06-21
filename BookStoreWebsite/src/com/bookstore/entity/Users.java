package com.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity 
@Table(name="users")
@NamedQueries({
	@NamedQuery(name="Users.findAll" , query = "SELECT u FROM Users u ORDER BY u.fullName"),
	@NamedQuery(name ="Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email "),
	@NamedQuery(name ="Users.countAll",query = "SELECT Count(*) FROM Users u")
})
public class Users {
			
	
	
	private int userId;
	private String email;
	private String password;
	private String fullName;
	
	
	public Users() {
		
	}

	public Users(int userId, String email, String password, String fullName) {
		this(email,password,fullName);
		this.userId = userId;
		
	}
	
	public Users(String email, String password, String fullName) {
		this.email = email;
		this.password = password;
		this.fullName = fullName;
	}



	

	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="full_name")
	public String getFullName() {
		return fullName;
	}
     
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
