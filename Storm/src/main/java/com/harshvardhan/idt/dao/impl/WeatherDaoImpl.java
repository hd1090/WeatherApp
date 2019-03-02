package com.harshvardhan.idt.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
import com.harshvardhan.idt.model.WeatherDetails;

@Repository
public class WeatherDaoImpl implements WeatherDao {

	public WeatherDetails getCurrentWeather(String city) throws ClientProtocolException, IOException {
		System.out.println(Constants.weatherURL + city);
		HttpGet getRequest = new HttpGet(Constants.weatherURL + city);
		getRequest.addHeader("accept", "application/xml");
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(getRequest);
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
	}

}
