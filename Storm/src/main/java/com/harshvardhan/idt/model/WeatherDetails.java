package com.harshvardhan.idt.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class WeatherDetails {
	@XmlElement
	private Coord coord;

	@XmlElement
	private List<Weather> weather;

	@XmlElement
	private String base;

	@XmlElement
	private Main main;

	@XmlElement
	private Long visibility;

	@XmlElement
	private Wind wind;

	@XmlElement
	private Clouds clouds;

	@XmlElement
	private Double dt;

	@XmlElement
	private Integer id;

	@XmlElement
	private String name;

	@XmlElement
	private Integer cod;

	@XmlElement
	private Boolean error = Boolean.FALSE;

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Long getVisibility() {
		return visibility;
	}

	public void setVisibility(Long visibility) {
		this.visibility = visibility;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Double getDt() {
		return dt;
	}

	public void setDt(Double dt) {
		this.dt = dt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public WeatherDetails(Coord coord, List<Weather> weather, String base, Main main, Long visibility, Wind wind,
			Clouds clouds, Double dt, Integer id, String name, Integer cod) {
		super();
		this.coord = coord;
		this.weather = weather;
		this.base = base;
		this.main = main;
		this.visibility = visibility;
		this.wind = wind;
		this.clouds = clouds;
		this.dt = dt;
		this.id = id;
		this.name = name;
		this.cod = cod;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public WeatherDetails() {
		super();
	}

}
