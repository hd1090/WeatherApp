package com.harshvardhan.idt.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Main {

	@XmlElement(name = "main")
	private Float temp;

	@XmlElement
	private Integer pressure;

	@XmlElement
	private Integer humidity;

	@XmlElement
	private Integer temp_min;

	@XmlElement
	private Integer temp_max;

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public Integer getPressure() {
		return pressure;
	}

	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Integer getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(Integer temp_min) {
		this.temp_min = temp_min;
	}

	public Integer getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(Integer temp_max) {
		this.temp_max = temp_max;
	}

	public Main(Float temp, Integer pressure, Integer humidity, Integer temp_min, Integer temp_max) {
		super();
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
	}

	public Main() {
		super();
	}

}
