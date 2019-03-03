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
	private Float curTemp;

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

	@XmlElement
	private Boolean error;

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

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

	public Float getCurTemp() {
		return curTemp;
	}

	public void setCurTemp(Float curTemp) {
		this.curTemp = curTemp;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public void setMinTemp(Integer minTemp) {
		this.minTemp = minTemp;
	}

	public void setMaxTemp(Integer maxTemp) {
		this.maxTemp = maxTemp;
	}

	public void setWindSpeed(Float windSpeed) {
		this.windSpeed = windSpeed;
	}

	public void setWindDirection(Integer windDirection) {
		this.windDirection = windDirection;
	}

	public void setVisibilty(Long visibilty) {
		this.visibilty = visibilty;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public DisplayWeatherDTO(List<Weather> weather, Float curTemp, Integer minTemp, Integer maxTemp, Float windSpeed,
			Integer windDirection, Long visibilty, String name, Integer humidity) {
		super();
		this.weather = weather;
		this.curTemp = curTemp;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.visibilty = visibilty;
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
		this.curTemp = details.getMain().getTemp();
		this.error = details.getError();
	}

}
