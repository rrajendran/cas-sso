package com.capella.database.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.capella.database.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/capella/database/config/applicationContext.xml")
@TransactionConfiguration(defaultRollback=false, transactionManager="transactionManager")
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	@PersistenceContext
	EntityManager entityManager;
	@Test
	public void testSaveS() {
		User user = new User("test1","test123", "ROLE_USER,ROLE_SUPERVISOR");
		userDao.save(user);
		List<User> findAll = userDao.findAll();
		Assert.assertNotNull(findAll);
	}
	@org.junit.After
	public void tearDown(){
		userDao.delete();
	}
}
