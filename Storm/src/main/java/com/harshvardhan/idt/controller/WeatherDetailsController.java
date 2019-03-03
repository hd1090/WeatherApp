package com.harshvardhan.idt.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshvardhan.idt.constants.Constants;
import com.harshvardhan.idt.service.WeatherService;
import com.harshvardhan.idt.util.IPUtil;
import com.maxmind.geoip2.exception.AddressNotFoundException;
import com.maxmind.geoip2.exception.GeoIp2Exception;

@Controller
@RequestMapping("/weatherDetails")
public class WeatherDetailsController {

	@Autowired
	WeatherService weatherService;

	/**
	 * Method simply to render the jsp. Does nothing else but forward requests just
	 * like a front controller
	 * 
	 * @return string of the name of the jsp the request should be forwarded to.
	 *         Automatically Prefixed with WEB-INF and Suffix with .jsp
	 * @throws GeoIp2Exception
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws IOException, GeoIp2Exception {
		try {
			String currentLocation = IPUtil.getLocationFromIp(request);
			request.setAttribute("city", currentLocation);
		} catch (AddressNotFoundException ae) {
			request.setAttribute("error", "Couldn't Autodetect location - please try searching");
			request.setAttribute("city", Constants.DEFAULT_CITY);
		}
		return "weatherDetails";
	}

	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public String getCity(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@RequestParam("city") String city) throws IOException, GeoIp2Exception {
		request.setAttribute("city", city);
		return "weatherDetails";
	}

}
