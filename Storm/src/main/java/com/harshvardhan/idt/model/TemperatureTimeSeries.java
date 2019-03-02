package com.harshvardhan.idt.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TemperatureTimeSeries {

	@XmlElement
	private String time;

	@XmlElement
	private Float temperature;

	public TemperatureTimeSeries(Object l, Float temperature) {
		super();
		this.time = l.toString();
		this.temperature = temperature;
	}


}
