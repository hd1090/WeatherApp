package com.harshvardhan.idt.service.impl;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshvardhan.idt.dao.WeatherDao;
import com.harshvardhan.idt.dto.DisplayDTO;
import com.harshvardhan.idt.dto.DisplayForecastDTO;
import com.harshvardhan.idt.dto.DisplayWeatherDTO;
import com.harshvardhan.idt.model.ForecastDetailsArray;
import com.harshvardhan.idt.model.WeatherDetails;
import com.harshvardhan.idt.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	WeatherDao weatherDao;

	@Override
	public DisplayWeatherDTO getCurrentWeather(String city,String currentLocation) throws ClientProtocolException, IOException {
		if ("".equals(city))
			city = "new%20york";

		WeatherDetails details = weatherDao.getCurrentWeather(city,currentLocation);

		DisplayWeatherDTO dto = new DisplayWeatherDTO(details);
		return dto;
	}

	@Override
	public DisplayForecastDTO getWeatherForcast(String city,String currentLocation) throws ClientProtocolException, IOException {
		if ("".equals(city))
			city = "new%20york";

		ForecastDetailsArray details = weatherDao.getWeatherForcast(city,currentLocation);

		DisplayForecastDTO dto = new DisplayForecastDTO(details);
		return dto;
	}

	@Override
	public DisplayDTO getCurrentWeatherAndForecast(String city,String currentLocation) throws ClientProtocolException, IOException {

		DisplayWeatherDTO weatherDTO = getCurrentWeather(city,currentLocation);
		DisplayForecastDTO forecastDTO = getWeatherForcast(city,currentLocation);
		DisplayDTO displayDTO = new DisplayDTO(weatherDTO, forecastDTO);
		return displayDTO;
	}

}
