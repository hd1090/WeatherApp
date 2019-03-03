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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshvardhan.idt.constants.Constants;
import com.harshvardhan.idt.dao.WeatherDao;
import com.harshvardhan.idt.model.ForecastDetailsArray;
import com.harshvardhan.idt.model.WeatherDetails;
import com.harshvardhan.idt.util.PropertiesUtil;

@Repository
public class WeatherDaoImpl implements WeatherDao {

	public WeatherDetails getCurrentWeather(String city, String currentLocation)
			throws ClientProtocolException, IOException {
		String url;
		HttpResponse response;
		try {
			url = getURLWithAPIFromPropertiesFile(Constants.CURRENT_WEATHER_URL, city);
			response = execute(url);
		} catch (IllegalArgumentException ie) {
			return getDefaultCityWeatherDetails(currentLocation);
		}

		if (200 == response.getStatusLine().getStatusCode()) {

			String userProfile = deserialize(response);
			return convertToWeatherDetails(userProfile);

		} else if (404 == response.getStatusLine().getStatusCode()) {

			return getDefaultCityWeatherDetails(currentLocation);

		} else {
			throw new InternalServerErrorException("Something went wrong, please try again later");
		}
	}

	@Override
	public ForecastDetailsArray getWeatherForcast(String city, String currentLocation)
			throws ClientProtocolException, IOException {
		String url;
		HttpResponse response;
		try {
			url = getURLWithAPIFromPropertiesFile(Constants.FORECAST_WEATHER_URL, city);
			response = execute(url);
		} catch (IllegalArgumentException e) {
			return getDefaultCityForecast(currentLocation);
		}

		if (200 == response.getStatusLine().getStatusCode()) {

			String userProfile = deserialize(response);
			return convertToForeCastDetails(userProfile);

		} else if (404 == response.getStatusLine().getStatusCode()) {

			return getDefaultCityForecast(currentLocation);

		} else {
			throw new InternalServerErrorException("Something went wrong, please try again later");
		}
	}

	private WeatherDetails getDefaultCityWeatherDetails(String currentLocation)
			throws IOException, ClientProtocolException, JsonParseException, JsonMappingException {
		String url;
		HttpResponse response;
		url = getURLWithAPIFromPropertiesFile(Constants.CURRENT_WEATHER_URL, currentLocation);
		response = execute(url);

		String userProfile = deserialize(response);
		WeatherDetails details = convertToWeatherDetails(userProfile);
		details.setError(Boolean.TRUE);
		return details;
	}

	private ForecastDetailsArray getDefaultCityForecast(String currentLocation)
			throws IOException, ClientProtocolException, JsonParseException, JsonMappingException {
		String url;
		HttpResponse response;
		url = getURLWithAPIFromPropertiesFile(Constants.FORECAST_WEATHER_URL, currentLocation);
		response = execute(url);

		String userProfile = deserialize(response);
		return convertToForeCastDetails(userProfile);
	}

	private String getURLWithAPIFromPropertiesFile(String baseUrl, String city) throws IOException {
		String url = String.format(baseUrl,
				PropertiesUtil.getProperties(Constants.APPLICATION_PROPERTIES).getProperty("API_KEY"), city)
				.replaceAll(" ", "%20");
		return url;
	}

	private WeatherDetails convertToWeatherDetails(String userProfile)
			throws IOException, JsonParseException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		WeatherDetails user = mapper.readValue(userProfile.toString(), WeatherDetails.class);
		return user;
	}

	private String deserialize(HttpResponse response) throws IOException {
		StringBuilder userProfile = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		while ((line = br.readLine()) != null) {
			userProfile.append(line);
		}
		return userProfile.toString();
	}

	private ForecastDetailsArray convertToForeCastDetails(String userProfile)
			throws IOException, JsonParseException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		ForecastDetailsArray user = mapper.readValue(userProfile, ForecastDetailsArray.class);
		return user;
	}

	private HttpResponse execute(String url) throws IOException, ClientProtocolException {
		HttpGet getRequest = new HttpGet(url);
		getRequest.addHeader("accept", "application/xml");
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(getRequest);
		return response;
	}

}
