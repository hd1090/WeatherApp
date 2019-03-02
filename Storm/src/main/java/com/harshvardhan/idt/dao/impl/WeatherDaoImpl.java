package com.harshvardhan.idt.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.InternalServerErrorException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshvardhan.idt.constants.Constants;
import com.harshvardhan.idt.dao.WeatherDao;
import com.harshvardhan.idt.model.ForecastDetailsArray;
import com.harshvardhan.idt.model.WeatherDetails;

@Repository
public class WeatherDaoImpl implements WeatherDao {

	public WeatherDetails getCurrentWeather(String city) throws ClientProtocolException, IOException {
		String url = (Constants.currentWeatherURL + city).replaceAll(" ", "%20");
		HttpGet getRequest = new HttpGet(url);
		getRequest.addHeader("accept", "application/xml");
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(getRequest);

		if (200 == response.getStatusLine().getStatusCode()) {
			StringBuilder userProfile = new StringBuilder();

			BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = br.readLine()) != null) {
				userProfile.append(line);
			}
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			WeatherDetails user = mapper.readValue(userProfile.toString(), WeatherDetails.class);
			return user;
		} else if (404 == response.getStatusLine().getStatusCode()) {
			throw new IllegalArgumentException("City name doesn't exist !!!!");
		} else {
			throw new InternalServerErrorException("Something went wrong, please try again later");
		}
	}

	@Override
	public ForecastDetailsArray getWeatherForcast(String city) throws ClientProtocolException, IOException {
		String url = (Constants.forcastWeatherURL + city).replaceAll(" ", "%20");
		HttpGet getRequest = new HttpGet(url);
		getRequest.addHeader("accept", "application/xml");
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(getRequest);
		if (200 == response.getStatusLine().getStatusCode()) {
			StringBuilder userProfile = new StringBuilder();

			BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = br.readLine()) != null) {
				userProfile.append(line);
			}

			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			ForecastDetailsArray user = mapper.readValue(userProfile.toString(), ForecastDetailsArray.class);

			return user;
		} else if (404 == response.getStatusLine().getStatusCode()) {
			throw new IllegalArgumentException("City name doesn't exist !!!!");
		} else {
			throw new InternalServerErrorException("Something went wrong, please try again later");
		}
	}

}
