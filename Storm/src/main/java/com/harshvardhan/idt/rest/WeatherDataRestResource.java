package com.harshvardhan.idt.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.harshvardhan.idt.constants.Constants;
import com.harshvardhan.idt.service.WeatherService;
import com.harshvardhan.idt.util.IPUtil;
import com.maxmind.geoip2.exception.AddressNotFoundException;

import io.swagger.annotations.Api;

@Api
@Component
@Path("/weather")
public class WeatherDataRestResource {
	@Autowired
	WeatherService weatherService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@DefaultValue("new%20york") @QueryParam("city") String city,
			@Context HttpServletRequest request, @Context HttpServletResponse response) {
		try {
			String currentLocation;
			try {
				currentLocation = IPUtil.getLocationFromIp(request);
			} catch (AddressNotFoundException ae) {
				currentLocation = Constants.DEFAULT_CITY;
			}
			if("".equals(city)) {
				city = currentLocation;
			}
			return Response.ok(weatherService.getCurrentWeatherAndForecast(city, currentLocation)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@Path("/ip")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIP(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		try {
			String ip = IPUtil.getClientIpAddress(request);
			return Response.ok(IPUtil.getLocationFromIp(ip)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

}
