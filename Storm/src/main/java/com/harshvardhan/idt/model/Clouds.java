package com.harshvardhan.idt.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
@XmlAccessorType(XmlAccessType.FIELD)
public class Clouds {

	@XmlElement
	private Integer all;

	public Integer getAll() {
		return all;
	}

	public void setAll(Integer all) {
		this.all = all;
	}

	public Clouds(Integer all) {
		super();
		this.all = all;
	}

	public Clouds() {
		super();
	}

}
