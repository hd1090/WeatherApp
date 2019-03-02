package com.harshvardhan.idt.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastDetailsArray {

	@XmlElement
	private List<ForecastDetails> list;

	
	@XmlElement
	private Long population;
	
	
	public List<ForecastDetails> getList() {
		return list;
	}

	public void setList(List<ForecastDetails> list) {
		this.list = list;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public List<ForecastDetails> getDetails() {
		return list;
	}

	public void setDetails(List<ForecastDetails> list) {
		this.list = list;
	}

	

	public ForecastDetailsArray(List<ForecastDetails> list, Long population) {
		super();
		this.list = list;
		this.population = population;
	}

	public ForecastDetailsArray() {
		super();
	}

}
