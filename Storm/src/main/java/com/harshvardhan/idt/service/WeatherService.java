package com.harshvardhan.idt.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.harshvardhan.idt.model.WeatherDetails;

public interface WeatherService {

	public WeatherDetails getCurrentWeather(String city) throws ClientProtocolException, IOException;

}
