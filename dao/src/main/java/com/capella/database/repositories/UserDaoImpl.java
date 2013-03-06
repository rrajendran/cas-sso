package com.capella.database.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capella.database.entity.User;

@Service("userDao")
@Transactional
public class UserDaoImpl implements UserDao{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void save(User user){
		entityManager.persist(user);
	}
	@Override
	public List<User> findAll() {
		return entityManager.createQuery("From User", User.class).getResultList();
	}
	@Override
	public String getPassword(String username) {
		Query query = entityManager.createQuery("from User where lower(username) = lower(:username)",User.class);
		query.setParameter("username", username);
		User singleResult = (User) query.getSingleResult();
		if(singleResult != null)
			return singleResult.getPassword();
		return null;
	}
	@Override
	public void delete() {
		entityManager.createQuery("delete from User").executeUpdate();
	}
}
