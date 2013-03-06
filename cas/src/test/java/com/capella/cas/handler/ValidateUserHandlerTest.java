package com.capella.cas.handler;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import junit.framework.Assert;

import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.capella.database.entity.User;
import com.capella.database.repositories.UserDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/capella/database/config/applicationContext.xml")
@TransactionConfiguration(defaultRollback=false)
public class ValidateUserHandlerTest {
	
	private static final String USER_NAME = "admin";
	private static final String PASSWORD = "secret";
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	ValidateUserHandler validateUserHandler;
	@Autowired
	private UserDao userDao;
	
	@Before
	public void setUp(){
		userDao.delete();
		User user = new User(USER_NAME,PASSWORD, "ROLE_USER,ROLE_SUPERVISOR");
		userDao.save(user);
		List<User> findAll = userDao.findAll();
		Assert.assertNotNull(findAll);
	}
	@Test
	public void testAuthenticateUsernamePasswordInternalUsernamePasswordCredentials() throws AuthenticationException {
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials();
		credentials.setUsername(USER_NAME);
		credentials.setPassword(PASSWORD);
		boolean validated = validateUserHandler.authenticateUsernamePasswordInternal(credentials );
		Assert.assertTrue(validated);
	}
	
	@org.junit.After
	public void tearDown(){
		userDao.delete();
	}

}
