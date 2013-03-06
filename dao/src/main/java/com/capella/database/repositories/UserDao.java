package com.capella.database.repositories;

import java.util.List;

import com.capella.database.entity.User;

public interface UserDao {

	void save(User user);

	List<User> findAll();

	User findUser(String username);

	void delete();

}
