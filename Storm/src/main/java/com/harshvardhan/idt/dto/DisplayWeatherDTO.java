package com.harshvardhan.idt.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.harshvardhan.idt.model.Weather;
import com.harshvardhan.idt.model.WeatherDetails;

@XmlAccessorType(XmlAccessType.FIELD)
public class DisplayWeatherDTO {

	@XmlElement
	private List<Weather> weather;

	@XmlElement
	private Integer minTemp;

	@XmlElement
	private Integer maxTemp;

	@XmlElement
	private Float windSpeed;

	@XmlElement
	private Integer windDirection;

	@XmlElement
	private Long visibilty;

	@XmlElement
	private String name;

	@XmlElement
	private Integer humidity;
	
	

	public List<Weather> getWeather() {
		return weather;
	}

	public Integer getMinTemp() {
		return minTemp;
	}

	public Integer getMaxTemp() {
		return maxTemp;
	}

	public Float getWindSpeed() {
		return windSpeed;
	}

	public Integer getWindDirection() {
		return windDirection;
	}

	public Long getVisibilty() {
		return visibilty;
	}

	public String getName() {
		return name;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public DisplayWeatherDTO(List<Weather> weather, Integer minTemp, Integer maxTemp, Float windSpeed,
			Integer windDirection, Long visibility, String name, Integer humidity) {
		super();
		this.weather = weather;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.visibilty = visibility;
		this.name = name;
		this.humidity = humidity;
	}

	public DisplayWeatherDTO(WeatherDetails details) {
		super();
		this.weather = details.getWeather();
		this.minTemp = details.getMain().getTemp_min();
		this.maxTemp = details.getMain().getTemp_max();
		this.windSpeed = details.getWind().getSpeed();
		this.windDirection = details.getWind().getDeg();
		this.visibilty = details.getVisibility();
		this.name = details.getName();
		this.humidity = details.getMain().getHumidity();
	}

}
