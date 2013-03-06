package com.capella.database.repositories;

import java.util.List;

import com.capella.database.entity.User;

public interface UserDao {

	void save(User user);

	List<User> findAll();

	String getPassword(String username);

	void delete();

}
