package com.harshvardhan.idt.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
@XmlAccessorType(XmlAccessType.FIELD)
public class Coord {
	@XmlElement
	private Float lon;

	@XmlElement
	private Float lat;

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Coord(Float lon, Float lat) {
		super();
		this.lon = lon;
		this.lat = lat;
	}

	public Coord() {
		super();
	}

}
