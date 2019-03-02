package com.harshvardhan.idt.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshvardhan.idt.constants.Constants;
import com.harshvardhan.idt.model.WeatherDetails;

public class Main {
	public static void main(String[] args) throws ClientProtocolException, IOException, JAXBException {
		HttpGet getRequest = new HttpGet(Constants.currentWeatherURL + "new%20york");
		getRequest.addHeader("accept", "application/xml");
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(getRequest);
		StringBuilder userProfile = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		while ((line = br.readLine()) != null) {
			userProfile.append(line);
		}
		System.out.println(userProfile);

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		WeatherDetails user = mapper.readValue(userProfile.toString(), WeatherDetails.class);

		System.out.println(user);
	}
}
