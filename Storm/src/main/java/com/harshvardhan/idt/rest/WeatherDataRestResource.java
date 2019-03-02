package com.harshvardhan.idt.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.harshvardhan.idt.service.WeatherService;

import io.swagger.annotations.Api;

@Api
@Component
@Path("/weather")
public class WeatherDataRestResource {
	@Autowired
	WeatherService weatherService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@DefaultValue("new%20york") @QueryParam("city") String city) {
		try {
			return Response.ok(weatherService.getCurrentWeather(city.replaceAll(" ", "%20"))).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
		}
	}

}
