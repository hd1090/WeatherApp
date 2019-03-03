package com.harshvardhan.idt.dao;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.harshvardhan.idt.model.ForecastDetailsArray;
import com.harshvardhan.idt.model.WeatherDetails;

public interface WeatherDao {
	public WeatherDetails getCurrentWeather(String city, String currentLocation)
			throws ClientProtocolException, IOException;

	public ForecastDetailsArray getWeatherForcast(String city, String currentLocation)
			throws ClientProtocolException, IOException;

}
