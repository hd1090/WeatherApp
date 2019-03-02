package com.harshvardhan.idt.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.harshvardhan.idt.dto.DisplayDTO;
import com.harshvardhan.idt.dto.DisplayForecastDTO;
import com.harshvardhan.idt.dto.DisplayWeatherDTO;

public interface WeatherService {

	public DisplayWeatherDTO getCurrentWeather(String city) throws ClientProtocolException, IOException;

	public DisplayForecastDTO getWeatherForcast(String city) throws ClientProtocolException, IOException;

	public DisplayDTO getCurrentWeatherAndForecast(String city) throws ClientProtocolException, IOException;

}
