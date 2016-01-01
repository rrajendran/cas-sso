package com.capella.database.repositories;

import com.capella.database.entity.User;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
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
