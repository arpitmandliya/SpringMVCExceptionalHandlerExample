package org.arpit.java2blog.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.arpit.java2blog.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	private static final Logger logger = Logger
			.getLogger(HelloWorldController.class);

	@RequestMapping("/helloworld/{helloType}")
	public ModelAndView hello(@PathVariable("helloType") String helloType)
			throws CustomException, IOException {

		String helloWorldMessage="";
		if (helloType.equalsIgnoreCase("CustomException")) {
			throw new CustomException("Custom exception occured");
		} else if (helloType.equalsIgnoreCase("IOException")) {
			throw new IOException(" IO exception occured");
		} else {
			helloWorldMessage = "Hello world from java2blog!";
			
		}

		return new ModelAndView("hello", "message", helloWorldMessage);
	}

	@ExceptionHandler(CustomException.class)
	public ModelAndView catchCustomException(CustomException ex) {

		ModelAndView model = new ModelAndView("Custom_Exception");
		model.addObject("errorMessage", ex.getMessage());
		return model;
	}
	
	@ExceptionHandler(IOException.class)
	public ModelAndView catchCustomException(IOException ex) {

		ModelAndView model = new ModelAndView("IOException");
		model.addObject("errorMessage", ex.getMessage());
		return model;
	}
}
