package com.harshvardhan.idt.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.harshvardhan.idt.model.TemperatureTimeSeries;
import com.harshvardhan.idt.model.Weather;

@XmlAccessorType(XmlAccessType.FIELD)
public class DisplayDTO {
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
	List<TemperatureTimeSeries> hourly;

	@XmlElement
	List<TemperatureTimeSeries> daily;
	
	@XmlElement
	private Boolean error;

	public DisplayDTO(DisplayWeatherDTO weatherDTO, DisplayForecastDTO forecastDTO) {
		super();
		this.weather = weatherDTO.getWeather();
		this.curTemp = weatherDTO.getCurTemp();
		this.minTemp = weatherDTO.getMinTemp();
		this.maxTemp = weatherDTO.getMaxTemp();
		this.windSpeed = weatherDTO.getWindSpeed();
		this.windDirection = weatherDTO.getWindDirection();
		this.visibilty = weatherDTO.getVisibilty();
		this.name = weatherDTO.getName();
		this.humidity = weatherDTO.getHumidity();
		this.hourly = forecastDTO.getHourly();
		this.daily = forecastDTO.getDaily();
		this.error = weatherDTO.getError();
	}

	public DisplayDTO(List<Weather> weather, Float curTemp, Integer minTemp, Integer maxTemp, Float windSpeed,
			Integer windDirection, Long visibilty, String name, Integer humidity, List<TemperatureTimeSeries> hourly,
			List<TemperatureTimeSeries> daily) {
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
		this.hourly = hourly;
		this.daily = daily;
	}
	
	

	

}
