package com.harshvardhan.idt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/weatherDetails")
public class WeatherDetailsController {
	
	public WeatherDetailsController() {
		System.out.println("Controller initializzzed!!!");
	}

	/**
	 * Method simply to render the jsp. Does nothing else but forward requests just
	 * like a front controller
	 * 
	 * @return string of the name of the jsp the request should be forwarded to.
	 *         Automatically Prefixed with WEB-INF and Suffix with .jsp
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "weatherDetails";
	}

}
