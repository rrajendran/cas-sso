package com.capella.login.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class HomeController {
	
	//@RequestMapping(value="/home")
	public ModelAndView home(HttpServletRequest request){
		ModelAndView model = new ModelAndView("home");
		return model;
	}
}
