package com.harshvardhan.idt.service.impl;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshvardhan.idt.dao.WeatherDao;
import com.harshvardhan.idt.model.WeatherDetails;
import com.harshvardhan.idt.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	WeatherDao weatherDao;

	@Override
	public WeatherDetails getCurrentWeather(String city) throws ClientProtocolException, IOException {
		if ("".equals(city))
			city = "new%20york";
		return weatherDao.getCurrentWeather(city);
	}

}
