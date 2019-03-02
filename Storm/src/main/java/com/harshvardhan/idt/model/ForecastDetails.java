package com.harshvardhan.idt.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastDetails {

	@XmlElement
	private Main main;

	@XmlElement
	private List<Weather> weather;

	@XmlElement
	private Clouds clouds;

	@XmlElement
	private Wind wind;

	@XmlElement
	private String dt_txt;

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public ForecastDetails(Main main, List<Weather> weather, Clouds clouds, Wind wind, String dt_txt) {
		super();
		this.main = main;
		this.weather = weather;
		this.clouds = clouds;
		this.wind = wind;
		this.dt_txt = dt_txt;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}

	public ForecastDetails() {
		super();
	}

}
