package com.capella.cas.authentication;

import org.apache.log4j.Logger;
import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;

import com.capella.database.userservice.SpringUserService;

/**
 * Authentication Handler for username password credentials
 * @author rrajendran
 *
 */
public class SpringAuthenticationHandler extends
		AbstractUsernamePasswordAuthenticationHandler {
	private static final Logger LOG = Logger.getLogger(SpringAuthenticationHandler.class);
	
	@Autowired
	private SpringUserService springUserService;
	
	@Override
	protected boolean authenticateUsernamePasswordInternal(
			UsernamePasswordCredentials credentials)
			throws AuthenticationException {
		final String username = getPrincipalNameTransformer().transform(credentials.getUsername());
		LOG.debug("Authentication user : " + username);
        final String password = credentials.getPassword();
        final String encryptedPassword = this.getPasswordEncoder().encode(
            password);
        UserDetails loadUserByUsername = springUserService.loadUserByUsername(username);
        try {
            return loadUserByUsername.getPassword().equals(encryptedPassword);
        } catch (final IncorrectResultSizeDataAccessException e) {
        	LOG.debug("Authentication user failed: " + username + " - " + e.getMessage());
            return false;
        }
	}

}
