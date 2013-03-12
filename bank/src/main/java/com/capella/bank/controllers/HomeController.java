package com.capella.bank.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jasig.cas.client.util.CommonUtils;
import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private static final Logger LOGGER = Logger.getLogger(HomeController.class);
	@RequestMapping(value={"/index","/"} , method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request){
		ModelAndView model = new ModelAndView("home");
		model.addObject("message", "Welcome to bank application");
		model.addObject("ticket", getProxyTicket(request));
		
		CasAuthenticationToken principal = (CasAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		model.addObject("principal", principal);
		model.addObject("credentials", principal.getCredentials());
		return model;
	}


	private String getProxyTicket(HttpServletRequest request) {
		/*final CasAuthenticationToken token = (CasAuthenticationToken) request.getUserPrincipal();
		final String proxyTicket = token.getAssertion().getPrincipal().getProxyTicketFor(TARGET_URL);
		String proxyResponse = CommonUtils.getResponseFromServer(serviceUrl, "UTF-8");
		LOGGER.info("Ticket : " + proxyTicket);*/
		return "";
	}
	
	@RequestMapping(value="/loginFailed" , method = RequestMethod.GET)
	public ModelAndView loginFailed(HttpServletRequest request){
		ModelAndView model = new ModelAndView("/casfailed");
		model.addObject("principal", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		model.addObject("message", "Logout failed!!");
		return model;
	}
}
