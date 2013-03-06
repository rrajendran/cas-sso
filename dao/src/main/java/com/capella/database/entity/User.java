package com.capella.database.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User implements Serializable {

    private static final long serialVersionUID = -8712872385957386182L;

    private String username;
    private String password;
    
    public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User() {
		
	}
	/**
     * Gets id (primary key).
     */
    @Id
    @Column(name = "username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
}