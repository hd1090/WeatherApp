package com.harshvardhan.idt.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Wind {
	@XmlElement
	private Float speed;

	@XmlElement
	private Integer deg;

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

	public Integer getDeg() {
		return deg;
	}

	public void setDeg(Integer deg) {
		this.deg = deg;
	}

	public Wind(Float speed, Integer deg) {
		super();
		this.speed = speed;
		this.deg = deg;
	}

	public Wind() {
		super();
	}

}
