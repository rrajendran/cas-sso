package com.capella.common.security.handlers;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class CasAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	private static final Logger LOGGER = Logger.getLogger(CasAuthenticationSuccessHandler.class);
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
					throws ServletException, IOException {
		Enumeration parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String paramName = parameterNames.nextElement().toString();
			response.addCookie(getCookie(request, paramName) );
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
	/**
	 * Create cookie
	 * @param request
	 * @param paramName
	 * @return
	 */
	private Cookie getCookie(HttpServletRequest request, String paramName) {
		String paramValue = (String) request.getParameter(paramName);
		LOGGER.debug("Adding cookie : " + paramName + ", " + paramValue);
		return new Cookie(paramName, paramValue);
	}
}
