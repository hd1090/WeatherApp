
package com.harshvardhan.idt.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Weather {

	@XmlElement(name = "main")
	private String main;

	@XmlElement(name = "description")
	private String description;

	@XmlElement
	private String icon;

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Weather(String main, String description, String icon) {
		super();
		this.main = main;
		this.description = description;
		this.icon = icon;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Weather() {
		super();
	}

}
